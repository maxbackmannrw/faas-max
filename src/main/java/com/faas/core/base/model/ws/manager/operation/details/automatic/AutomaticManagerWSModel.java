package com.faas.core.base.model.ws.manager.operation.details.automatic;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.operation.details.automatic.dto.AutomaticManagerWSDTO;

public class AutomaticManagerWSModel {

    private GeneralWSModel general;
    private AutomaticManagerWSDTO automaticManager;

    public AutomaticManagerWSModel() {
    }

    public AutomaticManagerWSModel(GeneralWSModel general, AutomaticManagerWSDTO automaticManager) {
        this.general = general;
        this.automaticManager = automaticManager;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public AutomaticManagerWSDTO getAutomaticManager() {
        return automaticManager;
    }

    public void setAutomaticManager(AutomaticManagerWSDTO automaticManager) {
        this.automaticManager = automaticManager;
    }
}
