package br.com.obras.application.dtos;

import br.com.obras.domain.entities.Servico;
import br.com.obras.domain.enums.TipoZona;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
public class ObraDTO {
    private Long numeroObra;
    private LocalDate dataCadastro;
    private String descricao;
    private TipoZona zona;
    private Double areaTotal;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<Servico> servicos;
}
