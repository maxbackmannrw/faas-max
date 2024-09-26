package com.faas.core.api.middleware.operation.manager.content;

import com.faas.core.api.framework.operation.manager.content.ApiOperationManagerFramework;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationActivityWSModel;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationDetailsWSModel;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationManagerMiddleware {


    @Autowired
    ApiOperationManagerFramework apiOperationManagerFramework;


    public ApiOperationDetailsWSModel apiGetOperationDetails(long agentId, String operationId) {

        ApiOperationDetailsWSModel response = new ApiOperationDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationDetailsWSDTO operationDetailsWSDTO = apiOperationManagerFramework.apiGetOperationDetailsService(agentId, operationId);
        if (operationDetailsWSDTO != null) {
            response.setOperationDetails(operationDetailsWSDTO);
        }

        general.setOperation("apiGetOperationDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiStartOperation(long agentId, String operationId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationManagerFramework.apiStartOperationService(agentId, operationId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiStartOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiCompleteOperation(long agentId, String operationId, String operationResult) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationManagerFramework.apiCompleteOperationService(agentId, operationId, operationResult);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiCompleteOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiGetSwitchOperations(long agentId, String operationId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationWSDTO> operationWSDTOS = apiOperationManagerFramework.apiGetSwitchOperationsService(agentId, operationId);
        if (operationWSDTOS != null) {
            response.setOperations(operationWSDTOS);
        }

        general.setOperation("apiGetSwitchOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiSwitchOperation(long agentId, String operationId, String selectedId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationManagerFramework.apiSwitchOperationService(agentId, operationId, selectedId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiSwitchOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiCampaignDetailsWSModel apiGetOperationCampaign(long agentId, String operationId) {

        ApiCampaignDetailsWSModel response = new ApiCampaignDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiCampaignDetailsWSDTO operationCampaign = apiOperationManagerFramework.apiGetOperationCampaignService(agentId, operationId);
        if (operationCampaign != null) {
            response.setCampaignDetails(operationCampaign);
        }

        general.setOperation("apiGetOperationCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationActivityWSModel apiGetOperationActivities(long agentId, String operationId) {

        ApiOperationActivityWSModel response = new ApiOperationActivityWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationActivityWSDTO> operationActivityWSDTOS = apiOperationManagerFramework.apiGetOperationActivitiesService(agentId, operationId);
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

        ApiOperationActivityWSDTO operationActivityWSDTO = apiOperationManagerFramework.apiGetOperationActivityService(agentId, operationId, activityId);
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