package com.example.CanaryFitAndroid.detail.presenter;

import com.example.CanaryFitAndroid.detail.data.DetailData;
import com.example.CanaryFitAndroid.detail.model.I_DetailModel;
import com.example.CanaryFitAndroid.detail.state.DetailState;
import com.example.CanaryFitAndroid.detail.view.I_DetailView;
import com.example.CanaryFitAndroid.mediator.CanaryFitMediatorCode;
import com.example.CanaryFitAndroid.product.view.ProductMasterView;
import com.example.CanaryFitAndroid.screen.buscador.master.MasterBuscadorView;
import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenObservable;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;



public class DetailPresenter
        extends AndroidScreenPresenter implements I_DetailPresenter, I_ScreenObservable {


    private I_DetailModel getDetailModel(){
        return (I_DetailModel) getScreenModel();
    }

    private I_DetailView getDetailView(){
        return (I_DetailView) getScreenView();
    }


    @Override
    public void deleteData() {
        debug("deleteData");

        //DetailState state = new DetailState(getDetailModel().getData());
        //notifyScreenObservers(this, CanaryFitMediatorCode.DELETE, state);
        notifyScreenObservers(this, CanaryFitMediatorCode.DELETE, null);
        //finishScreen();
    }



    @Override
    public void createScreen() {
        debug("createScreen");

        getDetailView().setDetailLayout();
//        getDetailView().setDetailBtnListener();
        getDetailModel().setData(new DetailData());
    }

    @Override
    public void backScreen() {
        debug("backScreen");

        notifyScreenObservers(this, CanaryFitMediatorCode.BACK, null);
    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen");

        getDetailView().setDetailData(getDetailModel().getData());
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

        if(state != null){

            if(view.equals(ProductMasterView.class)
                    && code == CanaryFitMediatorCode.SELECT) {

                DetailState _state = (DetailState) state;
                getDetailModel().setData(_state.getData());
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

        DetailState state = new DetailState(getDetailModel().getData());
        return state;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);

        return null;
    }


    @Override
    public void updateObservableState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("updateObservableState", "view", view.getSimpleName());
        debug("updateObservableState", "code", code);


        if(view.equals(ProductMasterView.class)
                && code == CanaryFitMediatorCode.DELETE) {

            finishScreen();
        }

        if(view.equals(MasterBuscadorView.class)
                && code == CanaryFitMediatorCode.DELETE) {

            finishScreen();
        }
    }





}
