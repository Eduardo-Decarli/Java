package entities;

import exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reservation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    //Declara que irá propagar uma exception do tipo DomainException
    public void updateDates(Date checkin, Date checkout) throws DomainException{
        Date now = new Date();

        if(checkin.before(now)){
            //A palavra throw propaga uma exception
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if(checkout.after(now)){
            throw new IllegalArgumentException("Check-out date must be after check-in date");
        }
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString(){
        return "Room" + ", checkin: " + sdf.format(checkin)
                + ", checkout: " + sdf.format(checkout)
                + ", " + duration() + "Nights";
    }
}
