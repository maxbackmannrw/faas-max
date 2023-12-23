package com.faas.core.base.model.ws.manager.app;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerCampaignWSDTO;

public class AppManagerCampaignWSModel {

    private GeneralWSModel general;
    private AppManagerCampaignWSDTO appManagerCampaign;

    public AppManagerCampaignWSModel() {
    }

    public AppManagerCampaignWSModel(GeneralWSModel general, AppManagerCampaignWSDTO appManagerCampaign) {
        this.general = general;
        this.appManagerCampaign = appManagerCampaign;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public AppManagerCampaignWSDTO getAppManagerCampaign() {
        return appManagerCampaign;
    }

    public void setAppManagerCampaign(AppManagerCampaignWSDTO appManagerCampaign) {
        this.appManagerCampaign = appManagerCampaign;
    }
}
