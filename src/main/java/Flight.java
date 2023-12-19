import java.sql.Date;



public class Flight {

    // main
    private int flightNum;

    private Date dateTime;
    private String airport;

    private String destination;

    private String departure;

    public Flight(int flightNum, Date dateTime, String airport, String destination, String departure) {
        this.flightNum = flightNum;
        this.dateTime = dateTime;
        this.airport = airport;
        this.destination = destination;
        this.departure = departure;
    }
// constructor


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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
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
