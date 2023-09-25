package com.faas.core.api.middleware.campaign.process;

import com.faas.core.api.framework.campaign.process.ApiCampaignProcessFramework;
import com.faas.core.api.model.ws.campaign.process.ApiProcessDetailsWSModel;
import com.faas.core.api.model.ws.campaign.process.ApiProcessWSModel;
import com.faas.core.api.model.ws.campaign.process.dto.ApiProcessDetailsWSDTO;
import com.faas.core.api.model.ws.campaign.process.dto.ApiProcessWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiCampaignProcessMiddleware {


    @Autowired
    ApiCampaignProcessFramework apiCampaignProcessFramework;


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

    public ApiProcessDetailsWSModel apiGetCampaignProcessDetails(long agentId, String campaignId, String processId) {

        ApiProcessDetailsWSModel response = new ApiProcessDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiProcessDetailsWSDTO> processDetailsWSDTOS = new ArrayList<>();


        response.setProcessDetails(processDetailsWSDTOS);
        general.setOperation("apiGetCampaignProcessDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
