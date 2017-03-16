package com.example.emillemartins.agendinha.core;



/**
 * Created by emillemartins on 16/03/17.
 */


public class Controller {

    private static Controller INSTANCE = null;
    private String value;

    private Controller() {
    }

    public static Controller getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Controller();
        return INSTANCE;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
