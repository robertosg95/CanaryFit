package com.example.CanaryFitAndroid.screen.buscador.master;

import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;

public interface I_MasterBuscadorPresenter {
//    String recuperarTextoVista();

    public void setScreenState(Class<? extends I_ScreenView> view, int code, I_ScreenState state);

}
