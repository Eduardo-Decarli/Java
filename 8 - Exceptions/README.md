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

O uso da palavra-chave throws em um método indica que esse método pode lançar uma exceção, mas não a trata diretamente. Em vez disso, delega a responsabilidade para o método chamador.

```java

public void metodo() throws IOException {
    // Código que pode lançar uma IOException
}

```

A palavra-chave throw é usada para lançar uma exceção explicitamente.

```java

public void metodo() {
    throw new IllegalArgumentException("Argumento inválido");
}

```

### Exemplo completo de Exceptions

```java

import java.io.*;

public class ExemploException {
    public static void main(String[] args) {
        try {
            lerArquivo("arquivo.txt");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            System.out.println("Operação concluída.");
        }
    }

    public static void lerArquivo(String nomeArquivo) throws IOException {
        if (nomeArquivo == null) {
            throw new IllegalArgumentException("O nome do arquivo não pode ser nulo");
        }
        // Simulando uma operação que pode lançar IOException
        FileReader arquivo = new FileReader(nomeArquivo);
        BufferedReader leitor = new BufferedReader(arquivo);
        System.out.println(leitor.readLine());
        leitor.close();
    }
}


