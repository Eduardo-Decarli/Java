# Usando throw e throws corretamente

Em Java, throw e throws são usados para lidar com exceções, mas possuem funções diferentes:

| **Palavra-chave** | **Propósito**                                                 |
|-------------------|---------------------------------------------------------------|
| throw             | Lança uma exceção manualmente durante a execução do programa. |
| throws            | Declara que um método pode lançar uma ou mais exceções.       |

## Conceitos Fundamentais

**throw – Lançando Exceções:** Usado dentro de um método para lançar uma exceção explicitamente, pode lançar tanto exceções personalizadas quanto exceções padrão do Java. Quando um throw é executado, o fluxo do programa é interrompido e a exceção deve ser tratada por um try-catch ou propagada.

``` Java

throw new TipoDaExceção("Mensagem opcional");

```

throws - Declarando exceções no método: Indica que um método pode lançar exceções, mas não as trata diretamente. O chamador do método deve tratar a exceção com try-catch ou propagá-la novamente. Somente checked exceptions precisam ser declaradas com throws; unchecked exceptions são opcionais.

``` Java

public void metodo() throws TipoDaExceção {
    // Código que pode gerar exceção
}

```

## Exemplos Práticos

Agora vamos ver 3 exemplos para uso do throw e throws e suas implementações comuns

``` Java

// Usando throw com uma exceção padrão

public class ExemploThrow {
    public static void dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Erro: Divisão por zero não permitida.");
        }
        System.out.println("Resultado: " + (a / b));
    }

    public static void main(String[] args) {
        dividir(10, 0); // Isso lançará uma exceção
    }
}

```

- Se **b** for **0**, throw lança uma **ArithmeticException**.
- O programa será interrompido, pois não há **try-catch**.

``` Java

// Usando throws para Propagar uma Checked Exception

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExemploThrows {
    public static void lerArquivo(String caminho) throws FileNotFoundException {
        File file = new File(caminho);
        Scanner scanner = new Scanner(file); // Pode lançar FileNotFoundException
        System.out.println("Arquivo lido com sucesso!");
    }

    public static void main(String[] args) {
        try {
            lerArquivo("arquivo_inexistente.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado.");
        }
    }
}

```

- lerArquivo declara throws FileNotFoundException, indicando que pode lançar essa exceção.
- O main chama lerArquivo e trata a exceção com try-catch.

``` Java

// throw e throws Juntos com Exceção Personalizada

// Criando uma exceção personalizada
class IdadeInvalidaException extends Exception {
    public IdadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}

public class Cadastro {
    public static void validarIdade(int idade) throws IdadeInvalidaException {
        if (idade < 18) {
            throw new IdadeInvalidaException("Erro: Idade mínima para cadastro é 18 anos.");
        }
        System.out.println("Cadastro realizado com sucesso.");
    }

    public static void main(String[] args) {
        try {
            validarIdade(16); // Isso lançará a exceção
        } catch (IdadeInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }
}

```

- **throw** lança a exceção personalizada **IdadeInvalidaException**.
- **throws** declara que **validarIdade** pode lançar essa exceção.
- **try-catch** no **main** trata o erro.