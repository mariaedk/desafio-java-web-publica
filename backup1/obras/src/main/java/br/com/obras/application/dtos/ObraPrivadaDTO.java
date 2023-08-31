package br.com.obras.application.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@SuperBuilder
@Setter
public class ObraPrivadaDTO extends ObraDTO {
    private TipoZonaDTO zona;
    private Double areaTotal;
}
