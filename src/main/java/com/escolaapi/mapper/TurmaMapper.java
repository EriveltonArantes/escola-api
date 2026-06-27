package com.escolaapi.mapper;

import com.escolaapi.dto.TurmaRequestDTO;
import com.escolaapi.dto.TurmaResponseDTO;
import com.escolaapi.model.Turma;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TurmaMapper {

    @Mapping(target = "professor", ignore = true)
    Turma toEntity(TurmaRequestDTO dto);

    @Mapping(target = "professorId", source = "professor.id")
    TurmaResponseDTO toResponseDTO(Turma entity);
}
