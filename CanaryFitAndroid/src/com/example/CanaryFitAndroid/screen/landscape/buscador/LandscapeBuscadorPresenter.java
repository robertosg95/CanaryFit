package com.example.CanaryFitAndroid.screen.landscape.buscador;


import com.example.CanaryFitAndroid.mediator.CanaryFitMediatorCode;
import com.example.CanaryFitAndroid.screen.buscador.presenter.BuscadorPresenter;

public class LandscapeBuscadorPresenter extends BuscadorPresenter {

    private String text;

    @Override
    public void rotateScreen() {
        debug("rotateScreen");

        changeRotation(CanaryFitMediatorCode.BUSCADOR_PORTRAIT);
    }

    @Override
    public void buttonClickedBuscar() {
        setBtnClickedBuscar(true);
        debug("buttonClickedBuscador", "clicked", getBtnClickedBuscar());

        startNextScreenWithFinish(CanaryFitMediatorCode.BUSCADOR_MASTER_LANDSCAPE, false);

    }


}
