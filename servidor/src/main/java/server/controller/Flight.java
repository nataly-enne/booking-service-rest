package server.controller;

public class Flight {

    private String code;
    private String leaving_from;
    private String going_to;
    private String leaving_date;
    private int flight_capacity;
    private Boolean isDirect_flight = false;

    public Flight() {
    }

    public Flight(String code, String leaving_from, String going_to, String leaving_date, int flight_capacity, boolean isDirect_flight) {
        this.code = code;
        this.leaving_from = leaving_from;
        this.going_to = going_to;
        this.leaving_date = leaving_date;
        this.flight_capacity = flight_capacity;
        this.isDirect_flight = isDirect_flight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLeaving_from() {
        return leaving_from;
    }

    public void setLeaving_from(String leaving_from) {
        this.leaving_from = leaving_from;
    }

    public String getGoing_to() {
        return going_to;
    }

    public void setGoing_to(String going_to) {
        this.going_to = going_to;
    }

    public String getLeaving_date() {
        return leaving_date;
    }

    public void setLeaving_date(String leaving_date) {
        this.leaving_date = leaving_date;
    }

    public int getFlight_capacity() {
        return flight_capacity;
    }

    public void setFlight_capacity(int flight_capacity) {
        this.flight_capacity = flight_capacity;
    }

    public void decreaseFlightCapacity() {
        this.flight_capacity = this.flight_capacity - 1;
    }

    public Boolean getDirect_flight() {
        return isDirect_flight;
    }

    public void setDirect_flight(Boolean direct_flight) {
        isDirect_flight = direct_flight;
    }

    public String toString() {
        return "\n --------------------------\n"
                + "Codigo: " + this.getCode() + "\nSaida: " + this.getLeaving_from() + "\nDestino: " +this.getGoing_to() +
                "\nData de saida: " + this.getLeaving_date() + "\nCapacidade do aviao: " + this.getFlight_capacity();
    }
}