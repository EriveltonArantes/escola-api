package com.escolaapi.dto;

public class TurmaResponseDTO {

    private Long id;
    private Long professorId;
    private String nome;
    private String serie;
    private String turno;
    private Integer ano;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
