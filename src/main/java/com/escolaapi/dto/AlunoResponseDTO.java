package com.escolaapi.dto;

public class AlunoResponseDTO {

    private Long id;
    private Long turmaId;
    private String nome;
    private String cpf;
    private java.time.LocalDate dataNascimento;
    private String telefoneResponsavel;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getTurmaId() { return turmaId; }
    public void setTurmaId(Long turmaId) { this.turmaId = turmaId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public java.time.LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(java.time.LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getTelefoneResponsavel() { return telefoneResponsavel; }
    public void setTelefoneResponsavel(String telefoneResponsavel) { this.telefoneResponsavel = telefoneResponsavel; }
}
