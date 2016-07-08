package com.example.CanaryFitAndroid.detail.presenter;

import com.example.CanaryFitAndroid.detail.data.DetailData;
import com.example.CanaryFitAndroid.detail.model.I_DetailModel;
import com.example.CanaryFitAndroid.detail.state.DetailState;
import com.example.CanaryFitAndroid.detail.view.I_DetailView;
import com.example.CanaryFitAndroid.mediator.CanaryFitMediatorCode;
import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenObservable;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DetailPresenter
        extends AndroidScreenPresenter implements I_ScreenObservable, I_DetailPresenter {


    private I_DetailModel getDetailModel(){
        return (I_DetailModel) getScreenModel();
    }

    private I_DetailView getDetailView(){
        return (I_DetailView) getScreenView();
    }

    /**
     * La forma correcta de dar funcionalidad a los botones de la vista es la siguiente, pero el framework no nos permite
     * hacer un startActivity en esta pantalla. Por lo tanto nos vemos obligados a implementar estos métodos en la vista.
     */

//    @Override
//    public void guardarCalendario(String fechaString, String nombre) throws ParseException {
//
//        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
//        Date date = fecha.parse(fechaString);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        Intent intent = new Intent(Intent.ACTION_EDIT);
//        intent.setType("vnd.android.cursor.item/event");
//        intent.putExtra("beginTime", calendar.getTimeInMillis());
//        intent.putExtra("allDay", true);
//        intent.putExtra("endTime", calendar.getTimeInMillis()+60*60*1000);
//        intent.putExtra("title", nombre);
//        startActivity(intent);
//
//    }
//
//    @Override
//    public void inscripcion(String enlace){
//        Intent intent = null;
//        intent = new Intent(intent.ACTION_VIEW, Uri.parse(enlace));
//        startActivity(intent);
//    }

    /**
     * Método que nos pasa la fecha que tenemos guardada en el Json (String) a formato Date.
     * Obtenido de http://stackoverflow.com/questions/2331513/convert-a-string-to-a-gregoriancalendar
     * @param fechaString la que tenemos almacenada en nuestra base de datos
     * @return la fecha en formato Date
     * @throws ParseException si nuestro String no tiene el formato dd/MM/yyyy
     */
    @Override
    public Date parsearFecha(String fechaString) throws ParseException {
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        return fecha.parse(fechaString);

    }


    @Override
    public void createScreen() {
        debug("createScreen");

        getDetailView().setDetailLayout();
        getDetailModel().setData(new DetailData());
    }

    @Override
    public void backScreen() {
        debug("backScreen");

        notifyScreenObservers(this, CanaryFitMediatorCode.BACK, null);
    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen");

        getDetailView().setDetailData(getDetailModel().getData());
    }

    /**
     * Método que nos carga el estado de la pantalla, recuperando el objeto DetailData que tenemos que cargar en cada caso.
     * @param view, no necesario, porque aunque vengamos de dos pantallas distintas (ProductMasterView y MasterBuscadorView)
     *              vamos a realizar la misma acción.
     * @param code, igual que el parámetro anterior
     * @param state, objeto de la clase DetailState
     */
    @Override
    public void setScreenState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);

        if(state != null){
            DetailState _state = (DetailState) state;
            getDetailModel().setData(_state.getData());
        }
    }

    /**
     * Método para almacenar el estado actual de la pantalla.
     * @return el estado con el elemento de DetailData adecuado en cada caso.
     */
    @Override
    public I_ScreenState getScreenState() {
        debug("getScreenState");

        DetailState state = new DetailState(getDetailModel().getData());
        return state;
    }

    /**
     * Métodos que nos obliga a implementar la interfaz pero que realmente no estamos usando:
     */

    @Override
    public void pauseScreen() {}

    @Override
    public void rotateScreen() {}

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        return null;
    }

    @Override
    public void updateObservableState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {}



}
