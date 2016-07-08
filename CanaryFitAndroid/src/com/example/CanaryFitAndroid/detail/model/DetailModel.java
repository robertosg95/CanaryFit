package com.example.CanaryFitAndroid.detail.model;

import com.example.CanaryFitAndroid.detail.data.DetailData;
import es.ulpgc.eite.framework.android.AndroidScreenModel;

/**
 * Clase utilizada para obtener y actualizar el dato que se muestra en la pantalla detail.
 */
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


}
