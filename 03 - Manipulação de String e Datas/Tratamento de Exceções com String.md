# Tratamento de Exceptions com String

Erros ao manipular Strings podem causar exceções, como:

- **NullPointerException** (quando tentamos acessar métodos em uma String nula).

- **IndexOutOfBoundsException** (quando tentamos acessar índices inválidos).

- **NumberFormatException** (ao tentar converter uma String em número inválido).

Usamos **try-catch** para capturar e tratar essas exceções, evitando que o programa quebre inesperadamente.

## Conceitos Fundamentais

**NullPointerException** -> A String está **null** e tentamos chamar um método.

**IndexOutOfBoundsException** -> Acessamos um índice inválido na String.

**NumberFormatException** -> Tentamos converter uma String em número, mas o formato é invalido.

**Bloco try-catch:** O código dentro do try é monitorado, se ocorrer uma exceção, o código dentro do catch trata o erro.

**Bloco Finally (opcional):** Executa código sempre, mesmo se houver erro ou não.

## Exemplos Práticos

- Evitando NullPointerException ao acessar Strings

``` Java

public class TesteNullPointer {
    public static void main(String[] args) {
        String nome = null;

        try {
            System.out.println(nome.length()); // Erro! nome é null
        } catch (NullPointerException e) {
            System.out.println("Erro: String está nula!");
        }
    }
}

```