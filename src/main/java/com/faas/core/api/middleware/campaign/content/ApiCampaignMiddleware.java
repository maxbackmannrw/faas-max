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


    public ApiCampaignListWSModel apiGetCampaignList(long agentId) {

        ApiCampaignListWSModel response = new ApiCampaignListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiCampaignListWSDTO agentCampaignList = apiCampaignFramework.apiGetCampaignListService(agentId);
        if (agentCampaignList != null) {
            response.setCampaignList(agentCampaignList);
        }

        general.setOperation("apiGetCampaignList");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiCampaignWSModel apiGetCampaigns(long agentId,String campaignCategory) {

        ApiCampaignWSModel response = new ApiCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiCampaignWSDTO> campaignWSDTOS = apiCampaignFramework.apiGetCampaignsService(agentId,campaignCategory);
        if (campaignWSDTOS != null) {
            response.setCampaigns(campaignWSDTOS);
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

        ApiCampaignWSDTO campaignWSDTO = apiCampaignFramework.apiGetCampaignService(agentId, campaignId);
        if (campaignWSDTO != null) {
            campaignWSDTOS.add(campaignWSDTO);
        }

        response.setCampaigns(campaignWSDTOS);
        general.setOperation("apiGetCampaign");
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
