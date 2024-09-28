# Classe Instant

A classe Instant, da API de tempo do Java (java.time), representa um ponto específico na linha do tempo, geralmente utilizado para marcações de tempo (timestamps). Ela mede o tempo em segundos e nanossegundos a partir da época Unix (Unix epoch), que é meia-noite de 1º de janeiro de 1970 (UTC).

## Caracteristicas de Instant

- Representa um ponto no tempo em UTC.

- Mede o tempo em segundos e nanossegundos desde o epoch Unix (1º de Janeiro de 1970, 00:00:00 UTC)

- Imutável como outras classes da API de tempo.

- Usado frequentemente para operações de tempo, como capturar o momento atual ou calcular a diferença entre dois pontos no tempo.

## Instanciação

- Obter o instante atual: Para capturar o momento atual, você usa o método now()

``` java

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Instant agora = Instant.now();
        System.out.println(agora);  // Exibe o instante atual em formato YYYY-MM-DDTHH:MMZ
    }
}

```

- Criar um instante a partir da epoch: Para criar um instante a partir de segundos ou nanosegundos desde a época Unix, usa-se o método ofEpochSecond() ou ofEpochMilli().

``` java

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Instant doEpoch = Instant.ofEpochSecond(0);  // Cria o instante correspondente ao epoch Unix
        System.out.println(doEpoch);  // 1970-01-01T00:00:00Z
    }
}

```

``` java

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Instant parsedInstant = Instant.parse("2024-09-27T10:15:30.00Z");
        System.out.println(parsedInstant);  // 2024-09-27T10:15:30Z
    }
}

```

## Métodos Comuns

- Adicionar ou subtrair tempo: Instant permite adicionar ou subtrair segundos ou nanossegundos.

``` java

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Instant agora = Instant.now();
        Instant maisUmSegundo = agora.plusSeconds(1);  // Adiciona 1 segundo
        Instant menosUmSegundo = agora.minusSeconds(1);  // Subtrai 1 segundo
        System.out.println(maisUmSegundo);
    }
}

```

- Comparação entre instantes: Para comparar dois instantes, você pode usar isBefore(), isAfter(), ou equals().

``` java

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Instant primeiroInstante = Instant.parse("2024-09-27T10:15:30.00Z");
        Instant segundoInstante = Instant.now();

        boolean anterior = primeiroInstante.isBefore(segundoInstante);  // true ou false
        boolean posterior = primeiroInstante.isAfter(segundoInstante);  // true ou false

    }
}

```

- Calcular a diferença entre dois instantes: Usando o método Duration.between(), você pode calcular a diferença de tempo entre dois Instants.

``` java

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Instant inicio = Instant.now();
        // Operação qualquer...
        Instant fim = Instant.now();
        long duracaoEmMillis = Duration.between(inicio, fim).toMillis();
        System.out.println("Duração: " + duracaoEmMillis + " milissegundos");
    }
}

```

- Converter Instant para outro tipo de data e hora: Embora Instant seja útil para marcações temporais, ele pode ser convertido em um LocalDateTime ou ZonedDateTime quando você quiser trabalhar com um formato mais amigável ou incluir fusos horários.

``` java

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Instant agora = Instant.now();
        ZonedDateTime zonedDateTime = agora.atZone(ZoneId.systemDefault());  // Converte para o fuso horário do sistema
        System.out.println(zonedDateTime);

    }
}

```