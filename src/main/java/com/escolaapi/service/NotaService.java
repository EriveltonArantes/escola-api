package com.escolaapi.service;

import com.escolaapi.dto.NotaRequestDTO;
import com.escolaapi.dto.NotaResponseDTO;
import com.escolaapi.exception.ResourceNotFoundException;
import com.escolaapi.mapper.NotaMapper;
import com.escolaapi.model.Nota;
import com.escolaapi.repository.NotaRepository;
import com.escolaapi.repository.AlunoRepository;
import com.escolaapi.model.Aluno;
import com.escolaapi.repository.TurmaRepository;
import com.escolaapi.model.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NotaService {

    @Autowired
    private NotaRepository repository;

    @Autowired
    private NotaMapper mapper;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Transactional(readOnly = true)
    public List<NotaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public NotaResponseDTO buscar(Long id) {
        Nota entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Nota não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public NotaResponseDTO criar(NotaRequestDTO dto) {
        Nota entity = mapper.toEntity(dto);
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
            .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: " + dto.getAlunoId()));
        entity.setAluno(aluno);
        Turma turma = turmaRepository.findById(dto.getTurmaId())
            .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrado com id: " + dto.getTurmaId()));
        entity.setTurma(turma);
        Nota salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public NotaResponseDTO atualizar(Long id, NotaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Nota não encontrado com id: " + id);
        }
        Nota entity = mapper.toEntity(dto);
        entity.setId(id);
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
            .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: " + dto.getAlunoId()));
        entity.setAluno(aluno);
        Turma turma = turmaRepository.findById(dto.getTurmaId())
            .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrado com id: " + dto.getTurmaId()));
        entity.setTurma(turma);
        Nota salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Nota não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
