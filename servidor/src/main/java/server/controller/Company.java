package server.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("company")
public class Company {
    private String name = "T&N`S Booking Service";
    private final ArrayList<Flight> flights = new ArrayList<>();
  
    public Company() {
        Flight flights1 = new Flight("ABC123", "NATAL", "SAO PAULO", "20-05-2021", 182, true);
        Flight flights2 = new Flight("ASD133", "JOAO PESSOA", "RIO DE JANEIRO", "21-06-2021", 150, false);
        Flight flights3 = new Flight("DEC113", "NATAL", "MOSSORO", "15-01-2022", 50, true);
        Flight flights4 = new Flight("ENE444", "SAO PAULO", "RIO DE JANEIRO", "30-05-2022", 50, true);
        Flight flights5 = new Flight("TIJ987", "BRASILIA", "SAO PAULO", "22-05-2022", 50, false);

        flights.add(flights1);
        flights.add(flights2);
        flights.add(flights3);
        flights.add(flights4);
        flights.add(flights5);
    }

    @GetMapping("name")
    public String getName() {
        return String.format(this.name);
    }

    @GetMapping("flights")
    public ArrayList<Flight> getFlights() {
        return flights;
    }

    @GetMapping("flight/{origin}/{destination}")
    public Flight getByOriginAndDestination(@PathVariable(value = "origin") String origin, @PathVariable(value = "destination") String destination) {
        for (Flight f : flights) {
            if(origin.equals(f.getLeaving_from())  && destination.equals(f.getGoing_to())){
                return f;
            }
        }
        return null;
    }

    @PostMapping("reserve/{flightcode}/{date}/{isdirect}")
    public String reserveFlight(@PathVariable String flightcode, @PathVariable String date, @PathVariable boolean isdirect) {
        for (Flight f : flights) {
            if(flightcode.equals(f.getCode()) && date.equals(f.getLeaving_date()) && isdirect == f.getDirect_flight() && f.getFlight_capacity() > 0) {
                f.decreaseFlightCapacity();
                return String.format("Reserva Realziada. Nova capacidade do Voo: " + f.getFlight_capacity());
            }
        }
        return String.format("Voo não encontrado!");
    }

}
