package com.faas.core.api.framework.campaign.process;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiCampaignProcessFramework {


    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public ApiCampaignDetailsWSDTO getAgentCampaignDetailsService(long agentId, long campaignId) {

        return null;
    }


    public ApiCampaignDetailsWSDTO apiGetCampaignProcessDetailsService(long agentId, long campaignId) {

        return null;
    }





}
