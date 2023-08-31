package br.com.obras.obras.application.mapper;

import br.com.obras.obras.application.dtos.ServicoDTO;
import br.com.obras.obras.domain.entities.Servico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicoMapper {
    Servico toEntity(ServicoDTO servicoDTO);
    ServicoDTO toDto(Servico servico);
}
