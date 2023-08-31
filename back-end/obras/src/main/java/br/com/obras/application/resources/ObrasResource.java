package br.com.obras.application.resources;

import br.com.obras.application.services.ObrasService;
import br.com.obras.domain.entities.Obra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public ResponseEntity<List<Obra>> listarObras() {
        List<Obra> obras = obrasService.listarTodasObras();
        return ResponseEntity.ok(obras);
    }

    @PostMapping()
    public ResponseEntity<Obra> cadastrarObraPrivada(@RequestBody Obra obra) {
        return new ResponseEntity<Obra>(obrasService.cadastrarObraPrivada(obra), HttpStatus.CREATED);
    }
}
