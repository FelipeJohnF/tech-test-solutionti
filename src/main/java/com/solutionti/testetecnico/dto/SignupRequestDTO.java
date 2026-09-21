package com.solutionti.testetecnico.dto;
 
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
 
import java.time.LocalDate;
 
public class SignupRequestDTO {
 
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String senha;
 
    @JsonCreator
    public SignupRequestDTO(
        @JsonProperty("nome") String nome,
        @JsonProperty("cpf") String cpf,
        @JsonProperty("dataNascimento") LocalDate dataNascimento,
        @JsonProperty("senha") String senha
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public String getCpf() {
        return cpf;
    }
 
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
 
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
 
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
 
    public String getSenha() {
        return senha;
    }
 
    public void setSenha(String senha) {
        this.senha = senha;
    }
}