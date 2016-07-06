package com.example.CanaryFitAndroid.screen.portrait.principal;


import com.example.CanaryFitAndroid.mediator.CanaryFitMediatorCode;
import com.example.CanaryFitAndroid.screen.principal.presenter.PrincipalPresenter;

public class PortraitPrincipalPresenter extends PrincipalPresenter {

    @Override
    public void rotateScreen() {
        debug("rotateScreen");

        changeRotation(CanaryFitMediatorCode.PRINCIPAL_LANDSCAPE);
    }

    @Override
    public void imageButtonClickedBuscador() {
        setBtnClickedBuscador(true);
        debug("buttonClickedBuscador", "clicked", getBtnClickedBuscador());
        startNextScreenWithObserver(this, CanaryFitMediatorCode.PRINCIPAL_BUSCADOR_PORTRAIT);
    }

    @Override
    public void imageButtonClickedProximasCarreras() {
        setBtnClickedProximasCarreras(true);
        debug("buttonClickedProximasCarreras", "clicked", getBtnClickedProximasCarreras());
        startNextScreenWithObserver(this, CanaryFitMediatorCode.PRINCIPAL_PROXIMAS_PORTRAIT);
    }

   /* @Override
    public void imageButtonClickedResultados() {

        setBtnClickedResultados(true);
        debug("buttonClickedResultados", "clicked", getBtnClickedResultados());
        startNextScreenWithObserver(this, CanaryFitMediatorCode.PRINCIPAL_PROXIMAS_PORTRAIT);

    }*/
}
