package com.faas.core.base.model.ws.manager.operation.details.manual;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.operation.details.manual.dto.ManualManagerWSDTO;

public class ManualManagerWSModel {

    private GeneralWSModel general;
    private ManualManagerWSDTO manualManager;

    public ManualManagerWSModel() {
    }

    public ManualManagerWSModel(GeneralWSModel general, ManualManagerWSDTO manualManager) {
        this.general = general;
        this.manualManager = manualManager;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ManualManagerWSDTO getManualManager() {
        return manualManager;
    }

    public void setManualManager(ManualManagerWSDTO manualManager) {
        this.manualManager = manualManager;
    }
}
