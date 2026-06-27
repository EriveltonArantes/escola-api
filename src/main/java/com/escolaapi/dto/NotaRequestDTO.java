package com.escolaapi.dto;

import jakarta.validation.constraints.*;

public class NotaRequestDTO {

    @NotNull(message = "AlunoId é obrigatório")
    @Positive(message = "AlunoId deve ser um ID válido (positivo)")
    private Long alunoId;
    @NotNull(message = "TurmaId é obrigatório")
    @Positive(message = "TurmaId deve ser um ID válido (positivo)")
    private Long turmaId;
    @NotNull(message = "bimestre não pode ser nulo")
    private Integer bimestre;
    @NotNull(message = "nota avaliacao não pode ser nulo")
    private Double notaAvaliacao;
    @NotNull(message = "nota trabalho não pode ser nulo")
    private Double notaTrabalho;
    @NotNull(message = "media não pode ser nulo")
    private Double media;
    @NotBlank(message = "situacao não pode estar em branco")
    private String situacao;

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
