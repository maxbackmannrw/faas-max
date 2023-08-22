package com.faas.core.base.model.ws.dashboard.operation;

import com.faas.core.base.model.ws.dashboard.operation.dto.DashboardOperationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class DashboardOperationWSModel {

    private GeneralWSModel general;
    private List<DashboardOperationWSDTO>dashboardOperations;

    public DashboardOperationWSModel() {
    }

    public DashboardOperationWSModel(GeneralWSModel general, List<DashboardOperationWSDTO> dashboardOperations) {
        this.general = general;
        this.dashboardOperations = dashboardOperations;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<DashboardOperationWSDTO> getDashboardOperations() {
        return dashboardOperations;
    }

    public void setDashboardOperations(List<DashboardOperationWSDTO> dashboardOperations) {
        this.dashboardOperations = dashboardOperations;
    }
}
