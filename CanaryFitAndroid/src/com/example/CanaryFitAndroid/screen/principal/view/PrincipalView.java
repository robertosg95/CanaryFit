package com.example.CanaryFitAndroid.screen.principal.view;

import android.view.View;
import android.widget.ImageButton;
import com.example.CanaryFitAndroid.R;
import com.example.CanaryFitAndroid.screen.principal.presenter.I_PrincipalPresenter;
import es.ulpgc.eite.framework.android.AndroidScreenView;



public abstract class PrincipalView extends AndroidScreenView implements I_PrincipalView {

    private I_PrincipalPresenter getPrincipalPresenter(){
        return (I_PrincipalPresenter) getScreenPresenter();
    }

    public abstract int getLayout();

    @Override
    public void setLayout(){
        debug("setLayout");

        setContentView(getLayout());
    }

    @Override
    public void setListener() {
        ImageButton imagenBuscador = (ImageButton) findViewById(R.id.imageButtonBrowser);
        imagenBuscador.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                getPrincipalPresenter().imageButtonClickedBuscador();
            }
        });

        ImageButton imagenProximasCarreras = (ImageButton) findViewById(R.id.imageButtonProximasCarreras);
        imagenProximasCarreras.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                getPrincipalPresenter().imageButtonClickedProximasCarreras();
            }
        });

        /*ImageButton imagenResultados = (ImageButton) findViewById(R.id.ImageButtonResultados);
        imagenResultados.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                getPrincipalPresenter().imageButtonClickedResultados();
            }
        });*/

    }


}
