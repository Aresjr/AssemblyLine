package com.example.projeto.builder;

import com.example.projeto.factory.AtividadeFactory;
import com.example.projeto.interf.ArquivoBuilderInterface;
import com.example.projeto.model.Atividade;
import org.springframework.context.MessageSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoAssemblyBuilder implements ArquivoBuilderInterface {

    private final AtividadeFactory atividadeFactory;

    public ArquivoAssemblyBuilder(MessageSource messageSource){
        this.atividadeFactory = new AtividadeFactory(messageSource);
    }

    public List<Atividade> trazAtividadesArquivo(String caminhoArquivo) throws IOException {
        List<Atividade> atividades = new ArrayList<>();

        File arquivo = new File(caminhoArquivo);
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                atividades.add(atividadeFactory.criaAtividade(linha));
            }
        }

        return atividades;
    }

}
