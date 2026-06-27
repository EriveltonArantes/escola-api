package com.escolaapi.dto;

public class NotaResponseDTO {

    private Long id;
    private Long alunoId;
    private Long turmaId;
    private Integer bimestre;
    private Double notaAvaliacao;
    private Double notaTrabalho;
    private Double media;
    private String situacao;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public Long getTurmaId() { return turmaId; }
    public void setTurmaId(Long turmaId) { this.turmaId = turmaId; }
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
