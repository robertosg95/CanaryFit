package com.example.CanaryFitAndroid.category.presenter;


import com.example.CanaryFitAndroid.master.presenter.MasterPresenter;
import com.example.CanaryFitAndroid.master.state.MasterState;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;

public class CategoryMasterPresenter extends MasterPresenter {

    @Override
    public I_ScreenState getScreenState() {
        debug("getScreenState");

        MasterState state = new MasterState(getMasterModel().getPosition());
        state.setDataRef(getMasterModel().getDataRef());
        return state;
    }



}
