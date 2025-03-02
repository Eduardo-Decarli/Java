# Deque

O Deque (Double-Ended Queue) é uma estrutura de dados do tipo fila dupla, onde os elementos podem ser adicionados ou removidos tanto do início quanto do fim. Ele combina características de fila (FIFO) e pilha (LIFO), tornando-o bastante flexível.

- Permite inserção e remoção nos dois extremos
- Pode ser usado como Fila (FIFO) ou Pilha (LIFO).
- Implementado pelas classes ArrayDeque e LinkedList.
- Geralmente mais eficiente que Stack e LinkedList para operações de pilha e fila.
- Não permite elementos null no ArrayDeque.

## Conceitos Fundamentais

**FIFO (First In, First Out)**: O primeiro elemento a entrar é o primeiro a sair (como uma fila de banco).

**LIFO (Last In, First Out)**: O último elemento a entrar é o primeiro a sair (como uma pilha de pratos).

**Eficiencia de um Deque:** A eficiencia depende da sua implementação, **ArrayDeque** usa um array dinâmico, sendo rápido para adição e remoção nas extremidades **(O(1))**, mas pode ser lento ao crescer (realloc). Já o **LinkedList** usa nós encadeados, permitindo remoção e inserção eficientes **(O(1))**, mas pode ser mais lento para percorrer os elementos **(O(n))**.

- Principais Implementações do Deque

| **Implementação** | **Características**                                                      |
|-------------------|--------------------------------------------------------------------------|
| ArrayDeque        | Baseado em array dinâmico, mais rápido que LinkedList, não permite null. |
| LinkedList        | Baseado em lista duplamente encadeada, mais flexível, permite null.      |

- Principais métodos do Deque

| **Método**    | **Descrição**                                            |
|---------------|----------------------------------------------------------|
| offerFirst(e) | Adiciona um elemento no início da fila.                  |
| offerLast(e)  | Adiciona um elemento no final da fila.                   |
| pollFirst()   | Remove e retorna o primeiro elemento (ou null se vazio). |
| pollLast()    | Remove e retorna o último elemento (ou null se vazio).   |
| peekFirst()   | Retorna o primeiro elemento sem remover.                 |
| peekLast()    | Retorna o último elemento sem remover.                   |
| push(e)       | Insere um elemento no topo (modo pilha - LIFO).          |
| pop()         | Remove o elemento do topo (modo pilha - LIFO).           |

## Exemplos Práticos

- Criando um Deque com ArrayDeque

``` Java

import java.util.Deque;
import java.util.ArrayDeque;

public class TesteDeque {
    public static void main(String[] args) {
        // Criando um Deque
        Deque<String> deque = new ArrayDeque<>();

        // Adicionando elementos nos dois extremos
        deque.offerFirst("Início");
        deque.offerLast("Meio");
        deque.offerLast("Fim");

        System.out.println("Deque: " + deque); // [Início, Meio, Fim]

        // Removendo elementos
        System.out.println("Removendo do início: " + deque.pollFirst()); // Início
        System.out.println("Removendo do fim: " + deque.pollLast()); // Fim

        System.out.println("Deque agora: " + deque); // [Meio]
    }
}

```

---

- Usando Deque como uma Pilha (LIFO)

``` Java

import java.util.Deque;
import java.util.ArrayDeque;

public class TesteDequePilha {
    public static void main(String[] args) {
        Deque<Integer> pilha = new ArrayDeque<>();

        // Adicionando elementos como uma pilha
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Pilha: " + pilha); // [30, 20, 10]

        // Removendo elementos (LIFO)
        System.out.println("Removendo do topo: " + pilha.pop()); // 30

        System.out.println("Pilha agora: " + pilha); // [20, 10]
    }
}

```

## Boas Práticas

- Prefira **ArrayDeque** em vez de **LinkedList**, pois é mais eficiente para operações de fila e pilha.
- Use **offerFirst()** e **offerLast()** em vez de **addFirst()** e **addLast()** para evitar exceções.
- Se precisar de uma estrutura híbrida (Fila + Pilha), o Deque é a melhor escolha.