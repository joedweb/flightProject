import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {

    // display flights
    // buy flight


    void addflight(Flight flight);

    void updateFlight(Flight flight);

    void cancelFlight(int flightNum);       //deleting

    Flight getFlightByID(int flightNum);       //read one book

    Flight getFlightByDay(LocalDateTime dateTime);

    List<Flight> getAllFlights();

}
