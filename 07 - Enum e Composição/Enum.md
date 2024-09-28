# Enums

Enumerações em Java, também conhecidas como enums, são um tipo especial de classe que representam um conjunto fixo de constantes (objetos imutáveis). Elas são usadas quando temos uma quantidade limitada de valores possíveis, como dias da semana, estados de uma aplicação, ou direções (Norte, Sul, Leste, Oeste).

## Caracteristicas

- Valores constantes: Cada valor de uma enum é um objeto singleton (uma única instância) da enum.

- Tipo seguro: Enums oferecem segurança de tipo. Você não pode atribuir valores que não estejam definidos na enumeração.

- Imutáveis: Uma vez que uma enum é definida, seus valores não podem ser alterados.

- Suporte para métodos e construtores: Embora representem valores constantes, enums em Java podem ter construtores, métodos e até comportamentos complexos, como qualquer outra classe.

- Implícita extensão de java.lang.Enum: Todas as enums são, implicitamente, subclasses da classe java.lang.Enum.

## Sintáxe Básica

- Aqui está um exemplo de uma enumeração simples para os dias da semana:

``` java

public enum DiaDaSemana {
    SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
}

```

## Como usar Enums

- Acessando valores de enums: Você pode acessar os valores de uma enum diretamente como constantes.

``` java

import java.time.LocalDate;

public class Rotina {
    public static void main(String[] args) {
        DiaDaSemana hoje = DiaDaSemana.SEGUNDA;
    }
}

```

- Usando enums em switch: Você pode usar enums diretamente em expressões switch, o que é uma vantagem sobre outros tipos.



``` java

import java.time.LocalDate;

public class Rotina {
    public static void main(String[] args) {
        switch (hoje) {
            case SEGUNDA:
                System.out.println("Hoje é segunda-feira!");
                break;
            case SABADO:
            case DOMINGO:
                System.out.println("Final de semana!");
                break;
            default:
                System.out.println("Dia normal.");
                break;
        }    
    }
}

```
