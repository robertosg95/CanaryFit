package com.example.CanaryFitAndroid.screen.principal.model;
import com.example.CanaryFitAndroid.database.I_Data;
import com.example.CanaryFitAndroid.detail.data.DetailData;
import com.example.CanaryFitAndroid.master.data.MasterData;
import com.example.CanaryFitAndroid.master.model.MasterModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Clase inicial de nuestra aplicación. En principio no necesita ningún tipo de dato, pero como vamos a trabajar con varios
 * maestros-detalles es mejor cargar desde que arranca la aplicación la base de datos para así evitarnos problemas
 * más adelante.
 */

public class PrincipalModel extends MasterModel implements I_PrincipalModel {

    @Override
    public I_Data getData() {
        return null;
    }

    /**
     * Método que comprueba si la base de datos está vacía, y si es así, la llena.
     */
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

    /**
     * Método para rellenar la base de datos mapeando el json a java
     */
    private void fillCollection() {
        debug("fillCollection");

            mapperJsonToJava(loadJsonFromAsset("modalidadDB.json"), loadJsonFromAsset("carrerasDB.json"));


    }


    /**
     * Método para mapear el json a java
     * @param jsonStringModalidad modalidadDB.json
     * @param jsonStringCarreras carrerasDB.json
     */
    private void mapperJsonToJava(String jsonStringModalidad, String jsonStringCarreras) {
        try {
            JSONArray jsonArray = new JSONArray(jsonStringModalidad);
            JSONArray jsonArray2 = new JSONArray(jsonStringCarreras);
            //Recorremos todas las modalidades que hay
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectMasterCategory = jsonArray.getJSONObject(i);
                //Guardamos en MasterData cada modalidad
                MasterData data = getJavaObjectCategory(jsonObjectMasterCategory);
                //Asignamos una referencia a cada modalidad
                Long ref = getMasterDatabase().saveMasterData(data);
                //Recorremos todos los elementos de carrerasDB
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonObjectMasterProduct = jsonArray2.getJSONObject(j);
                    //Guardamos en DetailData cada carrera
                    DetailData _data = getJavaObjectProduct(jsonObjectMasterProduct);
                    //Si la modalidad de la carrera es igual a alguna modalidad de modalidadDB, le asignamos una referencia
                    //que será igual para todas las carreras de una misma modalidad
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
