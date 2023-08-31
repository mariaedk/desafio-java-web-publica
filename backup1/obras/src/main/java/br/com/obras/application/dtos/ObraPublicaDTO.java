package br.com.obras.application.dtos;

import br.com.obras.domain.entities.Obra;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@SuperBuilder
@Setter
public class ObraPublicaDTO extends ObraDTO {
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
