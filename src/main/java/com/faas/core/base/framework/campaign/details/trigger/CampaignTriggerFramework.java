package com.faas.core.base.framework.campaign.details.trigger;

import com.faas.core.base.model.ws.campaign.details.trigger.dto.*;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.campaign.CampaignHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignTriggerFramework {


    @Autowired
    CampaignHelpers campaignHelpers;

    @Autowired
    AppUtils appUtils;


    public CampaignTriggerWSDTO getCampaignTriggersService(long userId, String campaignId) {

        return campaignHelpers.createCampaignTriggerWSDTO(campaignId);
    }




}
