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
 * DTO que contém somente os campos necessários para criação de uma obra privada
 */
public class CriarObraPrivadaDTO {
    private LocalDate dataCadastro;
    private String descricao;
    private TipoZona zona;
    private Double areaTotal;
    private List<ResponsavelDTO> responsaveis;
}
