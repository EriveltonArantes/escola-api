package com.escolaapi.service;

import com.escolaapi.dto.AlunoRequestDTO;
import com.escolaapi.dto.AlunoResponseDTO;
import com.escolaapi.exception.ResourceNotFoundException;
import com.escolaapi.mapper.AlunoMapper;
import com.escolaapi.model.Aluno;
import com.escolaapi.repository.AlunoRepository;
import com.escolaapi.repository.TurmaRepository;
import com.escolaapi.model.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoMapper mapper;

    @Autowired
    private TurmaRepository turmaRepository;

    @Transactional(readOnly = true)
    public List<AlunoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AlunoResponseDTO buscar(Long id) {
        Aluno entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public AlunoResponseDTO criar(AlunoRequestDTO dto) {
        Aluno entity = mapper.toEntity(dto);
        Turma turma = turmaRepository.findById(dto.getTurmaId())
            .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrado com id: " + dto.getTurmaId()));
        entity.setTurma(turma);
        Aluno salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public AlunoResponseDTO atualizar(Long id, AlunoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Aluno não encontrado com id: " + id);
        }
        Aluno entity = mapper.toEntity(dto);
        entity.setId(id);
        Turma turma = turmaRepository.findById(dto.getTurmaId())
            .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrado com id: " + dto.getTurmaId()));
        entity.setTurma(turma);
        Aluno salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Aluno não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
