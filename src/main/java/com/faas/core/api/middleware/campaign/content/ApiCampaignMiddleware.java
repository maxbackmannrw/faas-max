package com.faas.core.api.middleware.campaign.content;

import com.faas.core.api.framework.campaign.content.ApiCampaignFramework;
import com.faas.core.api.model.ws.campaign.content.ApiCampaignListWSModel;
import com.faas.core.api.model.ws.campaign.content.ApiCampaignWSModel;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignListWSDTO;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.general.dto.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiCampaignMiddleware {


    @Autowired
    ApiCampaignFramework apiCampaignFramework;


    public ApiCampaignListWSModel apiGetAgentCampaignList(long agentId) {

        ApiCampaignListWSModel response = new ApiCampaignListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiCampaignListWSDTO agentCampaignList = apiCampaignFramework.apiGetAgentCampaignListService(agentId);
        if (agentCampaignList != null) {
            response.setCampaignList(agentCampaignList);
        }

        general.setOperation("apiGetAgentCampaignList");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiCampaignWSModel apiGetAgentCampaigns(long agentId,String campaignCategory) {

        ApiCampaignWSModel response = new ApiCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiCampaignWSDTO> campaignWSDTOS = apiCampaignFramework.apiGetAgentCampaignsService(agentId,campaignCategory);
        if (campaignWSDTOS != null) {
            response.setCampaigns(campaignWSDTOS);
        }

        general.setOperation("apiGetAgentCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiCampaignWSModel apiGetAgentCampaign(long agentId, String campaignId) {

        ApiCampaignWSModel response = new ApiCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        ApiCampaignWSDTO campaignWSDTO = apiCampaignFramework.apiGetAgentCampaignService(agentId, campaignId);
        if (campaignWSDTO != null) {
            campaignWSDTOS.add(campaignWSDTO);
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("apiGetAgentCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiSummaryWSModel apiGetAgentCampaignsSummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSummaryWSDTO> campaignSummary = apiCampaignFramework.apiGetAgentCampaignsSummaryService(agentId);
        if (campaignSummary != null) {
            response.setSummaries(campaignSummary);
        }

        general.setOperation("apiGetAgentCampaignsSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
