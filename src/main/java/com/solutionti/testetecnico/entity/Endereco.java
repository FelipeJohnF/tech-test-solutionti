package com.solutionti.testetecnico.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "endereco")
public class Endereco {

    public Endereco(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_endereco_usuario"))
    private User user;

    @Column(nullable = false, length = 8)
    private Long cep;

    @Column(length = 20)
    private String numero;

    @Column(length = 255)
    private String complemento;

    @Column(nullable = false, length = 255)
    private String logradouro;

    @Column(nullable = false, length = 150)
    private String bairro;


    @Column(nullable = false, length = 150)
    private String cidade;


    @Column(nullable = false, length = 2)
    private String estado;

    @Column(name = "is_main")
    private boolean isMain;

    @CreationTimestamp
    @Column(name="createdat", nullable = false, updatable = false)
    private LocalDate createdAt;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean isMain) {
        this.isMain = isMain;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
