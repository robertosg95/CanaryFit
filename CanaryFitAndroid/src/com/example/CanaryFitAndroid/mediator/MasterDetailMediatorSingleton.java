package com.example.CanaryFitAndroid.mediator;

import es.ulpgc.eite.framework.android.AndroidMediatorSingleton;

public class MasterDetailMediatorSingleton extends AndroidMediatorSingleton {

    @Override
    public void createMediator() {
        setCustomConfig(new MasterDetailMediatorConfig(this));
    }
}
