package com.example.CanaryFitAndroid.screen.portrait.buscador;


import com.example.CanaryFitAndroid.mediator.CanaryFitMediatorCode;
import com.example.CanaryFitAndroid.screen.buscador.presenter.BuscadorPresenter;

public class PortraitBuscadorPresenter extends BuscadorPresenter {

    private String text;

    @Override
    public void rotateScreen() {
        debug("rotateScreen");

        changeRotation(CanaryFitMediatorCode.BUSCADOR_LANDSCAPE);
    }


    @Override
    public void buttonClickedBuscar() {
        setBtnClickedBuscar(true);
        debug("buttonClickedBuscador", "clicked", getBtnClickedBuscar());
        startNextScreenWithFinish(CanaryFitMediatorCode.BUSCADOR_MASTER_PORTRAIT, false);
    }


}
