# Criando exceções personalizadas em Java

As exceções personalizadas permitem criar classes de erro específicas para a lógica da aplicação, tornando o código mais compreensível e facilitando a depuração.

- Para representar erros específicos do domínio da aplicação.
- Para adicionar mensagens mais descritivas e personalizadas.
- Para encapsular lógica específica no tratamento de erros. 

Uma exceção personalizada em Java é criada estendendo uma classe de exceção existente:

**Checked Exception** → Deve estender Exception. Usado quando o erro deve ser tratado obrigatoriamente pelo chamador.
**Unchecked Exception** → Deve estender RuntimeException. Quando o erro ocorre por falha de programação (ex.: valores inválidos).

``` Java

// Criando uma exceção personalizada para saldo insuficiente
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

// Classe Banco para testar a exceção
public class Banco {
    private double saldo;

    public Banco(double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Erro: Saldo insuficiente para saque de R$ " + valor);
        }
        saldo -= valor;
        System.out.println("Saque realizado. Novo saldo: R$ " + saldo);
    }

    public static void main(String[] args) {
        Banco conta = new Banco(100.0);

        try {
            conta.sacar(150.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
}

```

- SaldoInsuficienteException estende Exception, tornando-se uma checked exception.
- O método sacar usa throws para indicar que pode lançar essa exceção.
- O **try-catch** no main trata a exceção.

``` Java

// Criando exceção personalizada para idade inválida
class IdadeInvalidaException extends RuntimeException {
    public IdadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}

// Classe Validador para testar a exceção
public class Validador {
    public static void validarIdade(int idade) {
        if (idade < 18) {
            throw new IdadeInvalidaException("Erro: Idade mínima para cadastro é 18 anos.");
        }
        System.out.println("Idade válida para cadastro.");
    }

    public static void main(String[] args) {
        validarIdade(16); // Isso lançará a exceção
    }
}

```

- IdadeInvalidaException estende RuntimeException, tornando-se uma unchecked exception.
- O método validarIdade lança a exceção sem precisar de throws.
- Se a idade for menor que 18, ocorre um erro

## Boas Praticas

- Nomeie as exceções de forma clara (SaldoInsuficienteException, IdadeInvalidaException).
- Sempre forneça uma mensagem descritiva no construtor.
- Prefira checked exceptions para erros previsíveis e unchecked exceptions para falhas de