package com.faas.core.base.middleware.campaign.details.trigger.content;

import com.faas.core.base.framework.campaign.details.trigger.content.CampaignTriggerFramework;
import com.faas.core.base.model.ws.campaign.details.trigger.content.dto.CampaignTriggerWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.trigger.content.CampaignTriggerWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CampaignTriggerMiddleware {


    @Autowired
    CampaignTriggerFramework campaignTriggerFramework;


    public CampaignTriggerWSModel getCampaignTriggers(long userId, String campaignId) {

        CampaignTriggerWSModel response = new CampaignTriggerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignTriggerWSDTO campaignTriggerWSDTO = campaignTriggerFramework.getCampaignTriggersService(userId,campaignId);
        if (campaignTriggerWSDTO != null){
            response.setCampaignTrigger(campaignTriggerWSDTO);
        }

        general.setOperation("getCampaignTriggers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
