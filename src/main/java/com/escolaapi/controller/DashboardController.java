package com.escolaapi.controller;

import com.escolaapi.model.Professor;
import com.escolaapi.model.Aluno;
import com.escolaapi.model.Turma;
import com.escolaapi.model.Nota;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.escolaapi.repository.ProfessorRepository professorRepository;

    @Autowired
    private com.escolaapi.repository.AlunoRepository alunoRepository;

    @Autowired
    private com.escolaapi.repository.TurmaRepository turmaRepository;

    @Autowired
    private com.escolaapi.repository.NotaRepository notaRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalProfessor", professorRepository.count());
        resumo.put("totalAluno", alunoRepository.count());
        resumo.put("totalTurma", turmaRepository.count());
        resumo.put("totalNota", notaRepository.count());
        resumo.put("somaBimestreNota", notaRepository.findAll().stream().filter(e -> e.getBimestre() != null).mapToInt(e -> e.getBimestre()).sum());
        resumo.put("graficoNota", notaRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getSituacao()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
