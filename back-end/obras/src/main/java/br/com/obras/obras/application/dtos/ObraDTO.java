package br.com.obras.obras.application.dtos;

import br.com.obras.obras.domain.enums.TipoZona;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ObraDTO {
    private Long numeroObra;
    private LocalDate dataCadastro;
    private String descricao;
    private TipoZona zona;
    private Double areaTotal;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<ResponsavelDTO> responsaveis;
}
