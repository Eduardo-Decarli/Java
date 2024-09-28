# Classe LocalDate

A classe LocalDate em Java faz parte da API de manipulação de datas introduzida no Java 8 (dentro do pacote **java.time**). Ela é usada para representar uma data (**dia, mês e ano**) sem a hora. Isso a torna ideal para situações em que só precisamos trabalhar com datas, como aniversários, datas de vencimento, datas de eventos, etc.

## caracteristicas 

- Representa apenas a data (sem tempo ou fuso horário)

- Imutável (como todas as classes do java.time)

- Comparações entre datas são simples e diretas

## Instanciação

- Obter a data atual: A forma mais simples de obter a data atual é usar o método estático **now()**.

``` java

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now(); // Armazena na variavel hoje, a data respectiva ao SO usado
        System.out.println(hoje);  // Exibe a data atual no formato YYYY-MM-DD
    }
}

```

- Criação de uma data específica: É possivel criar um objeto LocalDate para uma **data especifica**, usando o método estático **of()**.

``` java

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate dataEspecifica = LocalDate.of(2023, 9, 27);  // 27 de setembro de 2023
        System.out.println(dataEspecifica);
    }
}

```

- Parsear uma String para LocalDate: Você pode criar um objeto LocalDate a partir de uma string com o formato **YYYY-MM-DD** usando o método **parse()**.

``` java

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate dataParseada = LocalDate.parse("2024-09-27");
        System.out.println(dataParseada);
    }
}

```

## Métodos Comuns

- Acessando partes da data: A LocalDate oferece métodos para acessar os componentes de uma data.

``` java

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now();
        int ano = data.getYear();        // Ano atual
        int mes = data.getMonthValue();  // Mês atual (como número)
        int dia = data.getDayOfMonth();  // Dia do mês

        System.out.println("Ano: " + ano);
        System.out.println("Mês: " + mes);
        System.out.println("Dia: " + dia);

    }
}

```

- Manipulação de datas: A LocalDate permite adicionar ou subtrair dias, semanas, meses ou anos de uma data.

``` java

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        LocalDate umaSemanaDepois = hoje.plusWeeks(1);  // Adiciona 1 semana
        LocalDate umMesAntes = hoje.minusMonths(1);     // Subtrai 1 mês
    }
}

```

- Comparação entre datas: Você pode comparar duas datas usando métodos como isBefore(), isAfter(), e isEqual().

``` java

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate data1 = LocalDate.of(2023, 9, 27);
        LocalDate data2 = LocalDate.of(2024, 9, 27);

        boolean anterior = data1.isBefore(data2);  // true
        boolean posterior = data1.isAfter(data2);  // false
        boolean igual = data1.isEqual(data2);      // false
    }
}

```