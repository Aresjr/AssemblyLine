package com.example.projeto.model;

import java.util.List;

public class LinhaMontagem {

    Integer sequencia;
    List<Atividade> linhasAtividades;

    public LinhaMontagem(){}

    public LinhaMontagem(Integer sequencia, List<Atividade> linhasAtividades) {
        this.sequencia = sequencia;
        this.linhasAtividades = linhasAtividades;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }

    public List<Atividade> getLinhasAtividades() {
        return linhasAtividades;
    }

    public void setLinhasAtividades(List<Atividade> linhasAtividades) {
        this.linhasAtividades = linhasAtividades;
    }
}
