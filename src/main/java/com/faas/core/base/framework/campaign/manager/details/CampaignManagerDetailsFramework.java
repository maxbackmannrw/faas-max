package com.faas.core.base.framework.campaign.manager.details;

import com.faas.core.base.model.ws.campaign.manager.details.dto.CampaignManagerDetailsWSDTO;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.campaign.CampaignHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignManagerDetailsFramework {


    @Autowired
    CampaignHelpers campaignHelpers;

    @Autowired
    AppUtils appUtils;


    public CampaignManagerDetailsWSDTO getCampaignManagerDetailsService(long userId,String campaignId) {

        CampaignManagerDetailsWSDTO campaignManagerDetailsWSDTO = new CampaignManagerDetailsWSDTO();

        return null;
    }




}
