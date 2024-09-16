package com.faas.core.api.framework.campaign.details.content;

import com.faas.core.data.ws.api.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.data.ws.api.general.ApiSummaryWSDTO;
import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.data.repo.campaign.details.scenario.CampaignScenarioRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.operation.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiCampaignDetailsFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignScenarioRepository campaignScenarioRepository;

    @Autowired
    AppUtils appUtils;


    public ApiCampaignDetailsWSDTO apiGetCampaignDetailsService(long agentId, String campaignId, int reqPage, int reqSize) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);

        return null;
    }

    public List<ApiSummaryWSDTO> apiGetCampaignSummaryService(long agentId, String campaignId) {

        List<ApiSummaryWSDTO> campaignSummaries = new ArrayList<>();
        campaignSummaries.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId, campaignId, AppConstant.ACTIVE_STATE))));
        campaignSummaries.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId, campaignId, AppConstant.READY_STATE))));
        campaignSummaries.add(new ApiSummaryWSDTO(AppConstant.AGENT_ALL_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndCampaignId(agentId, campaignId))));

        return campaignSummaries;
    }


}
