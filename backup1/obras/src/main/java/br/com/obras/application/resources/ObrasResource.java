package br.com.obras.application.resources;

import br.com.obras.application.dtos.ObraDTO;
import br.com.obras.application.dtos.ObraPrivadaDTO;
import br.com.obras.application.dtos.ObraPublicaDTO;
import br.com.obras.application.services.ObrasService;
import br.com.obras.domain.entities.Obra;
import br.com.obras.domain.entities.ObraPrivada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/obras")
public class ObrasResource {

    @Autowired
    ObrasService obrasService;

    @GetMapping
    public ResponseEntity<List<ObraDTO>> listarObras() {
        try {
            List<ObraDTO> obras = obrasService.listarTodasObras();
            return ResponseEntity.ok(obras);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("obraPrivada")
    public ResponseEntity<ObraPrivadaDTO> cadastrarObraPrivada(@RequestBody ObraPrivadaDTO obraPrivadaDTO) {
        try {
            ObraPrivadaDTO obraSalva = obrasService.cadastrarObraPrivada(obraPrivadaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(obraSalva);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("obraPublica")
    public ResponseEntity<ObraPublicaDTO> cadastrarObraPrivada(@RequestBody ObraPublicaDTO obraPublicaDTO) {
        try {
            ObraPublicaDTO obraSalva = obrasService.cadastrarObraPublica(obraPublicaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(obraSalva);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
