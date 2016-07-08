package com.example.CanaryFitAndroid.screen.principal.presenter;


import com.example.CanaryFitAndroid.screen.principal.model.I_PrincipalModel;
import com.example.CanaryFitAndroid.screen.principal.view.I_PrincipalView;
import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenObserver;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;


public abstract class PrincipalPresenter extends AndroidScreenPresenter implements I_PrincipalPresenter, I_ScreenObserver {

    private Boolean _btnClickedBuscador;

    private Boolean _btnClickedProximasCarreras;


    public Boolean getBtnClickedBuscador() {
        return _btnClickedBuscador;
    }

    public Boolean getBtnClickedProximasCarreras() {
        return _btnClickedProximasCarreras;
    }

    public void setBtnClickedBuscador(Boolean btnClicked) {
        _btnClickedBuscador = btnClicked;
    }

    public void setBtnClickedProximasCarreras(Boolean btnClicked) {
        _btnClickedProximasCarreras = btnClicked;
    }

    private I_PrincipalView getPrincipalView() {
        return (I_PrincipalView) getScreenView();
    }

    private I_PrincipalModel getPrincipalModel(){
        return (I_PrincipalModel) getScreenModel();
    }


    @Override
    public void createScreen() {
        debug("createScreen");
        getPrincipalModel().checkCollection();
        getPrincipalView().setLayout();
        getPrincipalView().setListener();
    }

    public void changeRotation(int code){
        debug("changeRotation", "code", code);

        startNextScreenWithFinish(code, true);
    }

    //Métodos no necesarios, pero que el framework nos obliga a implementar:


    @Override
    public void backScreen() {
        debug("backScreen");

    }

    @Override
    public void resumeScreen() {

    }

    @Override
    public void pauseScreen() {
        debug("pauseScreen");
    }

    @Override
    public void rotateScreen() {
        debug("rotateScreen");
    }

    @Override
    public void setScreenState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

    }

    @Override
    public I_ScreenState getScreenState() {
        return null;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        return null;
    }

    @Override
    public I_ScreenState updateObserverState(Class<? extends I_ScreenView> aClass, int i, I_ScreenState i_screenState) {
        return null;
    }





}
