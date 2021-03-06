package com.example.projeto.task;

import com.example.projeto.builder.ArquivoAssemblyBuilder;
import com.example.projeto.factory.LinhaMontagemFactory;
import com.example.projeto.model.Atividade;
import com.example.projeto.model.LinhaMontagem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class LeituraArquivoAssemblyTask {
    private static final Logger log = LoggerFactory.getLogger(LeituraArquivoAssemblyTask.class);

    @Autowired
    private MessageSource messageSource;

    @Scheduled(fixedRateString = "${arquivo.tempo.leitura}")
    public void leArquivoAssembly() {

        String caminhoArquivoLeitura = messageSource.getMessage("arquivo.caminho.arquivo.leitura", null, Locale.getDefault());
        ArquivoAssemblyBuilder arquivoBuilder = new ArquivoAssemblyBuilder(messageSource);
        List<Atividade> atividades = new ArrayList<>();
        try {
            atividades = arquivoBuilder.trazAtividadesArquivo(caminhoArquivoLeitura);
        } catch (IOException e) {
            log.error(messageSource.getMessage("log.arquivo.impossivel.ler.arquivo", new String[]{caminhoArquivoLeitura}, Locale.getDefault()));
        }

        if(atividades.size() > 0){
            LinhaMontagemFactory linhaMontagemFactory = new LinhaMontagemFactory(messageSource);
            List<LinhaMontagem> linhasMontagem = linhaMontagemFactory.criaLinhasMontagem(atividades);

            String caminhoArquivoSaida = messageSource.getMessage("arquivo.caminho.arquivo.saida", null, Locale.getDefault());
            try {
                arquivoBuilder.exportaLinhasMontagemArquivo(caminhoArquivoSaida, linhasMontagem);
            } catch (IOException e) {
                log.error(messageSource.getMessage("log.arquivo.impossivel.gravar.arquivo", new String[]{caminhoArquivoSaida}, Locale.getDefault()));
            }
        } else {
            log.error(messageSource.getMessage("log.arquivo.nenhuma.atividade", null, Locale.getDefault()));
        }
    }
}