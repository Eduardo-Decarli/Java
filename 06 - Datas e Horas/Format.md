# Classe Format

A classe java.time.format.DateTimeFormatter pertence ao pacote java.time.format e é usada para formatar e analisar objetos de data e hora no Java. Ela desempenha um papel fundamental ao converter objetos como LocalDate, LocalTime, LocalDateTime, ZonedDateTime e outros tipos de data e hora para uma representação textual e vice-versa.

## Caracteristicas

- Imutável: A classe é imutável, o que significa que suas instâncias são seguras para uso em ambientes com múltiplas threads

- Flexível: Ela permite a formatação de objetos de data e hora em diversos formatos personalizados, como datas abreviadas, datas completas e formatos ISO.

- Compatibilidade: Fornece métodos predefinidos para os padrões mais comuns de formatação (ex.: ISO-8601) e também permite a criação de formatos personalizados usando pattern.

- Suporte a locais: O formato pode ser adaptado ao idioma ou convenções regionais usando Locale.

## Instanciação

- Padrão Personalizado: Você pode criar seu próprio padrão de formatação usando o método estático ofPattern():

``` java

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
}

```

- Formatos com Localidade: Para suportar diferentes convenções de idiomas, pode-se especificar um Locale:

``` java

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.FRANCE);
    }
}

```

## Principais Métodos

- Formatar uma data ou hora: O método format() formata um objeto de data/hora para uma string.

``` java

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter); // 28/09/2024
    }
}

```

- Analisar uma string: O método parse() converte uma string formatada em um objeto de data ou hora.

``` java

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        String dateStr = "28/09/2024";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
    }
}

```

- Formatação Padrão (ISO): O DateTimeFormatter pode ser usado com padrões ISO predefinidos.

``` java

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        String isoFormatted = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}

```
