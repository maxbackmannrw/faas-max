package com.faas.core.api.model.ws.operation.manager.activity.dto;

import com.faas.core.data.db.operation.details.activity.OperationActivityDBModel;

public class ApiOperationActivityWSDTO {

    private OperationActivityDBModel operationActivity;

    public ApiOperationActivityWSDTO() {
    }

    public ApiOperationActivityWSDTO(OperationActivityDBModel operationActivity) {
        this.operationActivity = operationActivity;
    }

    public OperationActivityDBModel getOperationActivity() {
        return operationActivity;
    }

    public void setOperationActivity(OperationActivityDBModel operationActivity) {
        this.operationActivity = operationActivity;
    }
}
