# HashSet

O HashSet faz parte do pacote java.util e implementa a interface set. Ele é uma coleção que não permite elementos duplicados e não mantém a ordem de inserção.

- Armazena elementos únicos (não aceita valores duplicados)
- Não mantém a ordem de inserção.
- Acesso a busca rápido (tempo médio 0(1), devido ao uso de uma tabela hash)
- Permite valores null (apenas um)
- Não é sincronizado, ou seja, não é seguro para múltiplas threads

## Conceitos Fundamentais

- Declaração e Inicialização

``` Java

import java.util.HashSet;
import java.util.Set;

Set<String> nomes = new HashSet<>();

```

- **Como o HashSet funciona internamente:** O HashSet usa uma tabela hash para armazenar os elementos. Cada elemento recebe um hash code e é armazenado em um bucket dentro da tabela hash. Se houver colisão (dois elementos com o mesmo hash), o HashSet usa listas encadeadas ou árvores balanceadas para armazená-los no mesmo bucket.

- Principais Métodos do HashSet

| Método             | Descrição                                  |
|--------------------|--------------------------------------------|
| add(E e)           | Adiciona um elemento(ignora se já existir) |
| remove(Object o)   | Remove um elemento                         |
| conteins(Object o) | Verifica se um elemento existe             |
| size()             | Retorna o número de elementos              | 
| isEmpty()          | Verifica se o conjunto está vazio          |
| clear()            | Remove todos os elementos                  |
| iterator()         | Retorna um iterador sobre os elementos     |

## Exemplos Práticos

- Criando e manipulando um HashSet

``` Java

import java.util.HashSet;
import java.util.Set;

public class TesteHashSet {
    public static void main(String[] args) {
        // Criando um HashSet de nomes
        Set<String> nomes = new HashSet<>();

        // Adicionando elementos
        nomes.add("Alice");
        nomes.add("Bob");
        nomes.add("Carlos");
        nomes.add("Alice"); // Elemento duplicado (será ignorado)

        // Exibindo os elementos
        System.out.println(nomes); // A ordem pode ser diferente!

        // Verificando se um elemento existe
        System.out.println("Contém Bob? " + nomes.contains("Bob")); // true
        System.out.println("Contém Daniel? " + nomes.contains("Daniel")); // false

        // Removendo um elemento
        nomes.remove("Carlos");

        // Iterando sobre o HashSet
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}

// O retorno será algo como:

// [Alice, Bob, Carlos]  
// Contém Bob? true  
// Contém Daniel? false  
// Alice  
// Bob  


```

## Iterando sobre um HashSet

``` Java

// Usando for-each

for(String nome : nomes) {
    System.out.println(nome);
}

// Usando um Iterator

Iterator<String> it = nome.Iterator();
while(it.hasNext()) {
    System.out.println(it.next());
}

// Usando forEach com Lambda

nomes.forEach(nome -> System.out.pringln(nome));

```

## Comparação entre HashSet, TreeSet e LinkedHashSet

| **Critério**         | **HashSet**         | **TreeSet**          | **LinkedHashSet**               |
|----------------------|---------------------|----------------------|---------------------------------|
| Ordem dos elementos  | Não garantida       | Ordenada (crescente) | Mantém ordem de inserção        |
| Velocidade de acesso | Muito rápido (O(1)) | Lento (O(log n))     | Rápido (O(1))                   |
| Aceita null?         | Sim (1 vez)         | Não                  | Sim (1 vez)                     |
| Baseado em...        | Tabela Hash         | Árvore Red-Black     | Tabela Hash + Lista Encadeada   |

## Boas Práticas

- Use **Set<String> nomes = new HashSet<>();** para maior flexibilidade.

- Utilize **contains()** para verificar se um elemento já existe antes de adicioná-lo.

- Use **clear()** para limpar o conjunto em vez de recriar a instância.