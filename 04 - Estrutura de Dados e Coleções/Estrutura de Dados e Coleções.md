# Estrutura de Dados e Coleções

Todas essas classes fazem parte do framework de Collections do Java. Antes de estudá-las, você precisa entender:

**O que são coleções:** São estruturas que armazenam e manipulam grupos de objetos.

**List:** Coleção ordenada que permite elementos duplicados (ex: ArrayList, LinkedList).

**Set:** Coleção que não permite elementos duplicados e pode ter diferentes implementações para ordenação e desempenho (ex: HashSet e TreeSet)

**Map:** Estrutura chave-valor que não permite chaves duplicadas, mas permite valores duplicados (ex: HashMap, TreeMap)

## Conceitos fundamentais

Cada estrutura de dados tem vantagens e desvantagens dependendo do cenário.

**Hashing:** é um processo que transforma dados em uma sequência de caracteres fixos, usando um algoritmo matemático, também é uma tecnica de segurança digital para proteger dados sensíveis.

**Tabela Hash:** É uma estrutura de dados que associa chaves e valores. Ela é utilizada para armazenar e recuperar informações de forma eficiente.

**Big-O Notation (0(1)), 0(n), 0(log n)**: Utilizados para analisar a eficiência de busca, inserções e remoções.

Arrays tem acesso rápido (0(1)), mas inserções e remoções podem ser lentas.

Estruturas baseadas em hashing são eficientes para buscas (ex: HashMap).

Estruturas ordenadas geralmente são mais lentas para inserção, mas facilitam buscas ordenadas(ex: TreeMap, TreeSet)

## Arrays e Listas Encadeadas

**Arrays** -> São estruturas básicas para armazenar elementos sequencialmente na memória. Arrays têm tamanho fixo e permitem acesso rápido por índice.

**Listas Encadeadas** -> São compostas por nós, cada um apontando para o próximo elemento. Listas encadeadas crescem dinamicamente e têm inserção e remoção mais flexíveis.

## Hashing e Tabela Hash

Antes de estudar HashMap e HashSet, você precisa entender:

**O que é uma função de hash** -> Uma função que mapeia um valor para um índice em uma tabela

**Por que HashMap e HashSet são eficientes** -> Eles usam hashing para acesso rápido

