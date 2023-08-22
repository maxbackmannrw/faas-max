package com.faas.core.api.middleware.campaign.details.process.content;

import com.faas.core.api.framework.campaign.details.process.content.ApiCampaignProcessFramework;
import com.faas.core.api.model.ws.campaign.details.process.content.ApiProcessWSModel;
import com.faas.core.api.model.ws.campaign.details.process.content.dto.ApiProcessWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiCampaignProcessMiddleware {

    @Autowired
    ApiCampaignProcessFramework apiCampaignProcessFramework;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;


    public ApiProcessWSModel apiGetAgentCampaignProcesses(long agentId) {

        ApiProcessWSModel response = new ApiProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiProcessWSDTO> apiProcessWSDTOS = new ArrayList<>();



        response.setProcesses(apiProcessWSDTOS);
        general.setOperation("apiGetAgentCampaignProcesses");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiProcessWSModel apiGetCampaignProcesses(long agentId, String campaignId, String processId) {

        ApiProcessWSModel response = new ApiProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiProcessWSDTO> apiProcessWSDTOS = new ArrayList<>();



        response.setProcesses(apiProcessWSDTOS);
        general.setOperation("apiGetCampaignProcesses");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiProcessWSModel apiGetCampaignProcess(long agentId, String campaignId, String processId) {

        ApiProcessWSModel response = new ApiProcessWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiProcessWSDTO> apiProcessWSDTOS = new ArrayList<>();



        response.setProcesses(apiProcessWSDTOS);
        general.setOperation("apiGetCampaignProcess");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





}
