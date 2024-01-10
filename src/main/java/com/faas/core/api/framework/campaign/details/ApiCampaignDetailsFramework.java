package com.faas.core.api.framework.campaign.details;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignProcessWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiCampaignDetailsFramework {


    @Autowired
    CampaignHelper campaignHelper;


    @Autowired
    AppUtils appUtils;


    public ApiCampaignDetailsWSDTO apiGetCampaignDetailsService(long agentId,String campaignId) {

        return null;
    }


    public List<ApiSummaryWSDTO> apiGetAgentCampaignSummaryService(long agentId) {
        return campaignHelper.mapAgentCampaignSummary(agentId);
    }



    public ApiCampaignProcessWSDTO apiGetCampaignProcessService(long agentId, String campaignId) {

        return null;
    }


}
