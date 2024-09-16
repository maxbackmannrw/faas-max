package com.faas.core.data.ws.base.dashboard.content;

import com.faas.core.data.ws.base.dashboard.content.dto.DashboardWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

public class DashboardWSModel {

    private GeneralWSModel general;
    private DashboardWSDTO dashboard;

    public DashboardWSModel() {
    }

    public DashboardWSModel(GeneralWSModel general, DashboardWSDTO dashboard) {
        this.general = general;
        this.dashboard = dashboard;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public DashboardWSDTO getDashboard() {
        return dashboard;
    }

    public void setDashboard(DashboardWSDTO dashboard) {
        this.dashboard = dashboard;
    }
}
