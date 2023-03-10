package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

    public Reservation(){
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
        if(!checkOut.after(checkIn)){
            throw new DomainException("Check-out date must be after check-in date");        
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    

    public void setChackIn(Date chackIn) {
        this.checkIn = chackIn;
    }

    public Date getChackOut() {
        return checkOut;
    }    

    public long duration(){
        //Pega o metof getTime pega a o tempo em milisegundos
        long diff = checkOut.getTime() - checkIn.getTime();
        //convertendo milisegundos para dias
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

    }

    //A atualiação das datas passa antes por um check da datas procurando algum erro
    public void updateDates(Date checkIn, Date checkOut) throws DomainException{
        
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("reservation: Reservation dates for udates must be fture");
        } 
        if(!checkOut.after(checkIn)){
            throw new DomainException("Check-out date must be after check-in date");        
        } 
        
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        
    }

    @Override
    public String toString(){
        return "Room "
        +roomNumber
        +", Check-in "
        +sdf.format(checkIn)
        +", Check-out "
        +sdf.format(checkOut)
        +", "
        +duration()
        +" Nights";
    }

}
