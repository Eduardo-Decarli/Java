# Map

O Map em Java é uma interface que representa uma estrutura de dados de mapeamento, onde você pode associar chaves (keys) a valores (values). Ao contrário de uma List ou Set, que armazena elementos únicos, o Map armazena pares de chave-valor. Cada chave deve ser única, mas um valor pode ser repetido.

## Caracteristicas

- Chave-valor: Armazena pares de elementos, onde cada chave é mapeada para um valor.

- Chaves únicas: Não podem haver chaves duplicadas. Se você tentar inserir uma chave que já existe, o valor correspondente será substituído.

- Valores podem ser duplicados: Diferente das chaves, os valores podem se repetir.

- Assim como o Set, o Mep possui várias implementações: HashMap, TreeMap, LinkedHashMap, Hashtable, entre outros.

## HashMap

O HashMap em Java é uma classe da biblioteca java.util que implementa a interface Map. Ele armazena pares de chave-valor, permitindo que você associe uma chave a um valor específico. A principal característica do HashMap é que ele é baseado em uma tabela de hash, o que proporciona acesso rápido aos elementos. Isso significa que, quando você deseja buscar, inserir ou remover um elemento, o HashMap pode realizar essas operações de forma eficiente, geralmente em tempo constante (O(1)), desde que a dispersão das chaves seja adequada.

### Estrutura do HashMap

Ele funciona internamente dividindo as chaves em buckets usando uma função de hash. Cada chave é transformada em um valor hash, que é usado para determinar em qual bucket o par chave-valor será armazenado. Se duas chaves diferentes gerarem o mesmo valor de hash (uma colisão), o HashMap armazena essas chaves no mesmo bucket, geralmente usando uma lista ligada para resolver o problema de colisões.

### Métodos Comuns

- put(K chave, V valor): Adiciona ou atualiza um par chave-valor no mapa.

``` java

import java.util.HashMap;

public class ExemploPut {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = new HashMap<>();

        // Adicionando pares chave-valor
        mapa.put("Maçã", 10);
        mapa.put("Banana", 20);

        // Exibindo o mapa
        System.out.println(mapa); // Retorna: {Maçã=10, Banana=20}

        // Atualizando o valor da chave "Maçã"
        mapa.put("Maçã", 15);

        // Exibindo o mapa atualizado
        System.out.println(mapa); // Retorna: {Maçã=15, Banana=20}
    }
}

```

- get(Object chave): Retorna o valor associado á chave, ou null se a chave não existir

``` java

import java.util.HashMap;

public class ExemploGet {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("Maçã", 10);
        mapa.put("Banana", 20);

        // Obtendo o valor associado à chave "Maçã"
        Integer valor = mapa.get("Maçã");
        System.out.println("Valor de Maçã: " + valor); // Retorna: Valor de Maçã: 10
    }
}

```

- remove(Object chave): Remove o par chave-valor associado a chave fornecida.

``` java

import java.util.HashMap;

public class ExemploRemove {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("Maçã", 10);
        mapa.put("Banana", 20);
        
        // Removendo a chave "Banana"
        mapa.remove("Banana");

        // Exibindo o mapa após a remoção
        System.out.println(mapa); // Retorna: {Maçã=10}
    }
}


```

- containsKey(Object chave): Verifica se o mapa contém a chave fornecida.

``` java

import java.util.HashMap;

public class ExemploContainsKey {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("Maçã", 10);
        mapa.put("Banana", 20);

        // Verificando se a chave "Maçã" existe
        System.out.println(mapa.containsKey("Maçã")); // Retorna: true

        // Verificando se a chave "Laranja" existe
        System.out.println(mapa.containsKey("Laranja")); // Retorna: false
    }
}

```

- containsValue(Object valor): Verifica se o mapa contém o valor fornecido.

``` java

import java.util.HashMap;

public class ExemploContainsValue {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("Maçã", 10);
        mapa.put("Banana", 20);

        // Verificando se o valor 10 existe
        System.out.println(mapa.containsValue(10)); // Retorna: true

        // Verificando se o valor 30 existe
        System.out.println(mapa.containsValue(30)); // Retorna: false
    }
}

```

- keySet(): Retorna um conjunto (Set) de todas as chaves no mapa.

``` java

import java.util.HashMap;
import java.util.Set;

public class ExemploKeySet {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("Maçã", 10);
        mapa.put("Banana", 20);
        mapa.put("Laranja", 30);

        // Obtendo todas as chaves
        Set<String> chaves = mapa.keySet();

        // Exibindo as chaves
        System.out.println("Chaves: " + chaves); // Retorna: Chaves: [Maçã, Banana, Laranja]
    }
}

```

- values(): Retorna uma coleção de todos os valores no mapa.

``` java

import java.util.HashMap;
import java.util.Collection;

public class ExemploValues {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("Maçã", 10);
        mapa.put("Banana", 20);
        mapa.put("Laranja", 30);

        // Obtendo todos os valores
        Collection<Integer> valores = mapa.values();

        // Exibindo os valores
        System.out.println("Valores: " + valores); // Retorna: Valores: [10, 20, 30]
    }
}


```

entrySet(): Retorna um conjunto de todos os pares chave-valor (cada entrada é um objeto Map.Entry).

``` java

import java.util.HashMap;
import java.util.Map;

public class ExemploEntrySet {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("Maçã", 10);
        mapa.put("Banana", 20);
        mapa.put("Laranja", 30);

        // Exibindo todos os pares chave-valor
        for (Map.Entry<String, Integer> entrada : mapa.entrySet()) {
            System.out.println(entrada.getKey() + " = " + entrada.getValue());
            // Saída: 
            // Maçã = 10
            // Banana = 20
            // Laranja = 30
        }
    }
}

```