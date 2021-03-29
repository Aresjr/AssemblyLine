package com.example.projeto.model;

import java.time.LocalTime;

public class Atividade {

    String descricao;
    Integer duracao;
    Boolean manutencao;
    LocalTime horarioInicio;

    public Atividade(String descricao, Integer duracao, Boolean manutencao, LocalTime horarioInicio) {
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

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
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

    public String linhasArquivo() {
        return horarioInicio.toString() + " " + descricao + " " + duracao + "min";
    }
}
