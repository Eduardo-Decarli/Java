import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        /* Instanciações */
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime parser = LocalDateTime.parse("2024-08-28T12:50:40");

        System.out.println("Data usando método now(): " + agora);
        System.out.println("Data Parseada: " + parser);

        /* Recuperando valores do LocalDateTime */

        System.out.println("Hora da variavel parser: " + parser.getHour());
        System.out.println("Minuto da variavel parser: " + parser.getMinute());
        System.out.println("Segundo da variavel parser: " + parser.getSecond());

        /* Adicionando e Diminuindo valores */
        System.out.println("Diminuindo 3 horas: " + parser.minusHours(3));
        System.out.println("Aumentando 20 minutos: " + parser.plusMinutes(20));

        /* Convertendo para LocalDate */
        LocalDate ld = parser.toLocalDate();
        System.out.println("Data convertida para LocalDate: " + ld);
    }
}