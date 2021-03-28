package com.example.projeto.model;

public class Atividade {

    String descricao;
    Integer duracao;
    Boolean manutencao;

    public Atividade(String descricao, Integer duracao, Boolean manutencao) {
        this.descricao = descricao;
        this.duracao = duracao;
        this.manutencao = manutencao;
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

    public Boolean getManutencao() {
        return manutencao;
    }

    public void setManutencao(Boolean manutencao) {
        this.manutencao = manutencao;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "descricao='" + descricao + '\'' +
                ", duracao=" + duracao +
                ", manutencao=" + manutencao +
                '}';
    }
}
