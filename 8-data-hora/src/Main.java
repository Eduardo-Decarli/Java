import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        /* Data Hora */
        //Em java, é utilizado o padrão ISO 8601 para representar um tipo data
        //Data local = 2022-07-22T14:52:09 -> Esse é o horário local do sistema
        //Data Global = 22-07-23T14:52:09Z -> Significa horário GMT de londres

        //Instanciação
        //Para instanciar data-hora local utiliza-se o LocalDate para armazenar a data e LocalDateTime para armazenar a data e o horário

        LocalDate dataAtual = LocalDate.now(); //Retorna a data local atual do sistema
        LocalDateTime dataHoraAtual = LocalDateTime.now(); //Retorna a data e o horário atual do sistema
        Instant dataHoraGlobal = Instant.now(); //Retorna a data e o horario glboal

        //Gerar uma data a partir do formato ISO 8106
        LocalDate dataAtualISO = LocalDate.parse("2024-09-15");
        LocalDateTime dataHoraAtualISO = LocalDateTime.parse("2024-09-15T12:26:15");
        Instant dataHoraGlobalISO = Instant.parse("2024-09-15T12:26:15-03:00"); //Iniciando um instant com fuso horário -03:00

        //Podemos gerar uma data passando valores inteiros como argumento
        LocalDate dataOf = LocalDate.of(2024, 8,25);


        System.out.println("Data atual do sistema = " + dataAtual);
        System.out.println("Data e horário atual do sistema = " + dataHoraAtual);
        System.out.println("Data global e horário GMT: " + dataHoraGlobal);
        System.out.println("Data local gerada a partir do formato ISO 8106: " + dataAtualISO);
        System.out.println("Data e horario local gerada a partir do formato ISO 8106: " + dataHoraAtualISO);
        System.out.println("Data e horario global gerada a partir do formato ISO 8106 com fuso horário: " + dataHoraGlobalISO);
        System.out.println("Data gerada a partir de valores inteiros: " + dataOf);

        System.out.println("------------------------------------------");

        //Formatação

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Cria um pattern para o formato de data especificado
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); //Cria um pattern para o formato de data e horário especificado

        System.out.println("Data sem formatação: " + dataAtual);
        System.out.println("Data formatada em formato dd/mm/yyyy: " + dataAtual.format(fmt1)); //Podemos passar o fmt1 como argumento, ou passar fmt1.format(dataAtual) que terá o mesmo resultado

        //Obter dados de uma data-hora local

        //converter data-hora global para local

        //calculos com data-hora
    }
}