# HashMap

O **HashMap<K, V>** é uma implementação na interface Map que armazena elementos em pares chave-valor. Ele usa uma tabela Hash para armazenar e acessar os elementos rapidamente.

- Armazena elementos como pares chave-valor (**k-v**).

- Permite valores duplicados, mas não permite chaves duplicadas.

- A ordem dos elementos não é garantida (não é ordenado).

- Aceita **null** como chave (somente uma) e como valor

- Acesso rápido (O(1)) para inserção, busca e remoção.

- Não é thread-safe (para ambientes concorrentes, usar **ConcurrentHashMap**).

## Conceitos fundamentais

- Declaração e Inicialização

``` Java

import java.util.HashMap;
import java.util.Map;

Map<String, Integer> idades = new HashMap<>();

```

- **Como o HashMap funciona internamente:** Ele usa uma tabela **hash**, onde cada chave é transformada em um índice através de uma função de dispersão (**hashCode()**), distribuindo os elementos para acesso eficiente.

- Principais métodos do HashMap

| **Método**                  | **Descrição**                             |
|-----------------------------|-------------------------------------------|
| put(K key, V value)         | Adiciona um par chave-valor.              |
| get(Object key)             | Retorna o valor associado a uma chave.    |
| remove(Object key)          | Remove um par chave-valor.                |
| containsKey(Object key)     | Verifica se a chave existe.               |
| containsValue(Object value) | Verifica se o valor existe.               |
| keySet()                    | Retorna todas as chaves.                  |
| values()                    | Retorna todos os valores.                 |
| entrySet()                  | Retorna um conjunto de pares chave-valor. |
| size()                      | Retorna o número de elementos.            |
| clear()                     | Remove todos os elementos.                |

## Exemplos Práticos

- Criando e manipulando um HashMap

``` Java

import java.util.HashMap;

public class TesteHashMap {
    public static void main(String[] args) {
        // Criando um HashMap
        HashMap<String, Integer> idades = new HashMap<>();

        // Adicionando elementos
        idades.put("Alice", 25);
        idades.put("Bob", 30);
        idades.put("Carlos", 22);

        // Exibindo o HashMap
        System.out.println(idades); // {Alice=25, Bob=30, Carlos=22}

        // Pegando um valor pela chave
        System.out.println("Idade de Alice: " + idades.get("Alice")); // 25

        // Removendo um elemento
        idades.remove("Bob");

        // Verificando se uma chave existe
        System.out.println("Carlos está no mapa? " + idades.containsKey("Carlos")); // true
    }
}

```

---

- Iterando sobre um HashMap

``` Java

import java.util.HashMap;
import java.util.Map;

public class TesteHashMapIteracao {
    public static void main(String[] args) {
        HashMap<String, Integer> idades = new HashMap<>();
        idades.put("Alice", 25);
        idades.put("Bob", 30);
        idades.put("Carlos", 22);

        // Percorrendo todas as chaves
        for (String chave : idades.keySet()) {
            System.out.println("Chave: " + chave);
        }

        // Percorrendo todos os valores
        for (Integer valor : idades.values()) {
            System.out.println("Valor: " + valor);
        }

        // Percorrendo os pares chave-valor
        for (Map.Entry<String, Integer> entrada : idades.entrySet()) {
            System.out.println("Chave: " + entrada.getKey() + ", Valor: " + entrada.getValue());
        }
    }
}

```

---

- Iterando sobre um HashMap

``` Java

import java.util.HashMap;
import java.util.Map;

public class TesteHashMapIteracao {
    public static void main(String[] args) {
        HashMap<String, Integer> idades = new HashMap<>();
        idades.put("Alice", 25);
        idades.put("Bob", 30);
        idades.put("Carlos", 22);

        // Percorrendo todas as chaves
        for (String chave : idades.keySet()) {
            System.out.println("Chave: " + chave);
        }

        // Percorrendo todos os valores
        for (Integer valor : idades.values()) {
            System.out.println("Valor: " + valor);
        }

        // Percorrendo os pares chave-valor
        for (Map.Entry<String, Integer> entrada : idades.entrySet()) {
            System.out.println("Chave: " + entrada.getKey() + ", Valor: " + entrada.getValue());
        }
    }
}

```

---

- Trabalhando com null

``` Java

import java.util.HashMap;

public class TesteHashMapNull {
    public static void main(String[] args) {
        HashMap<String, String> mapa = new HashMap<>();

        // Chave null é permitida
        mapa.put(null, "Valor para chave null");
        mapa.put("Chave1", null);

        System.out.println(mapa); // {null=Valor para chave null, Chave1=null}
    }
}

```

## Boas Práticas

- Use **containsKey()** antes de **get()** para evitar **null** ao buscar um valor inexistente.
- Utilize **entrySet()** para percorrer o HashMap de forma eficiente.
- Defina um tamanho inicial adequado (new HashMap<>(1000)) se souber a quantidade de elementos esperada.

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