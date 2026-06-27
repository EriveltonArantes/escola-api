package com.escolaapi.controller;

import com.escolaapi.dto.NotaRequestDTO;
import com.escolaapi.dto.NotaResponseDTO;
import com.escolaapi.service.NotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Nota", description = "Gerenciamento de notas")
@RestController
@RequestMapping("/api/notas")
public class NotaController {

    @Autowired
    private NotaService service;

    @Operation(summary = "Listar todos os Nota")
    @GetMapping
    public List<NotaResponseDTO> listar(@RequestParam(required = false) Long alunoId, @RequestParam(required = false) Long turmaId) {
        List<NotaResponseDTO> resultado = service.listar();
        if (alunoId != null) {
            resultado = resultado.stream().filter(item -> alunoId.equals(item.getAlunoId())).collect(java.util.stream.Collectors.toList());
        }
        if (turmaId != null) {
            resultado = resultado.stream().filter(item -> turmaId.equals(item.getTurmaId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Nota por ID")
    @GetMapping("/{id}")
    public NotaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Nota")
    @PostMapping
    public ResponseEntity<NotaResponseDTO> criar(@Valid @RequestBody NotaRequestDTO nota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(nota));
    }

    @Operation(summary = "Atualizar Nota")
    @PutMapping("/{id}")
    public NotaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody NotaRequestDTO nota) {
        return service.atualizar(id, nota);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Nota")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
