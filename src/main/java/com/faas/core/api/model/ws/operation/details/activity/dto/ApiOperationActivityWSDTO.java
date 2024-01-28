package com.faas.core.api.model.ws.operation.details.activity.dto;

import com.faas.core.base.model.db.operation.content.dao.OperationActivityDAO;

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
