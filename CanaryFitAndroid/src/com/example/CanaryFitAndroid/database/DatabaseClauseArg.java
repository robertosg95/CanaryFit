package com.example.CanaryFitAndroid.database;

/**
 * Necesitamos esta clase para realizar búsquedas en la base de datos
 */

public class DatabaseClauseArg {

    //Nombre de la columna
    public String key;

    //Valor asociado a esa colunma
    public String val;

    //Condición de búsqueda
    public String cond;



    public DatabaseClauseArg(String k, String c, String v) {
        key = k;
        val = v;
        cond = c;

    }

}