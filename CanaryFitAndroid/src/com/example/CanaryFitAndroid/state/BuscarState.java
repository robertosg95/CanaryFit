package com.example.CanaryFitAndroid.state;

import es.ulpgc.eite.framework.core.screen.I_ScreenState;

public class BuscarState implements I_ScreenState {

    private  String text;

    public BuscarState() {
        text = null;
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
