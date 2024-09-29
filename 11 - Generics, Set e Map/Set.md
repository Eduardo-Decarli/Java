# Set

Set em Java é uma interface que faz parte do pacote java.util e **representa uma coleção/lista** que **não permite elementos duplicados**. Se você adicionar um elemento que já existe, ele simplesmente será ignorado. Isso torna o Set muito útil em cenários onde você quer garantir a unicidade dos itens.

## Caracteristicas Gerais

- Sem duplicatas: Cada elemento em um Set é único.

- Ordem não garantida: Dependendo da implementação do Set, a ordem de iteração dos elementos pode não ser a mesma em que foram inseridos (exceção: LinkedHashSet e TreeSet).

- Permite null: Alguns tipos de Set, como HashSet, permitem o valor null, mas apenas um null pode existir.

## Implementação do Set em HashSet

O HashSet é uma implementação da interface Set em Java que usa uma tabela hash para armazenar seus elementos. Ele herda características da classe AbstractSet e implementa a interface Set, o que significa que o HashSet não permite elementos duplicados e não mantém a ordem dos elementos inseridos.

### Caracterísiticas

- Rapidez nas operações: Como usa hashing, operações como adicionar, remover e verificar a presença de um elemento são realizadas de forma eficiente, geralmente com complexidade O(1).

- Não é sincronizado: Se múltiplas threads acessarem um HashSet simultaneamente, ele deve ser sincronizado externamente.

### Principais Métodos

- add(elemento): Adiciona um elemento ao conjunto. Retorna true se o elemento não estava presente, ou false se ele já existir.

``` java

public class ExemploHashSet {
    public static void main(String[] args) {
        HashSet<String> frutas = new HashSet<>();

        // Adicionando elementos
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Laranja");
        frutas.add("Maçã");  // Não será adicionado, pois já existe
    }
}

```

- Remove(elemento): Remove o elemento especificado do conjunto. Retorna true se o elemento foi removido, ou false se ele não estava presente.

``` java

public class ExemploHashSet {
    public static void main(String[] args) {
        HashSet<String> frutas = new HashSet<>();

        frutas.add("Laranja");

        // Remover um elemento
        frutas.remove("Laranja");
    }
}

```

- contains(elemento): Verificar se o conjunto contem o elemento especificado.

``` java

public class ExemploHashSet {
    public static void main(String[] args) {
        HashSet<String> frutas = new HashSet<>();

        frutas.add("Laranja");

        // Verificar se um elemento existe
        if (frutas.contains("Banana")) {
            System.out.println("Banana está presente.");
        }
    }
}

```

- size(): Retorna o número de elementos no conjunto.

``` java

public class ExemploHashSet {
    public static void main(String[] args) {
        HashSet<String> frutas = new HashSet<>();

        // Adicionando elementos
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Laranja");

        // Tamanho do HashSet
        System.out.println("Tamanho: " + frutas.size());  // Tamanho será 3
    }
}

```

- Iterar sobre elementos: Você pode usar um for-each ou iterador para percorrer os elementos do HashSet.

``` java

import java.util.HashSet;

public class ExemploHashSet {
    public static void main(String[] args) {
        HashSet<String> frutas = new HashSet<>();

        // Adicionando elementos
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Laranja");
        frutas.add("Maçã");  // Não será adicionado, pois já existe

        // Iterar sobre o HashSet
        for (String fruta : frutas) {
            System.out.println(fruta);
        }
    }
}

``` 

### Diferença entre o HashSet e TreeSet

- HashSet: Usa uma tabela hash, não garante a ordem dos elementos.

- TreeSet: Usa uma árvore de busca binária, o que garante a ordem natural dos elementos ou a ordem fornecida por um comparador.

## Implementação do Set em LinkedHashSet

O LinkedHashSet é uma extensão do HashSet que mantém uma ordem de inserção dos elementos. Assim como o HashSet, ele não permite duplicatas, mas ao contrário do HashSet, ele garante que os elementos sejam iterados na mesma ordem em que foram inseridos.

