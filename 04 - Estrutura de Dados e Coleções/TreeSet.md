# TreeSet

O TreeSet é uma implementação da interface **NavigableSet**, que estende **SortedSet**. Ele usa uma árvore Red-Black para armazenar os elementos em ordem crescente por padrão.

- Mantém os elementos ordenados automaticamente (ordem natural ou definida por um Comparator).

- Não permite elementos duplicados

- Baseado em uma árvore balanceada (Red-Black Tree), tornando operações como busca, inserção e remoção O(log n).

- Não permite elementos **null** (diferente do **HashSet**).

- Fornece métodos para navegação (menor, maior, anterior, próximo, etc.).

## Conceitos Fundamentais

- Declaração e Inicialização

``` Java

import java.util.TreeSet;
import java.util.Set;

Set<Integer> numeros = new TreeSet<>();

```

- **Arvore Red-Black:** A árvore Red-Black (ou árvore Vermelho-Preta) é uma estrutura de dados do tipo árvore binária de busca balanceada. Ela garante que a altura da árvore seja proporcional a 
𝑂(log 𝑛), O(logn), tornando operações como busca, inserção e remoção eficientes.

- **Como o TreeSet funciona internamente:** O TreeSet usa uma árvore Red-Black para armazenar os elementos ordenados. Isso garante um tempo de busca, inserção e remoção de O(log n), já que a árvore permanece balanceada.

- Principais métodos do TreeSet

| **Método**                | **Descrição**                                  |
|---------------------------|------------------------------------------------|
| add(E e)                  | Adiciona um elemento mantendo a ordem.         |
| remove(Object o)          | Remove um elemento.                            |
| contains(Object o)        | Verifica se um elemento existe.                |
| size()                    | Retorna o número de elementos.                 |
| first() / last()          | Retorna o menor ou maior elemento.             |
| higher(E e) / lower(E e)  | Retorna o menor/maior elemento em relação a e. |
| ceiling(E e) / floor(E e) | Retorna o menor/maior elemento >= ou <= a e.   |
| pollFirst() / pollLast()  | Remove e retorna o menor/maior elemento.       |

## Exemplos Práticos

- Criando e Manipulando um TreeSet

``` Java

import java.util.TreeSet;

public class TesteTreeSet {
    public static void main(String[] args) {
        // Criando um TreeSet de números
        TreeSet<Integer> numeros = new TreeSet<>();

        // Adicionando elementos
        numeros.add(10);
        numeros.add(5);
        numeros.add(20);
        numeros.add(15);

        // Exibindo os elementos (ordenados automaticamente)
        System.out.println(numeros); // [5, 10, 15, 20]

        // Pegando o menor e maior elemento
        System.out.println("Menor elemento: " + numeros.first()); // 5
        System.out.println("Maior elemento: " + numeros.last()); // 20

        // Pegando elementos menores ou maiores que um valor
        System.out.println("Menor que 15: " + numeros.lower(15)); // 10
        System.out.println("Maior que 10: " + numeros.higher(10)); // 15

        // Removendo um elemento
        numeros.remove(10);
        System.out.println(numeros); // [5, 15, 20]
    }
}

[5, 10, 15, 20]  
Menor elemento: 5  
Maior elemento: 20  
Menor que 15: 10  
Maior que 10: 15  
[5, 15, 20]  


```

---

- Trabalhando com TreeSet de String

``` Java

import java.util.TreeSet;

public class TesteTreeSetString {
    public static void main(String[] args) {
        TreeSet<String> nomes = new TreeSet<>();

        nomes.add("Carlos");
        nomes.add("Alice");
        nomes.add("Bob");

        // Mantém a ordem alfabética
        System.out.println(nomes); // [Alice, Bob, Carlos]

        // Primeiro e último elemento
        System.out.println("Primeiro: " + nomes.first()); // Alice
        System.out.println("Último: " + nomes.last()); // Carlos
    }
}

```

--- 

- Ordenando um TreeSet com Comparator

``` Java

import java.util.TreeSet;
import java.util.Comparator;

public class TesteTreeSetComparator {
    public static void main(String[] args) {
        // Criando um TreeSet ordenado pelo tamanho das palavras
        TreeSet<String> palavras = new TreeSet<>(Comparator.comparing(String::length));

        palavras.add("Java");
        palavras.add("Spring");
        palavras.add("AWS");

        System.out.println(palavras); // [AWS, Java, Spring]
    }
}

```


## Comparação entre HashSet, TreeSet e LinkedHashSet

| **Critério**         | **HashSet**         | **TreeSet**          | **LinkedHashSet**               |
|----------------------|---------------------|----------------------|---------------------------------|
| Ordem dos elementos  | Não garantida       | Ordenada (crescente) | Mantém ordem de inserção        |
| Velocidade de acesso | Muito rápido (O(1)) | Lento (O(log n))     | Rápido (O(1))                   |
| Aceita null?         | Sim (1 vez)         | Não                  | Sim (1 vez)                     |
| Baseado em...        | Tabela Hash         | Árvore Red-Black     | Tabela Hash + Lista Encadeada   |

## Boas Práticas

- Use **NavigableSet<Integer> numeros = new TreeSet<>();** para maior flexibilidade.

- Utilize **contains()** para verificar se um elemento já existe antes de adicioná-lo.

Use **pollFirst()** e **pollLast()** para recuperar e remover o menor ou maior elemento.