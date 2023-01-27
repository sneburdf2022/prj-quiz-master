package org.senai.prjquiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String Nome;
    private Integer QtdAcertos;
    private Integer QtdErros;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public Integer getQtdAcertos() {
        return QtdAcertos;
    }

    public void setQtdAcertos(Integer qtdAcertos) {
        this.QtdAcertos = qtdAcertos;
    }

    public Integer getQtdErros() {
        return QtdErros;
    }

    public void setQtdErros(Integer qtdErros) {
        this.QtdErros = qtdErros;
    }

    /**
     * @param id
     * @param nome
     * @param qtdAcertos
     * @param qtdErros
     */
    public Usuario(Integer id, String nome, Integer qtdAcertos, Integer qtdErros) {
        this.id = id;
        this.Nome = nome;
        this.QtdAcertos = qtdAcertos;
        this.QtdErros = qtdErros;
    }

}
