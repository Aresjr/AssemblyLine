package com.example.projeto.builder;

import com.example.projeto.factory.AtividadeFactory;
import com.example.projeto.factory.LinhaMontagemFactory;
import com.example.projeto.interf.ArquivoBuilderInterface;
import com.example.projeto.model.Atividade;
import com.example.projeto.model.LinhaMontagem;
import com.sun.media.sound.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoAssemblyBuilder implements ArquivoBuilderInterface {

    private static final Logger log = LoggerFactory.getLogger(ArquivoAssemblyBuilder.class);
    private final AtividadeFactory atividadeFactory;
    private final LinhaMontagemFactory linhaMontagemFactory;

    public ArquivoAssemblyBuilder(MessageSource messageSource){
        this.atividadeFactory = new AtividadeFactory(messageSource);
        this.linhaMontagemFactory = new LinhaMontagemFactory(messageSource);
    }

    public List<Atividade> trazAtividadesArquivo(String caminhoArquivo) throws IOException {
        List<Atividade> atividades = new ArrayList<>();

        File arquivo = new File(caminhoArquivo);
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                //trata exceção por linha para não impedir a "importação" das outras linhas
                try {
                    atividades.add(atividadeFactory.criaAtividadeDaLinhaDeArquivo(linha));
                } catch(InvalidFormatException e) {
                    log.error(e.getLocalizedMessage());
                }
            }
        }

        return atividades;
    }

    public void exportaLinhasMontagemArquivo(String caminhoArquivoSaida, List<LinhaMontagem> linhasMontagem) throws IOException {

        FileWriter writer = null;
        try {
            writer = new FileWriter(caminhoArquivoSaida);
            StringBuilder conteudoArquivo = new StringBuilder();
            for(LinhaMontagem linhaMontagem : linhasMontagem){
                conteudoArquivo.append(linhaMontagem.toString());
                conteudoArquivo.append("\n");
            }
            writer.write(conteudoArquivo.toString());
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }
}
