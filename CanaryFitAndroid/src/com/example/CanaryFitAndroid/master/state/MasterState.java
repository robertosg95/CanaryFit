package com.example.CanaryFitAndroid.master.state;

import com.example.CanaryFitAndroid.master.data.MasterData;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;

/**
 * Contiene los elementos que nos interesa guardar para pasárselo a otras pantallas
 */

public class MasterState implements I_ScreenState {

    //Utilizada para guardar la posición de un elemento en la lista
    private int position;
    //Utilizada para guardar la la referencia de un elemento y así saber que productos pertenecen a él
    private MasterData dataRef;

    public MasterState() {
        setPosition(0);
        setDataRef(null);
    }

    public MasterState(int pos) {
        setPosition(pos);
        setDataRef(null);
    }

    public MasterState(MasterData data) {
        setDataRef(data);
        setPosition(0);
    }

    public MasterData getDataRef() {
        return dataRef;
    }

    public void setDataRef(MasterData data) {
        dataRef = data;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int pos) {
        position = pos;
    }
}