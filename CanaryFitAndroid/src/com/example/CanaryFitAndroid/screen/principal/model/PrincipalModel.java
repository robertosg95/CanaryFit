package com.example.CanaryFitAndroid.screen.principal.model;


import com.example.CanaryFitAndroid.database.I_Data;
import com.example.CanaryFitAndroid.detail.data.DetailData;
import com.example.CanaryFitAndroid.master.data.MasterData;
import com.example.CanaryFitAndroid.master.model.MasterModel;
import com.example.CanaryFitAndroid.screen.principal.presenter.I_PrincipalPresenter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class PrincipalModel extends MasterModel implements I_PrincipalModel {

    private I_PrincipalPresenter getPrincipalPresenter(){
        return (I_PrincipalPresenter) getScreenPresenter();
    }



    @Override
    public I_Data getData() {
        return null;
    }

    @Override
    public void checkCollection(){
        if(getMasterDatabase().getMasterDataList().size() == 0){
            fillCollection();
        }
    }





    @Override
    public List<? extends I_Data> getCollection(){
        return null;
    }

    private void fillCollection() {
        debug("fillCollection");

        if (getDatabase().getMasterDataList().size() == 0) {
            mapperJsonToJava(loadJsonFromAsset("modalidadDB.json"), loadJsonFromAsset("carrerasDB.json"));

        }
    }


    private void mapperJsonToJava(String jsonStringModalidad, String jsonStringCarreras) {
        try {
            JSONArray jsonArray = new JSONArray(jsonStringModalidad);
            JSONArray jsonArray2 = new JSONArray(jsonStringCarreras);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectMasterCategory = jsonArray.getJSONObject(i);
                MasterData data = getJavaObjectCategory(jsonObjectMasterCategory);
                Long ref = getMasterDatabase().saveMasterData(data);
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonObjectMasterProduct = jsonArray2.getJSONObject(j);
                    DetailData _data = getJavaObjectProduct(jsonObjectMasterProduct);
                    if (_data.getModalidad().equals(data.getLabel())) {
                        _data.setRef(ref);

                    }
                    getDetailDatabase().saveDetailData(_data);
                }

            }

        } catch (JSONException e) {

        }
    }






}
