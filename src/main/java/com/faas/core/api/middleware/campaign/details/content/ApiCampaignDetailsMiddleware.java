package com.faas.core.api.middleware.campaign.details.content;

import com.faas.core.api.framework.campaign.details.content.ApiCampaignDetailsFramework;
import com.faas.core.api.model.ws.campaign.details.ApiCampaignDetailsWSModel;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiCampaignDetailsMiddleware {


    @Autowired
    ApiCampaignDetailsFramework apiCampaignDetailsFramework;


    public ApiCampaignDetailsWSModel apiGetCampaignDetails(long agentId,String campaignId,int reqPage,int reqSize) {

        ApiCampaignDetailsWSModel response = new ApiCampaignDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiCampaignDetailsWSDTO campaignDetailsWSDTO = apiCampaignDetailsFramework.apiGetCampaignDetailsService(agentId,campaignId,reqPage,reqSize);
        if (campaignDetailsWSDTO != null) {
            response.setCampaignDetails(campaignDetailsWSDTO);
        }

        general.setOperation("getAgentCampaignDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSummaryWSModel apiGetCampaignSummary(long agentId,String campaignId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSummaryWSDTO> campaignDetailsSummary = apiCampaignDetailsFramework.apiGetCampaignSummaryService(agentId,campaignId);
        if (campaignDetailsSummary != null) {
            response.setSummaries(campaignDetailsSummary);
        }

        general.setOperation("apiGetCampaignSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }








}
