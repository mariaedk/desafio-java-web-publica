package br.com.obras.obras.application.controller;

import br.com.obras.obras.application.dtos.ResponsavelDTO;
import br.com.obras.obras.application.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/responsavel"})
public class ResponsavelController {
    @Autowired
    ResponsavelService responsavelService;

    /**
     * Permite o cadastro de responsáveis por obras no sistema.
     * @param responsavelDTO ResponsavelDTO, objeto a ser salvo
     * @return responsavelDTO, objeto que foi salvo
     */
    @PostMapping()
    public ResponseEntity<ResponsavelDTO> cadastrarResponsavel(@RequestBody ResponsavelDTO responsavelDTO) {
        try {
            ResponsavelDTO responsavel = responsavelService.cadastrarResponsavel(responsavelDTO);
            return new ResponseEntity<ResponsavelDTO>(responsavel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
