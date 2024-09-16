package com.faas.core.data.ws.api.dashboard;

import com.faas.core.data.ws.api.dashboard.dto.ApiDashboardWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

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
