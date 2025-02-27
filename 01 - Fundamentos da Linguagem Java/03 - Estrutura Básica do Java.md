# Estrutura Básica de um Programa Java

Todo programa Java segue uma estrutura padrão, que permite organizar o código de forma legível e eficiente. Ele deve conter:

- **Pacote (opcional):** Organização do código em módulos.

- **Classe principal:** Define o ponto de entrada do programa.

- **Método main:** Onde a execução do programa começa.

- **Comentários:** Melhoram a legibilidade do código.

## Conceitos Fundamentais

Antes de vermos o código, entenda algumas palavras chaves:

**Classes e Métodos:** Uma classe é um bloco que contém atributos e métodos. O método main é o ponto de inicio de um programa Java.

- **public:** Define a visibilidade (Acessível para outras partes do programa).

- **static:** Permite chamar o método sem criar um objeto da classe.

- **void:** Indica que o método não retornará valor nenhum após sua conclusão.

- **System.out.println():** Exibe mensagens no console.

``` Java

// Declaração do pacote (opcional, usado para organizar classes)
package com.exemplo;

// Declaração da classe principal
public class Main {

    // Método principal que inicia o programa
    public static void main(String[] args) {
        // Exibe "Olá, Mundo!" no console
        System.out.println("Olá, Mundo!");
    }
}

```

- **Pacote (package com.exemplo):** Define o pacote onde a classe pertence. Pode ser omitido em pequenos programas.

- **Classe Principal (public class Main):** O nome da classe deve ser igual ao nome do arquivo (Main.java).

- **Método main (public static void main(String[] args)):** Onde o programa começa a ser executado.

- **String[] args:** Permite receber argumentos ao executar o programa.

- **Exibir no Console (System.out.println("Olá, Mundo!")):** Imprime o texto na tela e pula para a próxima linha.

## Estrutura detalhada de um porgrama java

Aqui está um exemplo mais completo:

``` Java

package com.exemplo;

// Definição de uma classe
public class Pessoa {
    // Atributos (variáveis da classe)
    String nome;
    int idade;

    // Construtor (método chamado ao criar um objeto)
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método para exibir informações
    public void apresentar() {
        System.out.println("Meu nome é " + nome + " e tenho " + idade + " anos.");
    }

    // Método principal
    public static void main(String[] args) {
        // Criando um objeto da classe Pessoa
        Pessoa pessoa1 = new Pessoa("Alice", 25);
        pessoa1.apresentar();  // Saída: Meu nome é Alice e tenho 25 anos.
    }
}

```

**Atributos String nome e int idade:** Variáveis que guardam informações sobre a pessoa.

**Construtor (Pessoa(String nome, int idade)):** Inicializa o objeto ao ser criado.

**Método apresentar():** Exibe as informações da pessoa. 

**Criando um objeto (new Pessoa("Alice", 25)):** Instancia a classe e chama seus métodos.

## Boas Práticas

- Nomeie classes com inicial maiúscula (Main, Pessoa).

- Use indentação e comentários para legibilidade.

- Separe bem as responsabilidades (classe deve conter apenas atributos e métodos relacionados).

- Evite usar **System.out.println()** dentro da lógica principal (separe a lógica e a apresentação).