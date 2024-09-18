package aplication;

import entities.Reservation;
import exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    //A palavra throws é usada para propagar exceptions, aqui consta que a nossa função main pode gerar exceptions e terá que ser propagada para outra classe tratar ela
    //A inicialização do main ficaria assim -> public static void main(String[] args) throws ParseException {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            //Essa chamada de método pode causar uma exception, então o código entende o risto e consta que ou você trata ou propaga a exception
            Date checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkout = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());

            reservation.updateDates(checkin, checkout);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException x){

        }
        catch (DomainException e){
            System.out.println("Error in reservation " + e.getMessage());
        }
        //Esse bloco catch irá capturar qualquer exception gerada pela função updateDates que forem do tipo declarado
        //Então terá um if no método updateDate, se cair no if, ele irá propagar uma exception, e o block catch abaixo irá capturar
        catch(IllegalArgumentException e){
            System.out.println("Error in reservation " + e.getMessage());
        }
        sc.close();
    }
}
