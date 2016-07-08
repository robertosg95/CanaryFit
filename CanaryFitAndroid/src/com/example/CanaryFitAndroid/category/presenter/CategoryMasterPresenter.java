package com.example.CanaryFitAndroid.category.presenter;


import com.example.CanaryFitAndroid.master.presenter.MasterPresenter;
import com.example.CanaryFitAndroid.master.state.MasterState;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;

public class CategoryMasterPresenter extends MasterPresenter {

    /**
     * Método para guardar el estado de la pantalla category, para después poder pasar a product el dato que necesitamos
     * para cargar los productos correspondientes. En este caso le estamos pasando la referencia de la categoria.
     * @return el estado de la pantalla category, tras haber cargado la referencia
     */
    @Override
    public I_ScreenState getScreenState() {
        debug("getScreenState");

        MasterState state = new MasterState(getMasterModel().getPosition());
        state.setDataRef(getMasterModel().getDataRef());
        return state;
    }



}
