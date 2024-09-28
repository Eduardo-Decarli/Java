import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        /* Instanciando tipos de datas */
        LocalDate hoje = LocalDate.now();
        LocalDate hojeToOfMethod = LocalDate.of(2024, 9, 27);
        LocalDate dataParser = LocalDate.parse("2024-09-27");

        System.out.println(hoje);
        System.out.println(hojeToOfMethod);
        System.out.println(dataParser);

        /* Acessando valores de datas */

        System.out.println("Retorna o dia do mês: " + hoje.getDayOfMonth());
        System.out.println("Retorna o dia da semana: " + hoje.getDayOfWeek());
        System.out.println("Retorna o dia do ano: " + hoje.getDayOfYear());

        System.out.println("\nRetorna o mês: " + hoje.getMonthValue());

        System.out.println("\nRetorna o ano: " + hoje.getYear());

        /* Aumentando e Diminuindo dias/meses/semanas */

        System.out.println("Uma semna a frente: " + hoje.plusWeeks(1));
        System.out.println("Uma semna a atrás: " + hoje.minusWeeks(1));

        /* Comparando Datas */

        System.out.println("A variavel hoje é antes da dataPaser? " + hoje.isBefore(dataParser));
        System.out.println("\nAs duas datas são iguais? " + hoje.isEqual(dataParser));
        System.out.println("A variavel hoje é depois da dataPaser?" + hoje.isAfter(dataParser));







    }
}