import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        /* Instanciação */
        DateTimeFormatter fmtLocalDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmtLocalTime = DateTimeFormatter.ofPattern("HH:mm:ss");

        String stringData = "10/12/2023";
        LocalDate data = LocalDate.parse(stringData, fmtLocalDate);

        LocalTime time = LocalTime.of(12,20, 50);

        System.out.println("Data formatada: " + data.format(fmtLocalDate));
        System.out.println("Hora formatada: " + time.format(fmtLocalTime));
    }
}