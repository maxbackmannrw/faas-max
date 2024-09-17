package com.faas.core.base.framework.campaign.details.trigger.content;

import com.faas.core.base.model.ws.campaign.details.trigger.content.dto.CampaignTriggerWSDTO;
import com.faas.core.misc.helpers.campaign.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignTriggerFramework {


    @Autowired
    CampaignHelper campaignHelper;


    public CampaignTriggerWSDTO getCampaignTriggersService(long userId, String campaignId) {

        return campaignHelper.getCampaignTriggerWSDTO(campaignId);
    }


}
