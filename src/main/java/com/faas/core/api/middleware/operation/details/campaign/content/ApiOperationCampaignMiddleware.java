package com.faas.core.api.middleware.operation.details.campaign.content;

import com.faas.core.api.framework.operation.details.campaign.content.ApiOperationCampaignFramework;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationCampaignMiddleware {


    @Autowired
    ApiOperationCampaignFramework apiOperationCampaignFramework;


    public ApiCampaignDetailsWSModel apiGetOperationCampaign(long agentId, String operationId) {

        ApiCampaignDetailsWSModel response = new ApiCampaignDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiCampaignDetailsWSDTO operationCampaign = apiOperationCampaignFramework.apiGetOperationCampaignService(agentId,operationId);
        if (operationCampaign != null){
            response.setCampaignDetails(operationCampaign);
        }

        general.setOperation("apiGetOperationCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
