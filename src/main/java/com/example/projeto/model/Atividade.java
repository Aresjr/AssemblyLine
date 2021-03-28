package com.example.projeto.model;

public class Atividade {

    String descricao;
    Integer duracao;

    public Atividade(String descricao, Integer duracao) {
        this.descricao = descricao;
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "descricao='" + descricao + '\'' +
                ", duracao=" + duracao +
                '}';
    }
}
