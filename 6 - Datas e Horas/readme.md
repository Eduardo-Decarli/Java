# Classe `LocalDate` em Java

A classe `LocalDate` faz parte do pacote `java.time` e foi introduzida no Java 8 como parte da nova API de data e hora. Ela representa uma data sem o horário do dia e é uma forma imutável de manipular datas em Java.

## O que é `LocalDate`?

`LocalDate` é uma classe que armazena uma data no formato `ano-mês-dia` (por exemplo, 2024-09-17). Ela é útil quando você precisa trabalhar com datas em uma aplicação, sem se preocupar com o horário.

## Principais Funcionalidades

- **Imutabilidade**: Instâncias de `LocalDate` são imutáveis, o que significa que uma vez criado, o objeto não pode ser alterado.
- **Representação de Data**: A classe armazena apenas informações de data (ano, mês e dia) e não inclui informações sobre o tempo.
- **Manipulação de Datas**: Permite realizar operações como adição e subtração de dias, meses e anos.

## Criação de Instâncias

Você pode criar uma instância de `LocalDate` de várias maneiras:

### Usando a Data Atual

```java
LocalDate hoje = LocalDate.now(); // Retorna a data atual do sistema
LocalDate dataEspecifica = LocalDate.of(2024, 9, 17); // Armazena a data na variavel
LocalDate dataDeString = LocalDate.parse("2024-09-17"); // Cria uma data a partir de uma String



