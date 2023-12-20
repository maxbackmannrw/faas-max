package com.faas.core.api.framework.operation.details.activity;

import com.faas.core.api.model.ws.operation.details.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.base.model.db.operation.content.dao.ActivityDAO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiOperationActivityFramework {


    @Autowired
    AppUtils appUtils;


    public ApiOperationActivityWSDTO fillApiOperationActivityWSDTO(ActivityDAO activityDAO) {

        ApiOperationActivityWSDTO operationActivityWSDTO = new ApiOperationActivityWSDTO();
        return operationActivityWSDTO;
    }


    public List<ActivityDAO> apiGetOperationActivitiesService(long sessionId, long clientId) {

        return null;
    }


    public ActivityDAO apiGetOperationActivityService(long sessionId, long clientId, String activityId) {

        return null;
    }


}
