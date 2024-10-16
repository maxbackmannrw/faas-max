package com.faas.core.api.model.ws.dashboard;

import com.faas.core.api.model.ws.dashboard.dto.ApiDashContentWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiDashContentWSModel {

    private GeneralWSModel general;
    private ApiDashContentWSDTO dashContent;

    public ApiDashContentWSModel() {
    }

    public ApiDashContentWSModel(GeneralWSModel general, ApiDashContentWSDTO dashContent) {
        this.general = general;
        this.dashContent = dashContent;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiDashContentWSDTO getDashContent() {
        return dashContent;
    }

    public void setDashContent(ApiDashContentWSDTO dashContent) {
        this.dashContent = dashContent;
    }
}
