package com.example.projeto.model;

import java.util.ArrayList;
import java.util.List;

public class LinhaMontagem {

    Integer sequencia;
    List<Atividade> linhasAtividades = new ArrayList<>();

    public LinhaMontagem(Integer sequencia) {
        this.sequencia = sequencia;
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
