package com.faas.core.api.model.ws.dashboard;

import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiDashboardWSModel {

    private GeneralWSModel general;
    private ApiDashboardWSDTO dashboard;

    public ApiDashboardWSModel() {
    }

    public ApiDashboardWSModel(GeneralWSModel general, ApiDashboardWSDTO dashboard) {
        this.general = general;
        this.dashboard = dashboard;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiDashboardWSDTO getDashboard() {
        return dashboard;
    }

    public void setDashboard(ApiDashboardWSDTO dashboard) {
        this.dashboard = dashboard;
    }
}
