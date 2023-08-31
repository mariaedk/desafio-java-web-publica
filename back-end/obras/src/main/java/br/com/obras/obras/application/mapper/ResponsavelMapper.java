package br.com.obras.obras.application.mapper;

import br.com.obras.obras.application.dtos.ResponsavelDTO;
import br.com.obras.obras.domain.entities.Responsavel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponsavelMapper {
    Responsavel toEntity(ResponsavelDTO responsavelDTO);
    ResponsavelDTO toDto(Responsavel responsavel);
}
