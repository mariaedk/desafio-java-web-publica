package br.com.obras.obras.application.service;

import br.com.obras.obras.application.dtos.*;
import br.com.obras.obras.application.mapper.ObraMapper;
import br.com.obras.obras.domain.entities.Obra;
import br.com.obras.obras.domain.enums.TipoObra;
import br.com.obras.obras.domain.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObraService {

    @Autowired
    ObraRepository obraRepository;
    @Autowired
    ResponsavelService responsavelService;
    @Autowired
    ServicoService servicoService;
    @Autowired
    ObraMapper obraMapper;

    /**
     * Traz uma lista de todas as obras ordenadas pelo número da obra, independente se PUBLICA ou PRIVADA
     * @return Lista de todas as obras
     */
    public List<ObraDTO> listarTodasObras() {
        return obraRepository.findAllByOrderByNumeroObra()
                .stream()
                .map(obra -> obraMapper.toDto(obra))
                .collect(Collectors.toList());
    }

    /**
     * Traz uma lista de todas as obras PUBLICAS ordenadas pelo número da obra
     * @return Lista de obras publicas
     */
    public List<ObraDTO> listarObrasPublicas() {
        return obraRepository.findAllByOrderByNumeroObra()
                .stream()
                .filter(obra -> obra.getTipoObra() == TipoObra.PUBLICA)
                .map(obra -> obraMapper.toDto(obra))
                .collect(Collectors.toList());
    }

    /**
     * Traz uma lista de todas as obras PRIVADAS ordenadas pelo número da obra
     * @return Lista de obras privadas
     */
    public List<ObraDTO> listarObrasPrivadas() {
        return obraRepository.findAllByOrderByNumeroObra()
                .stream()
                .filter(obra -> obra.getTipoObra() == TipoObra.PRIVADA)
                .map(obra -> obraMapper.toDto(obra))
                .collect(Collectors.toList());
    }

    /**
     * Traz uma lista de todas as obras de um determinado responsável
     * @return Lista de obras ordenadas e filtradas pelo responsável informado
     */
    public List<ObraDTO> listarObrasPorResponsavel(Long responsavelId) {
        return obraRepository.listarObrasPorResponsavelOrdenadasPorNumeroObra(responsavelId)
                .stream()
                .map(obra -> {
                    ObraDTO obraDTO = obraMapper.toDto(obra);
                    List<ResponsavelDTO> responsaveisDTO = responsavelService.buscarResponsaveisPorNumeroObra(obra.getNumeroObra());
                    obraDTO.setResponsaveis(responsaveisDTO);
                    return obraDTO;
                })
                .collect(Collectors.toList());
    }

    /**
     * Realiza direcionamento de cadastro de obra privada
     * @return Obra que foi salva
     */
    public ObraDTO cadastrarObraPrivada(CriarObraPrivadaDTO criarObraPrivadaDTO, TipoObra tipoObra) throws Exception {
        ObraDTO obraDTO = obraMapper.criarPrivadaToDto(criarObraPrivadaDTO);
        return this.cadastrarObra(obraDTO, tipoObra);
    }

    /**
     * Realiza direcionamento de cadastro de obra publica
     * @return Obra que foi salva
     */
    public ObraDTO cadastrarObraPublica(CriarObraPublicaDTO criarObraPublicaDTO, TipoObra tipoObra) throws Exception {
        ObraDTO obraDTO = obraMapper.criarPublicaToDto(criarObraPublicaDTO);
        return this.cadastrarObra(obraDTO, tipoObra);
    }

    /**
     * Realiza o cadastro de uma obra e salva a relação Obra-Responsavel na tabela Servico, armazenando os IDs de cada.
     * @return Obra que foi salva
     */
    private ObraDTO cadastrarObra(ObraDTO obra, TipoObra tipoObra) throws Exception {
        Obra obraEntity = obraMapper.toEntity(obra);
        // Flag que determina o comportamento da entidade em tipo da obra, para depois filtrar
        obraEntity.atribuirTipoObra(tipoObra);

        Obra obraSalva = obraRepository.save(obraEntity);
        ObraDTO obraDTOSalva = obraMapper.toDto(obraSalva);

        // Utiliza o DTO da obra salva no banco
        this.salvarRelacaoServico(obra, obraDTOSalva);

        // Busca a lista de responsáveis por meio da relação da entidade Servico
        obraDTOSalva.setResponsaveis(responsavelService.buscarResponsaveisPorNumeroObra(obraDTOSalva.getNumeroObra()));
        return obraDTOSalva;
    }

    /**
     * Método auxiliar que para cada responsável, salva um registro de serviço na entidade "Servico", com o número da obra
     */
    private void salvarRelacaoServico(ObraDTO obraRecebida, ObraDTO obraDTOSalva) throws Exception {
        List<ServicoDTO> servicos = new ArrayList<>();
        if (!obraRecebida.getResponsaveis().isEmpty()) {
            for (ResponsavelDTO resp : obraRecebida.getResponsaveis()) {
                ResponsavelDTO responsavelExistente = responsavelService.buscarResponsavel(resp.getCpf());
                servicos.add(new ServicoDTO(responsavelExistente, obraDTOSalva));
            }
        }
        servicoService.cadastrarServicos(servicos);
    }
}
