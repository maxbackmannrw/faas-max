package com.faas.core.base.model.ws.manager.app;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerCampaignWSDTO;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerContentWSDTO;

public class AppManagerContentWSModel {

    private GeneralWSModel general;
    private AppManagerContentWSDTO appManagerContent;

    public AppManagerContentWSModel() {
    }

    public AppManagerContentWSModel(GeneralWSModel general, AppManagerContentWSDTO appManagerContent) {
        this.general = general;
        this.appManagerContent = appManagerContent;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public AppManagerContentWSDTO getAppManagerContent() {
        return appManagerContent;
    }

    public void setAppManagerContent(AppManagerContentWSDTO appManagerContent) {
        this.appManagerContent = appManagerContent;
    }
}
