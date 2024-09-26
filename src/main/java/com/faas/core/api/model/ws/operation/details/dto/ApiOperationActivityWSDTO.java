package com.faas.core.api.model.ws.operation.details.dto;

import com.faas.core.data.db.operation.content.dao.OperationActivityDAO;

public class ApiOperationActivityWSDTO {

    private OperationActivityDAO operationActivity;

    public ApiOperationActivityWSDTO() {
    }

    public ApiOperationActivityWSDTO(OperationActivityDAO operationActivity) {
        this.operationActivity = operationActivity;
    }

    public OperationActivityDAO getOperationActivity() {
        return operationActivity;
    }

    public void setOperationActivity(OperationActivityDAO operationActivity) {
        this.operationActivity = operationActivity;
    }
}
