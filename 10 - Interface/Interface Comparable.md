# Interface `Comparable` em Java

A interface `Comparable` em Java é usada para definir a ordem natural de objetos de uma classe. Ela faz parte do pacote `java.lang` e é utilizada para permitir que objetos de uma classe possam ser comparados entre si para fins de ordenação. O método principal da interface `Comparable` é o método `compareTo(T o)`.

## Definição da Interface

A interface `Comparable` possui a seguinte assinatura:

```java
public interface Comparable<T> {
    int compareTo(T o);
}

```

## O método compareTo(T o)
O método compareTo(T o) deve ser implementado pela classe que deseja ser comparável, e ele compara o objeto atual com o objeto passado como parâmetro o. O método retorna:

- Um número negativo se o objeto atual for menor que o objeto o.
- Zero se o objeto atual for igual ao objeto o.
- Um número positivo se o objeto atual for maior que o objeto o.

```java

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public int compareTo(Pessoa outraPessoa) {
        return Integer.compare(this.idade, outraPessoa.getIdade());
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Ana", 25));
        pessoas.add(new Pessoa("Carlos", 30));
        pessoas.add(new Pessoa("Beatriz", 20));

        // Ordenar a lista usando o compareTo
        Collections.sort(pessoas);

        // Exibir a lista ordenada
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}

