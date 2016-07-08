package com.example.CanaryFitAndroid.product.model;
import com.example.CanaryFitAndroid.database.DatabaseClauseArg;
import com.example.CanaryFitAndroid.database.I_Data;
import com.example.CanaryFitAndroid.master.model.MasterModel;

import java.util.List;

public class ProductMasterModel extends MasterModel {

    @Override
    public I_Data getData() {
        return getCollection().get(getPosition());
    }

    /**
     * Obtenemos la lista con los elementos que tengan una determinada referencia.
     * Cada modalidad tiene asiganada una referencia única, y dentro de cada modalidad tendremos varios elementos con esa
     * referencia. Aquí estamos cargando todos los elementos que tengan una misma referencia.
     * @return la lista de datos correspondientes que debemos cargar
     */
    @Override
    public List<? extends I_Data> getCollection(){

        DatabaseClauseArg arg = new DatabaseClauseArg(
                "ref", "==", getDataRef().getId().toString());

        return getDetailDatabase().getDetailDataListBy(
                new DatabaseClauseArg[]{arg});
    }

}
