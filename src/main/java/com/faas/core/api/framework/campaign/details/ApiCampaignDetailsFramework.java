package com.faas.core.api.framework.campaign.details;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignProcessWSDTO;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiCampaignDetailsFramework {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    AppUtils appUtils;


    public ApiCampaignDetailsWSDTO apiGetCampaignDetailsService(long agentId,String campaignId) {

        return null;
    }


    public ApiCampaignProcessWSDTO apiGetCampaignProcessService(long agentId, String campaignId) {

        return null;
    }


}
