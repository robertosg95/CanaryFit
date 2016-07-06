package com.example.CanaryFitAndroid.detail.state;

import com.example.CanaryFitAndroid.detail.data.DetailData;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;


public class DetailState implements I_ScreenState {

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
