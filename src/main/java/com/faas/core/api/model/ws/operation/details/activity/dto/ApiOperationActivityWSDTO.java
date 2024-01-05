package com.faas.core.api.model.ws.operation.details.activity.dto;

import com.faas.core.base.model.db.operation.content.dao.OperationActivityDAO;

public class ApiOperationActivityWSDTO {

    private OperationActivityDAO operationActivityDAO;

    public ApiOperationActivityWSDTO() {
    }

    public ApiOperationActivityWSDTO(OperationActivityDAO operationActivityDAO) {
        this.operationActivityDAO = operationActivityDAO;
    }

    public OperationActivityDAO getOperationActivity() {
        return operationActivityDAO;
    }

    public void setOperationActivity(OperationActivityDAO operationActivityDAO) {
        this.operationActivityDAO = operationActivityDAO;
    }
}
