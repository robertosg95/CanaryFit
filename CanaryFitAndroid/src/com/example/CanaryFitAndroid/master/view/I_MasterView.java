package com.example.CanaryFitAndroid.master.view;


import com.example.CanaryFitAndroid.database.I_Data;

import java.util.List;

public interface I_MasterView {

    void setMasterCollection(List<? extends I_Data> collection);
    void setListPosition(int position);
    void setMasterScreen();
}
