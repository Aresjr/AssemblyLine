package com.example.projeto.model;

import java.util.Date;

public class LinhaAtividade extends Atividade {

    Date horarioInicio;

    public LinhaAtividade(Atividade atividade) {
        super(atividade.getDescricao(), atividade.getDuracao(), atividade.getManutencao());
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
                ", manutencao=" + manutencao +
                ", horarioInicio=" + horarioInicio +
                '}';
    }
}
