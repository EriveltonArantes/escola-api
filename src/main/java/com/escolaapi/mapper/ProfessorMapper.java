package com.escolaapi.mapper;

import com.escolaapi.dto.ProfessorRequestDTO;
import com.escolaapi.dto.ProfessorResponseDTO;
import com.escolaapi.model.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    @Mapping(target = "aluno", ignore = true)
    Professor toEntity(ProfessorRequestDTO dto);

    @Mapping(target = "alunoId", source = "aluno.id")
    ProfessorResponseDTO toResponseDTO(Professor entity);
}
