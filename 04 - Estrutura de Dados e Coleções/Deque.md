# Deque

O Deque (Double-Ended Queue) é uma estrutura de dados do tipo fila dupla, onde os elementos podem ser adicionados ou removidos tanto do início quanto do fim. Ele combina características de fila (FIFO) e pilha (LIFO), tornando-o bastante flexível.

- Permite inserção e remoção nos dois extremos
- Pode ser usado como Fila (FIFO) ou Pilha (LIFO).
- Implementado pelas classes ArrayDeque e LinkedList.
- Geralmente mais eficiente que Stack e LinkedList para operações de pilha e fila.
- Não permite elementos null no ArrayDeque.

## Conceitos Fundamentais

**FIFO (First In, First Out)**: O primeiro elemento a entrar é o primeiro a sair (como uma fila de banco).

**LIFO (Last In, First Out)**: O último elemento a entrar é o primeiro a sair (como uma pilha de pratos).

**Eficiencia de um Deque:** A eficiencia depende da sua implementação, **ArrayDeque** usa um array dinâmico, sendo rápido para adição e remoção nas extremidades **(O(1))**, mas pode ser lento ao crescer (realloc). Já o **LinkedList** usa nós encadeados, permitindo remoção e inserção eficientes **(O(1))**, mas pode ser mais lento para percorrer os elementos **(O(n))**.