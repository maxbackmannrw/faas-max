package com.faas.core.api.model.ws.dashboard;

import com.faas.core.api.model.ws.dashboard.dto.ApiDashboardOperationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiDashboardOperationWSModel {

    private GeneralWSModel general;
    private ApiDashboardOperationWSDTO dashboardOperation;

    public ApiDashboardOperationWSModel() {
    }

    public ApiDashboardOperationWSModel(GeneralWSModel general, ApiDashboardOperationWSDTO dashboardOperation) {
        this.general = general;
        this.dashboardOperation = dashboardOperation;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiDashboardOperationWSDTO getDashboardOperation() {
        return dashboardOperation;
    }

    public void setDashboardOperation(ApiDashboardOperationWSDTO dashboardOperation) {
        this.dashboardOperation = dashboardOperation;
    }
}
