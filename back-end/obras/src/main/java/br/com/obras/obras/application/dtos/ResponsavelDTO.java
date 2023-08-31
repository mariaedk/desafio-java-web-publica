package br.com.obras.obras.application.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponsavelDTO {
    private Long id;
    private String cpf;
    private String nome;
}
