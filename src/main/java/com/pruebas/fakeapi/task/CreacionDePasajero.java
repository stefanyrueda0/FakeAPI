package com.pruebas.fakeapi.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.pruebas.fakeapi.utilsRest.obtenerJson;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreacionDePasajero implements Task {

    public static final String VARSESION_PASAJERO ="";
    private Pasajero infopasajero;


    public CreacionDePasajero(Pasajero infopasajero) {
        this.infopasajero=infopasajero;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/v1/passenger").with(
                        request ->
                                request
                                        .body(obtenerJson(infopasajero))));
        actor.remember(VARSESION_PASAJERO,infopasajero);



    }

    public static CreacionDePasajero datos(PasajeroBuilder pasajeroBuilder){
        return instrumented(CreacionDePasajero.class, pasajeroBuilder.build());
    }
}
