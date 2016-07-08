package com.example.CanaryFitAndroid.mediator;

import com.example.CanaryFitAndroid.category.model.CategoryMasterModel;
import com.example.CanaryFitAndroid.category.presenter.CategoryMasterPresenter;
import com.example.CanaryFitAndroid.category.view.CategoryMasterView;
import com.example.CanaryFitAndroid.database.DatabaseCanaryFit;
import com.example.CanaryFitAndroid.detail.model.DetailModel;
import com.example.CanaryFitAndroid.detail.presenter.DetailPresenter;
import com.example.CanaryFitAndroid.detail.view.DetailView;
import com.example.CanaryFitAndroid.product.model.ProductMasterModel;
import com.example.CanaryFitAndroid.product.presenter.ProductMasterPresenter;
import com.example.CanaryFitAndroid.product.view.ProductMasterView;
import com.example.CanaryFitAndroid.screen.buscador.master.MasterBuscadorModel;
import com.example.CanaryFitAndroid.screen.buscador.master.MasterBuscadorPresenter;
import com.example.CanaryFitAndroid.screen.buscador.master.MasterBuscadorView;
import com.example.CanaryFitAndroid.screen.buscador.model.BuscadorModel;
import com.example.CanaryFitAndroid.screen.landscape.buscador.LandscapeBuscadorPresenter;
import com.example.CanaryFitAndroid.screen.landscape.buscador.LandscapeBuscadorView;
import com.example.CanaryFitAndroid.screen.landscape.principal.LandscapePrincipalPresenter;
import com.example.CanaryFitAndroid.screen.landscape.principal.LandscapePrincipalView;
import com.example.CanaryFitAndroid.screen.portrait.buscador.PortraitBuscadorPresenter;
import com.example.CanaryFitAndroid.screen.portrait.buscador.PortraitBuscadorView;
import com.example.CanaryFitAndroid.screen.portrait.principal.PortraitPrincipalPresenter;
import com.example.CanaryFitAndroid.screen.portrait.principal.PortraitPrincipalView;
import com.example.CanaryFitAndroid.screen.principal.model.PrincipalModel;
import es.ulpgc.eite.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.framework.core.mediator.MediatorConfig;
import es.ulpgc.eite.framework.core.mediator.MediatorScreen;
import es.ulpgc.eite.framework.core.mediator.MediatorTransition;


public class MasterDetailMediatorConfig extends MediatorConfig {

    public MasterDetailMediatorConfig(I_MediatorSingleton mediator) {
        super(mediator);
    }

    @Override
    public void setCustomConfig() {
        setMasterDetailConfig();
    }

    private void setMasterDetailConfig() {
        setMasterDetailScreenCollection();
        setMasterDetailTransitionCollection();
    }

    private void setMasterDetailScreenCollection() {
        getScreens().add(new MediatorScreen(
                CategoryMasterView.class, CategoryMasterPresenter.class,
                CategoryMasterModel.class, DatabaseCanaryFit.class));
        getScreens().add(new MediatorScreen(
                ProductMasterView.class, ProductMasterPresenter.class,
                ProductMasterModel.class, DatabaseCanaryFit.class));
        getScreens().add(new MediatorScreen(
                DetailView.class, DetailPresenter.class,
                DetailModel.class, DatabaseCanaryFit.class));

        getScreens().add(new MediatorScreen(
                MasterBuscadorView.class, MasterBuscadorPresenter.class,
                MasterBuscadorModel.class, DatabaseCanaryFit.class));

        getScreens().add(new MediatorScreen(
                PortraitPrincipalView.class, PortraitPrincipalPresenter.class, PrincipalModel.class, DatabaseCanaryFit.class
        ));

        getScreens().add(new MediatorScreen(
                LandscapePrincipalView.class, LandscapePrincipalPresenter.class, PrincipalModel.class, DatabaseCanaryFit.class
        ));

        getScreens().add(new MediatorScreen(
                PortraitBuscadorView.class, PortraitBuscadorPresenter.class, BuscadorModel.class, DatabaseCanaryFit.class
        ));

        getScreens().add(new MediatorScreen(
                LandscapeBuscadorView.class, LandscapeBuscadorPresenter.class, BuscadorModel.class, DatabaseCanaryFit.class
        ));

    }

    private void setMasterDetailTransitionCollection() {

        getTransitions().add(new MediatorTransition(
                PortraitPrincipalView.class, LandscapePrincipalView.class, CanaryFitMediatorCode.PRINCIPAL_LANDSCAPE
        ));

        getTransitions().add(new MediatorTransition(
                LandscapePrincipalView.class, PortraitPrincipalView.class, CanaryFitMediatorCode.PRINCIPAL_PORTRAIT
        ));

        getTransitions().add(new MediatorTransition(
                PortraitPrincipalView.class, PortraitBuscadorView.class, CanaryFitMediatorCode.PRINCIPAL_BUSCADOR_PORTRAIT
        ));

        getTransitions().add(new MediatorTransition(
                LandscapePrincipalView.class, LandscapeBuscadorView.class, CanaryFitMediatorCode.PRINCIPAL_BUSCADOR_LANDSCAPE
        ));

        getTransitions().add(new MediatorTransition(
                PortraitBuscadorView.class, PortraitPrincipalView.class, CanaryFitMediatorCode.BUSCADOR_PRINCIPAL_PORTRAIT
        ));

        getTransitions().add(new MediatorTransition(
                LandscapeBuscadorView.class, LandscapePrincipalView.class, CanaryFitMediatorCode.BUSCADOR_PRINCIPAL_LANDSCAPE
        ));

        getTransitions().add(new MediatorTransition(
                PortraitBuscadorView.class, LandscapeBuscadorView.class, CanaryFitMediatorCode.BUSCADOR_LANDSCAPE
        ));

        getTransitions().add(new MediatorTransition(
                LandscapeBuscadorView.class, PortraitBuscadorView.class, CanaryFitMediatorCode.BUSCADOR_PORTRAIT
        ));

        getTransitions().add(new MediatorTransition(PortraitPrincipalView.class,
                CategoryMasterView.class, CanaryFitMediatorCode.PRINCIPAL_PROXIMAS_PORTRAIT));

        getTransitions().add(new MediatorTransition(LandscapePrincipalView.class,
                CategoryMasterView.class, CanaryFitMediatorCode.PRINCIPAL_PROXIMAS_LANDSCAPE));

        getTransitions().add(new MediatorTransition(PortraitBuscadorView.class,
                MasterBuscadorView.class, CanaryFitMediatorCode.BUSCADOR_MASTER_PORTRAIT));

        getTransitions().add(new MediatorTransition(LandscapeBuscadorView.class,
                MasterBuscadorView.class, CanaryFitMediatorCode.BUSCADOR_MASTER_LANDSCAPE));

        getTransitions().add(new MediatorTransition(MasterBuscadorView.class,
                DetailView.class, CanaryFitMediatorCode.SELECT));

        getTransitions().add(new MediatorTransition(CategoryMasterView.class,
                ProductMasterView.class, CanaryFitMediatorCode.SELECT));

        getTransitions().add(new MediatorTransition(ProductMasterView.class,
                DetailView.class, CanaryFitMediatorCode.SELECT));

    }
}
