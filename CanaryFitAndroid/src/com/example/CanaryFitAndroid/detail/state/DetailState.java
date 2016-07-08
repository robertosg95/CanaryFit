package com.example.CanaryFitAndroid.detail.state;

import com.example.CanaryFitAndroid.detail.data.DetailData;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;

/**
 * Contiene los elementos que nos interesa guardar para pasárselo a otras pantallas
 */

public class DetailState implements I_ScreenState {

    //Utilizada para guardar objetos de la clase DetailData
    private DetailData _data;

    public DetailState() {
        setData(new DetailData());
    }

    public DetailState(DetailData data) {
        _data = data;
    }

    public DetailData getData() {
        return _data;
    }

    public void setData(DetailData data) {
        _data = data;
    }

}
