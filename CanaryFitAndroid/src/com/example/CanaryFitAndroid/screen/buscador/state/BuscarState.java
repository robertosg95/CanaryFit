package com.example.CanaryFitAndroid.screen.buscador.state;

import es.ulpgc.eite.framework.core.screen.I_ScreenState;

/**
 * Contiene los elementos que nos interesa guardar para pasárselo a la siguiente pantalla
 */

public class BuscarState implements I_ScreenState {

    //Texto que introducimos en el buscador
    private  String text;

    public BuscarState() {
        setText("");
    }

    public BuscarState(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
