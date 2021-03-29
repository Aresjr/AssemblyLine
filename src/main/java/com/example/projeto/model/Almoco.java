package com.example.projeto.model;

import org.springframework.context.MessageSource;

import java.time.LocalTime;
import java.util.Locale;

public class Almoco extends Atividade {

    public Almoco(MessageSource messageSource) {
        super(null, 60, false, LocalTime.of(12, 0));
        setDescricao(messageSource.getMessage("atividade.descricao.almoco", null, Locale.getDefault()));
    }

    @Override
    public String linhasArquivo(MessageSource messageSource) {
        return horarioInicio.toString() + " " + descricao;
    }

}
