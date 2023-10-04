package com.faas.core.api.middleware.operation.details.result;

import com.faas.core.api.framework.operation.details.result.ApiOperationOutcomeFramework;
import com.faas.core.api.model.ws.operation.details.activity.ApiOperationActivityWSModel;
import com.faas.core.api.model.ws.operation.details.activity.dto.ApiOperationActivityWSDTO;
import com.faas.core.base.model.db.operation.content.dao.OperationActivityDAO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationOutcomeMiddleware {


    @Autowired
    ApiOperationOutcomeFramework apiOperationOutcomeFramework;


    public ApiOperationActivityWSModel apiGetOperationActivities(long agentId, long sessionId,long clientId) {

        ApiOperationActivityWSModel response = new ApiOperationActivityWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationActivityWSDTO>operationActivityWSDTOS = new ArrayList<>();

        List<OperationActivityDAO> operationActivities = apiOperationOutcomeFramework.apiGetOperationActivitiesService(sessionId,clientId);
        if (operationActivities != null){
            for (OperationActivityDAO operationActivityDAO : operationActivities) {
                operationActivityWSDTOS.add(apiOperationOutcomeFramework.fillApiOperationActivityWSDTO(operationActivityDAO));
            }
        }

        response.setOperationActivities(operationActivityWSDTOS);
        general.setOperation("apiGetOperationActivities");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiOperationActivityWSModel apiGetOperationActivity(long agentId, long sessionId,long clientId,String activityId) {

        ApiOperationActivityWSModel response = new ApiOperationActivityWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationActivityWSDTO>operationActivityWSDTOS = new ArrayList<>();

        OperationActivityDAO operationActivityDAO = apiOperationOutcomeFramework.apiGetOperationActivityService(sessionId,clientId,activityId);
        if (operationActivityDAO != null){
            operationActivityWSDTOS.add(apiOperationOutcomeFramework.fillApiOperationActivityWSDTO(operationActivityDAO));
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
