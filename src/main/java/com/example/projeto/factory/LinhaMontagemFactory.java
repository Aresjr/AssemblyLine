package com.example.projeto.factory;

import com.example.projeto.model.Atividade;
import com.example.projeto.model.LinhaMontagem;

public class LinhaMontagemFactory {

    public LinhaMontagem criaLinhaMontagem(){
        return new LinhaMontagem();
    }

}
