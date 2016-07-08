package com.example.CanaryFitAndroid.screen.buscador.view;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.CanaryFitAndroid.R;
import com.example.CanaryFitAndroid.screen.buscador.presenter.I_BuscadorPresenter;
import es.ulpgc.eite.framework.android.AndroidScreenView;



public abstract class BuscadorView extends AndroidScreenView implements I_BuscadorView {

    private I_BuscadorPresenter getBuscadorPresenter(){
        return (I_BuscadorPresenter) getScreenPresenter();
    }

    public abstract int getLayout();

    @Override
    public void setLayout(){
        debug("setLayout");

        setContentView(getLayout());
    }

    /**
     * Método para obtener el texto introducido
     * @return el texto introducido en el buscador
     */
    @Override
    public String getTextBuscar(){
        EditText texto = (EditText) findViewById(R.id.nombre_competicion);
        return texto.getText().toString();
    }

    /**
     * Actualiza el texto en el buscador
     * @param txt valor del nuevo texto
     */
    @Override
    public void setTextBuscar(String txt){
        EditText texto = (EditText) findViewById(R.id.nombre_competicion);
        texto.setText(txt);
    }

    @Override
    public void setListener() {
        Button buscar = (Button) findViewById(R.id.buscar);
        //EditText texto = (EditText) findViewById(R.id.nombre_competicion);
        buscar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Pan para hoy, hambre para mañana:
                /*
                String txt = texto.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("texto a buscar", txt);
                Intent intent = new Intent(BuscadorView.this, MasterBuscadorView.class);
                intent.putExtras(bundle);
                startActivity(intent);
                */

                getBuscadorPresenter().buttonClickedBuscar();
            }
        });

    }

}
