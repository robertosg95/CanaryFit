package com.example.CanaryFitAndroid.detail.view;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.CanaryFitAndroid.R;
import com.example.CanaryFitAndroid.detail.data.DetailData;
import com.example.CanaryFitAndroid.detail.presenter.I_DetailPresenter;
import es.ulpgc.eite.framework.android.AndroidScreenView;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
public class DetailView extends AndroidScreenView implements I_DetailView {

    private I_DetailPresenter getDetailPresenter(){ return (I_DetailPresenter) getScreenPresenter();}

    private int getDataLayout(){
        return R.layout.detail_view;
    }

    @Override
    public void setDetailLayout(){
        debug("setDetailLayout");

        setContentView(getDataLayout());
    }



    @Override
    public void setDetailData(DetailData data){
        TextView dataView = (TextView) findViewById(R.id.nombre_carrera);
        dataView.setText(data.getLabel());

        TextView textDescripcion = (TextView) findViewById(R.id.textViewDescripcion);
        textDescripcion.setText(data.getDescripcion());

        TextView textDistancia = (TextView) findViewById(R.id.textViewDistancia);
        textDistancia.setText("Distancia: " + data.getDistancia());

        TextView textZona = (TextView) findViewById(R.id.textViewZona);
        textZona.setText("Isla: " + data.getZona());

        TextView textFecha = (TextView) findViewById(R.id.textViewFecha);
        textFecha.setText("Fecha: " + data.getFecha());

        TextView textPrecio = (TextView) findViewById(R.id.textViewPrecio);
        textPrecio.setText("Precio: " + data.getPrecio());

        Button inscripcion = (Button) findViewById(R.id.inscripcion);
        inscripcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inscripcion(data.getEnlace());

//                Forma correcta de hacerlo:
//                getDetailPresenter().inscripcion();
            }
        });

        Button guardar = (Button) findViewById(R.id.guardarCalendario);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Date fecha = getDetailPresenter().parsearFecha(data.getFecha());
                    guardarCalendario(fecha, data.getLabel());

//                    Forma correcta de hacerlo:
//                    getDetailPresenter().guardarCalendario(data.getFecha(), data.getLabel());

                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        });


    }

    /**
     * Estos métodos deberían estar implementados en DetailPresenter:
     */

    /**
     * Método que nos lleva al calendario que el usuario tenga instalado para guardar el evento.
     * Obtenido de http://stackoverflow.com/questions/3721963/how-to-add-calendar-events-in-android
     * @param fecha del evento a guardar
     * @param nombre del evento a guardar
     */
    public void guardarCalendario(Date fecha, String nombre) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", calendar.getTimeInMillis());
        intent.putExtra("allDay", true);
        intent.putExtra("endTime", calendar.getTimeInMillis()+60*60*1000);
        intent.putExtra("title", nombre);
        startActivity(intent);

    }


    /**
     * Método que nos abre el navegador que el usuario tenga instalado en su dispositivo y nos lleva a la página de la competición
     * @param enlace de la página a la que queremos ir
     */
    public void inscripcion(String enlace){
        Intent intent = null;
        intent = new Intent(intent.ACTION_VIEW, Uri.parse(enlace));
        startActivity(intent);
    }


}
