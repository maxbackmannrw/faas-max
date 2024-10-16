package com.faas.core.api.framework.campaign.details;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignScenarioWSDTO;
import com.faas.core.api.model.ws.general.dto.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiValidateOperationWSDTO;
import com.faas.core.data.db.campaign.content.CampaignDBModel;
import com.faas.core.data.db.campaign.details.agent.CampaignAgentDBModel;
import com.faas.core.data.db.campaign.details.scenario.CampaignScenarioDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.data.repo.campaign.details.remote.CampaignRemoteRepository;
import com.faas.core.data.repo.campaign.details.scenario.CampaignScenarioRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.helpers.campaign.CampaignHelper;
import com.faas.core.misc.helpers.operation.content.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CampaignScenarioRepository campaignScenarioRepository;

    @Autowired
    CampaignRemoteRepository campaignRemoteRepository;


    public ApiCampaignDetailsWSDTO apiGetCampaignDetailsService(long agentId, String campaignId) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByIdAndCampaignState(campaignId,AppConstant.ACTIVE_CAMPAIGN);
        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByCampaignIdAndAgentIdAndAgentState(campaignId,agentId,AppConstant.ACTIVE_STATE);
        if (!campaignDBModels.isEmpty() && !campaignAgentDBModels.isEmpty()){

            ApiCampaignDetailsWSDTO campaignDetailsWSDTO = new ApiCampaignDetailsWSDTO();
            campaignDetailsWSDTO.setCampaign(campaignHelper.getApiCampaignWSDTO(agentId,campaignDBModels.get(0)));
            campaignDetailsWSDTO.setCampaignScenarios(campaignScenarioRepository.findByCampaignId(campaignId));
            campaignDetailsWSDTO.setCampaignRemotes(campaignRemoteRepository.findByCampaignId(campaignId));
            campaignDetailsWSDTO.setReadyOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.READY_STATE, PageRequest.of(0,20 ))));
            campaignDetailsWSDTO.setActiveOperation(operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,AppConstant.ACTIVE_STATE, PageRequest.of(0,20 ))));

            return campaignDetailsWSDTO;
        }
        return null;
    }

    public List<ApiCampaignScenarioWSDTO> apiGetCampaignScenariosService(long agentId,String campaignId) {

        List<ApiCampaignScenarioWSDTO> campaignScenarioWSDTOS = new ArrayList<>();
        List<CampaignScenarioDBModel> campaignScenarioDBModels = campaignScenarioRepository.findByCampaignId(campaignId);
        for (CampaignScenarioDBModel campaignScenarioDBModel : campaignScenarioDBModels) {
            campaignScenarioWSDTOS.add(new ApiCampaignScenarioWSDTO(campaignScenarioDBModel));
        }
        return campaignScenarioWSDTOS;
    }

    public ApiCampaignScenarioWSDTO apiGetCampaignScenarioService(long agentId,String campaignId,String scenarioId) {

        ApiCampaignScenarioWSDTO campaignScenarioWSDTO = new ApiCampaignScenarioWSDTO();
        List<CampaignScenarioDBModel> campaignScenarioDBModels =campaignScenarioRepository.findByCampaignIdAndScenarioId(campaignId,scenarioId);
        if (!campaignScenarioDBModels.isEmpty()) {
            campaignScenarioWSDTO.setCampaignScenario(campaignScenarioDBModels.get(0));
        }
        return campaignScenarioWSDTO;
    }

    public ApiOperationListWSDTO apiGetCampaignOperationsService(long agentId, String campaignId, String operationState, int reqPage, int reqSize) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByIdAndCampaignState(campaignId,AppConstant.ACTIVE_CAMPAIGN);
        List<CampaignAgentDBModel> campaignAgentDBModels = campaignAgentRepository.findByCampaignIdAndAgentIdAndAgentState(campaignId,agentId,AppConstant.ACTIVE_STATE);
        if (!campaignDBModels.isEmpty() && !campaignAgentDBModels.isEmpty()){
            return operationHelper.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,operationState, PageRequest.of(reqPage,reqSize)));
        }
        return null;
    }

    public ApiOperationWSDTO apiGetCampaignOperationService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            return operationHelper.getApiOperationWSDTO(operationDBModels.get(0));
        }
        return null;
    }

    public ApiValidateOperationWSDTO apiValidateCampaignOperationService(long agentId, String operationId) {

        Optional<UserDBModel> userDBModel = userRepository.findById(agentId);
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (userDBModel.isPresent() && !operationDBModels.isEmpty()) {
            userDBModel.get().setPassword("");
            return operationHelper.validateOperationHelper(userDBModel.get(), operationDBModels.get(0));
        }
        return null;
    }

    public List<ApiSummaryWSDTO> apiGetCampaignDetailsSummaryService(long agentId, String campaignId) {

        List<ApiSummaryWSDTO> campaignDetailsSummary = new ArrayList<>();
        campaignDetailsSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_ACTIVE_OPERATION_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId, campaignId, AppConstant.ACTIVE_STATE))));
        campaignDetailsSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_READY_OPERATION_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndCampaignIdAndOperationState(agentId, campaignId, AppConstant.READY_STATE))));
        campaignDetailsSummary.add(new ApiSummaryWSDTO(AppConstant.AGENT_TOTAL_OPERATION_SUMMARY, String.valueOf(operationRepository.countByAgentIdAndCampaignId(agentId, campaignId))));

        return campaignDetailsSummary;
    }


}