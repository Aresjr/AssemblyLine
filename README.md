# AssemblyLine

## Compilação e Utilização
```
mvn clean install
java -jar DesafioReceita-0.0.1-SNAPSHOT.jar
```

## Testes Unitários
```mvn test```

## Funcionamento
Projeto criado como um serviço agendado para rodar a cada 10 segundos, configurado para a leitura do arquivo no caminho *C:\assembly\input.txt* e a geração do arquivo novo com o resultado no caminho *C:\assembly\saida.txt*.

Qualquer alteração no arquivo de entrada afetará a próxima execução da tarefa, o que ajuda nos testes do arquivo de saída em tempo real.

O caminho do arquivo pode ser alterado no arquivo ```messages.properties```, propriedade ```arquivo.caminho.arquivo.leitura``` e o tempo de espera entre as execuções no arquivo ```application.properties```, propriedade ```arquivo.tempo.leitura```
