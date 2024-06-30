package com.faas.core.base.middleware.campaign.details.channel.temp;

import com.faas.core.base.framework.campaign.details.channel.temp.CampaignTempFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.temp.CampaignTempWSModel;
import com.faas.core.base.model.ws.campaign.details.channel.temp.dto.CampaignTempWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CampaignTempMiddleware {


    @Autowired
    CampaignTempFramework campaignTempFramework;


    public CampaignTempWSModel getCampaignTemps(long userId, String campaignId) {

        CampaignTempWSModel response = new CampaignTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignTempWSDTO campaignTempWSDTO = campaignTempFramework.getCampaignTempsService(userId,campaignId);
        if (campaignTempWSDTO != null){
            response.setCampaignTemp(campaignTempWSDTO);
        }

        general.setOperation("getCampaignTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
