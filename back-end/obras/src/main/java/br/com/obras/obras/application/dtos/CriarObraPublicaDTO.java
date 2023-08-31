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
/**
 * DTO que contém somente os campos necessários para criação de uma obra pública
 */
public class CriarObraPublicaDTO {
    private Long numeroObra;
    private LocalDate dataCadastro;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<ResponsavelDTO> responsaveis;
}
