package com.example.CanaryFitAndroid.master.model;


import com.example.CanaryFitAndroid.database.I_Data;
import com.example.CanaryFitAndroid.master.data.MasterData;

import java.util.List;

public interface I_MasterModel {

    void setDataRef(MasterData data);
    MasterData getDataRef();

    int getPosition();
    void setPosition(int pos);
    List<? extends I_Data> getCollection();
    I_Data getData();

}
