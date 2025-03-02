# Queue

A interface Queue representa uma estrutura de fila, onde os elementos são processados na ordem em que foram adicionados

- Segue o princípio FIFO (First In, First Out)

- Usada para armazenar e processar elementos sequencialmente.

- Pode ser implementada com diferentes classes (LinkedList, PriorityQueue, etc)

- Possui métodos específicos para inserção e remoção de elementos.

- Existem variações como Deque (Fila dupla) e PriorityQueue (Fila com prioridade)

## Conceitos Fundamentais

**FIFO (First In, First Out)**: O primeiro elemento a entrar é o primeiro a sair (como uma fila de banco).

**LIFO (Last In, First Out)**: O último elemento a entrar é o primeiro a sair (como uma pilha de pratos).

- Principais implementações de Queue em Java

| **Implementação** | **Características**                                                             |
|-------------------|---------------------------------------------------------------------------------|
| LinkedList        | Implementa Queue e Deque, permite elementos null, não tem ordenação específica. |
| PriorityQueue     | Os elementos são ordenados por prioridade, baseada em Comparable ou Comparator. |
| ArrayDeque        | Alternativa mais eficiente que LinkedList, suporta Deque (fila dupla).          |

- Principais métodos da interface Queue

| **Método** | **Descrição**                                                     |
|------------|-------------------------------------------------------------------|
| offer(E e) | Adiciona um elemento à fila (retorna true ou false se falhar).    |
| add(E e)   | Adiciona um elemento à fila (lança exceção se falhar).            |
| poll()     | Remove e retorna o primeiro elemento (retorna null se vazio).     |
| remove()   | Remove e retorna o primeiro elemento (lança exceção se vazio).    |
| peek()     | Retorna o primeiro elemento sem remover (ou null se vazio).       |
| element()  | Retorna o primeiro elemento sem remover (lança exceção se vazio). |

## Exemplos Práticos

- Criando uma Queue com LinkedList

``` Java

import java.util.Queue;
import java.util.LinkedList;

public class TesteQueue {
    public static void main(String[] args) {
        // Criando uma fila (Queue)
        Queue<String> fila = new LinkedList<>();

        // Adicionando elementos
        fila.offer("João");
        fila.offer("Maria");
        fila.offer("Carlos");

        System.out.println("Fila: " + fila); // [João, Maria, Carlos]

        // Obtendo o primeiro elemento (sem remover)
        System.out.println("Primeiro da fila: " + fila.peek()); // João

        // Removendo elementos
        System.out.println("Removendo: " + fila.poll()); // João

        System.out.println("Fila após remoção: " + fila); // [Maria, Carlos]
    }
}

```

---

- PriorityQueue - Fila com Prioridade

A PriorityQueue não segue a ordem FIFO pura, pois os elementos são ordenados por prioridade.

``` Java

import java.util.PriorityQueue;
import java.util.Queue;

public class TestePriorityQueue {
    public static void main(String[] args) {
        Queue<Integer> filaPrioridade = new PriorityQueue<>();

        filaPrioridade.offer(30);
        filaPrioridade.offer(10);
        filaPrioridade.offer(20);

        System.out.println("Fila de prioridade: " + filaPrioridade); // A ordem de exibição pode variar!

        // Removendo elementos (menor elemento primeiro)
        System.out.println("Removendo: " + filaPrioridade.poll()); // 10
        System.out.println("Fila agora: " + filaPrioridade); // [20, 30]
    }
}

```

## Boas Práticas

- Prefira **offer()** e **poll()** em vez de **add()** e **remove()** para evitar exceções.

- Se precisar de ordenação automática, use **PriorityQueue**.

- Para operações em ambos os extremos, use **Deque (ArrayDeque)**.