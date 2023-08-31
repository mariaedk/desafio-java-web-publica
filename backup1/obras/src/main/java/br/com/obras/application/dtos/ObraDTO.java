package br.com.obras.application.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@SuperBuilder
@Setter
public abstract class ObraDTO {
    private Long numeroObra;
    private LocalDate dataCadastro;
    private String descricao;
}
