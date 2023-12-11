package com.faas.core.base.framework.manager.campaign.content;

import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.AutomaticHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CampaignManagerFramework {

    @Autowired
    AutomaticHelper automaticHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignManagerWSDTO getAutomaticCampaignsService(long userId) {


        return null;
    }



}
