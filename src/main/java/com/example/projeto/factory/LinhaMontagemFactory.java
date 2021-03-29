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
    private final static LocalTime horaInicioMaxLaboral = LocalTime.of(16, 55);

    public LinhaMontagemFactory(MessageSource messageSource){
        this.messageSource = messageSource;
        this.atividadeFactory = new AtividadeFactory(messageSource);
    }

    public List<LinhaMontagem> criaLinhasMontagem(List<Atividade> atividades){

        List<LinhaMontagem> linhasMontagem = new ArrayList<>();
        LocalTime horarioMontagem = horaInicioMontagem;

        LinhaMontagem linhaMontagem = new LinhaMontagem(sequencia);
        sequencia++;

        for(int i = 0; i < atividades.size(); i++){
            Atividade atividade = atividades.get(i);

            LocalTime horarioSomado = horarioMontagem.plusMinutes(atividade.getDuracao());

            //HORARIO = 9 < 12
            if(horarioMontagem.equals(horaInicioMontagem) || (horarioSomado.isAfter(horaInicioMontagem) && horarioSomado.isBefore(horaInicioAlmoco))) {

                atividade.setHorarioInicio(horarioMontagem);
                linhaMontagem.getLinhasAtividades().add(atividade);
                horarioMontagem = horarioSomado;

            //PASSARIA DE 12 E ANTES DAS 13 = ALMOÇO
            } else if(horarioSomado.isAfter(horaInicioAlmoco) && horarioSomado.isBefore(horaFimAlmoco)) {

                linhaMontagem.getLinhasAtividades().add( atividadeFactory.criaAtividadeAlmoco() );
                atividade.setHorarioInicio(horaFimAlmoco);
                linhaMontagem.getLinhasAtividades().add(atividade);
                horarioMontagem = horaFimAlmoco.plusMinutes(atividade.getDuracao());

            //HORARIO 13 E NÃO PASSARIA DE 16:55
            } else if(horarioSomado.isAfter(horaFimAlmoco) && horarioSomado.isBefore(horaInicioMaxLaboral)) {

                atividade.setHorarioInicio(horarioMontagem);
                linhaMontagem.getLinhasAtividades().add(atividade);
                horarioMontagem = horarioSomado;

            //PASSARIA DO HORÁRIO, ENTÃO COLOCA A LABORAL E CRIA OUTRA LINHA DE MONTAGEM
            } else {

                linhaMontagem.getLinhasAtividades().add( atividadeFactory.criaGinasticaLaboral(horarioMontagem) );
                linhasMontagem.add(linhaMontagem);

                linhaMontagem = new LinhaMontagem(sequencia);
                sequencia++;

                atividade.setHorarioInicio(horaInicioMontagem);
                linhaMontagem.getLinhasAtividades().add(atividade);
                horarioMontagem = horaInicioMontagem.plusMinutes(atividade.getDuracao());

            }

            if(i == atividades.size()-1){
                linhasMontagem.add(linhaMontagem);
            }
        }

        return linhasMontagem;
    }

}
