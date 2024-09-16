package com.faas.core.data.ws.base.dashboard.flow;

import com.faas.core.data.ws.base.dashboard.flow.dto.DashboardFlowWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class DashboardFlowWSModel {

    private GeneralWSModel general;
    private List<DashboardFlowWSDTO> dashboardFlows;

    public DashboardFlowWSModel() {
    }

    public DashboardFlowWSModel(GeneralWSModel general, List<DashboardFlowWSDTO> dashboardFlows) {
        this.general = general;
        this.dashboardFlows = dashboardFlows;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<DashboardFlowWSDTO> getDashboardFlows() {
        return dashboardFlows;
    }

    public void setDashboardFlows(List<DashboardFlowWSDTO> dashboardFlows) {
        this.dashboardFlows = dashboardFlows;
    }
}
