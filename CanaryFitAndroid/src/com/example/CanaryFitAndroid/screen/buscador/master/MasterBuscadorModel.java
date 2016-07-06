package com.example.CanaryFitAndroid.screen.buscador.master;


import com.example.CanaryFitAndroid.database.DatabaseClauseArg;
import com.example.CanaryFitAndroid.detail.data.DetailData;
import com.example.CanaryFitAndroid.master.model.MasterModel;

import java.util.List;

public class MasterBuscadorModel extends MasterModel implements I_MasterBuscadorModel{

    private I_MasterBuscadorPresenter getMasterBuscadorPresenter(){ return (I_MasterBuscadorPresenter) getScreenPresenter(); }

    private String texto;


    @Override
    public List<DetailData> getCollection(){

                // ???
        /*
        DetailData data = new DetailData();
        DatabaseClauseArg arg = new DatabaseClauseArg(
                "nombre", "==", data.getTextoBuscar());
                */

//        getMasterBuscadorPresenter().setScreenState();
        DatabaseClauseArg arg = new DatabaseClauseArg(
                "nombre", "==", getTexto());
        return getDetailDatabase().getDetailDataListBy(new DatabaseClauseArg[]{arg});

//        DatabaseClauseArg arg = new DatabaseClauseArg(
//                "ref", "==", getDataRef().getId().toString());
//
//        return getDetailDatabase().getDetailDataListBy(
//                new DatabaseClauseArg[]{arg});



    }

    @Override
    public String getTexto(){
        return texto;
    }

    @Override
    public void setTexto(String texto){
        this.texto = texto;

    }

    /*private void fillCollection() {
        debug("fillCollection");

        if (getDatabase().getMasterDataList().size() == 0) {
             mapperJsonToJava(loadJsonFromAsset("carrerasDB.json"));
        }
    }

    private void mapperJsonToJava(String jsonStringCarreras) {
        try {
            JSONArray jsonArray = new JSONArray(jsonStringCarreras);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObjectMaster = jsonArray.getJSONObject(i);
                DetailData _data = getJavaObjectProduct(jsonObjectMaster);
                getDetailDatabase().saveDetailData(_data);

            }

        } catch (JSONException e) {

        }

    }*/

    @Override
    public DetailData getData() {
        return getCollection().get(getPosition());
    }




}
