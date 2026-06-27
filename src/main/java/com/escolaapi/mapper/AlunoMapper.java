package com.escolaapi.mapper;

import com.escolaapi.dto.AlunoRequestDTO;
import com.escolaapi.dto.AlunoResponseDTO;
import com.escolaapi.model.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    @Mapping(target = "turma", ignore = true)
    Aluno toEntity(AlunoRequestDTO dto);

    @Mapping(target = "turmaId", source = "turma.id")
    AlunoResponseDTO toResponseDTO(Aluno entity);
}
