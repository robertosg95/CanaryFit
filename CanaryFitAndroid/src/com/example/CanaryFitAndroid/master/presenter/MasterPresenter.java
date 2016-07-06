package com.example.CanaryFitAndroid.master.presenter;

import com.example.CanaryFitAndroid.category.view.CategoryMasterView;
import com.example.CanaryFitAndroid.detail.data.DetailData;
import com.example.CanaryFitAndroid.detail.model.I_DetailModel;
import com.example.CanaryFitAndroid.detail.state.DetailState;
import com.example.CanaryFitAndroid.detail.view.DetailView;
import com.example.CanaryFitAndroid.master.data.MasterData;
import com.example.CanaryFitAndroid.master.model.I_MasterModel;
import com.example.CanaryFitAndroid.master.state.MasterState;
import com.example.CanaryFitAndroid.master.view.I_MasterView;
import com.example.CanaryFitAndroid.mediator.CanaryFitMediatorCode;
import com.example.CanaryFitAndroid.product.view.ProductMasterView;
import com.example.CanaryFitAndroid.screen.buscador.master.MasterBuscadorView;
import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenObserver;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;


public abstract class MasterPresenter extends AndroidScreenPresenter
        implements I_MasterPresenter, I_ScreenObserver {


    public I_MasterModel getMasterModel() {
        return (I_MasterModel) getScreenModel();
    }

    protected I_MasterView getMasterView(){
        return (I_MasterView) getScreenView();
    }

    public I_DetailModel getDetailModel(){
        return (I_DetailModel) getScreenModel();
    }

//    public I_MasterBuscadorModel getMasterBuscadorModel() {
//        return (I_MasterBuscadorModel) getScreenModel();
//    }





    @Override
    public void setListPosition(int position) {

        getMasterModel().setPosition(position);
        startNextScreenWithFinish(CanaryFitMediatorCode.SELECT, false);

        debug("setListPosition", "position", position);
        debug("setListPosition", "data", getMasterModel().getData());
    }

    @Override
    public void createScreen() {
        debug("createScreen");

        getMasterView().setMasterScreen();
    }

    @Override
    public void backScreen() {
        debug("backScreen");
    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen");

        getMasterView().setMasterCollection(getMasterModel().getCollection());
        getMasterView().setListPosition(getMasterModel().getPosition());
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
    public void setScreenState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);

        if(state != null) {


//            if(view.equals(BuscadorView.class)
//                    && code == CanaryFitMediatorCode.BUSCADOR_MASTER_PORTRAIT) {
//
//                BuscarState _state = (BuscarState) state;
//                String texto = _state.getText();
//                debug("setScreenState", "texto", texto);
//
//
//            }

            if(view.equals(CategoryMasterView.class)
                    && code == CanaryFitMediatorCode.NULL) {

                MasterState _state = (MasterState) state;
                getMasterModel().setPosition(_state.getPosition());
            }

            if( view.equals(CategoryMasterView.class)
                    && code == CanaryFitMediatorCode.SELECT) {

                MasterState _state = (MasterState) state;
                getMasterModel().setDataRef(_state.getDataRef());

                debug("setScreenState", "ref", _state.getDataRef());

            }

            if(view.equals(MasterBuscadorView.class)
                    && code == CanaryFitMediatorCode.SELECT) {

                DetailState _state = (DetailState) state;
                getDetailModel().setData(_state.getData());
            }

        }
    }

    @Override
    public I_ScreenState getScreenState() {
        debug("getScreenState");

        MasterState state = new MasterState(getMasterModel().getPosition());
        state.setDataRef(getMasterModel().getDataRef());
        return state;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);

        if(view.equals(DetailView.class)
                && code == CanaryFitMediatorCode.SELECT) {

            DetailData data = (DetailData) getMasterModel().getData();
            DetailState state = new DetailState(data);
            return state;
        }

        if(view.equals(ProductMasterView.class)
                && code == CanaryFitMediatorCode.SELECT) {

            MasterData data = (MasterData) getMasterModel().getData();

            debug("getNextState", "data", data);

            MasterState state = new MasterState(data);
            return state;
        }
        if(view.equals(DetailView.class)
                && code == CanaryFitMediatorCode.SELECT) {

            DetailState state = new DetailState((DetailData) getMasterModel().getData());
            return state;
        }



        return null;
    }


    @Override
    public I_ScreenState updateObserverState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("updateObserverState", "view", view.getSimpleName());
        debug("updateObserverState", "code", code);


        if(view.equals(DetailView.class)
                && code == CanaryFitMediatorCode.DELETE) {

            debug("updateObserverState", "position", getMasterModel().getPosition());


            resumeScreen();

            return new DetailState();
        }


        if(view.equals(DetailView.class)
                && code == CanaryFitMediatorCode.BACK) {

            return null;
        }

        return null;

    }



}
