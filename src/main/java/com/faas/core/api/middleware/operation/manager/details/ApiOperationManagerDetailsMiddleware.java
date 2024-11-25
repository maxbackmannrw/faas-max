package com.faas.core.api.middleware.operation.manager.details;

import com.faas.core.api.framework.operation.manager.details.ApiOperationManagerDetailsFramework;
import com.faas.core.api.model.ws.operation.manager.details.ApiOperationCampaignScriptWSModel;
import com.faas.core.api.model.ws.operation.manager.details.ApiOperationCampaignWSModel;
import com.faas.core.api.model.ws.operation.manager.details.dto.ApiOperationCampaignWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.data.db.campaign.content.dao.CampaignScriptDAO;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

        List<CampaignScriptDAO> campaignScriptDAOS = apiOperationManagerDetailsFramework.apiGetOperationCampaignScriptsService(agentId, campaignId);
        if (campaignScriptDAOS != null) {
            response.setCampaignScripts(campaignScriptDAOS);
        }

        general.setOperation("apiGetOperationCampaignScripts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}