package br.com.obras.obras.application.mapper;

import br.com.obras.obras.application.dtos.CriarObraPrivadaDTO;
import br.com.obras.obras.application.dtos.CriarObraPublicaDTO;
import br.com.obras.obras.application.dtos.ObraDTO;
import br.com.obras.obras.domain.entities.Obra;
import org.mapstruct.Mapper;

/**
 * Mapper para realizar a conversão entre DTOs e a entidade. Dependência MapStruct
 */
@Mapper(componentModel = "spring")
public interface ObraMapper {
    Obra toEntity(ObraDTO obraDTO);
    ObraDTO toDto(Obra obra);
    ObraDTO criarPrivadaToDto(CriarObraPrivadaDTO obraPrivadaDTO);
    ObraDTO criarPublicaToDto(CriarObraPublicaDTO obraPublicaDTO);
}
