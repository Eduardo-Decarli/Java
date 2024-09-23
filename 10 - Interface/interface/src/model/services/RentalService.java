package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.Duration;

public class RentalService {
    private double pricePerDay;
    private double pricePerHour;

    private TaxService taxService;

    public RentalService(double pricePerDay, double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental){

        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60.0;

        double basicPayment;
        if(hours <= 12){
            basicPayment = pricePerHour * Math.ceil(hours);
        }else{
            basicPayment = pricePerDay * Math.ceil(hours);
        }

        double tax = taxService.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
