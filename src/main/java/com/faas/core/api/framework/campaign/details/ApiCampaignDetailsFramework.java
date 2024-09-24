package com.faas.core.api.framework.campaign.details;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.general.dto.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiValidateOperationWSDTO;
import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.details.agent.CampaignAgentDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.helpers.campaign.CampaignHelper;
import com.faas.core.misc.helpers.operation.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiCampaignDetailsFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    CampaignHelper campaignHelper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;


    public ApiCampaignDetailsWSDTO apiGetAgentCampaignDetailsService(long agentId, String campaignId) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByIdAndCampaignState(campaignId,AppConstant.ACTIVE_CAMPAIGN);
        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByCampaignIdAndAgentIdAndAgentState(campaignId,agentId,AppConstant.ACTIVE_STATE);
        if (!campaignDBModels.isEmpty() && !campaignAgentDBModels.isEmpty()){

            ApiCampaignDetailsWSDTO agentCampaignDetails = new ApiCampaignDetailsWSDTO();
            agentCampaignDetails.setCampaign(campaignHelper.getApiCampaignWSDTO(agentId,campaignDBModels.get(0)));
            agentCampaignDetails.setReadyOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.READY_STATE, PageRequest.of(0,20 ))));
            agentCampaignDetails.setActiveOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.ACTIVE_STATE, PageRequest.of(0,20 ))));

            return agentCampaignDetails;
        }
        return null;
    }

    public ApiOperationListWSDTO apiGetAgentCampaignOperationsService(long agentId, String campaignId, String operationState, int reqPage, int reqSize) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByIdAndCampaignState(campaignId,AppConstant.ACTIVE_CAMPAIGN);
        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByCampaignIdAndAgentIdAndAgentState(campaignId,agentId,AppConstant.ACTIVE_STATE);
        if (!campaignDBModels.isEmpty() && !campaignAgentDBModels.isEmpty()){
            return operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,operationState, PageRequest.of(reqPage,reqSize)));
        }
        return null;
    }

    public ApiOperationWSDTO apiGetAgentCampaignOperationService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            return operationHelper.getApiOperationWSDTO(operationDBModels.get(0));
        }
        return null;
    }

    public ApiValidateOperationWSDTO apiValidateAgentCampaignOperationService(long agentId, String operationId) {

        Optional<UserDBModel> userDBModel = userRepository.findById(agentId);
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (userDBModel.isPresent() && !operationDBModels.isEmpty()) {
            userDBModel.get().setPassword("");
            return operationHelper.validateOperationHelper(userDBModel.get(), operationDBModels.get(0));
        }
        return null;
    }

    public List<ApiSummaryWSDTO> apiGetAgentCampaignDetailsSummaryService(long agentId, String campaignId) {

        List<ApiSummaryWSDTO> agentCampaignDetailsSummary = new ArrayList<>();
        agentCampaignDetailsSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATION_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId, campaignId, AppConstant.ACTIVE_STATE))));
        agentCampaignDetailsSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATION_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId, campaignId, AppConstant.READY_STATE))));
        agentCampaignDetailsSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_TOTAL_OPERATION_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndCampaignId(agentId, campaignId))));

        return agentCampaignDetailsSummary;
    }


}