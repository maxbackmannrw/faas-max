package com.faas.core.api.middleware.campaign.details.process;

import com.faas.core.api.framework.campaign.details.process.ApiCampaignProcessDetailsFramework;
import com.faas.core.api.model.ws.campaign.details.process.details.ApiProcessDetailsWSModel;
import com.faas.core.api.model.ws.campaign.details.process.details.dto.ApiProcessDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiCampaignProcessDetailsMiddleware {


    @Autowired
    ApiCampaignProcessDetailsFramework apiCampaignProcessDetailsFramework;

    @Autowired
    AppUtils appUtils;


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
