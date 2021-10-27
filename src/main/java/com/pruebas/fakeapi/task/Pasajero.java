package com.pruebas.fakeapi.task;

public class Pasajero {

    private String name;
    private int trip;
    private int airline;

    public Pasajero(PasajeroBuilder pasajeroBuilder) {
        this.name = pasajeroBuilder.getName();
        this.trip = pasajeroBuilder.getTrip();
        this.airline = pasajeroBuilder.getAirline();
    }


    public String getName() {
        return name;
    }

    public int getTrip() {
        return trip;
    }

    public int getAirline() {
        return airline;
    }
}
