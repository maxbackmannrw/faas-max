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
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.campaign.CampaignHelpers;
import com.faas.core.utility.helpers.operation.OperationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiCampaignDetailsFramework {

    @Autowired
    CampaignHelpers campaignHelpers;

    @Autowired
    OperationHelpers operationHelpers;

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


    public ApiCampaignDetailsWSDTO apiGetCampaignDetailsService(long agentId,String campaignId,int reqPage,int reqSize) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignAgentRepository.existsByAgentIdAndCampaignId(agentId,campaignId) && campaignDBModel.isPresent()){
            Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.get().getProcessId());
            if (processDBModel.isPresent()){

                ApiCampaignDetailsWSDTO campaignDetailsWSDTO = new ApiCampaignDetailsWSDTO();
                campaignDetailsWSDTO.setCampaign(campaignDBModel.get());
                campaignDetailsWSDTO.setCampaignProcess(campaignHelpers.getApiCampaignProcessWSDTO(processDBModel.get()));
                campaignDetailsWSDTO.setActiveOperation(operationHelpers.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.ACTIVE_STATE,PageRequest.of(reqPage,reqSize))));

                if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.MANUAL_CAMPAIGN)){
                    campaignDetailsWSDTO.setReadyOperation(operationHelpers.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.READY_STATE,PageRequest.of(reqPage,reqSize))));
                }
                if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){
                    campaignDetailsWSDTO.setReadyOperation(operationHelpers.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndCampaignIdAndOperationStateAndOperationInquiryState(agentId,campaignId,AppConstant.READY_STATE,AppConstant.NEW_STATE,PageRequest.of(reqPage,reqSize))));
                }
                if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)){
                    campaignDetailsWSDTO.setReadyOperation(operationHelpers.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndCampaignIdAndOperationStateAndOperationFlowState(agentId,campaignId,AppConstant.READY_STATE,AppConstant.NEW_STATE,PageRequest.of(reqPage,reqSize))));
                }
                return campaignDetailsWSDTO;
            }
        }
        return null;
    }


    public List<ApiSummaryWSDTO> apiGetCampaignSummaryService(long agentId, String campaignId) {

        List<ApiSummaryWSDTO> campaignSummaries = new ArrayList<>();
        campaignSummaries.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.ACTIVE_STATE))));
        campaignSummaries.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATIONS_SUMMARY,String.valueOf(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.READY_STATE ))));
        campaignSummaries.add(new ApiSummaryWSDTO(AppConstant.AGENT_ALL_OPERATIONS_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndCampaignId(agentId,campaignId))));

        return campaignSummaries;
    }


    public ApiCampaignProcessWSDTO apiGetCampaignProcessService(long agentId, String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignAgentRepository.existsByAgentIdAndCampaignId(agentId,campaignId) && campaignDBModel.isPresent()){
            Optional<ProcessDBModel> processDBModel = processRepository.findById(campaignDBModel.get().getProcessId());
            if (processDBModel.isPresent()){
                return campaignHelpers.getApiCampaignProcessWSDTO(processDBModel.get());
            }
        }
        return null;
    }



}
