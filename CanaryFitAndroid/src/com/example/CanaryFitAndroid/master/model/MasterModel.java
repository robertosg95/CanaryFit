package com.example.CanaryFitAndroid.master.model;

import android.app.Application;
import com.example.CanaryFitAndroid.database.I_DetailDatabase;
import com.example.CanaryFitAndroid.database.I_MasterDatabase;
import com.example.CanaryFitAndroid.detail.data.DetailData;
import com.example.CanaryFitAndroid.master.data.MasterData;
import com.example.CanaryFitAndroid.master.presenter.I_MasterPresenter;
import es.ulpgc.eite.framework.android.AndroidScreenModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public abstract class MasterModel
        extends AndroidScreenModel implements I_MasterModel{

    private int position;
    private MasterData dataRef;


    protected I_MasterPresenter getMasterPresenter() {
        return (I_MasterPresenter) getScreenPresenter();
    }


    protected I_MasterDatabase getMasterDatabase(){
        return (I_MasterDatabase) getScreenDatabase();
    }

    protected I_DetailDatabase getDetailDatabase(){
        return (I_DetailDatabase) getScreenDatabase();
    }

    @Override
    public MasterData getDataRef() {
        return dataRef;
    }

    @Override
    public void setDataRef(MasterData data) {
        dataRef = data;
    }


    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int pos) {
        position = pos;
    }


    //metodos comunes del buscador y proximas:

    public I_MasterDatabase getDatabase() {
        return (I_MasterDatabase) getScreenDatabase();
    }

    public String loadJsonFromAsset(String path) {

        Application singleton = (Application) getMediator();

        try {
            InputStream is = singleton.getAssets().open(path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String json = new String(buffer, "UTF-8");
            debug("loadJsonFromAsset", "json=", json);
            return json;

        } catch (IOException ex) {
            return null;
        }
    }

    public MasterData getJavaObjectCategory(JSONObject jsonObject) throws JSONException {

        String label = jsonObject.getString("modalidad");

        return new MasterData(label);
    }

    public DetailData getJavaObjectProduct(JSONObject jsonObject) throws JSONException {

        String nombre = jsonObject.getString("nombre");
        String modalidad = jsonObject.getString("label");
        String zona =jsonObject.getString("zona");
        String descripcion =jsonObject.getString("descripcion");
        String distancia =jsonObject.getString("distancia");
        String fecha = jsonObject.getString("fecha");
        String precio = jsonObject.getString("precio");
        String enlace = jsonObject.getString("enlace");
        String mapa = jsonObject.getString("mapa");

        return new DetailData(nombre, modalidad, zona, descripcion, distancia, fecha, precio, enlace, mapa);
    }


}
