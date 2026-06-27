package com.escolaapi.mapper;

import com.escolaapi.dto.NotaRequestDTO;
import com.escolaapi.dto.NotaResponseDTO;
import com.escolaapi.model.Nota;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotaMapper {

    @Mapping(target = "aluno", ignore = true)
    @Mapping(target = "turma", ignore = true)
    Nota toEntity(NotaRequestDTO dto);

    @Mapping(target = "alunoId", source = "aluno.id")
    @Mapping(target = "turmaId", source = "turma.id")
    NotaResponseDTO toResponseDTO(Nota entity);
}
