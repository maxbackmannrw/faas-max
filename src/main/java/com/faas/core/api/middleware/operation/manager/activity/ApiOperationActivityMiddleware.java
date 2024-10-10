package com.faas.core.api.middleware.operation.manager.activity;

import com.faas.core.api.framework.operation.manager.activity.ApiOperationActivityFramework;
import com.faas.core.api.model.ws.operation.manager.activity.ApiOperationActivityWSModel;
import com.faas.core.api.model.ws.operation.manager.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationActivityMiddleware {


    @Autowired
    ApiOperationActivityFramework apiOperationActivityFramework;


    public ApiOperationActivityWSModel apiGetOperationActivities(long agentId, String operationId) {

        ApiOperationActivityWSModel response = new ApiOperationActivityWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationActivityWSDTO> operationActivityWSDTOS = apiOperationActivityFramework.apiGetOperationActivitiesService(agentId, operationId);
        if (operationActivityWSDTOS != null) {
            response.setOperationActivities(operationActivityWSDTOS);
        }

        general.setOperation("apiGetOperationActivities");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationActivityWSModel apiGetOperationActivity(long agentId, String operationId, String activityId) {

        ApiOperationActivityWSModel response = new ApiOperationActivityWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationActivityWSDTO> operationActivityWSDTOS = new ArrayList<>();

        ApiOperationActivityWSDTO operationActivityWSDTO = apiOperationActivityFramework.apiGetOperationActivityService(agentId, operationId, activityId);
        if (operationActivityWSDTO != null) {
            operationActivityWSDTOS.add(operationActivityWSDTO);
        }

        response.setOperationActivities(operationActivityWSDTOS);
        general.setOperation("apiGetOperationActivity");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}