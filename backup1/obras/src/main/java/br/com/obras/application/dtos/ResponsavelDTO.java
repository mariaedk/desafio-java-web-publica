package br.com.obras.application.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class ResponsavelDTO {

    private Long id;
    private String cpf;
    private String nome;
}
