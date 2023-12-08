package com.faas.core.base.framework.manager.operation.details.automatic;

import com.faas.core.base.model.ws.manager.campaign.content.dto.OperationCampaignWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AutomaticOperationFramework {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public List<OperationCampaignWSDTO> getAutomaticOperationDetailsService(long userId) {

        return null;
    }



}
