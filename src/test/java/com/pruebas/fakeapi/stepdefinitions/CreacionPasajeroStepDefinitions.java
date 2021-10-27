package com.pruebas.fakeapi.stepdefinitions;

import com.pruebas.fakeapi.task.CreacionDePasajero;
import com.pruebas.fakeapi.task.PasajeroBuilder;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


public class CreacionPasajeroStepDefinitions {

    @Before
    public void declararactor(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("x").whoCan(CallAnApi.at("https://api.instantwebtools.net"));
    }

    private PasajeroBuilder PASS;

    @Dado("^el pasajero (.*) con (\\d+) viajes completados se quiere inscribir a la aerolinea (\\d+)$")
    public void elPasajeroJohnConViajesCompletadosSeQuiereInscribirALaAerolinea(String nombreActor, int numviajes, int codaerolinea) {

        PASS = PasajeroBuilder.nuevo().ingreso(nombreActor, numviajes, codaerolinea);
    }


    @Cuando("^Se crea su usuario$")
    public void seCreaSuUsuario() {

        theActorInTheSpotlight().attemptsTo(
    CreacionDePasajero.datos(PASS)
        );
    }

    @Entonces("^Se puede identificar la creación exitosa del usuario$")
    public void sePuedeIdentificarLaCreaciónExitosaDelUsuario() {
        theActorInTheSpotlight().should(seeThatResponse(
                "valid passenger data must submit.",
                response -> response.statusCode(400)
                        ));
    }


}
