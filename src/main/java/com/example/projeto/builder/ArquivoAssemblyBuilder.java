package com.example.projeto.builder;

import com.example.projeto.interf.ArquivoBuilderInterface;
import com.example.projeto.model.Atividade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ArquivoAssemblyBuilder implements ArquivoBuilderInterface {

    private static final Logger log = LoggerFactory.getLogger(ArquivoAssemblyBuilder.class);
    private final MessageSource messageSource;

    public ArquivoAssemblyBuilder(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    public List<Atividade> trazAtividadesArquivo(String caminhoArquivo) throws IOException {
        List<Atividade> atividades = null;

        File arquivo = new File(caminhoArquivo);
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                //TODO - continuar amanhã
            }
        }

        return atividades;
    }

}
