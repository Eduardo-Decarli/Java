# Tipos de Dados em Java

Os tipos de dados determinam o tipo de valores que podem ser armazenados em variáveis. Java possui dois grupos principais:

**Tipos primitivos** → Armazenam valores simples diretamente na memória.

**Tipos de referência** → Armazenam referências para objetos, permitindo manipular estruturas mais complexas.

## Tipos Primitivos

Os tipos primitivos são os blocos básicos de construção do Java. Eles ocupam um espaço fixo na memória e são mais rápidos.

![Tipos de Dados](tipos_de_dados.png)

- **long** deve terminar com **L**, como em **1000000L**.

- **float** deve terminar com **f**, como em **3.14f**.

- **char** usa aspas simples (**'A'**), enquanto String usa aspas duplas (**"Java"**).

## Tipos Referência (Armazenam objetos e arrays)

Os tipos de referência armazenam **endereços de memória** que apontam para objetos. Diferente dos primitivos, eles não armazenam diretamente o valor, mas sim uma referência ao objeto.

| Tipo    | Descrição                             | Exemplo                       |
|---------|---------------------------------------|-------------------------------|
| String  | Cadeia de caracteres                  | String nome = "Java";         |
| Arrays  | Coleção de valores do mesmo tipo      | int[] numeros = {1, 2, 3};    |
| Classes | Instâncias de objetos personalizados  | Pessoa p = new Pessoa();      |

- String é imutável (qualquer alteração gera um novo objeto).

- Arrays e classes são sempre manipulados por referência.

## Exemplos 

- Tipos Primitivos

``` Java

public class TiposPrimitivos {
    public static void main(String[] args) {
        byte idade = 25;
        int populacao = 1500000;
        long distancia = 10000000000L;
        float temperatura = 36.5f;
        double preco = 49.99;
        char inicial = 'J';
        boolean ativo = true;

        System.out.println("Idade: " + idade);
        System.out.println("População: " + populacao);
        System.out.println("Distância: " + distancia);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Preço: " + preco);
        System.out.println("Inicial: " + inicial);
        System.out.println("Ativo: " + ativo);
    }
}

```

- Exemplo Tipo Referencia

``` Java

public class TiposReferencia {
    public static void main(String[] args) {
        // String (objeto imutável)
        String nome = "Java";
        
        // Array
        int[] numeros = {1, 2, 3, 4, 5};

        // Criando um objeto
        Pessoa pessoa = new Pessoa("Alice", 30);

        System.out.println("Nome: " + nome);
        System.out.println("Primeiro número: " + numeros[0]);
        pessoa.apresentar();
    }
}

// Classe Pessoa
class Pessoa {
    String nome;
    int idade;

    // Construtor
    Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método para exibir informações
    void apresentar() {
        System.out.println("Meu nome é " + nome + " e tenho " + idade + " anos.");
    }
}

```

## Boas Práticas

- Escolha o tipo adequado para economizar memória → Exemplo: Use byte para idades pequenas, int para contagens maiores.

- Prefira double para cálculos matemáticos (evita erros de precisão do float).

- Utilize String com moderação → Se precisar modificar o texto frequentemente, use StringBuilder.

- Inicialize variáveis sempre que possível → Evita comportamento inesperado.

- Use **==** para comparar tipo primitivo e **equals()** para comparar tipo referência.