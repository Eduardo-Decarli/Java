# Tratamento de Exceções em Java

## O que são Exceções?

Exceções são eventos que ocorrem durante a execução de um programa que interrompem o fluxo normal das instruções. Em Java, as exceções são usadas para indicar erros ou condições inesperadas que podem ocorrer durante a execução do programa, como divisão por zero, tentativa de acessar um índice fora dos limites de uma array ou uma falha na abertura de um arquivo.

## Tipos de Exceções

As exceções em Java podem ser categorizadas em três tipos:

1. **Checked Exceptions** (Exceções Verificadas): 
   - São exceções verificadas em tempo de compilação. O compilador força o programador a tratar essas exceções explicitamente. Elas geralmente ocorrem por motivos externos ao programa, como falhas de I/O.
   - Exemplo: `IOException`, `SQLException`.

2. **Unchecked Exceptions** (Exceções Não Verificadas): 
   - Também conhecidas como `RuntimeException`, essas exceções ocorrem durante a execução do programa e não precisam ser tratadas obrigatoriamente. Elas resultam principalmente de erros de lógica de programação.
   - Exemplo: `NullPointerException`, `ArrayIndexOutOfBoundsException`.

3. **Error**: 
   - `Error` refere-se a problemas graves que ocorrem fora do controle do aplicativo, como falhas de hardware ou de sistema. Erros geralmente não são tratados pelo programa.
   - Exemplo: `OutOfMemoryError`, `StackOverflowError`.

## Hierarquia de Exceções

Todas as exceções e erros em Java são subclasses da classe `Throwable`. A hierarquia básica de exceções é a seguinte:


- **Throwable**: É a superclasse de todas as exceções e erros. 
- **Exception**: Representa exceções que podem ser razoavelmente tratadas.
- **RuntimeException**: Subclasse de `Exception`, usada para exceções que podem ocorrer em tempo de execução e não são verificadas pelo compilador.
- **Error**: Representa problemas graves que, em geral, o programa não consegue recuperar.

## Blocos de Tratamento de Exceções

### `try-catch`

O bloco `try-catch` é usado para capturar e tratar exceções. O código que pode gerar uma exceção é colocado dentro do bloco `try`, e o tratamento dessa exceção é feito no bloco `catch`.

```java
try {
    // Código que pode lançar uma exceção
} catch (TipoDeExcecao e) {
    // Código para tratar a exceção
}

```

### Finally

O bloco finally é opcional e é executado após o bloco try-catch, independentemente de uma exceção ter sido lançada ou não. Geralmente é usado para liberar recursos, como fechar arquivos ou conexões de banco de dados.

```java
try {
    // Código que pode lançar uma exceção
} catch (TipoDeExcecao e) {
    // Código para tratar a exceção
} finally {
    // Código que será sempre executado
}

```

## throws

A palavra-chave throws em um método indica que o método pode lançar uma ou mais exceções, mas não as trata diretamente. Em vez disso, ele "avisa" que o método pode lançar uma exceção, e quem chamar esse método será responsável por tratar a exceção.

```java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

    // O método readFile "avisa" que pode lançar uma IOException, mas não trata essa exceção aqui.
    public void readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void main(String[] args) {
        FileReaderExample example = new FileReaderExample();
        String filePath = "example.txt"; // Caminho para o arquivo

        // Aqui, o main é responsável por tratar a exceção lançada pelo método readFile
        try {
            example.readFile(filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}

```

### Exemplo completo de Exceptions

```java

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberInputExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int number = 0;

        // Continuar pedindo um número até que o usuário insira um valor válido
        while (!validInput) {
            try {
                System.out.print("Please enter a number: ");
                number = scanner.nextInt();  // Tenta ler um número inteiro
                validInput = true;  // Se chegou até aqui, a entrada foi válida
            } catch (InputMismatchException e) {
                // Trata a exceção caso o usuário digite algo que não seja um número
                System.out.println("That's not a valid number. Please try again.");
                scanner.next();  // Limpa a entrada inválida
            }
        }

        System.out.println("You entered the number: " + number);
        scanner.close();
    }
}

```


