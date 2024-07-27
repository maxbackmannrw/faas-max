package com.faas.core.base.middleware.campaign.manager.details;

import com.faas.core.base.framework.campaign.manager.details.CampaignManagerDetailsFramework;
import com.faas.core.base.model.ws.campaign.manager.details.CampaignManagerDetailsWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CampaignManagerDetailsMiddleware {


    @Autowired
    CampaignManagerDetailsFramework campaignManagerDetailsFramework;


    public CampaignManagerDetailsWSModel getCampaignManagerDetails(long userId) {

        CampaignManagerDetailsWSModel response = new CampaignManagerDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getCampaignManagerDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
