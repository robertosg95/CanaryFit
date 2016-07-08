package com.example.CanaryFitAndroid.product.presenter;


import com.example.CanaryFitAndroid.master.presenter.MasterPresenter;
import com.example.CanaryFitAndroid.mediator.CanaryFitMediatorCode;

public class ProductMasterPresenter extends MasterPresenter {

    /**
     * Al seleccionar un elemento de la lista arrancaremos una pantalla nueva, en este caso el detalle.
     * @param position del elemnto seleccionado
     */
    @Override
    public void setListPosition(int position) {
        super.setListPosition(position);

        startNextScreenWithObserver(this, CanaryFitMediatorCode.SELECT);
    }
}
