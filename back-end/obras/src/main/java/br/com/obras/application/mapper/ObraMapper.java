package br.com.obras.application.mapper;

import br.com.obras.application.dtos.ObraDTO;
import br.com.obras.domain.entities.Obra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ObraMapper {
    Obra toEntity(ObraDTO obraDTO);
}
