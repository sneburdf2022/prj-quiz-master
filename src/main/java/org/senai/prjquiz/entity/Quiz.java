package org.senai.prjquiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String pergunta;
    private String[] respostas;
    private int correta;

    public Integer getId() {
        return id;
    }
    public String getPergunta() {
        return pergunta;
    }
    public String[] getRespostas() {
        return respostas;
    }

    public int getCorreta() {
        return correta;
    }

    public void setId(Integer id) {
        this.id = id;
    }    

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
    
    public void setRespostas(String[] respostas) {
        this.respostas = respostas;
    }

    public void setCorreta(int correta) {
        this.correta = correta;
    }

}
