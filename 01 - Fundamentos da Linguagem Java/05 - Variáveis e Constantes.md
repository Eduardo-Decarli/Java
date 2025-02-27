# Variáveis e Constantes

Agora vamos entender como armazenar valores de forma eficiente usando **variáveis** e **constantes** em Java.

**Variáveis:** Uma variável é um espaço na memória que armazena um valor que pode ser alterado durante a execução do programa.

**Constantes:** Uma constante é um valor na memória que não pode ser alterado após a inicialização.

Usar variáveis e constantes corretametne torna o código mais organizado, eficiente e legível.

## Conceitos Fundamentais

- **Declaração de Variáveis:** Para declarar uma variável, usamos a seguinte sintaxe: **tipo nomeDaVariavel = valorInicial;**, como por exemplo:

``` Java

int idade = 25;
double preco = 49.99;
String nome = "Java";

```

- **Regras para nomes de Variáveis:** Toda variável deve começar com uma **letra**, **_** (underline) ou **$**. Não podem conter espaços ou caracteres especiais (*, %, @, etc). As variaveis em java também são case-sensitive (**idade** ≠ **Idade**). E não podem ser palavras-chave do Java (**int**, **class**, **static**, etc).

**final:** Torna a variável imutável/constante

``` Java

final double PI = 3.1314;

```

**static:** Compartilha a variável entre todas as instâncias da classe.

``` Java

static int contador = 0;

```

**transient:** Impede a serialização da variável.

``` Java

transient String senha;

```

**volatile:** Indica que a variável pode ser alterada por várias threads.

``` Java

volatile boolean ativo;

```

## Exemplos Práticos

Aqui temos um exemplo de variáveis e atribuição

``` Java

public class ExemploVariaveis {
    public static void main(String[] args) {
        int idade = 30;
        double altura = 1.75;
        boolean ativo = true;
        String nome = "Alice";

        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);
        System.out.println("Está ativo? " + ativo);

        // Alterando valores das variáveis
        idade = 31;
        System.out.println("Nova idade: " + idade);
    }
}

```

Aqui temos um Exemplo de Constante (**final**)

``` Java

public class ExemploConstantes {
    public static void main(String[] args) {
        final double PI = 3.1415;
        final int ANO_ATUAL = 2025;

        System.out.println("Valor de PI: " + PI);
        System.out.println("Ano Atual: " + ANO_ATUAL);

        // Tentando alterar uma constante (erro)
        ANO_ATUAL = 2030; // ERRO! Constantes não podem ser modificadas
    }
}

```

## Boas Práticas

- Use nomes descritivos para variáveis (**precoProduto** em vez de **x**).

- Utilize **final** para valores que não devem ser alterados.

- Declare variáveis o mais próximo possível do uso para melhorar a legibilidade.

- Prefira **camelCase** para variáveis (**minhaVariavel**).

- Constantes devem ser em **UPPER_CASE** (**TAMANHO_MAXIMO**).