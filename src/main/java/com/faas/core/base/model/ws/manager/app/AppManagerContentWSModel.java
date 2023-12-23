package com.faas.core.base.model.ws.manager.app;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerContentWSDTO;

public class AppManagerContentWSModel {

    private GeneralWSModel general;
    private AppManagerContentWSDTO appManager;

    public AppManagerContentWSModel() {
    }

    public AppManagerContentWSModel(GeneralWSModel general, AppManagerContentWSDTO appManager) {
        this.general = general;
        this.appManager = appManager;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public AppManagerContentWSDTO getAppManager() {
        return appManager;
    }

    public void setAppManager(AppManagerContentWSDTO appManager) {
        this.appManager = appManager;
    }
}
