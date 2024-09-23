package application;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do Carro: ");
        String carModel = sc.nextLine();
        System.out.println("Retirada (dd/MM/yyyy hh:mm: ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.println("Retorno (dd/MM/yyyy hh:mm: ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Entre com o preço por hora: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double pricePerDay = sc.nextDouble();

        //Embora o construtor RentalService declara que será um TaxService, o uso do BrazilTaxService é perfeitamente usado
        //Pois será feito o upcasting de BrazilTaxService para a interface TaxService dentro da classe RentalService
        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("FATURA");
        System.out.println("Pagamento basico: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Imposto: " + cr.getInvoice().getTax());
        System.out.println("Pagamento Total: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));


        sc.close();

    }
}