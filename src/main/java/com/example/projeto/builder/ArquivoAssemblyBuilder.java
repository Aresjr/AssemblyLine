package com.example.projeto.builder;

import com.example.projeto.interf.ArquivoBuilderInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import java.io.IOException;

public class ArquivoAssemblyBuilder implements ArquivoBuilderInterface {

    private static final Logger log = LoggerFactory.getLogger(ArquivoAssemblyBuilder.class);
    private final MessageSource messageSource;

    public ArquivoAssemblyBuilder(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    private void parseLines() throws IOException {
    }

}
