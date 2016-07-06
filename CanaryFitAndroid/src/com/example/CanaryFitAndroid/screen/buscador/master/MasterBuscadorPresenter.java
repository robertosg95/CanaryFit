package com.example.CanaryFitAndroid.screen.buscador.master;

import com.example.CanaryFitAndroid.detail.state.DetailState;
import com.example.CanaryFitAndroid.master.presenter.MasterPresenter;
import com.example.CanaryFitAndroid.state.BuscarState;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;

public class MasterBuscadorPresenter extends MasterPresenter implements I_MasterBuscadorPresenter{

    private I_MasterBuscadorView getMasterBuscadorView(){ return (I_MasterBuscadorView) getScreenView(); }

    private I_MasterBuscadorModel getMasterBuscadorModel(){ return (I_MasterBuscadorModel) getScreenModel();}

//    @Override
//    public String recuperarTextoVista(){
//        return getMasterBuscadorView().recuperarTexto();
//    }
//

    @Override
    public void setScreenState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);

        if(state != null) {

//            if(view.equals(MasterBuscadorView.class)
//                    && code == CanaryFitMediatorCode.BUSCADOR_MASTER_PORTRAIT) {

                BuscarState _state = (BuscarState) state;
                getMasterBuscadorModel().setTexto(_state.getText());
//                getMasterBuscadorModel().setTexto(_state.getText());
               // getDetailModel().setData(_state.getData());
//            }

//            if(view.equals(MasterBuscadorView.class)
//                    && code == CanaryFitMediatorCode.BUSCADOR_MASTER_LANDSCAPE) {
//
//                BuscarState _state = (BuscarState) state;
//                getMasterBuscadorModel().setTexto(_state.getText());
//            }



        }

    }

    @Override
    public I_ScreenState getScreenState() {
        debug("getScreenState");

        DetailState state = new DetailState(getDetailModel().getData());
        return state;
    }

   /* @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);




        return null;
    }*/


    /*@Override
    public I_ScreenState updateObserverState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("updateObserverState", "view", view.getSimpleName());
        debug("updateObserverState", "code", code);


        if(view.equals(MasterBuscadorView.class)
                && code == CanaryFitMediatorCode.DELETE) {

            finishScreen();
        }

        return null;

    }*/



}
