package com.faas.core.api.framework.campaign.content;

import com.faas.core.data.ws.api.campaign.content.dto.ApiAgentCampaignWSDTO;
import com.faas.core.data.ws.api.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.data.ws.api.general.ApiSummaryWSDTO;
import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.details.agent.CampaignAgentDBModel;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.campaign.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiCampaignFramework {


    @Autowired
    CampaignHelper campaignHelper;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentCampaignWSDTO apiGetAgentCampaignsService(long agentId) {

        ApiAgentCampaignWSDTO agentCampaignWSDTO = new ApiAgentCampaignWSDTO();
        List<ApiCampaignWSDTO> manualCampaigns = new ArrayList<>();
        List<ApiCampaignWSDTO> inquiryCampaigns = new ArrayList<>();

        List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel campaignAgent : campaignAgents) {
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignAgent.getCampaignId());
            if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.MANUAL_CAMPAIGN)) {
            }
            if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)) {
            }
        }
        agentCampaignWSDTO.setManualCampaigns(manualCampaigns);
        agentCampaignWSDTO.setInquiryCampaigns(inquiryCampaigns);

        return agentCampaignWSDTO;
    }

    public List<ApiCampaignWSDTO> apiGetCampaignsService(long agentId, String campaignCategory) {

        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel campaignAgent : campaignAgents) {
            Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignAgent.getCampaignId());
            if (campaignDBModel.isPresent()) {
                if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(campaignCategory) || campaignCategory.equalsIgnoreCase(AppConstant.ALL_CAMPAIGNS)) {
                    campaignWSDTOS.add(campaignHelper.getApiCampaignWSDTO(agentId, campaignDBModel.get()));
                }
            }
        }
        return campaignWSDTOS;
    }

    public ApiCampaignWSDTO getApiCampaignService(long agentId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            return campaignHelper.getApiCampaignWSDTO(agentId, campaignDBModel.get());
        }
        return null;
    }

    public List<ApiSummaryWSDTO> apiGetCampaignsSummaryService(long agentId) {

        List<ApiSummaryWSDTO> agentCampaignSummary = new ArrayList<>();
        agentCampaignSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ALL_CAMPAIGNS_SUMMARY, String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        agentCampaignSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE))));
        agentCampaignSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId, AppConstant.READY_STATE))));

        return agentCampaignSummary;
    }


}
