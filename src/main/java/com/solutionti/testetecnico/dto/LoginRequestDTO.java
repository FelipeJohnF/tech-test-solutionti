package com.solutionti.testetecnico.dto;

public class LoginRequestDTO {
    private String cpf;
    private String senha;

    public LoginRequestDTO(){}

    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getSenha() {return this.senha;}
    public void setSenha(String senha) {this.senha = senha;}
}
