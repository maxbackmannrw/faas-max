package com.faas.core.base.framework.campaign.details.channel.temp;

import com.faas.core.base.model.ws.campaign.details.channel.temp.dto.CampaignTempWSDTO;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.campaign.CampaignHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CampaignTempFramework {


    @Autowired
    CampaignHelpers campaignHelpers;

    @Autowired
    AppUtils appUtils;


    public CampaignTempWSDTO getCampaignTempsService(long userId, String campaignId) {

        return campaignHelpers.createCampaignTempWSDTO(campaignId);
    }


}
