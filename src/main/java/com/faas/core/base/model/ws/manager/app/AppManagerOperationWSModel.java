package com.faas.core.base.model.ws.manager.app;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerOperationWSDTO;

public class AppManagerOperationWSModel {

    private GeneralWSModel general;
    private AppManagerOperationWSDTO appManagerOperation;

    public AppManagerOperationWSModel() {
    }

    public AppManagerOperationWSModel(GeneralWSModel general, AppManagerOperationWSDTO appManagerOperation) {
        this.general = general;
        this.appManagerOperation = appManagerOperation;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public AppManagerOperationWSDTO getAppManagerOperation() {
        return appManagerOperation;
    }

    public void setAppManagerOperation(AppManagerOperationWSDTO appManagerOperation) {
        this.appManagerOperation = appManagerOperation;
    }
}
