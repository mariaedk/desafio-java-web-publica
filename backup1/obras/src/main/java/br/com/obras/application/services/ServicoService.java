package br.com.obras.application.services;

import br.com.obras.domain.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {
    @Autowired
    ServicoRepository servicoRepository;
}
