package br.com.obras.obras.application.service;

import br.com.obras.obras.application.dtos.ResponsavelDTO;
import br.com.obras.obras.application.mapper.ResponsavelMapper;
import br.com.obras.obras.domain.entities.Responsavel;
import br.com.obras.obras.domain.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResponsavelService {

    @Autowired
    ResponsavelRepository responsavelRepository;

    @Autowired
    ResponsavelMapper responsavelMapper;

    /**
     * Realiza cadastro de um responsável.
     * CPF deve ser único e informado apenas caracteres numéricos.
     * Não é necessário informar ID.
     * @param responsavelDTO responsável a ser salvo
     * @return responsável que foi salvo
     */
    public ResponsavelDTO cadastrarResponsavel(ResponsavelDTO responsavelDTO) {
        Responsavel responsavelEntity = responsavelMapper.toEntity(responsavelDTO);
        return responsavelMapper.toDto(responsavelRepository.save(responsavelEntity));
    }

    /**
     * Método para validar se responsável existe por meio do seu CPF
     * @param cpf
     * @return Responsável existente
     * @throws Exception
     */
    public ResponsavelDTO buscarResponsavel(String cpf) throws Exception {
        return responsavelMapper.toDto(responsavelRepository.findByCpf(cpf)
                .orElseThrow(
                        () -> new Exception("O Responsável informado não foi encontrado.")));
    }

    /**
     * Método que busca responsáveis por uma determinada obra informada, para preencher o atributo "responsaveis"
     * @param numeroObra número da obra que se deseja buscar os responsaveis
     * @return lista dos responsáveis da obra
     */
    public List<ResponsavelDTO> buscarResponsaveisPorNumeroObra(Long numeroObra) {
        return responsavelRepository.buscarResponsaveisPorNumeroObra(numeroObra)
                .stream()
                .map(o -> responsavelMapper.toDto(o))
                .collect(Collectors.toList());
    }

}
