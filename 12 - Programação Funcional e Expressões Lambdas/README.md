# Expressão Lambda

Expressões lambdas em Java são uma maneira concisa de representar funções anônimas, ou seja, funções que não precisam de um nome explícito. Elas permitem que você escreva funções mais curtas e elegantes, especialmente quando usadas com interfaces funcionais (interfaces que possuem apenas um método abstrato).

## strutura básica de uma expressão lambda

(parametros) -> expressão ou bloco de código

- Parâmetros: São as entradas para a função. Se não houver parâmetros, você usa parênteses vazios. Se houver mais de um parâmetro, você separa-os por vírgula.

- Seta "->": É o que separa os parâmetros da implementação da função.

- Corpo: Pode ser uma expressão única ou um bloco de código entre {}.

Por exemplo

```java
Operacao quadrado = (x) -> x * x; // Calcula o quadrado de um número

```
