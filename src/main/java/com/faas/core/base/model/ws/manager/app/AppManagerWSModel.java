package com.faas.core.base.model.ws.manager.app;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerWSDTO;

public class AppManagerWSModel {

    private GeneralWSModel general;
    private AppManagerWSDTO appManager;

    public AppManagerWSModel() {
    }

    public AppManagerWSModel(GeneralWSModel general, AppManagerWSDTO appManager) {
        this.general = general;
        this.appManager = appManager;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public AppManagerWSDTO getAppManager() {
        return appManager;
    }

    public void setAppManager(AppManagerWSDTO appManager) {
        this.appManager = appManager;
    }
}
