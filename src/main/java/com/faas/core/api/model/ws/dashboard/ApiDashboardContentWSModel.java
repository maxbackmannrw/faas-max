package com.faas.core.api.model.ws.dashboard;

import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardContentWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiDashboardContentWSModel {

    private GeneralWSModel general;
    private ApiDashboardContentWSDTO dashboardContent;

    public ApiDashboardContentWSModel() {
    }

    public ApiDashboardContentWSModel(GeneralWSModel general, ApiDashboardContentWSDTO dashboardContent) {
        this.general = general;
        this.dashboardContent = dashboardContent;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiDashboardContentWSDTO getDashboardContent() {
        return dashboardContent;
    }

    public void setDashboardContent(ApiDashboardContentWSDTO dashboardContent) {
        this.dashboardContent = dashboardContent;
    }
}
