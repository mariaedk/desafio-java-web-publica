package br.com.obras.obras.application.mapper;

import br.com.obras.obras.application.dtos.ObraDTO;
import br.com.obras.obras.domain.entities.Obra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ObraMapper {
    Obra toEntity(ObraDTO obraDTO);
    ObraDTO toDto(Obra obra);
}
