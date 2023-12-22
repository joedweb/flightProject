import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;



public class FlightApp {
    private static FlightService flightService = new FlightServiceImpl(JDBConnection.getConnection());

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int choice;

        System.out.println("Welcome to BLIT Flight Services! ");
        do {
            System.out.println("""
                                 
                    Please enter your action:
                    1) Add a flight
                    2) Update a flight
                    3) Cancel a flight
                    4) Display a flight
                    5) Display all flight
                    6)- EXIT -
                    """);

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addflight(sc);
                    break;

                case 2:
                    updateflight(sc);
                    break;

                case 3:
                    cancelflight(sc);
                    break;

                case 4:
                    readFlightByNum(sc);
                    break;

                case 5:
                    displayFlights(sc);
                    break;

                case 6:
                    System.out.println("See you later...");
                    break;

                default:
                    System.out.println("No such choice. Try again");
                    break;
            }

        } while (choice != 6);
    }

    private static void displayFlights(Scanner sc) {
        for(Flight flight : flightService.getAllFlights()){
            System.out.println(flight);
        }
    }

    private static void readFlightByNum(Scanner sc) {


        System.out.println("Please enter flight number: ");
        int flightNum = sc.nextInt();
        Flight flight = flightService.getFlightByNum(flightNum);

        if(flight == null){
            System.out.println("No flight found with that number.");
        }
        else {
            System.out.println(flight);
        }
}
    private static void cancelflight(Scanner sc) {

        System.out.println(" Enter the flight number to delete: ");
        int flightNum = sc.nextInt();
        sc.nextLine();

        //check if the book is there, if yes then proceed to update
        Flight flight = flightService.getFlightByNum(flightNum);

        if(flight == null) {
            System.out.println("Flight not found");
        }
        else{
            flightService.cancelFlight(flightNum);
            System.out.println("Flight cancelled succesffully!");
        }
    }

    private static void updateflight(Scanner sc) {
        System.out.println("Enter the flight number to update it: ");
        int flightNum = sc.nextInt();
        sc.nextLine();

        //check if the book is there, if yes then proceed to update
        Flight flight = flightService.getFlightByNum(flightNum);
        if(flight == null) {
            System.out.println("Flight not found");
        }
        else{
            System.out.println("Enter your new flight (press enter to skip item)");
            System.out.println("Date and Time: ");
            String datetime = sc.nextLine();
            System.out.println("Airport: ");
            String airport = sc.nextLine();
            System.out.println("Departure: ");
            String departure = sc.nextLine();
            System.out.println("Destination: ");
            String destination = sc.nextLine();

            flight.setAirport(airport.isEmpty()?flight.getAirport(): airport);
            flight.setDateTime(datetime.isEmpty()?flight.getDateTime(): datetime);
            flight.setDeparture(departure.isEmpty()? flight.getDeparture(): departure);
            flight.setDestination(destination.isEmpty()? flight.getDestination(): destination);

            flightService.updateFlight(flight);

            System.out.println("Flight updated successfully!");
        }
    }

    private static void addflight(Scanner sc)  {
        System.out.println("Please enter the new flight details: ");
        System.out.println("Flight Number: ");
        int flightNum = sc.nextInt();
        sc.nextLine();

        System.out.println("Date and Time: (MMM/DD/YYYY HH:MM)");             //!!
        String flightDT = sc.nextLine();                                         //!!

        System.out.println("Airport: ");
        String airport = sc.nextLine();
        System.out.println("Destination: ");
        String destination = sc.nextLine();
        System.out.println("Departure: ");
        String departure = sc.nextLine();

        Flight flight = new Flight(flightNum, flightDT,airport,destination,departure);           //cannot be casted
        flightService.addflight(flight);
        System.out.println("Flight added successfully");

    }


}
