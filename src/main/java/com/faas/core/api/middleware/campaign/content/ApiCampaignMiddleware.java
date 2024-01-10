package com.faas.core.api.middleware.campaign.content;

import com.faas.core.api.framework.campaign.content.ApiCampaignFramework;
import com.faas.core.api.model.ws.campaign.content.ApiAgentCampaignWSModel;
import com.faas.core.api.model.ws.campaign.content.ApiCampaignWSModel;
import com.faas.core.api.model.ws.campaign.content.dto.ApiAgentCampaignWSDTO;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiCampaignMiddleware {

    @Autowired
    ApiCampaignFramework apiCampaignFramework;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentCampaignWSModel apiGetAgentCampaigns(long agentId) {

        ApiAgentCampaignWSModel response = new ApiAgentCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentCampaignWSDTO agentCampaignWSDTO = apiCampaignFramework.apiGetAgentCampaignsService(agentId);
        if (agentCampaignWSDTO != null){
            response.setAgentCampaign(agentCampaignWSDTO);
        }

        general.setOperation("apiGetAgentCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiCampaignWSModel apiGetCampaigns(long agentId,String campaignCategory) {

        ApiCampaignWSModel response = new ApiCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiCampaignWSDTO> apiCampaignWSDTOS = apiCampaignFramework.apiGetCampaignsService(agentId,campaignCategory);
        if (apiCampaignWSDTOS != null){
            response.setCampaigns(apiCampaignWSDTOS);
        }

        general.setOperation("apiGetCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiCampaignWSModel apiGetCampaign(long agentId,String campaignId) {

        ApiCampaignWSModel response = new ApiCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();

        ApiCampaignWSDTO campaignWSDTO = apiCampaignFramework.getApiCampaignService(agentId,campaignId);
        if (campaignWSDTO != null){
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



    public ApiSummaryWSModel apiGetAgentCampaignSummary(long agentId) {

        ApiSummaryWSModel response = new ApiSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSummaryWSDTO> summaryWSDTOS = apiCampaignFramework.apiGetAgentCampaignSummaryService(agentId);
        if (summaryWSDTOS != null){
            response.setSummaries(summaryWSDTOS);
        }

        general.setOperation("apiGetAgentCampaignSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
