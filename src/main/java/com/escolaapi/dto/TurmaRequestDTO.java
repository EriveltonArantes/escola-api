package com.escolaapi.dto;

import jakarta.validation.constraints.*;

public class TurmaRequestDTO {

    @NotNull(message = "ProfessorId é obrigatório")
    @Positive(message = "ProfessorId deve ser um ID válido (positivo)")
    private Long professorId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "serie não pode estar em branco")
    private String serie;
    @NotBlank(message = "turno não pode estar em branco")
    private String turno;
    @Min(value = 0, message = "ano não pode ser negativo")
    @NotNull(message = "ano não pode ser nulo")
    private Integer ano;

    public Long getProfessorId() { return professorId; }
    public void setProfessorId(Long professorId) { this.professorId = professorId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSerie() { return serie; }
    public void setSerie(String serie) { this.serie = serie; }
    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }
}
