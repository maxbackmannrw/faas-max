package com.faas.core.base.framework.manager.operation.content;

import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class OperationManagerFramework {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public List<CampaignManagerWSDTO> getAutomaticOperationDetailsService(long userId) {

        return null;
    }



}
