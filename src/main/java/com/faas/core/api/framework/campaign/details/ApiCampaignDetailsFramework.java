package com.faas.core.api.framework.campaign.details;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignProcessWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiCampaignDetailsFramework {


    @Autowired
    CampaignHelper campaignHelper;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;


    public ApiCampaignDetailsWSDTO apiGetCampaignDetailsService(long agentId,String campaignId) {

        return null;
    }


    public List<ApiSummaryWSDTO> apiGetAgentCampaignSummaryService(long agentId) {

        List<ApiSummaryWSDTO> agentCampaignSummary = new ArrayList<>();
        agentCampaignSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ALL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        agentCampaignSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId,AppConstant.ACTIVE_STATE))));
        agentCampaignSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId,AppConstant.READY_STATE))));

        return agentCampaignSummary;
    }


    public ApiCampaignProcessWSDTO apiGetCampaignProcessService(long agentId, String campaignId) {

        return null;
    }


}
