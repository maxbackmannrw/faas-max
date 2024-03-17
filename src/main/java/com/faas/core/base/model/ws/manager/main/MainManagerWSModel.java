package com.faas.core.base.model.ws.manager.main;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.main.dto.MainManagerWSDTO;

public class MainManagerWSModel {

    private GeneralWSModel general;
    private MainManagerWSDTO mainManager;

    public MainManagerWSModel() {
    }

    public MainManagerWSModel(GeneralWSModel general, MainManagerWSDTO mainManager) {
        this.general = general;
        this.mainManager = mainManager;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public MainManagerWSDTO getMainManager() {
        return mainManager;
    }

    public void setMainManager(MainManagerWSDTO mainManager) {
        this.mainManager = mainManager;
    }
}
