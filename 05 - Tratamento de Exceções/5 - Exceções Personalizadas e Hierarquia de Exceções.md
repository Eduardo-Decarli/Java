# Exceções Personalizadas e Hierarquia de Exceções em Java

Quando criamos exceções personalizadas em Java, é importante entender como organizá-las em uma hierarquia de exceções. Isso ajuda a tornar o código mais modular e reutilizável, além de melhorar a manutenção e a legibilidade.

A hierarquia de exceções em Java se baseia em uma árvore de classes, onde a classe Throwable é a raiz, e as exceções que criamos podem se ramificar a partir de classes como Exception ou RuntimeException.

- Para organizar as exceções de forma lógica, facilitando o tratamento e a compreensão dos erros.
- Para permitir que um único bloco catch trate múltiplas exceções relacionadas.
- Para manter a escalabilidade, criando exceções gerais e específicas.

## Conceitos Fundamentais

Throwable → Raiz da Hierarquia de Exceções
- Throwable é a classe pai de todas as exceções em Java.
- Duas subclasses principais:
    - Error → Para erros graves (não deve ser capturada).
    - Exception → Para exceções que podem ser capturadas.

Exception → Exceções que Podem Ser Tratadas
- Subdividida em duas categorias:
    - Checked Exceptions → Exceções que precisam ser tratadas ou declaradas (por exemplo, IOException).
    - Unchecked Exceptions → Exceções que podem ser ignoradas, geralmente causadas por erros de programação (por exemplo, NullPointerException).

Criando uma Hierarquia de Exceções Personalizadas
Ao criar exceções personalizadas, podemos organizar uma hierarquia com classes específicas para erros diferentes, tornando a lógica de tratamento mais flexível.

## Exemplos Práticos

Criando uma Hierarquia de Exceções

``` Java

// Exceção base personalizada
class BancoException extends Exception {
    public BancoException(String mensagem) {
        super(mensagem);
    }
}

// Exceções específicas
class SaldoInsuficienteException extends BancoException {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

class ContaInativaException extends BancoException {
    public ContaInativaException(String mensagem) {
        super(mensagem);
    }
}

public class Banco {
    public void sacar(double saldo, boolean contaAtiva) throws BancoException {
        if (saldo <= 0) {
            throw new SaldoInsuficienteException("Erro: Saldo insuficiente para saque.");
        }
        if (!contaAtiva) {
            throw new ContaInativaException("Erro: Conta inativa.");
        }
        System.out.println("Saque realizado com sucesso.");
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        try {
            banco.sacar(0, true); // Isso lançará uma SaldoInsuficienteException
        } catch (BancoException e) {
            System.out.println(e.getMessage());
        }
    }
}

```

- **BancoException** é a classe base para exceções relacionadas a erros bancários.
- **SaldoInsuficienteException** e **ContaInativaException** são exceções específicas, que estendem a classe base.
- Isso permite capturar erros de forma mais geral ou específica, dependendo da necessidade.

Usando a Hierarquia no catch

``` Java

public class Banco {
    public void sacar(double saldo, boolean contaAtiva) throws BancoException {
        if (saldo <= 0) {
            throw new SaldoInsuficienteException("Erro: Saldo insuficiente para saque.");
        }
        if (!contaAtiva) {
            throw new ContaInativaException("Erro: Conta inativa.");
        }
        System.out.println("Saque realizado com sucesso.");
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        try {
            banco.sacar(0, false);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro específico: " + e.getMessage());
        } catch (ContaInativaException e) {
            System.out.println("Erro específico: " + e.getMessage());
        } catch (BancoException e) {
            System.out.println("Erro genérico: " + e.getMessage());
        }
    }
}

```

- Usamos múltiplos catch para capturar exceções específicas, ou podemos usar BancoException para capturar qualquer erro relacionado ao banco.
- A hierarquia permite capturar exceções específicas antes de capturar a exceção mais geral.