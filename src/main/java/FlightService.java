import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {

    void addflight(Flight flight);

    void updateFlight(Flight flight);

    void cancelFlight(int flightNum);       //deleting

    Flight getFlightByID(int flightNum);       //read one book


    List<Flight> getAllFlights();

}
