package com.faas.core.base.middleware.campaign.manager.details.content;

import com.faas.core.base.framework.campaign.manager.details.content.CampaignManagerDetailsFramework;
import com.faas.core.base.model.ws.campaign.manager.details.content.CampaignManagerDetailsWSModel;
import com.faas.core.base.model.ws.campaign.manager.details.content.dto.CampaignManagerDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CampaignManagerDetailsMiddleware {


    @Autowired
    CampaignManagerDetailsFramework campaignManagerDetailsFramework;


    public CampaignManagerDetailsWSModel getCampaignManagerDetails(long userId,String campaignId) {

        CampaignManagerDetailsWSModel response = new CampaignManagerDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignManagerDetailsWSDTO campaignManagerDetailsWSDTO = campaignManagerDetailsFramework.getCampaignManagerDetailsService(userId,campaignId);
        if(campaignManagerDetailsWSDTO != null){
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
