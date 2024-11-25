package com.faas.core.api.model.ws.operation.manager.activity.dto;

import com.faas.core.data.db.utils.ActivityDBModel;

public class ApiOperationActivityWSDTO {

    private ActivityDBModel operationActivity;

    public ApiOperationActivityWSDTO() {
    }

    public ApiOperationActivityWSDTO(ActivityDBModel operationActivity) {
        this.operationActivity = operationActivity;
    }

    public ActivityDBModel getOperationActivity() {
        return operationActivity;
    }

    public void setOperationActivity(ActivityDBModel operationActivity) {
        this.operationActivity = operationActivity;
    }
}
