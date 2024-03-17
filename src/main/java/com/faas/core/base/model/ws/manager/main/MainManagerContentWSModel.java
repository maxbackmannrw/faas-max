package com.faas.core.base.model.ws.manager.main;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.main.dto.MainManagerContentWSDTO;

public class MainManagerContentWSModel {

    private GeneralWSModel general;
    private MainManagerContentWSDTO mainManagerContent;

    public MainManagerContentWSModel() {
    }

    public MainManagerContentWSModel(GeneralWSModel general, MainManagerContentWSDTO mainManagerContent) {
        this.general = general;
        this.mainManagerContent = mainManagerContent;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public MainManagerContentWSDTO getMainManagerContent() {
        return mainManagerContent;
    }

    public void setMainManagerContent(MainManagerContentWSDTO mainManagerContent) {
        this.mainManagerContent = mainManagerContent;
    }
}
