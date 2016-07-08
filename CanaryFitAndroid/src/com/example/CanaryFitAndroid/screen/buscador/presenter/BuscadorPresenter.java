package com.example.CanaryFitAndroid.screen.buscador.presenter;


import com.example.CanaryFitAndroid.screen.buscador.state.BuscarState;
import com.example.CanaryFitAndroid.screen.buscador.view.I_BuscadorView;
import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenObserver;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;


public abstract class BuscadorPresenter extends AndroidScreenPresenter implements I_BuscadorPresenter, I_ScreenObserver {

    private Boolean _btnClickedBuscar;

    public Boolean getBtnClickedBuscar() {
        return _btnClickedBuscar;
    }

    public void setBtnClickedBuscar(Boolean _btnClickedBuscar) {
        this._btnClickedBuscar = _btnClickedBuscar;
    }



    public I_BuscadorView getBuscadorView() {
        return (I_BuscadorView) getScreenView();
    }

    @Override
    public void createScreen() {
        debug("createScreen");

        getBuscadorView().setLayout();
        getBuscadorView().setListener();
    }

    /**
     * Método que actualiza el estado. En este caso necesitamos recuperar el valor almacenado en BuscarState del texto introducido.
     * Es necesario para pasar de portrait/landscape
     * @param view no necesario
     * @param code no necesario
     * @param state objeto de BuscarState
     */
    @Override
    public void setScreenState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        if(state!=null){

            BuscarState _state = (BuscarState) state;
            getBuscadorView().setTextBuscar(_state.getText());

        }

    }


    /**
     * Método que pasa información a la siguiente pantalla. En este caso necesitamos recuperar el valor almacenado en BuscarState
     * del texto introducido.
     * @param view no necesario
     * @param code no necesario
     * @return
     */
    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        BuscarState state = new BuscarState();
        state.setText(getBuscadorView().getTextBuscar());
        return state;
    }


    public void changeRotation(int code){
        debug("changeRotation", "code", code);

        startNextScreenWithFinish(code, true);
    }

    //Métodos que no se usan pero que el framework nos obliga a implementar:

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
    public I_ScreenState getScreenState() {
        return null;
    }

    @Override
    public I_ScreenState updateObserverState(Class<? extends I_ScreenView> aClass, int i, I_ScreenState i_screenState) {
        return null;
    }


}
