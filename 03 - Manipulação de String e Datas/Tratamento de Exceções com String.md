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

---

- Evitando IndexOutOfBoundsException ao acessar caracteres

``` Java

public class TesteIndexOutOfBounds {
    public static void main(String[] args) {
        String texto = "Java";

        try {
            char letra = texto.charAt(10); // Índice inválido!
            System.out.println(letra);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: Índice fora do limite da String!");
        }
    }
}

```

---

- Evitando NumberFormatException ao converter Strings para números

``` Java

public class TesteNumberFormat {
    public static void main(String[] args) {
        String numeroTexto = "abc"; // Valor inválido!

        try {
            int numero = Integer.parseInt(numeroTexto);
            System.out.println("Número convertido: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Erro: String não pode ser convertida em número!");
        }
    }
}

```

## Boas Práticas

- Sempre verifique se a String não é null antes de acessar seus métodos.

- Antes de acessar índices, use **if (indice < string.length())**.

- Antes de converter para número, use **matches("\\d+")** para validar.

- Capture exceções específicas (**NullPointerException**, **NumberFormatException**, etc.), ao invés de capturar Exception genérica.