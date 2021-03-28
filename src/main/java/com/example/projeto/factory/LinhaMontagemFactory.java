package com.example.projeto.factory;

import com.example.projeto.model.Atividade;
import com.example.projeto.model.LinhaMontagem;
import org.springframework.context.MessageSource;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class LinhaMontagemFactory {

    MessageSource messageSource;
    private static Integer sequencia = 1;
    private final AtividadeFactory atividadeFactory;
    private final static LocalTime horaInicioMontagem = LocalTime.of(9, 0);
    private final static LocalTime horaInicioAlmoco = LocalTime.of(12, 0);
    private final static LocalTime horaFimAlmoco = LocalTime.of(13, 0);
    private final static LocalTime horaInicioMinLaboral = LocalTime.of(16, 0);
    private final static LocalTime horaInicioMaxLaboral = LocalTime.of(17, 0);

    public LinhaMontagemFactory(MessageSource messageSource){
        this.messageSource = messageSource;
        this.atividadeFactory = new AtividadeFactory(messageSource);
    }

    public List<LinhaMontagem> criaLinhasMontagem(List<Atividade> atividades){

        List<LinhaMontagem> linhasMontagem = new ArrayList<>();
        LinhaMontagem linhaMontagem = new LinhaMontagem();
        for(Atividade atividade : atividades){
            //TODO - tratar os tempos
            atividade.getDuracao();
        }
        return linhasMontagem;
    }

}
