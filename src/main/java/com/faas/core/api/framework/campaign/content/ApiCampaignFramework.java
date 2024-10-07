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
import com.faas.core.misc.helpers.campaign.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


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


    public ApiCampaignListWSDTO apiGetAgentCampaignListService(long agentId) {

        ApiCampaignListWSDTO agentCampaignList = new ApiCampaignListWSDTO();
        List<ApiCampaignWSDTO> agentManualCampaigns = new ArrayList<>();
        List<ApiCampaignWSDTO> agentInquiryCampaigns = new ArrayList<>();

        List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByAgentIdAndAgentState(agentId,AppConstant.ACTIVE_STATE);
        for (CampaignAgentDBModel campaignAgent : campaignAgents) {
            List<CampaignDBModel> campaignDBModels = campaignRepository.findByIdAndCampaignState(campaignAgent.getCampaignId(),AppConstant.ACTIVE_CAMPAIGN);
            if (!campaignDBModels.isEmpty()) {
                if (campaignDBModels.get(0).getCampaignCategory().equalsIgnoreCase(AppConstant.MANUAL_CAMPAIGN)){
                    agentManualCampaigns.add(campaignHelper.getApiCampaignWSDTO(agentId,campaignDBModels.get(0)));
                }
                if (campaignDBModels.get(0).getCampaignCategory().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){
                    agentInquiryCampaigns.add(campaignHelper.getApiCampaignWSDTO(agentId,campaignDBModels.get(0)));
                }
            }
        }
        agentCampaignList.setManualCampaigns(agentManualCampaigns);
        agentCampaignList.setInquiryCampaigns(agentInquiryCampaigns);

        return agentCampaignList;
    }

    public List<ApiCampaignWSDTO> apiGetAgentCampaignsService(long agentId,String campaignCategory) {

        List<ApiCampaignWSDTO> agentCampaigns = new ArrayList<>();
        List<CampaignAgentDBModel> campaignAgents = campaignAgentRepository.findByAgentIdAndAgentState(agentId,AppConstant.ACTIVE_STATE);
        for (CampaignAgentDBModel campaignAgent : campaignAgents) {
            List<CampaignDBModel> campaignDBModels = campaignRepository.findByIdAndCampaignCategoryAndCampaignState(campaignAgent.getCampaignId(),campaignCategory,AppConstant.ACTIVE_CAMPAIGN);
            if (!campaignDBModels.isEmpty()){
                agentCampaigns.add(campaignHelper.getApiCampaignWSDTO(agentId,campaignDBModels.get(0)));
            }
        }
        return agentCampaigns;
    }

    public ApiCampaignWSDTO apiGetAgentCampaignService(long agentId, String campaignId) {

        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByCampaignIdAndAgentIdAndAgentState(campaignId,agentId,AppConstant.ACTIVE_STATE);
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByIdAndCampaignState(campaignId,AppConstant.ACTIVE_CAMPAIGN);
        if (!campaignAgentDBModels.isEmpty() && !campaignDBModels.isEmpty()) {
            return campaignHelper.getApiCampaignWSDTO(agentId, campaignDBModels.get(0));
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
