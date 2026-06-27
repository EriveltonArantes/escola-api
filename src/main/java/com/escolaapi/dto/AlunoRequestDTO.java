package com.escolaapi.dto;

import jakarta.validation.constraints.*;

public class AlunoRequestDTO {

    @NotNull(message = "TurmaId é obrigatório")
    @Positive(message = "TurmaId deve ser um ID válido (positivo)")
    private Long turmaId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cpf não pode estar em branco")
    @Size(min = 11, max = 14, message = "cpf deve ter entre 11 e 14 dígitos")
    private String cpf;
    @NotNull(message = "data nascimento não pode ser nulo")
    private java.time.LocalDate dataNascimento;
    @NotBlank(message = "telefone responsavel não pode estar em branco")
    private String telefoneResponsavel;

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
