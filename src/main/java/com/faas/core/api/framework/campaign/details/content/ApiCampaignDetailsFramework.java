package com.faas.core.api.framework.campaign.details.content;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignProcessWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.CampaignHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiCampaignDetailsFramework {

    @Autowired
    CampaignHelper campaignHelper;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    AppUtils appUtils;


    public ApiCampaignDetailsWSDTO apiGetCampaignDetailsService(long agentId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignAgentRepository.existsByAgentIdAndCampaignId(agentId,campaignId) && campaignDBModel.isPresent()){
            return campaignHelper.getApiCampaignDetailsWSDTO(campaignDBModel.get());
        }
        return null;
    }


    public List<ApiSummaryWSDTO> apiGetCampaignDetailsSummaryService(long agentId, String campaignId) {

        List<ApiSummaryWSDTO> campaignDetailsSummary = new ArrayList<>();
        campaignDetailsSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.ACTIVE_STATE))));
        campaignDetailsSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATIONS_SUMMARY,String.valueOf(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.READY_STATE ))));
        campaignDetailsSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ALL_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndCampaignId(agentId,campaignId))));

        return campaignDetailsSummary;
    }


    public ApiCampaignProcessWSDTO apiGetCampaignProcessService(long agentId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignAgentRepository.existsByAgentIdAndCampaignId(agentId,campaignId) && campaignDBModel.isPresent()){
            Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.get().getProcessId());
            if (processDBModel.isPresent()){
                return campaignHelper.getApiCampaignProcessWSDTO(processDBModel.get());
            }
        }
        return null;
    }



}
