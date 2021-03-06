package com.example.projeto.factory;

import com.example.projeto.model.Atividade;
import com.sun.media.sound.InvalidFormatException;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class AtividadeFactory {

    private static final Logger log = LoggerFactory.getLogger(AtividadeFactory.class);
    private final MessageSource messageSource;
    private static final String separador = " ";
    private static final String sinalizaManutencao = "maintenance";
    private static final String sinalizaMinutos = "min";
    private static final int duracaoManutencao = 15;

    public AtividadeFactory(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    public Atividade criaAtividadeDaLinhaDeArquivo(String linhaArquivo) throws InvalidFormatException {

        int duracao;
        boolean manutencao = false;

        String[] valores = linhaArquivo.split(separador);
        String duracaoOuManutencao = valores[valores.length-1];
        if(duracaoOuManutencao.equals(sinalizaManutencao)) {
            manutencao = true;
            duracao = duracaoManutencao;
            valores = ArrayUtils.remove(valores, valores.length-1);
        } else {
            if(!duracaoOuManutencao.contains(sinalizaMinutos)){
                throw new InvalidFormatException(messageSource.getMessage("log.arquivo.formato.invalido", new String[]{duracaoOuManutencao}, Locale.getDefault()));
            }
            String[] duracaoAtividadeMin = duracaoOuManutencao.split(sinalizaMinutos);

            try {
                duracao = Integer.parseInt(duracaoAtividadeMin[0]);
            } catch(NumberFormatException e) {
                throw new InvalidFormatException(messageSource.getMessage("log.arquivo.formato.invalido", new String[]{duracaoOuManutencao}, Locale.getDefault()));
            }
        }

        String[] valoresDescricaoAtividade = ArrayUtils.remove(valores, valores.length-1);
        String descricaoAtividade = String.join(separador, valoresDescricaoAtividade);

        Atividade atividade = new Atividade(descricaoAtividade, duracao, manutencao, null);
        log.info(atividade.toString());
        return atividade;
    }

}
