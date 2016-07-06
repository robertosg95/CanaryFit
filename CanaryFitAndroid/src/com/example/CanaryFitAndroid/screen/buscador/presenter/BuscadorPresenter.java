package com.example.CanaryFitAndroid.screen.buscador.presenter;


import com.example.CanaryFitAndroid.master.presenter.MasterPresenter;
import com.example.CanaryFitAndroid.screen.buscador.view.I_BuscadorView;
import com.example.CanaryFitAndroid.state.BuscarState;
import es.ulpgc.eite.framework.core.screen.I_ScreenObserver;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;


public abstract class BuscadorPresenter extends MasterPresenter implements I_BuscadorPresenter, I_ScreenObserver {

    private Boolean _btnClickedBuscar;

    private String _texto;

    public Boolean getBtnClickedBuscar() {
        return _btnClickedBuscar;
    }

    public void setBtnClickedBuscar(Boolean _btnClickedBuscar) {
        this._btnClickedBuscar = _btnClickedBuscar;
    }



    private I_BuscadorView getBuscadorView() {
        return (I_BuscadorView) getScreenView();
    }

    @Override
    public void createScreen() {
        debug("createScreen");

        getBuscadorView().setLayout();
        getBuscadorView().setListener();
    }

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
        BuscarState state = new BuscarState();
        state.setText(getBuscadorView().getTextBuscar());
        return state;
    }

    @Override
    public I_ScreenState updateObserverState(Class<? extends I_ScreenView> aClass, int i, I_ScreenState i_screenState) {
        return null;
    }

    public void changeRotation(int code){
        debug("changeRotation", "code", code);

        startNextScreenWithFinish(code, true);
    }

}
