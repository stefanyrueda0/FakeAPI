package com.pruebas.fakeapi.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.screenplay.actors.OnStage;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(

        features= "src/test/resources/creacion_de_pasajero.feature",
        glue = { "com.pruebas.fakeapi.stepdefinitions"},
        snippets= SnippetType.CAMELCASE
)

public class CreacionPasajeroRunner {



}
