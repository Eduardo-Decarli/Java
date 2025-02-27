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

- Como o HashSet funciona internamente: O HashSet usa uma tabela hash para armazenar os elementos. Cada elemento recebe um hash code e é armazenado em um bucket dentro da tabela hash. Se houver colisão (dois elementos com o mesmo hash), o HashSet usa listas encadeadas ou árvores balanceadas para armazená-los no mesmo bucket.

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