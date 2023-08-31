package br.com.obras.obras.application.controller;

import br.com.obras.obras.application.dtos.CriarObraPrivadaDTO;
import br.com.obras.obras.application.dtos.CriarObraPublicaDTO;
import br.com.obras.obras.application.dtos.ObraDTO;
import br.com.obras.obras.application.service.ObraService;
import br.com.obras.obras.domain.enums.TipoObra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/obras"})
public class ObraController {
    @Autowired
    ObraService obraService;

    /**
     * Lista todas as obras ordenadas pelo número
     * @return Lista de obras ordenadas pelo número
     */
    @GetMapping
    public ResponseEntity<List<ObraDTO>> listarObras() {
        try {
            List<ObraDTO> obras = obraService.listarTodasObras();
            if (obras.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(obras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Lista todas as obras de um determinado responsável ordenadas pelo número
     * @param id id do responsável que se deseja pesquisar
     * @return lista de obras que o responsável está relacionado
     */
    @GetMapping("/{idResponsavel}")
    public ResponseEntity<List<ObraDTO>> listarObrasPorResponsavel(@PathVariable("idResponsavel") Long id) {
        try {
            List<ObraDTO> obras = obraService.listarObrasPorResponsavel(id);
            if (obras.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(obras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Permite buscar apenas as obras públicas cadastradas
     * @return Lista de obras públicas ordenadas pelo número
     */
    @GetMapping("obrasPublicas")
    public ResponseEntity<List<ObraDTO>> listarObrasPublicas() {
        try {
            List<ObraDTO> obras = obraService.listarObrasPublicas();
            if (obras.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(obras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Permite buscar apenas as obras privadas cadastradas
     * @return Lista de obras privadas ordenadas pelo número
     */
    @GetMapping("obrasPrivadas")
    public ResponseEntity<List<ObraDTO>> listarObrasPrivadas() {
        try {
            List<ObraDTO> obras = obraService.listarObrasPrivadas();
            if (obras.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(obras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Permite cadastrar apenas uma obra privada. Deve existir responsáveis previamente cadastrados ao passar a lista
     * dos mesmos.
     * @param obra ObraDTO, obra privada a ser salva
     * @return obraDTO, obra privada que foi salva
     */
    @PostMapping("obraPrivada")
    public ResponseEntity<ObraDTO> cadastrarObraPrivada(@RequestBody CriarObraPrivadaDTO obra) {
        try {
            ObraDTO obraSalvar = obraService.cadastrarObraPrivada(obra, TipoObra.PRIVADA);
            return new ResponseEntity<ObraDTO>(obraSalvar, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Permite cadastrar apenas uma obra pública. Deve existir responsáveis previamente cadastrados ao passar a lista
     * dos mesmos.
     * @param obra ObraDTO, obra pública a ser salva
     * @return obraDTO, obra pública que foi salva
     */
    @PostMapping("obraPublica")
    public ResponseEntity<ObraDTO> cadastrarObraPublica(@RequestBody CriarObraPublicaDTO obra) {
        try {
            ObraDTO obraSalvar = obraService.cadastrarObraPublica(obra, TipoObra.PUBLICA);
            return new ResponseEntity<ObraDTO>(obraSalvar, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
