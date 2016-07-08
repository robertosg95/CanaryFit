package com.example.CanaryFitAndroid.detail.presenter;

//POSIBLE MEJORA: eliminar interfaz porque no está en uso
//Se conserva para ejemplificar cómo debería estar hecho

import java.text.ParseException;
import java.util.Date;

public interface I_DetailPresenter {
    Date parsearFecha(String fechaString) throws ParseException;

    /**
     *  Forma correcta de implementar la funcionalidad de los botones
     */

//    void guardarCalendario(String fechaString, String nombre) throws ParseException;

//    void inscripcion();

}
