package com.pruebas.fakeapi;

import com.google.gson.Gson;

import java.util.Map;

public class utilsRest {

    public static <T> String obtenerJson (T objeto){
        final Gson gson= new Gson();
        return gson.toJson(objeto);
    }

    public static Map convertirJsonMap(String objeto){

        final Gson gson = new Gson();
        return gson.fromJson(objeto,Map.class);

    }
}
