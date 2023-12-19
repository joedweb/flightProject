import java.time.LocalDateTime;

public class Flight {

    // main
    private int flightNum;

    private String airport;

    private LocalDateTime dateTime;

    private String destination;

    private String departure;


    // constructor
    public Flight(int flightNum, String airport, LocalDateTime dateTime, String destination, String departure) {
        this.flightNum = flightNum;
        this.airport = airport;
        this.dateTime = dateTime;
        this.destination = destination;
        this.departure = departure;
    }

    // S/G
    public int getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    //toString()

    @Override
    public String toString() {
        return "Flight{" +
                "flightNum=" + flightNum +
                ", airport='" + airport + '\'' +
                ", dateTime=" + dateTime +
                ", destination='" + destination + '\'' +
                ", departure='" + departure + '\'' +
                '}';
    }
}
