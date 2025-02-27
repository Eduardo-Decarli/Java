# API Data e Hora

A API de Data e Hora (**java.time**) foi introduzida no Java 8 para facilitar o trabalho com datas e horas. Ela resolve problemas das classes antigas, como mutabilidade, dificuldades de formatação e inconsistências em fusos horários. Suas principais classes são:

- **LocalDate** → Representa apenas a **data** (ex: 2025-02-26).
- **LocalTime** → Representa apenas a **hora** (ex: 14:30:15).
- **LocalDateTime** → Representa **data e hora** juntas (ex: 2025-02-26T14:30:15).
- **DateTimeFormatter** → Permite **formatar e parsear datas** para diferentes padrões.

## Conceitos Fundamentais

**LocalDate:** Armazena informação de ano, mês e dia, mas apenas a data (sem horário)

``` Java

import java.time.LocalDate;

public class ExemploLocalDate {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now(); // Data atual
        LocalDate dataEspecifica = LocalDate.of(2025, 2, 26); // Data específica

        System.out.println("Hoje: " + hoje);
        System.out.println("Data específica: " + dataEspecifica);
    }
}

```

**LocalTime:** Apenas horas (sem data), armazena informação de hora, minuto e segundo e nanossegundos.

``` Java

import java.time.LocalTime;

public class ExemploLocalTime {
    public static void main(String[] args) {
        LocalTime agora = LocalTime.now(); // Hora atual
        LocalTime horarioEspecifico = LocalTime.of(14, 30, 15); // 14:30:15

        System.out.println("Hora atual: " + agora);
        System.out.println("Horário específico: " + horarioEspecifico);
    }
}

```

**LocalDateTime:** Combina as classes LocalDate e LocalTime em um único objeto, ele junta as classes Data e Hora juntas

``` Java

import java.time.LocalDateTime;

public class ExemploLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now(); // Data e hora atuais
        LocalDateTime dataHoraEspecifica = LocalDateTime.of(2025, 2, 26, 14, 30, 15);

        System.out.println("Data e hora atual: " + agora);
        System.out.println("Data e hora específica: " + dataHoraEspecifica);
    }
}

```

**DateTimeFormatter:** Permite converter um LocalDateTime para String em formatos personalizados, isso permite transformar o retorno das classes em um formato personalizado.

``` Java

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExemploFormatter {
    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = agora.format(formatter);

        System.out.println("Data formatada: " + dataFormatada); // Data formatada: 26/02/2025 14:30:15
    }
}

```

## Exemplos práticos

- Somar e subtrair datas 

``` Java

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ManipulacaoData {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        LocalDate proximaSemana = hoje.plus(7, ChronoUnit.DAYS);
        LocalDate mesPassado = hoje.minus(1, ChronoUnit.MONTHS);

        System.out.println("Hoje: " + hoje);
        System.out.println("Próxima semana: " + proximaSemana);
        System.out.println("Mês passado: " + mesPassado);
    }
}

```

---

- Diferença entre Datas

``` Java

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DiferencaEntreDatas {
    public static void main(String[] args) {
        LocalDate inicio = LocalDate.of(2025, 2, 20);
        LocalDate fim = LocalDate.of(2025, 3, 1);

        long dias = ChronoUnit.DAYS.between(inicio, fim);

        System.out.println("Diferença em dias: " + dias); // Diferença em dias: 9
    }
}

```

---

- Comparação de Datas

``` Java

import java.time.LocalDate;

public class ComparacaoDeDatas {
    public static void main(String[] args) {
        LocalDate data1 = LocalDate.of(2025, 2, 26);
        LocalDate data2 = LocalDate.of(2025, 3, 1);

        System.out.println("data1 é antes de data2? " + data1.isBefore(data2)); // data1 é antes de data2? true
        System.out.println("data1 é depois de data2? " + data1.isAfter(data2)); // data1 é depois de data2? false
    }
}

```

## Boas Práticas

- Sempre use **java.time** (LocalDate, LocalTime, LocalDateTime) ao invés de **Date** e **Calendar**.

- Utilize **DateTimeFormatter** para garantir formatação consistente.

- Prefira **ChronoUnit** para calcular diferenças entre datas.