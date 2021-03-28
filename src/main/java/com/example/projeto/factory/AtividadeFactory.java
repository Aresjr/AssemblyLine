package com.example.projeto.factory;

import com.example.projeto.model.Atividade;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class AtividadeFactory {

    private final MessageSource messageSource;

    AtividadeFactory(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    public Atividade criaAtividade(String linhaArquivo){
        String separador = this.messageSource.getMessage("arquivo.atividade.separador", null, Locale.getDefault());
        String[] valores = linhaArquivo.split(separador);
        String duracaoBruta = valores[valores.length-1];
        //TODO - continuar amanhã
        return new Atividade("teste", 15);
    }

}
