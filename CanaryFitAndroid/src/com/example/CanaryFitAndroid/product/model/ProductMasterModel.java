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



    @Override
    public List<? extends I_Data> getCollection(){

        DatabaseClauseArg arg = new DatabaseClauseArg(
                "ref", "==", getDataRef().getId().toString());

        return getDetailDatabase().getDetailDataListBy(
                new DatabaseClauseArg[]{arg});
    }

}
