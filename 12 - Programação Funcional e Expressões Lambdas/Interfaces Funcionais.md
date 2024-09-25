# Interfaces Funcionais

## O que é uma interface funcional

Interfaces funcionais em Java são interfaces que possuem apenas um **método abstrato**. Elas são a base para a programação funcional em Java, especialmente no uso de expressões lambdas. A partir do Java 8, interfaces funcionais podem ser utilizadas para passar comportamento como parâmetro, ou seja, você pode tratá-las como se fossem funções.

## Caracteristicas de uma interface funcional

- Um único método abstrato: Isso significa que a interface define apenas um comportamento que deve ser implementado.

- Métodos default ou estáticos são permitidos: Além do método abstrato, a interface pode ter métodos default ou static, mas eles não contam como métodos abstratos.

Exemplo

``` java
@FunctionalInterface
public interface Calculadora {
    int calcular(int a, int b);
}
```

## Interfaces Comuns do Java

- Consumer<T> (recebe um parâmetro de tipo T, mas não retorna nada)
- Function<T, R> (recebe um parâmetro de tipo T e retorna um valor de tipo R)
- Supplier<T> (sem parâmetros, retorna um valor de tipo T)
