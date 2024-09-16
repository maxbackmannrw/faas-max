package com.faas.core.api.middleware.campaign.content;

import com.faas.core.api.framework.campaign.content.ApiCampaignFramework;
import com.faas.core.data.ws.api.campaign.content.ApiAgentCampaignWSModel;
import com.faas.core.data.ws.api.campaign.content.ApiCampaignWSModel;
import com.faas.core.data.ws.api.campaign.content.dto.ApiAgentCampaignWSDTO;
import com.faas.core.data.ws.api.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.data.ws.api.general.ApiSummaryWSDTO;
import com.faas.core.data.ws.api.general.ApiSummaryWSModel;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiCampaignMiddleware {


    @Autowired
    ApiCampaignFramework apiCampaignFramework;


    public ApiAgentCampaignWSModel apiGetAgentCampaigns(long agentId) {

        ApiAgentCampaignWSModel response = new ApiAgentCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentCampaignWSDTO agentCampaignWSDTO = apiCampaignFramework.apiGetAgentCampaignsService(agentId);
        if (agentCampaignWSDTO != null) {
            response.setAgentCampaign(agentCampaignWSDTO);
        }

        general.setOperation("apiGetAgentCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiCampaignWSModel apiGetCampaigns(long agentId, String campaignCategory) {

        ApiCampaignWSModel response = new ApiCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiCampaignWSDTO> apiCampaignWSDTOS = apiCampaignFramework.apiGetCampaignsService(agentId, campaignCategory);
        if (apiCampaignWSDTOS != null) {
            response.setCampaigns(apiCampaignWSDTOS);
        }

        general.setOperation("apiGetCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiCampaignWSModel apiGetCampaign(long agentId, String campaignId) {

        ApiCampaignWSModel response = new ApiCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        ApiCampaignWSDTO campaignWSDTO = apiCampaignFramework.getApiCampaignService(agentId, campaignId);
        if (campaignWSDTO != null) {
            campaignWSDTOS.add(campaignWSDTO);
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("getApiCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiSummaryWSModel apiGetCampaignsSummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSummaryWSDTO> campaignSummary = apiCampaignFramework.apiGetCampaignsSummaryService(agentId);
        if (campaignSummary != null) {
            response.setSummaries(campaignSummary);
        }

        general.setOperation("apiGetCampaignsSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
