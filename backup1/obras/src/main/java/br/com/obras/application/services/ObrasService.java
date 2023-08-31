package br.com.obras.application.services;

import br.com.obras.application.dtos.ObraDTO;
import br.com.obras.application.dtos.ObraPrivadaDTO;
import br.com.obras.application.dtos.ObraPublicaDTO;
import br.com.obras.application.mapper.ObraPrivadaMapper;
import br.com.obras.application.mapper.ObraPublicaMapper;
import br.com.obras.domain.entities.Obra;
import br.com.obras.domain.entities.ObraPrivada;
import br.com.obras.domain.entities.ObraPublica;
import br.com.obras.domain.repositories.ObraPrivadaRepository;
import br.com.obras.domain.repositories.ObraPublicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ObrasService {
    @Autowired
    ObraPublicaRepository obraPublicaRepository;

    @Autowired
    ObraPrivadaRepository obraPrivadaRepository;

    @Autowired
    ObraPrivadaMapper obraPrivadaMapper;

    @Autowired
    ObraPublicaMapper obraPublicaMapper;

    // métodos
    // Criar uma consulta que retorne todas as obras ordenadas pelo número
    public List<ObraDTO> listarTodasObras() {
        List<ObraPrivadaDTO> listaObrasPrivadas = obraPrivadaRepository.findAll()
                .stream()
                .map(obra -> obraPrivadaMapper.toDto(obra))
                .collect(Collectors.toList());

        List<ObraPublicaDTO> listaObrasPublicas = obraPublicaRepository.findAll()
                .stream()
                .map(obra -> obraPublicaMapper.toDto(obra))
                .collect(Collectors.toList());

        return Stream.concat(listaObrasPublicas.stream(), listaObrasPrivadas.stream())
                .sorted(Comparator.comparing(ObraDTO::getNumeroObra))
                .collect(Collectors.toList());
    }

    public ObraPrivadaDTO cadastrarObraPrivada(ObraPrivadaDTO obraDTO) {
        return obraPrivadaMapper.toDto(obraPrivadaRepository.save(obraPrivadaMapper.toEntity(obraDTO)));
    }

    public ObraPublicaDTO cadastrarObraPublica(ObraPublicaDTO obraDTO) {
        return obraPublicaMapper.toDto(obraPublicaRepository.save(obraPublicaMapper.toEntity(obraDTO)));
    }

    public List<ObraPrivadaDTO> listarObrasPrivadas() {
        List<ObraPrivadaDTO> listaObrasPrivadas = obraPrivadaRepository.findAll()
                .stream()
                .map(obra -> obraPrivadaMapper.toDto(obra))
                .collect(Collectors.toList());
        return listaObrasPrivadas;
    }

}
