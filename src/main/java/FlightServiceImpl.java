import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightServiceImpl implements FlightService{

    private Connection connection;

    public FlightServiceImpl(Connection connection) {
        this.connection = connection;
    }

    // Add a flight to the flights table
    @Override
    public void addflight(Flight flight) {
        try(PreparedStatement statement = connection.prepareStatement("INSERT INTO flights (flightnum, dateandtime, airport, destination, departure) VALUES (?,?,?,?,?)")){
            statement.setInt(1,flight.getFlightNum());
            statement.setString(2, flight.getDateTime());            //?
            statement.setString(3,flight.getAirport());
            statement.setString(4,flight.getDestination());
            statement.setString(5,flight.getDeparture());

            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    // Update a flight from the flights table
    @Override
    public void updateFlight(Flight flight) {

        try(PreparedStatement statement = connection.prepareStatement("UPDATE flights SET dateandtime=?, airport=?, destination=?, departure=? WHERE flightNum=?")){
            statement.setInt(5,flight.getFlightNum());
            statement.setString(1, flight.getDateTime());             //?
            statement.setString(2,flight.getAirport());
            statement.setString(3,flight.getDestination());
            statement.setString(4,flight.getDeparture());

            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // Cancel a flight from the flights table
    @Override
    public void cancelFlight(int flightNum) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM flights WHERE flightNum=?")) {
            statement.setInt(1, flightNum);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // get a flight from the  flights table by its flight number
    @Override
    public Flight getFlightByNum(int flightNum) {

        Flight flight = null;

        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights WHERE flightNum=?")){
            statement.setInt(1,flightNum);
            statement.executeQuery();

            try(ResultSet rs = statement.executeQuery()){
                while(rs.next()){
                    int flightN = rs.getInt("flightNum");
                    String date = rs.getString("dateandtime");
                    String airport = rs.getString("airport");
                    String destination = rs.getString("destination");
                    String departure = rs.getString("departure");

                    flight = new Flight(flightN,date, airport,destination,departure);
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return flight;
    }

    // return all the flights from the flights table
    @Override
    public List<Flight> getAllFlights() {

        List<Flight> flights = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights")){


            try(ResultSet rs = statement.executeQuery()){
                while(rs.next()){
                    int flightN = rs.getInt("flightNum");
                    String date = rs.getString("dateandtime");       //?
                    String airport = rs.getString("airport");
                    String destination = rs.getString("destination");
                    String departure = rs.getString("departure");

                    Flight flight = new Flight(flightN,date, airport,destination,departure);
                    flights.add(flight);
                }
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return flights;
    }
}
