import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        /* Data Hora */
        // Em Java, o padrão ISO 8601 é utilizado para representar um tipo de data.
        // Data local = 2022-07-22T14:52:09 -> Horário local do sistema.
        // Data Global = 2022-07-22T14:52:09Z -> Horário GMT de Londres (Z significa UTC).

        // Instanciação
        // Para instanciar data-hora local, utiliza-se o LocalDate para armazenar a data
        // e LocalDateTime para armazenar a data e o horário.

        LocalDate dataAtual = LocalDate.now(); // Retorna a data local atual do sistema.
        LocalDateTime dataHoraAtual = LocalDateTime.now(); // Retorna a data e o horário atual do sistema.
        Instant dataHoraGlobal = Instant.now(); // Retorna a data e o horário global.

        // Gerar uma data a partir do formato ISO 8601
        LocalDate dataAtualISO = LocalDate.parse("2024-09-15");
        LocalDateTime dataHoraAtualISO = LocalDateTime.parse("2024-09-15T12:26:15");
        Instant dataHoraGlobalISO = Instant.parse("2024-09-15T12:26:15-03:00"); // Incluindo fuso horário -03:00

        // Podemos gerar uma data passando valores inteiros como argumento
        LocalDate dataOf = LocalDate.of(2024, 8, 25);

        // Exibindo os resultados
        System.out.println("Data atual do sistema = " + dataAtual);
        System.out.println("Data e horário atual do sistema = " + dataHoraAtual);
        System.out.println("Data global e horário GMT: " + dataHoraGlobal);
        System.out.println("Data local gerada a partir do formato ISO 8601: " + dataAtualISO);
        System.out.println("Data e horário local gerados a partir do formato ISO 8601: " + dataHoraAtualISO);
        System.out.println("Data e horário global com fuso horário: " + dataHoraGlobalISO);
        System.out.println("Data gerada a partir de valores inteiros: " + dataOf);

        System.out.println("------------------------------------------");
        System.out.println("Formatação de Datas");

        // Formatação
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Padrão para formato de data.
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); // Padrão para data e horário.
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault()); // Formatação para Instant.

        System.out.println("Data sem formatação: " + dataAtual);
        System.out.println("Data formatada em formato dd/MM/yyyy: " + dataAtual.format(fmt1)); //Para trabalhar o formato, é necessario passar a variavel o .format() e especificar o formato
        System.out.println("Data e hora formatada em formato dd/MM/yyyy HH:mm = " + dataHoraAtual.format(fmt2));
        System.out.println("Data global formatada em formato dd/MM/yyyy: " + fmt3.format(dataHoraGlobal));

        System.out.println("------------------------------------------");
        System.out.println("Conversão de Datas");

        // Converter data-hora global para local
        LocalDate dataConvertida = LocalDate.ofInstant(dataHoraGlobal, ZoneId.systemDefault());
        System.out.println("Data global convertida para local: " + dataConvertida.format(fmt1));

        System.out.println("------------------------------------------");
        System.out.println("Capturando dados de Datas");

        // Obtendo dados de datas
        System.out.println("Dia do mês da variável dataAtual: " + dataAtual.getDayOfMonth());
        System.out.println("Mês do ano da variável dataAtual: " + dataAtual.getMonth());
        System.out.println("Ano da variável dataAtual: " + dataAtual.getYear());

        System.out.println("Hora da variável dataHoraAtual: " + dataHoraAtual.getHour());
        System.out.println("Minuto da variável dataHoraAtual: " + dataHoraAtual.getMinute());
        System.out.println("Segundo da variável dataHoraAtual: " + dataHoraAtual.getSecond());

        System.out.println("------------------------------------------");
        System.out.println("Calculando dados de Datas");

        //calculos com data-hora
        LocalDate pastWeekLocalDate = dataAtual.minusDays(7);
        LocalDate nextWeekLocalDate = dataAtual.plusWeeks(1);

        System.out.println("variavel dataAtual subtraida com 7 dias: " + pastWeekLocalDate);
        System.out.println("variavel dataAtual somada com 1 semana: " + nextWeekLocalDate);

        // Calculando a duração entre duas datas
        try {
            LocalDateTime ldt1 = LocalDateTime.parse("2024-10-20T10:20:40");
            LocalDateTime ldt2 = LocalDateTime.parse("2024-02-04T05:20:40");
            Duration d1 = Duration.between(ldt1, ldt2);
            System.out.println("Duração entre as datas: " + d1.toDays() + " dias");
        } catch (Exception e) {
            System.out.println("Erro ao analisar as datas: " + e.getMessage());
        }
    }
}
