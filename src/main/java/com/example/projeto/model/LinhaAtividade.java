package com.example.projeto.model;

import java.util.Date;

public class LinhaAtividade extends Atividade {

    Date horarioInicio;

    public LinhaAtividade(String descricao, Integer duracao) {
        super(descricao, duracao);
    }

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    @Override
    public String toString() {
        return "LinhaAtividade{" +
                "descricao='" + descricao + '\'' +
                ", duracao=" + duracao +
                ", horarioInicio=" + horarioInicio +
                '}';
    }
}