### Caracteristicas

- Mantém a ordem de inserção: Essa é a principal diferença em relação ao HashSet. O LinkedHashSet garante que os elementos serão iterados na mesma ordem em que foram inseridos.

- Mais lento que HashSet: Como o LinkedHashSet precisa manter uma lista duplamente ligada para armazenar a ordem de inserção dos elementos, ele tem um pouco mais de sobrecarga de processamento e memória em comparação com o HashSet.

### Principais Métodos

Como o LinkedHashSet é uma extensão do HashSet, ele possui os mesmos métodos para uso

### Diferença entre o LinkedHashSet e TreeSet

- LinkedHashSet: Mantém a ordem de inserção, mas não ordena os elementos de outra forma.

- TreeSet: Garante uma ordem "natural" dos elementos (ou uma ordem definida por um comparador), não a ordem de inserção.

## Implementação do Set em TreeSet


O TreeSet é uma implementação da interface Set em Java que usa uma árvore binária de busca (árvore AVL ou Red-Black Tree) para armazenar os elementos de forma ordenada. Diferentemente de HashSet e LinkedHashSet, o TreeSet mantém os elementos ordenados em sua "ordem natural" ou em uma ordem personalizada fornecida por um comparador.

### Caracteristicas Principais do TreeSet

- Mantém os elementos ordenados: Os elementos em um TreeSet são armazenados em ordem crescente (ordem natural dos elementos, definida pela interface Comparable) ou em uma ordem definida por um Comparator personalizado.

- Baseado em árvore de busca: O TreeSet é implementado usando uma árvore binária de busca auto-balanceada (geralmente uma árvore Red-Black), o que garante que as operações de adição, remoção e busca sejam feitas em tempo O(log n).

- Opera eficientemente para conjuntos ordenados: O TreeSet é útil quando você precisa manter um conjunto de dados ordenado e também fazer operações rápidas de busca, como encontrar o maior ou menor valor.

### Principais Métodos

Álem dos métodos padrões do **Set**, tais como adição, remoção, tamanho, etc... O TreeSet consta com os seguintes métodos

- first(): Retorna o menor elemento do conjunto.

``` java

import java.util.TreeSet;

public class ExemploTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> numeros = new TreeSet<>();

        // Adicionando elementos
        numeros.add(10);
        numeros.add(5);
        numeros.add(20);
        numeros.add(15);

        System.out.println("Menor elemento: " + numeros.first());  // 5
    }
}

```

- last(): Retorna o maior elemento do conjunto.


``` java

import java.util.TreeSet;

public class ExemploTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> numeros = new TreeSet<>();

        // Adicionando elementos
        numeros.add(10);
        numeros.add(5);
        numeros.add(20);
        numeros.add(15);

        System.out.println("Maior elemento: " + numeros.last());   // 20
    }
}

```

- higher(elemento): Retorna o próximo maior numero que o *elemento* especificado, não existir, retorna null.

``` java

import java.util.TreeSet;

public class ExemploTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> numeros = new TreeSet<>();

        // Adicionando elementos
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        System.out.println("Elemento maior que 20: " + numeros.higher(20));  // 30
        System.out.println("Elemento maior que 50: " + numeros.higher(50));  // null (não há maior que 50)
    }
}

```

- lower(elemento): Retorna o próximo menor numero que o *elemento* especificado, não existir, retorna null.

``` java

import java.util.TreeSet;

public class ExemploTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> numeros = new TreeSet<>();

        // Adicionando elementos
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        System.out.println("Elemento menor que 30: " + numeros.lower(30));  // 20
        System.out.println("Elemento menor que 10: " + numeros.lower(10));  // null (não há menor que 10)

    }
}

```

### Diferença entre o HashSet e LinkedHashSet

- Mantém os elementos ordenados em ordem natural ou por um comparador.

- As operações de adição, remoção e busca são realizadas em tempo O(log n).

- Não permite **null**