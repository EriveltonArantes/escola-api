package com.escolaapi.service;

import com.escolaapi.dto.TurmaRequestDTO;
import com.escolaapi.dto.TurmaResponseDTO;
import com.escolaapi.exception.ResourceNotFoundException;
import com.escolaapi.mapper.TurmaMapper;
import com.escolaapi.model.Turma;
import com.escolaapi.repository.TurmaRepository;
import com.escolaapi.repository.ProfessorRepository;
import com.escolaapi.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TurmaService {

    @Autowired
    private TurmaRepository repository;

    @Autowired
    private TurmaMapper mapper;

    @Autowired
    private ProfessorRepository professorRepository;

    @Transactional(readOnly = true)
    public List<TurmaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TurmaResponseDTO buscar(Long id) {
        Turma entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public TurmaResponseDTO criar(TurmaRequestDTO dto) {
        Turma entity = mapper.toEntity(dto);
        Professor professor = professorRepository.findById(dto.getProfessorId())
            .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado com id: " + dto.getProfessorId()));
        entity.setProfessor(professor);
        Turma salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public TurmaResponseDTO atualizar(Long id, TurmaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Turma não encontrado com id: " + id);
        }
        Turma entity = mapper.toEntity(dto);
        entity.setId(id);
        Professor professor = professorRepository.findById(dto.getProfessorId())
            .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado com id: " + dto.getProfessorId()));
        entity.setProfessor(professor);
        Turma salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Turma não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
