# LinkedList

A LinkedList é uma implementação da interface List e também da Deque em Java, baseada em uma lista duplamente encadeada. Diferente de um ArrayList, onde os elementos são armazenados em um array dinâmico, a LinkedList armazena cada elemento como um nó contendo referências para o nó anterior e o próximo.

- Permite elementos duplicados.
- Mantém a ordem de inserção.
- Inserções e remoções eficientes no início e no meio da lista (O(1) se referenciarmos diretamente o nó).
- Acesso por índice é mais lento (O(n)) comparado ao ArrayList.

## Conceitos Fundamentais

- Declaração e Inicialização

``` Java

import java.util.LinkedList;
import java.util.List;

List<String> lista = new LinkedList<>();

```

- Estrutura de um nó interno (explicação simplificada): Cada nó da LinkedList contem o dado armazenado, referência ao anterior e referencia ao seguinte

- Principais Métodos da LinkedList

| Método                     | Descrição                                    |
|----------------------------|----------------------------------------------|
| add(E e)                   | Adiciona um elemento no final.               |
| add(int index, E e)        | Adiciona um elemento em um índice específico |
| addFirst()                 | Adiciona um elemento no início               |
| addLast(E e)               | Adiciona um elemento no final                |
| get(int index)             | Obtém o elemento no índice especificado      |
| getFirst() / getLast()     | Obtém o primeiro ou o ultimo elemento        |
| remove(int index)          | Remove o elemento no índice especificado     |
| removeFirst() / removeLast | Remove o primeiro ou o último elemento       |
| size()                     | Retorna o número de elementos na lista       |
| contains(Object o)         | Retorna true se o elemento existir           |
| indexOf(Object o)          | Retorna o índice da primeira ocorrencia      |
| isEmpty()                  | Retorna true se a lista estiver vazia        |

## Exemplos Práticos

- Criando e Manipulando uma LinkedList

``` Java

import java.util.LinkedList;
import java.util.List;

public class TesteLinkedList {
    public static void main(String[] args) {
        // Criando uma LinkedList de nomes
        List<String> nomes = new LinkedList<>();

        // Adicionando elementos
        nomes.add("Alice");
        nomes.add("Bob");
        nomes.add("Carlos");

        // Imprimindo a lista
        System.out.println(nomes); // [Alice, Bob, Carlos]

        // Adicionando no início e no fim
        ((LinkedList<String>) nomes).addFirst("Zara");
        ((LinkedList<String>) nomes).addLast("Daniel");

        System.out.println(nomes); // [Zara, Alice, Bob, Carlos, Daniel]

        // Acessando elementos
        System.out.println("Primeiro: " + ((LinkedList<String>) nomes).getFirst()); // Zara
        System.out.println("Último: " + ((LinkedList<String>) nomes).getLast()); // Daniel

        // Removendo elementos
        ((LinkedList<String>) nomes).removeFirst();
        ((LinkedList<String>) nomes).removeLast();

        System.out.println(nomes); // [Alice, Bob, Carlos]
    }
}

```

---

- Iterando sobre uma **LinkedList**

``` Java

// Usando for-each

for (String nome : nomes) {
    System.out.println(nome);
}

// Usando for com índice

for (int i = 0; i < nomes.size(); i++) {
    System.out.println(nomes.get(i));
}

// Usando forEach com Lambda

nomes.forEach(nome -> System.out.println(nome));

// Usando Iterator

Iterator<String> it = nomes.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}

```

## Diferença entre ArrayList e LinkedList

| Critério                        | ArrayList                       | LinkedList                                   |
|---------------------------------|---------------------------------|----------------------------------------------|
| Estrutura interna               | Array dinâmico                  | lista duplamente encadeada                   |
| Acesso por índice (get)         | Rápido (0(1))                   | Lento (0(n))                                 |
| Inserção no final (add)         |	Rápido (O(1))                   | Rápido (O(1))                                |
| Inserção no meio (add(index))	  | Lento (O(n))	                | Rápido (O(1) se nó for acessado diretamente) |
| Remoção do meio (remove(index)) | Lento (O(n))                    | Rápido (O(1) se nó for acessado diretamente) |
| Uso de memória	              | Melhor (armazenamento contínuo)	| Maior (ponteiros adicionais para cada nó)    |

- Use ArrayList se precisar de acesso rápido a elementos pelo índice

- Use LinkedList se precisar de muitas inserções e remoções no meio da lista

## Boas Práticas

- Prefira **List<String> lista = new LinkedList<>();** para maior flexibilidade.
- Use **addFirst()** e **addLast()** para operações eficientes de inserção.
- Use **removeFirst()** e **removeLast()** quando precisar remover elementos rapidamente.