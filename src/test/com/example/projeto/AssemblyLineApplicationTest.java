package com.example.projeto;

import com.example.projeto.builder.ArquivoAssemblyBuilder;
import com.example.projeto.model.Atividade;
import com.example.projeto.model.LinhaMontagem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AssemblyLineApplicationTest {

    @Autowired
    private MessageSource messageSource;

    @Test
    public void singletonInstanciado() {
        assertNotNull(messageSource);
    }

    @Test
    public void arquivoExisteTest() {
        //remover ou renomear arquivo para que teste não passe
        String caminhoArquivoLeitura = messageSource.getMessage("arquivo.caminho.arquivo.leitura", null, Locale.getDefault());
        ArquivoAssemblyBuilder arquivoBuilder = new ArquivoAssemblyBuilder(messageSource);

        assertDoesNotThrow(() -> arquivoBuilder.trazAtividadesArquivo(caminhoArquivoLeitura), messageSource.getMessage("log.arquivo.impossivel.ler.arquivo", new String[]{caminhoArquivoLeitura}, Locale.getDefault()));
    }

    @Test
    public void arquivoSaidaGravavelTest() {
        //alterar o caminho para C:\saida.txt para estourar java.io.FileNotFoundException: C:\saida.txt (Access is denied)
        ArquivoAssemblyBuilder arquivoBuilder = new ArquivoAssemblyBuilder(messageSource);
        String caminhoArquivoEscrita = messageSource.getMessage("arquivo.caminho.arquivo.saida", null, Locale.getDefault());

        assertDoesNotThrow(() -> arquivoBuilder.exportaLinhasMontagemArquivo(caminhoArquivoEscrita, getLinhasMontagemDummy()), messageSource.getMessage("log.arquivo.impossivel.gravar.arquivo", new String[]{caminhoArquivoEscrita}, Locale.getDefault()));
    }

    private static List<LinhaMontagem> getLinhasMontagemDummy(){
        //TODO - migrar para mockito
        List<LinhaMontagem> linhasMontagem = new ArrayList<>();
        List<Atividade> atividades = new ArrayList<>();

        atividades.add(new Atividade("Cutting of steel sheets", 60, false, LocalTime.of(9, 0)));
        atividades.add(new Atividade("Injection subsystem assembly", 60, false, LocalTime.of(10, 0)));
        atividades.add(new Atividade("Navigation subsystem assembly", 60, false, LocalTime.of(11, 0)));

        LinhaMontagem linhaMontagem = new LinhaMontagem(1);
        linhaMontagem.setLinhasAtividades(atividades);

        linhasMontagem.add(linhaMontagem);

        return linhasMontagem;
    }

}
