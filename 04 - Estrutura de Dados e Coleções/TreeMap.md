# TreeMap

O TreeMap<K, V> é uma implementação da interface Map que mantém as chaves ordenadas de forma crescente (por padrão). Ele é baseado em uma árvore Red-Black, garantindo que operações como inserção, remoção e busca sejam feitas em tempo O(log n).

- Armazena elementos como pares chave-valor (K-V).

- Mantém as chaves ordenadas de forma natural (ou conforme um comparador personalizado).

- Não permite chaves duplicadas (mas permite valores duplicados).

- Não permite null como chave (diferente do HashMap).

- Acesso mais lento que HashMap (O(log n) contra O(1)), mas com a vantagem da ordenação.

## Conceitos Fundamentais

- Declarando e inciializando

``` Java

import java.util.TreeMap;
import java.util.Map;

Map<String, Integer> idades = new TreeMap<>();

```

- Como o TreeMap funciona internamente: O TreeMap é baseado em uma árvore Red-Black, que é uma estrutura de árvore balanceada. Isso permite que a inserção, remoção e busca sejam feitas de forma eficiente 0(log n), pois a árvore sempre se mantém equilibrada.

- Principais métodos de TreeMap

| **Método**                  | **Descrição**                                            |
|-----------------------------|----------------------------------------------------------|
| put(K key, V value)         | Adiciona um par chave-valor.                             |
| get(Object key)             | Retorna o valor associado a uma chave.                   |
| remove(Object key)          | Remove um par chave-valor.                               |
| containsKey(Object key)     | Verifica se a chave existe.                              |
| containsValue(Object value) | Verifica se o valor existe.                              |
| firstKey()                  | Retorna a primeira chave (menor).                        |
| lastKey()                   | Retorna a última chave (maior).                          |
| higherKey(K key)            | Retorna a menor chave que é maior que a chave fornecida. |
| lowerKey(K key)             | Retorna a maior chave que é menor que a chave fornecida. |
| keySet()                    | Retorna todas as chaves ordenadas.                       |
| values()                    | Retorna todos os valores.                                |
| entrySet()                  | Retorna um conjunto de pares chave-valor ordenados.      |

## Exemplos Práticos

- Criando e manipulando um TreeMap

``` Java

import java.util.TreeMap;

public class TesteTreeMap {
    public static void main(String[] args) {
        // Criando um TreeMap
        TreeMap<String, Integer> idades = new TreeMap<>();

        // Adicionando elementos
        idades.put("Carlos", 22);
        idades.put("Alice", 25);
        idades.put("Bob", 30);

        // Exibindo o TreeMap (ordem crescente das chaves)
        System.out.println(idades); // {Alice=25, Bob=30, Carlos=22}

        // Pegando um valor pela chave
        System.out.println("Idade de Alice: " + idades.get("Alice")); // 25

        // Pegando a primeira e a última chave
        System.out.println("Primeira chave: " + idades.firstKey()); // Alice
        System.out.println("Última chave: " + idades.lastKey()); // Carlos
    }
}

```

---

- Iterando sobre um TreeMap

``` Java

import java.util.TreeMap;
import java.util.Map;

public class TesteTreeMapIteracao {
    public static void main(String[] args) {
        TreeMap<String, Integer> idades = new TreeMap<>();
        idades.put("Carlos", 22);
        idades.put("Alice", 25);
        idades.put("Bob", 30);

        // Percorrendo os pares chave-valor
        for (Map.Entry<String, Integer> entrada : idades.entrySet()) {
            System.out.println("Chave: " + entrada.getKey() + ", Valor: " + entrada.getValue());
        }
    }
}

```

---

- **Trabalhando com submapas:** O TreeMap permite pegar intervalos de chaves facilmente com os métodos subMap(), headMap() e tailMap().

``` Java

import java.util.TreeMap;

public class TesteTreeMapSubMap {
    public static void main(String[] args) {
        TreeMap<Integer, String> mapa = new TreeMap<>();

        mapa.put(1, "Um");
        mapa.put(3, "Três");
        mapa.put(5, "Cinco");
        mapa.put(7, "Sete");

        // Submapa de 1 até antes de 5
        System.out.println("Submapa (1 até 5): " + mapa.subMap(1, 5));

        // Elementos antes de 5
        System.out.println("HeadMap até 5: " + mapa.headMap(5));

        // Elementos a partir de 3
        System.out.println("TailMap a partir de 3: " + mapa.tailMap(3));
    }
}

```

## Boas Práticas

✔️ Use **firstKey()** e **lastKey()** para acessar rapidamente os extremos.
✔️ Se precisar de ordenação personalizada, utilize um Comparator ao criar o TreeMap.


## Tabela de Diferenças

| **Critério**            | **HashMap**            | **TreeMap**              | **LinkedHashMap**             |
|-------------------------|------------------------|--------------------------|-------------------------------|
| Ordem dos elementos     | Não garantida          | Ordenada (crescente)     | Mantém ordem de inserção      |
| Velocidade de acesso    | Muito rápido (O(1))    | Mais lento (O(log n))    | Rápido (O(1))                 |
| Aceita null como chave? | Sim                    | Não                      | Sim                           |
| Baseado em...           | Tabela Hash            | Árvore Red-Black         | Tabela Hash + Lista Encadeada |

- Use HashMap quando precisar de performance e não se importar com a ordem.

- Use TreeMap quando precisar de elementos ordenados pela chave.

- Use LinkedHashMap quando precisar manter a ordem de inserção.