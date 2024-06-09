package com.faas.core.base.middleware.manager.campaign.details;

import com.faas.core.base.framework.manager.campaign.details.CampaignManagerDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.campaign.details.CampaignManagerDetailsWSModel;
import com.faas.core.base.model.ws.manager.campaign.details.dto.CampaignManagerDetailsWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CampaignManagerDetailsMiddleware {


    @Autowired
    CampaignManagerDetailsFramework campaignManagerDetailsFramework;


    public CampaignManagerDetailsWSModel getCampaignManagerDetails(long userId, String campaignId) {

        CampaignManagerDetailsWSModel response = new CampaignManagerDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignManagerDetailsWSDTO campaignManagerDetailsWSDTO = campaignManagerDetailsFramework.getCampaignManagerDetailsService(userId,campaignId);
        if (campaignManagerDetailsWSDTO != null){
            response.setCampaignManagerDetails(campaignManagerDetailsWSDTO);
        }

        general.setOperation("getCampaignManagerDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
