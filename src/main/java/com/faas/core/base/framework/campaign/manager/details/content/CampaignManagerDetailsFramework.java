package com.faas.core.base.framework.campaign.manager.details.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.campaign.manager.details.content.dto.CampaignManagerDetailsWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.campaign.CampaignHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CampaignManagerDetailsFramework {


    @Autowired
    CampaignHelpers campaignHelpers;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignManagerDetailsWSDTO getCampaignManagerDetailsService(long userId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            return campaignHelpers.getCampaignManagerDetailsWSDTO(campaignDBModel.get());
        }
        return null;
    }


}
