package br.com.obras.obras.application.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ServicoDTO {
    private ResponsavelDTO responsavel;
    private ObraDTO obra;
}
