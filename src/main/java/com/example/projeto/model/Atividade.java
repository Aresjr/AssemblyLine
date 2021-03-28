package com.example.projeto.model;

import java.util.Date;

public class Atividade {

    String descricao;
    Integer duracao;
    Boolean manutencao;
    Date horarioInicio;

    public Atividade(String descricao, Integer duracao, Boolean manutencao, Date horarioInicio) {
        this.descricao = descricao;
        this.duracao = duracao;
        this.manutencao = manutencao;
        this.horarioInicio = horarioInicio;
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

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "descricao='" + descricao + '\'' +
                ", duracao=" + duracao +
                ", manutencao=" + manutencao +
                ", horarioInicio=" + horarioInicio +
                '}';
    }
}
