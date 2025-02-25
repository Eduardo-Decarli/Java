# Tipos de Variáveis em Java

Em Java, variáveis são usadas para armazenar dados. Elas podem ser de dois tipos principais:

- Variáveis primitivas
- Variáveis de referência (objetos)

## Variáveis Primitivas

As variáveis primitivas armazenam valores simples, como números e caracteres. Existem oito tipos primitivos em Java:

| Tipo      | Tamanho | Valor Mínimo            | Valor Máximo            | Descrição                                                |
|-----------|---------|-------------------------|-------------------------|----------------------------------------------------------|
| `byte`    | 1 byte  | -128                    | 127                     | Usado para economizar espaço em grandes arrays.          |
| `short`   | 2 bytes | -32.768                 | 32.767                  | Versão menor de `int` para economizar memória.           |
| `int`     | 4 bytes | -2^31                   | 2^31 - 1                | Tipo padrão para números inteiros.                       |
| `long`    | 8 bytes | -2^63                   | 2^63 - 1                | Usado quando um valor maior que `int` é necessário.      |
| `float`   | 4 bytes | ±1.4E-45                | ±3.4E+38                | Armazena números de ponto flutuante de precisão simples. |
| `double`  | 8 bytes | ±4.9E-324               | ±1.7E+308               | Usado para números de ponto flutuante de precisão dupla. |
| `char`    | 2 bytes | \u0000 (0)              | \uffff (65.535)         | Representa um único caractere Unicode.                   |
| `boolean` | 1 bit   | `false`                 | `true`                  | Representa um valor booleano (verdadeiro ou falso).      |

### Exemplos de declaração

```java

int idade = 25;
boolean ativo = true;
char inicial = 'A';
double salario = 3500.75;

```

# Variáveis de Referência em Java

Em Java, as **variáveis de referência** são usadas para armazenar a referência (endereço de memória) de objetos, ao invés de armazenar diretamente o valor dos dados como nas variáveis primitivas. Todos os tipos de dados não primitivos em Java, como arrays, strings, e objetos de classes, são tipos de referência.

Uma variável de referência armazena o **endereço de memória** onde o objeto é armazenado. Ao contrário dos tipos primitivos, que armazenam diretamente valores, as variáveis de referência apontam para objetos criados no **heap**.

### Exemplo:

```java

String nome = "Maria";
Pessoa pessoa = new Pessoa();
int[] numeros = {1, 2, 3, 4, 5};

```

# Escopo de Variáveis em Java

O **escopo de variáveis** refere-se à parte do programa onde uma variável é visível e pode ser usada. Em Java, o escopo de uma variável depende de onde ela é declarada, e isso afeta seu ciclo de vida (tempo de existência) e acessibilidade.

## Tipos de Escopo de Variáveis

Em Java, existem três tipos principais de escopo para variáveis:

1. **Escopo de Classe (Variáveis de Instância e Estáticas)**
2. **Escopo de Método (Variáveis Locais)**
3. **Escopo de Bloco (Dentro de loops, ifs, etc.)**

---

## 1. Escopo de Classe

As variáveis declaradas dentro de uma classe, mas fora de qualquer método, são chamadas de **variáveis de instância** ou **variáveis de classe** (se forem `static`).

### a Variáveis de Instância

- **Escopo:** Acessível em toda a classe, exceto em métodos estáticos.
- **Ciclo de Vida:** Existente enquanto o objeto da classe estiver ativo.
- **Acessibilidade:** Acessada por qualquer método da classe (desde que não seja `static`).
  
#### Exemplo:

```java
class Carro {
    String modelo; // Variável de instância
    int ano;
    
    void exibirDetalhes() {
        System.out.println("Modelo: " + modelo + ", Ano: " + ano);
    }
}
