package com.faas.core.api.model.ws.operation.manager.details;

import com.faas.core.api.model.ws.operation.manager.details.dto.ApiOperationActivityWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiOperationActivityWSModel {

    private GeneralWSModel general;
    private List<ApiOperationActivityWSDTO> operationActivities;

    public ApiOperationActivityWSModel() {
    }

    public ApiOperationActivityWSModel(GeneralWSModel general, List<ApiOperationActivityWSDTO> operationActivities) {
        this.general = general;
        this.operationActivities = operationActivities;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationActivityWSDTO> getOperationActivities() {
        return operationActivities;
    }

    public void setOperationActivities(List<ApiOperationActivityWSDTO> operationActivities) {
        this.operationActivities = operationActivities;
    }
}
