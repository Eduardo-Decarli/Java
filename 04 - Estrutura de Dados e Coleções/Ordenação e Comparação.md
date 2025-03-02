# Ordenação e Comparação

Em Java, a ordenação de objetos é feita através das interfaces Comparable e Comparator. Elas permitem personalizar a ordem dos elementos, seja para listas (List), conjuntos ordenados (TreeSet) ou mapas ordenados (TreeMap).

**Comparable<T>:** Usada para quando queremos definir a ordem natural de um objeto.

**Comparator<T>:** Usada quando queremos criar diferentes critérios de ordenação, sem modificar a classe original.

Use **Comparable** quando a classe já sabe como deve ser ordenada(Ex: Ordem alfabética de nomes), e use **Comparator** quando queremos múltiplas formas de ordenação, sem modificar a classe original.

## Conceitos Fundamentais

**Ordenação Natural(Comparable):** Define um critério padrão de ordenação dentro da própria classe, implementa a interface **Comparable<T>** e sobrescreve o método compareTo(T obj).

Ordenaçã Customizada(Comparator): Define diferentes regras de ordenação sem modificar a classe original, implementa a interface Comparator<T> e sobrescreve o método compare<T obj1, T obj2>

- Principais Métodos

| **Método**                          | **Descrição**                       |
|-------------------------------------|-------------------------------------|
| Collections.sort(lista)             | Ordena uma lista usando Comparable. |
| Collections.sort(lista, comparator) | Ordena uma lista com um Comparator. |
| list.sort(comparator)               | Alternativa moderna (desde Java 8). |

## Exemplos Práticos

- Ordenação usando Comparable (Ordem Natural)

``` Java

import java.util.*;

class Produto implements Comparable<Produto> {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Implementação de Comparable para ordenar por nome
    @Override
    public int compareTo(Produto outro) {
        return this.nome.compareTo(outro.nome); // Ordem alfabética
    }

    @Override
    public String toString() {
        return nome + " - R$" + preco;
    }
}

public class TesteComparable {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto("Celular", 2000));
        lista.add(new Produto("Notebook", 3500));
        lista.add(new Produto("Tablet", 1500));

        Collections.sort(lista); // Ordenação pelo nome (Comparable)

        System.out.println("Ordenação natural (nome): " + lista);
    }
}

```

---

- Ordenação customizada com Comparator (Preço Crescente e Descrescente)

``` Java

import java.util.*;

class ComparadorPrecoCrescente implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco()); // Ordenação crescente
    }
}

class ComparadorPrecoDecrescente implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p2.getPreco(), p1.getPreco()); // Ordenação decrescente
    }
}

public class TesteComparator {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto("Celular", 2000));
        lista.add(new Produto("Notebook", 3500));
        lista.add(new Produto("Tablet", 1500));

        // Ordenação crescente por preço
        Collections.sort(lista, new ComparadorPrecoCrescente());
        System.out.println("Ordenação por preço crescente: " + lista);

        // Ordenação decrescente por preço
        Collections.sort(lista, new ComparadorPrecoDecrescente());
        System.out.println("Ordenação por preço decrescente: " + lista);
    }
}

```

---

- Usando Comparator com Expressões Lambda

``` Java

import java.util.*;

public class TesteLambda {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto("Celular", 2000));
        lista.add(new Produto("Notebook", 3500));
        lista.add(new Produto("Tablet", 1500));

        // Usando Lambda para ordenar por preço crescente
        lista.sort((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()));

        System.out.println("Ordenação por preço (Lambda): " + lista);
    }
}

```

## Boas Práticas

- Use **Comparable** quando a ordenação natural for suficiente.
- Use **Comparator** para permitir múltiplos critérios de ordenação.
- Prefira **Double.compare(x, y)** em vez de **x - y** para evitar erros de precisão.
- Use expressões lambda para código mais limpo e eficiente (Java 8+).