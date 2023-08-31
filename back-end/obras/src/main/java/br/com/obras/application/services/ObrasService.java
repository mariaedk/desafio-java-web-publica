package br.com.obras.application.services;

import br.com.obras.application.mapper.ObraMapper;
import br.com.obras.domain.entities.Obra;
import br.com.obras.domain.repositories.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObrasService {
    @Autowired
    ObraRepository obraRepository;

    @Autowired
    ObraMapper obraMapper;

    // métodos
    // Criar uma consulta que retorne todas as obras ordenadas pelo número

    public List<Obra> listarTodasObras() {
        return obraRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Obra::getNumeroObra))
                .map(obra -> obraMapper.to)
                .collect(Collectors.toList());
    }

    public Obra cadastrarObraPrivada(Obra obra) {
        return obraRepository.save(obra);
    }


}
