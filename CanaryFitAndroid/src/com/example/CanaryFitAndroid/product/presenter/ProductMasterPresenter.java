package com.example.CanaryFitAndroid.product.presenter;


import com.example.CanaryFitAndroid.master.presenter.MasterPresenter;
import com.example.CanaryFitAndroid.mediator.CanaryFitMediatorCode;

public class ProductMasterPresenter extends MasterPresenter {

    @Override
    public void setListPosition(int position) {
        super.setListPosition(position);

        startNextScreenWithObserver(this, CanaryFitMediatorCode.SELECT);
    }
}
