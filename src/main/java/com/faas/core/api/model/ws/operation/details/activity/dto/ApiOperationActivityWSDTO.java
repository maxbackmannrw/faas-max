package com.faas.core.api.model.ws.operation.details.activity.dto;

import com.faas.core.base.model.db.operation.content.dao.ActivityDAO;

public class ApiOperationActivityWSDTO {

    private ActivityDAO activityDAO;

    public ApiOperationActivityWSDTO() {
    }

    public ApiOperationActivityWSDTO(ActivityDAO activityDAO) {
        this.activityDAO = activityDAO;
    }

    public ActivityDAO getOperationActivity() {
        return activityDAO;
    }

    public void setOperationActivity(ActivityDAO activityDAO) {
        this.activityDAO = activityDAO;
    }
}
