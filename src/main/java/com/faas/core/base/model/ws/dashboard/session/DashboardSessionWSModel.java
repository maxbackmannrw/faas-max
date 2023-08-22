package com.faas.core.base.model.ws.dashboard.session;

import com.faas.core.base.model.ws.dashboard.session.dto.DashboardSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class DashboardSessionWSModel {

    private GeneralWSModel general;
    private List<DashboardSessionWSDTO>dashboardSessions;

    public DashboardSessionWSModel() {
    }

    public DashboardSessionWSModel(GeneralWSModel general, List<DashboardSessionWSDTO> dashboardSessions) {
        this.general = general;
        this.dashboardSessions = dashboardSessions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<DashboardSessionWSDTO> getDashboardSessions() {
        return dashboardSessions;
    }

    public void setDashboardSessions(List<DashboardSessionWSDTO> dashboardSessions) {
        this.dashboardSessions = dashboardSessions;
    }
}
