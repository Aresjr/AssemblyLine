package com.example.projeto.model;

import org.springframework.context.MessageSource;

import java.time.LocalTime;
import java.util.Locale;

public class GinasticaLaboral extends Atividade {

    public GinasticaLaboral(MessageSource messageSource, LocalTime horaInicio) {
        super(null, 15, false, horaInicio);
        setDescricao(messageSource.getMessage("atividade.descricao.laboral", null, Locale.getDefault()));
    }

    @Override
    public String linhasArquivo(MessageSource messageSource) {
        return horarioInicio.toString() + " " + descricao;
    }

}
