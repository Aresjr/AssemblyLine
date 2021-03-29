package com.example.projeto.model;

import org.springframework.context.MessageSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    public String linhasArquivo(MessageSource messageSource) {
        StringBuilder linhasArquivo = new StringBuilder(messageSource.getMessage("linha.montagem.descricao", null, Locale.getDefault()));
        linhasArquivo.append(String.format(" %d:\n", sequencia));
        for(Atividade atividade : linhasAtividades) {
            linhasArquivo.append(atividade.linhasArquivo(messageSource));
            linhasArquivo.append("\n");
        }
        return linhasArquivo.toString();
    }
}
