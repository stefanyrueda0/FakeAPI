package com.pruebas.fakeapi.task;



public class PasajeroBuilder {
    private String name;
    private int trip;
    private int airline;

    public PasajeroBuilder() {
        this.name = "";
        this.trip = 0;
        this.airline = 0;

    }


    public static PasajeroBuilder nuevo(){
        return new PasajeroBuilder();
    }

    public PasajeroBuilder ingreso(String nombre, int viajes, int aerolinea){
        this.name= nombre;
        this.trip=viajes;
        this.airline=aerolinea;
        return this;
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
    public Pasajero build(){
        return new Pasajero(this);
    }

}

