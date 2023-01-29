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
    private String Nome;
    private Integer QtdAcertos;
    private Integer QtdErros;
    private Integer QtdQuestoes;

    public Integer getId() {
        return id;
    }
    public String getNome() {
        return Nome;
    }
    public Integer getQtdAcertos() {
        return QtdAcertos;
    }
    public Integer getQtdErros() {
        return QtdErros;
    }
    public Integer getQtdQuestoes() {
        return QtdQuestoes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }
    
    public void setQtdAcertos(Integer qtdAcertos) {
        this.QtdAcertos = qtdAcertos;
    }

    public void setQtdErros(Integer qtdErros) {
        this.QtdErros = qtdErros;
    }
    
    public void setQtdQuestoes(Integer qtdQuestoes) {
        QtdQuestoes = qtdQuestoes;
    }

}
