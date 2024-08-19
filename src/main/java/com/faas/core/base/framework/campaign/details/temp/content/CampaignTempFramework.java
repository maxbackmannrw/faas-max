package com.faas.core.base.framework.campaign.details.temp.content;

import com.faas.core.base.model.ws.campaign.details.temp.content.dto.CampaignTempWSDTO;
import com.faas.core.utility.helpers.campaign.CampaignHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CampaignTempFramework {


    @Autowired
    CampaignHelpers campaignHelpers;


    public CampaignTempWSDTO getCampaignTempsService(long userId, String campaignId) {

        return campaignHelpers.getCampaignTempWSDTO(campaignId);
    }


}
