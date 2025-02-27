# ArrayList

**ArrayList** é uma implementação da interface **List** em Java. Diferente de **arrays**, que têm tamanho fixo, um ArrayList pode crescer e diminuir dinamicamente conforme elementos são adicionados ou removidos.

- Permite elementos duplicados
- Mantém a ordem de inserção
- Acesso rápido a elementos por indice (0(1))
- Usa um array interno para armazenar os elementos

## Conceitos Fundamentais

- Declaração e Inicialização

``` Java

import java.util.ArrayList;
import java.util.List;

List<String> lista = new ArrayList<>();

```

- Métodos Principais

| Método                   | Descrição                                    |
|--------------------------|----------------------------------------------|
| add(E e)                 | Adiciona um elemento no final                |
| add(int index, E e)      | Adiciona um elemento em um índice específico |
| get(int index)           | Obtém o elemento no índice específico        |
| set(int index, Object e) | Substitui um elemento no índice especificado |
| remove(int index)        | Remove o elemento no índice especificado     |
| remove(Object e)         | Remove a primeira ocorrência do objeto       |
| size()                   | Retorna o número de elementos na lista       |
| contains(Object o)       | Retorna true se o elemento existir           |
| indexOf(Object o)        | Retorna o índice da primeira ocorrência      |
| isEmpy()                 | Retornatrue se a lista estiver vazia         |

## Exemplos Práticos

- Criando e Manipulando um ArrayList

``` Java

import java.util.ArrayList;
import java.util.List;

public class TesteArrayList {
    public static void main(String[] args) {
        // Criando um ArrayList de nomes
        List<String> nomes = new ArrayList<>();

        // Adicionando elementos
        nomes.add("Alice");
        nomes.add("Bob");
        nomes.add("Carlos");

        // Imprimindo a lista
        System.out.println(nomes); // [Alice, Bob, Carlos]

        // Acessando um elemento pelo índice
        System.out.println(nomes.get(1)); // Bob

        // Modificando um elemento
        nomes.set(1, "Bruna");
        System.out.println(nomes); // [Alice, Bruna, Carlos]

        // Removendo um elemento
        nomes.remove("Bruna");
        System.out.println(nomes); // [Alice, Carlos]

        // Verificando tamanho
        System.out.println("Tamanho da lista: " + nomes.size()); // 2

        // Verificando se um elemento existe
        System.out.println(nomes.contains("Alice")); // true
    }
}

```

---

- Iterando sobre um ArrayList

``` Java

// Utilizando for-each

for (String nome : nomes) {
    System.out.println(nome);
}


// Usando for com índice

for (int i = 0; i < nomes.size(); i++) {
    System.out.println(nomes.get(i));
}

// Usando for-each com lambda

nomes.forEach(nome -> System.out.println(nome));

```

## Boas Práticas

- Prefira **List<String> lista = new ArrayList<>();** ao invés de **ArrayList<String> lista = new ArrayList<>();** para maior flexibilidade.

- Use **isEmpty()** ao invés de **size() == 0** para verificar se a lista está vazia.

- Use **removeIf()** para remover elementos com critério.
