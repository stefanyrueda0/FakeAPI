package com.pruebas.fakeapi.questions;

import com.pruebas.fakeapi.task.Pasajero;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

import static com.pruebas.fakeapi.task.CreacionDePasajero.VARSESION_PASAJERO;
import static com.pruebas.fakeapi.utilsRest.convertirJsonMap;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class Verificacion implements Question {

    private Map jsonConvertido;
    private Pasajero infopasajero;



    @Override
    public Boolean answeredBy(Actor actor) {
       jsonConvertido=convertirJsonMap(lastResponse().getBody().prettyPrint());
       infopasajero=actor.recall(VARSESION_PASAJERO);
        return verificacion();
    }
    private boolean verificacion() {
        return infopasajero.getName().equals(jsonConvertido.get("name"));
    }

    public static Verificacion creacion(){
        return new Verificacion();
    }


}
