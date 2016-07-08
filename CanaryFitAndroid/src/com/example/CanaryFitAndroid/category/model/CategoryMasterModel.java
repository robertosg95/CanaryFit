package com.example.CanaryFitAndroid.category.model;


import com.example.CanaryFitAndroid.database.I_Data;
import com.example.CanaryFitAndroid.master.model.MasterModel;

import java.util.List;

public class CategoryMasterModel extends MasterModel {

    @Override
    public List<? extends I_Data> getCollection(){
       /*
       NUNCA se va a cumplir esta condición porque la base de datos se carga desde el principio
       if(getMasterDatabase().getMasterDataList().size() == 0){
            fillCollection();
        }
        */
        return getMasterDatabase().getMasterDataList();
    }

//    private void fillCollection() {
//        debug("fillCollection");
//
//        if (getDatabase().getMasterDataList().size() == 0) {
//            mapperJsonToJava(loadJsonFromAsset("modalidadDB.json"), loadJsonFromAsset("carrerasDB.json"));
//           // mapperJsonToJava(loadJsonFromAsset("carrerasDB.json"));
//        }
//    }
//
//
//    private void mapperJsonToJava(String jsonStringModalidad, String jsonStringCarreras) {
//        try {
//            JSONArray jsonArray = new JSONArray(jsonStringModalidad);
//            JSONArray jsonArray2 = new JSONArray(jsonStringCarreras);
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObjectMasterCategory = jsonArray.getJSONObject(i);
//                MasterData data = getJavaObjectCategory(jsonObjectMasterCategory);
//                Long ref = getMasterDatabase().saveMasterData(data);
//                for (int j = 0; j < jsonArray2.length(); j++) {
//                    JSONObject jsonObjectMasterProduct = jsonArray2.getJSONObject(j);
//                    DetailData _data = getJavaObjectProduct(jsonObjectMasterProduct);
//                    if (_data.getModalidad().equals(data.getLabel())) {
//                        _data.setRef(ref);
//
//                    }
//                    getDetailDatabase().saveDetailData(_data);
//                }
//
//            }
//
//        } catch (JSONException e) {
//
//        }
//    }

    @Override
    public I_Data getData() {
        return getCollection().get(getPosition());
    }



}
