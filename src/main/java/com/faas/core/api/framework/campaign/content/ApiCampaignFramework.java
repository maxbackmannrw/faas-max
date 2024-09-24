package com.faas.core.api.framework.campaign.content;

import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignListWSDTO;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.general.dto.ApiSummaryWSDTO;
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


    public ApiCampaignListWSDTO apiGetAgentCampaignListService(long agentId) {

        ApiCampaignListWSDTO campaignListWSDTO = new ApiCampaignListWSDTO();
        List<ApiCampaignWSDTO> manualCampaigns = new ArrayList<>();
        List<ApiCampaignWSDTO> inquiryCampaigns = new ArrayList<>();

        List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel campaignAgent : campaignAgents) {
            if (campaignAgent.getAgentState().equalsIgnoreCase(AppConstant.ACTIVE_STATE)){
                Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignAgent.getCampaignId());
                if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignState().equalsIgnoreCase(AppConstant.ACTIVE_CAMPAIGN)) {
                    if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.MANUAL_CAMPAIGN)){
                        manualCampaigns.add(campaignHelper.getApiCampaignWSDTO(agentId,campaignDBModel.get()));
                    }
                    if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){
                        inquiryCampaigns.add(campaignHelper.getApiCampaignWSDTO(agentId,campaignDBModel.get()));
                    }
                }
            }
        }
        campaignListWSDTO.setManualCampaigns(manualCampaigns);
        campaignListWSDTO.setInquiryCampaigns(inquiryCampaigns);

        return campaignListWSDTO;
    }

    public List<ApiCampaignWSDTO> apiGetAgentCampaignsService(long agentId,String campaignCategory) {

        List<ApiCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByAgentId(agentId);
        for (CampaignAgentDBModel campaignAgent : campaignAgents) {
            if (campaignAgent.getAgentState().equalsIgnoreCase(AppConstant.ACTIVE_STATE)){
                List<CampaignDBModel> campaignDBModels = campaignRepository.findByIdAndCampaignCategoryAndCampaignState(campaignAgent.getCampaignId(),campaignCategory,AppConstant.ACTIVE_CAMPAIGN);
                if (!campaignDBModels.isEmpty() && campaignDBModels.get(0).getCampaignState().equalsIgnoreCase(AppConstant.ACTIVE_STATE)){
                    campaignWSDTOS.add(campaignHelper.getApiCampaignWSDTO(agentId,campaignDBModels.get(0)));
                }
            }
        }
        return campaignWSDTOS;
    }

    public ApiCampaignWSDTO apiGetAgentCampaignService(long agentId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            return campaignHelper.getApiCampaignWSDTO(agentId, campaignDBModel.get());
        }
        return null;
    }

    public List<ApiSummaryWSDTO> apiGetAgentCampaignsSummaryService(long agentId) {

        List<ApiSummaryWSDTO> agentCampaignSummary = new ArrayList<>();
        agentCampaignSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATION_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE))));
        agentCampaignSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATION_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId, AppConstant.READY_STATE))));
        agentCampaignSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_TOTAL_CAMPAIGN_SUMMARY, String.valueOf(campaignAgentRepository.countByAgentId(agentId))));

        return agentCampaignSummary;
    }


}
