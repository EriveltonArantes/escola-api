package com.escolaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;
    private Integer bimestre;
    private Double notaAvaliacao;
    private Double notaTrabalho;
    private Double media;
    @Column(nullable = false)
    private String situacao;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; }
    public Integer getBimestre() { return bimestre; }
    public void setBimestre(Integer bimestre) { this.bimestre = bimestre; }
    public Double getNotaAvaliacao() { return notaAvaliacao; }
    public void setNotaAvaliacao(Double notaAvaliacao) { this.notaAvaliacao = notaAvaliacao; }
    public Double getNotaTrabalho() { return notaTrabalho; }
    public void setNotaTrabalho(Double notaTrabalho) { this.notaTrabalho = notaTrabalho; }
    public Double getMedia() { return media; }
    public void setMedia(Double media) { this.media = media; }
    public String getSituacao() { return situacao; }
    public void setSituacao(String situacao) { this.situacao = situacao; }
}
