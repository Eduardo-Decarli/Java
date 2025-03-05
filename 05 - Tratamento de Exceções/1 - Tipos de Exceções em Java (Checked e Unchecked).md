# Tipos de Exceções em Java (Checked e Unchecked)

O tratamento de exceções em Java permite que um programa lide com erros de maneira controlada, evitando falhas inesperadas e melhorando a robustez da aplicação.

Uma exceção é um evento inesperado que ocorre durante a execução do programa, interrompendo seu fluxo normal. Java categoriza as exceções em dois tipos principais:

Checked Exceptions (Exceções Verificadas)
Unchecked Exceptions (Exceções Não Verificadas)

## Conceitos Fundamentais

**Checked Exceptions (Exceções Verificadas)**: São exceções que o compilador obriga a serem tratadas. Ocorrem devido a situações previsíveis, como falha ao abrir um arquivo ou erro de conexão com banco de dados. Precisam ser tratadas com **try-catch** ou declaradas com **throws** no método.

- IOException → erro ao manipular arquivos.
- SQLException → erro ao interagir com banco de dados.
- FileNotFoundException → arquivo não encontrado.

``` Java

// Exemplo de Checked Exception

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            File file = new File("arquivo.txt");
            Scanner scanner = new Scanner(file); // Pode lançar FileNotFoundException
            System.out.println("Arquivo encontrado!");
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado!");
        }
    }
}

```

Neste exemplo, FileNotFoundException é uma exceção verificada, então somos obrigados a tratá-la.

**Unchecked Exceptions (Exceções Não Verificadas)**: São exceções que não precisam ser tratadas obrigatoriamente. Representam erros de lógica do programa, geralmente causados por más práticas de programação. Herdam de RuntimeException.

- NullPointerException → tentar acessar um objeto nulo.
- ArrayIndexOutOfBoundsException → acessar um índice inexistente em um array.
- ArithmeticException → divisão por zero.

``` Java

// Exemplo de Unchecked Exception

public class UncheckedExceptionExample {
    public static void main(String[] args) {
        String texto = null;
        System.out.println(texto.length()); // Causa NullPointerException
    }
}

```

Aqui, NullPointerException é uma unchecked exception, pois ocorre devido a um erro lógico do programador.

## Boas Práticas

- Sempre trate checked exceptions com **try-catch** ou use throws se for mais apropriado.
- Use mensagens de erro descritivas para facilitar a depuração.
- Evite capturar exceções genéricas (Exception), pois isso pode mascarar erros específicos.
- Valide valores de entrada para evitar exceções desnecessárias, como **NullPointerException**.