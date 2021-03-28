package com.example.projeto.factory;

import com.example.projeto.model.Atividade;
import com.example.projeto.model.LinhaMontagem;
import org.springframework.context.MessageSource;

public class LinhaMontagemFactory {

    MessageSource messageSource;

    public LinhaMontagemFactory(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    public LinhaMontagem criaLinhaMontagem(Atividade atividade){
        return new LinhaMontagem();
    }

}
