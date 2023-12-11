package com.faas.core.base.framework.manager.campaign.details;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.manager.campaign.details.dto.CampaignManagerDetailsWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.AutomaticHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CampaignManagerDetailsFramework {

    @Autowired
    AutomaticHelper automaticHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignManagerDetailsWSDTO getAutomaticCampaignsService(long userId) {

        return null;
    }



}
