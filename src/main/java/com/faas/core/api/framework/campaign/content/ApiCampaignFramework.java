package com.faas.core.api.framework.campaign.content;

import com.faas.core.api.model.ws.campaign.content.dto.ApiAgentCampaignWSDTO;
import com.faas.core.api.model.ws.campaign.content.dto.ApiCampaignWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.campaign.details.CampaignAgentDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.CampaignHelper;
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
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

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
                manualCampaigns.add(campaignHelper.getApiCampaignWSDTO(agentId,campaignDBModel.get()));
            }
            if (campaignDBModel.isPresent() && campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)) {
                inquiryCampaigns.add(campaignHelper.getApiCampaignWSDTO(agentId,campaignDBModel.get()));
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
                    campaignWSDTOS.add(campaignHelper.getApiCampaignWSDTO(agentId,campaignDBModel.get()));
                }
            }
        }
        return campaignWSDTOS;
    }

    public ApiCampaignWSDTO getApiCampaignService(long agentId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()) {
            return campaignHelper.getApiCampaignWSDTO(agentId,campaignDBModel.get());
        }
        return null;
    }

    public List<ApiSummaryWSDTO> apiGetCampaignSummaryService(long agentId) {

        List<ApiSummaryWSDTO> agentCampaignSummary = new ArrayList<>();
        agentCampaignSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ALL_CAMPAIGNS_SUMMARY,String.valueOf(campaignAgentRepository.countByAgentId(agentId))));
        agentCampaignSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId,AppConstant.ACTIVE_STATE))));
        agentCampaignSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndOperationState(agentId,AppConstant.READY_STATE))));

        return agentCampaignSummary;
    }


}
