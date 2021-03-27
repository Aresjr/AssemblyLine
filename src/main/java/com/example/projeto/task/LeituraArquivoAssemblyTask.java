package com.example.projeto.task;

import com.example.projeto.builder.ArquivoAssemblyBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LeituraArquivoAssemblyTask {
    private static final Logger log = LoggerFactory.getLogger(LeituraArquivoAssemblyTask.class);

    @Autowired
    private MessageSource messageSource;

    @Scheduled(fixedRateString = "${application.properties.tempo.leitura}")
    public void leArquivoAssembly() {

        String caminhoArquivoLeitura = messageSource.getMessage("arquivo.caminho.leitura", null, Locale.getDefault());
        ArquivoAssemblyBuilder arquivoBuilder = new ArquivoAssemblyBuilder(messageSource);
        log.info(caminhoArquivoLeitura);
    }
}