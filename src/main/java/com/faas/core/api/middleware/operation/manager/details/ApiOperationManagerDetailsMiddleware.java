package com.faas.core.api.middleware.operation.manager.details;

import com.faas.core.api.framework.operation.manager.details.ApiOperationManagerDetailsFramework;
import com.faas.core.api.model.ws.operation.manager.details.ApiOperationActivityWSModel;
import com.faas.core.api.model.ws.operation.manager.details.ApiOperationCampaignScriptWSModel;
import com.faas.core.api.model.ws.operation.manager.details.ApiOperationCampaignWSModel;
import com.faas.core.api.model.ws.operation.manager.details.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.manager.details.dto.ApiOperationCampaignWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.data.db.campaign.content.dao.CampaignScriptDAO;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationManagerDetailsMiddleware {


    @Autowired
    ApiOperationManagerDetailsFramework apiOperationManagerDetailsFramework;


    public ApiOperationCampaignWSModel apiGetOperationCampaign(long agentId, String campaignId) {

        ApiOperationCampaignWSModel response = new ApiOperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationCampaignWSDTO operationCampaign = apiOperationManagerDetailsFramework.apiGetOperationCampaignService(agentId,campaignId);
        if (operationCampaign != null) {
            response.setCampaign(operationCampaign);
        }

        general.setOperation("apiGetOperationCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationCampaignScriptWSModel apiGetOperationCampaignScripts(long agentId, String campaignId) {

        ApiOperationCampaignScriptWSModel response = new ApiOperationCampaignScriptWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<CampaignScriptDAO> campaignScripts = apiOperationManagerDetailsFramework.apiGetOperationCampaignScriptsService(agentId, campaignId);
        if (campaignScripts != null) {
            response.setCampaignScripts(campaignScripts);
        }

        general.setOperation("apiGetOperationCampaignScripts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationActivityWSModel apiGetOperationActivities(long agentId, String operationId) {

        ApiOperationActivityWSModel response = new ApiOperationActivityWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationActivityWSDTO> operationActivityWSDTOS = apiOperationManagerDetailsFramework.apiGetOperationActivitiesService(agentId, operationId);
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

        ApiOperationActivityWSDTO operationActivityWSDTO = apiOperationManagerDetailsFramework.apiGetOperationActivityService(agentId, operationId, activityId);
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