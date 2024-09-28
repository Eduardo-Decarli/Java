# Classe LocalDateTime

A classe LocalDateTime faz parte da API de data e tempo introduzida no Java 8 (no pacote java.time). Ela representa data e hora, mas sem informações de fuso horário. Assim, combina as funcionalidades de LocalDate (apenas data) e LocalTime (apenas hora).

## Caracteristicas

- Representa data e hora, mas sem fuso horário.

- Imutável (uma vez criada, a instância não pode ser modificada).

- Pode ser usada para capturar e manipular momentos no tempo sem se preocupar com fusos horários.

## Instanciação

- Obter a data e hora atuais: A forma mais comum de criar um LocalDateTime é utilizando o método now(), que retorna a data e a hora atuais do sistema.

``` java

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora);  // Exibe a data e hora atuais
    }
}

```

- Criar uma data e hora específicas: Usando o método estático of(), você pode criar uma data e hora específicas.

``` java

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime dataHoraEspecifica = LocalDateTime.of(2024, 9, 27, 10, 45, 30);
        System.out.println(dataHoraEspecifica);  // 2024-09-27T10:45:30
    }
}

```

- Parsear uma string para LocalDateTime: Você pode criar um LocalDateTime a partir de uma string usando o método parse(). O formato deve ser YYYY-MM-DDTHH:MM:SS.

``` java

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime dataHoraParseada = LocalDateTime.parse("2024-09-27T10:45:30");
        System.out.println(dataHoraParseada);
    }
}

```

## Métodos Comuns

- Acessando partes da data e hora: A LocalDateTime permite acessar partes específicas da data e da hora usando métodos como getYear(), getMonthValue(), getHour(), etc.

``` java

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();
        int ano = agora.getYear();         // Ano atual
        int mes = agora.getMonthValue();   // Mês atual (como número)
        int dia = agora.getDayOfMonth();   // Dia atual
        int hora = agora.getHour();        // Hora atual
        int minuto = agora.getMinute();    // Minuto atual
        System.out.println(ano + "-" + mes + "-" + dia + " " + hora + ":" + minuto);
    }
}

```

- Manipulação de datas e horas: Similar a LocalDate, você pode adicionar ou subtrair dias, horas, minutos, etc.

``` java

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime umaHoraDepois = agora.plusHours(1);       // Adiciona 1 hora
        LocalDateTime tresDiasAntes = agora.minusDays(3);       // Subtrai 3 dias
    }
}

```

- Comparação de datas e horas: Você pode comparar duas instâncias de LocalDateTime usando métodos como isBefore(), isAfter(), e isEqual().

``` java

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime dataHora1 = LocalDateTime.of(2023, 9, 27, 10, 45);
        LocalDateTime dataHora2 = LocalDateTime.of(2024, 9, 27, 10, 45);

        boolean anterior = dataHora1.isBefore(dataHora2);  // true
        boolean posterior = dataHora1.isAfter(dataHora2);  // false
        boolean igual = dataHora1.isEqual(dataHora2);      // false
    }
}

```

- Conversão para LocalDate ou LocalTime: Você pode extrair apenas a parte da data (LocalDate) ou apenas a parte do tempo (LocalTime) de um LocalDateTime.

``` java

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();
        LocalDate data = agora.toLocalDate();    // Apenas a data
        LocalTime hora = agora.toLocalTime();    // Apenas a hora
    }
}

```