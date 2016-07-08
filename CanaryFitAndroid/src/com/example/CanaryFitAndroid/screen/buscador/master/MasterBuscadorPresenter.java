package com.example.CanaryFitAndroid.screen.buscador.master;

import com.example.CanaryFitAndroid.detail.state.DetailState;
import com.example.CanaryFitAndroid.master.presenter.MasterPresenter;
import com.example.CanaryFitAndroid.mediator.CanaryFitMediatorCode;
import com.example.CanaryFitAndroid.screen.buscador.state.BuscarState;
import com.example.CanaryFitAndroid.screen.landscape.buscador.LandscapeBuscadorView;
import com.example.CanaryFitAndroid.screen.portrait.buscador.PortraitBuscadorView;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;

public class MasterBuscadorPresenter extends MasterPresenter{

    private I_MasterBuscadorModel getMasterBuscadorModel(){ return (I_MasterBuscadorModel) getScreenModel();}

    /**
     * Carga el estado de la pantalla. En este caso se debe recuperar el valor del texto almacenado en BuscarState
     * @param view vista desde la que se viene
     * @param code código que indica la siguiente transcición
     * @param state objeto de la clase estado adecuada en cada caso
     */
    @Override
    public void setScreenState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);

        if(state != null) {

            if(view.equals(PortraitBuscadorView.class)
                    && code == CanaryFitMediatorCode.BUSCADOR_MASTER_PORTRAIT) {
                BuscarState _state = (BuscarState) state;
                getMasterBuscadorModel().setTexto(_state.getText());

            }

            if(view.equals(LandscapeBuscadorView.class)
                    && code == CanaryFitMediatorCode.BUSCADOR_MASTER_LANDSCAPE) {
                BuscarState _state = (BuscarState) state;
                getMasterBuscadorModel().setTexto(_state.getText());

            }
        }

    }

    @Override
    public I_ScreenState getScreenState() {
        debug("getScreenState");

        DetailState state = new DetailState(getDetailModel().getData());
        return state;
    }




}
