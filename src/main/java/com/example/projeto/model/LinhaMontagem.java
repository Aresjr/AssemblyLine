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

    @Override
    public String toString() {
        return "LinhaMontagem{" +
                "sequencia=" + sequencia +
                ", linhasAtividades=" + linhasAtividades +
                '}';
    }

    public String linhasArquivo() {
        StringBuilder linhasArquivo = new StringBuilder(String.format("Linha de montagem %d:\n", sequencia));
        for(Atividade atividade : linhasAtividades) {
            linhasArquivo.append(atividade.linhasArquivo());
            linhasArquivo.append("\n");
        }
        return linhasArquivo.toString();
    }
}
