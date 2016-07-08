package com.example.CanaryFitAndroid.screen.buscador.master;


import com.example.CanaryFitAndroid.database.DatabaseClauseArg;
import com.example.CanaryFitAndroid.detail.data.DetailData;
import com.example.CanaryFitAndroid.master.model.MasterModel;

import java.util.List;

public class MasterBuscadorModel extends MasterModel implements I_MasterBuscadorModel{



    private String texto;

    /**
     * Obtenemos la lista con los elementos que tengan un determinado nombre.
     * Con el estado que le pasamos de la pantalla anterior podemos obtener el texto introducido y compararlo con el nombre de
     * cada una de las competiciones que tengamos en la base de datos.
     * @return la lista de datos que coincida el nombre de la competición con el texto introducido
     */
    @Override
    public List<DetailData> getCollection(){

        DatabaseClauseArg arg = new DatabaseClauseArg(
                "nombre", "==", getTexto());
        return getDetailDatabase().getDetailDataListBy(new DatabaseClauseArg[]{arg});

    }

    @Override
    public String getTexto(){
        return texto;
    }

    @Override
    public void setTexto(String texto){
        this.texto = texto;

    }

    @Override
    public DetailData getData() {
        return getCollection().get(getPosition());
    }


//    Métodos redundantes no necesarios
//    private void fillCollection() {
//        debug("fillCollection");
//
//        if (getDatabase().getMasterDataList().size() == 0) {
//             mapperJsonToJava(loadJsonFromAsset("carrerasDB.json"));
//        }
//    }
//
//    private void mapperJsonToJava(String jsonStringCarreras) {
//        try {
//            JSONArray jsonArray = new JSONArray(jsonStringCarreras);
//            for (int i = 0; i < jsonArray.length(); i++){
//                JSONObject jsonObjectMaster = jsonArray.getJSONObject(i);
//                DetailData _data = getJavaObjectProduct(jsonObjectMaster);
//                getDetailDatabase().saveDetailData(_data);
//
//            }
//
//        } catch (JSONException e) {
//
//        }
//
//    }


}
