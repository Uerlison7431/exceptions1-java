package application ;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


import model.entities.Reservation;

public class Program {
    
    public static void main(String[] args) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date(dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        //o metodo after testa se uma e dpois da outra 
        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else{
        Reservation reservation = new Reservation(number, checkIn, checkOut);
        System.out.println("Reservation: " + reservation);

        System.out.println();
        System.out.println("Enter data to udate the reservation");
        
        System.out.print("Check-in date (dd/MM/yyyy)");
        checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date(dd/MM/yyyy)");
        checkOut = sdf.parse(sc.next());

       //Veririfica se checiIn e checkOut são antes da variavel now 
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            System.out.println("Error i  reservation: Reservation dates for udates must be fture");
        } else if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        
        } 
        else{
            reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }       

        }
        sc.close();

    }
}

