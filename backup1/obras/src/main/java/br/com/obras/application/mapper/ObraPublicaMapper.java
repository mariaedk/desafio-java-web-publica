package br.com.obras.application.mapper;

import br.com.obras.application.dtos.ObraPrivadaDTO;
import br.com.obras.application.dtos.ObraPublicaDTO;
import br.com.obras.domain.entities.ObraPrivada;
import br.com.obras.domain.entities.ObraPublica;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ObraPublicaMapper {

    ObraPublica toEntity(ObraPublicaDTO dto);

    ObraPublicaDTO toDto(ObraPublica entity);

}