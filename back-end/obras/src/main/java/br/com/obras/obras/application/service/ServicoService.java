package br.com.obras.obras.application.service;

import br.com.obras.obras.application.dtos.ServicoDTO;
import br.com.obras.obras.application.mapper.ServicoMapper;
import br.com.obras.obras.domain.entities.Servico;
import br.com.obras.obras.domain.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {
    @Autowired
    ServicoRepository servicoRepository;

    @Autowired
    ServicoMapper servicoMapper;

    /**
     * Realiza o cadastro de serviços.
     * @param servicosDTOS lista de serviços a serem cadastrados
     * @return lista de serviços cadastrados
     */
    public List<ServicoDTO> cadastrarServicos(List<ServicoDTO> servicosDTOS) {
        List<Servico> servicos = servicosDTOS.stream()
                .map(resp -> servicoMapper.toEntity(resp))
                .collect(Collectors.toList());

        return servicoRepository.saveAll(servicos).stream()
                .map(resp -> servicoMapper.toDto(resp))
                .collect(Collectors.toList());
    }



}
