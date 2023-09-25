package com.faas.core.api.middleware.campaign.details;

import com.faas.core.api.framework.campaign.details.ApiCampaignDetailsFramework;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiCampaignDetailsMiddleware {


    @Autowired
    ApiCampaignDetailsFramework apiCampaignDetailsFramework;


    public ApiCampaignDetailsWSModel apiGetCampaignDetails(long agentId, String campaignId) {

        ApiCampaignDetailsWSModel response = new ApiCampaignDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiCampaignDetailsWSDTO> campaignDetailsWSDTOS = new ArrayList<>();



        response.setCampaignDetails(campaignDetailsWSDTOS);
        general.setOperation("getAgentCampaignDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
