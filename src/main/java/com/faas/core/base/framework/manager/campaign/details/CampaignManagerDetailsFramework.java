package com.faas.core.base.framework.manager.campaign.details;

import com.faas.core.base.model.ws.manager.campaign.details.dto.CampaignManagerDetailsWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.manager.ManagerHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CampaignManagerDetailsFramework {


    @Autowired
    ManagerHelpers managerHelpers;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignManagerDetailsWSDTO getCampaignManagerDetailsService(long userId, String campaignId) {

        return null;
    }



}
