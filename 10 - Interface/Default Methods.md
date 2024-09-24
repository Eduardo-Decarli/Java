# Métodos `default` em Java

Os **métodos `default`** foram introduzidos no Java 8 e permitem que interfaces tenham implementações de métodos. Isso foi uma adição importante, pois anteriormente, todas as interfaces só podiam conter métodos abstratos. Com métodos `default`, podemos fornecer uma implementação padrão para um método em uma interface, sem obrigar as classes que implementam essa interface a sobrescrevê-lo.

## Definição de Métodos `default`

A sintaxe de um método `default` em uma interface é simples. Basta usar a palavra-chave `default` antes da assinatura do método. Veja um exemplo básico:

```java
public interface Animal {
    void fazerSom();

    // Método default
    default void dormir() {
        System.out.println("O animal está dormindo.");
    }
}
