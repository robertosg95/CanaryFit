package com.example.CanaryFitAndroid.master.state;

import com.example.CanaryFitAndroid.master.data.MasterData;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;


public class MasterState implements I_ScreenState {

    private int position;
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
