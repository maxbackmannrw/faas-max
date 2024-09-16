package com.faas.core.base.framework.campaign.details.temp.content;

import com.faas.core.data.ws.base.campaign.details.temp.content.dto.CampaignTempWSDTO;
import com.faas.core.misc.helpers.campaign.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CampaignTempFramework {


    @Autowired
    CampaignHelper campaignHelper;


    public CampaignTempWSDTO getCampaignTempsService(long userId, String campaignId) {

        return campaignHelper.getCampaignTempWSDTO(campaignId);
    }


}
