package com.faas.core.base.framework.campaign.details.trigger.content;

import com.faas.core.base.model.ws.campaign.details.trigger.content.dto.CampaignTriggerWSDTO;
import com.faas.core.utility.helpers.campaign.CampaignHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignTriggerFramework {


    @Autowired
    CampaignHelpers campaignHelpers;


    public CampaignTriggerWSDTO getCampaignTriggersService(long userId, String campaignId) {

        return campaignHelpers.getCampaignTriggerWSDTO(campaignId);
    }


}
