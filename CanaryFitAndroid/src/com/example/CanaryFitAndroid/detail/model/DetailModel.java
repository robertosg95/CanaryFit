package com.example.CanaryFitAndroid.detail.model;

import com.example.CanaryFitAndroid.detail.data.DetailData;
import com.example.CanaryFitAndroid.detail.presenter.I_DetailPresenter;
import es.ulpgc.eite.framework.android.AndroidScreenModel;


public class DetailModel extends AndroidScreenModel implements I_DetailModel{

    private DetailData _data;

    @Override
    public DetailData getData() {
        return _data;
    }

    @Override
    public void setData(DetailData data) {
        _data = data;
    }

    private I_DetailPresenter getDetailPresenter(){
        return (I_DetailPresenter) getScreenPresenter();
    }
}
