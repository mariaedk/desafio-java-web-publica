package br.com.obras.application.mapper;

import br.com.obras.application.dtos.ObraPrivadaDTO;
import br.com.obras.domain.entities.ObraPrivada;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ObraPrivadaMapper {

    ObraPrivada toEntity(ObraPrivadaDTO dto);

    ObraPrivadaDTO toDto(ObraPrivada entity);

}