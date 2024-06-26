package com.faas.core.api.framework.campaign.details.operation;

import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationValidateWSDTO;
import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.user.content.UserDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.campaign.details.scenario.CampaignScenarioRepository;
import com.faas.core.base.repo.user.content.UserRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.operation.OperationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ApiCampaignOperationFramework {

    @Autowired
    OperationHelpers operationHelpers;

    @Autowired
    UserRepository userRepository;

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


    public ApiOperationListWSDTO apiGetCampaignOperationsService(long agentId,String campaignId, String operationState, int reqPage, int reqSize) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            if (operationState.equalsIgnoreCase(AppConstant.READY_STATE)){
                if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.MANUAL_CAMPAIGN)){
                    return operationHelpers.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,operationState, PageRequest.of(reqPage,reqSize)));
                }
                if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.INQUIRY_CAMPAIGN)){
                }
                if (campaignDBModel.get().getCampaignCategory().equalsIgnoreCase(AppConstant.AUTOMATIC_CAMPAIGN)){
                }
            }
            if (operationState.equalsIgnoreCase(AppConstant.ACTIVE_STATE)){
                return operationHelpers.getApiOperationListWSDTO(operationRepository.findAllByAgentIdAndCampaignIdAndOperationState(agentId,campaignId,operationState, PageRequest.of(reqPage,reqSize)));
            }
        }
        return null;
    }


    public ApiOperationWSDTO apiGetCampaignOperationService(long agentId,String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            return operationHelpers.getApiOperationWSDTO(operationDBModels.get(0));
        }
        return null;
    }


    public ApiOperationValidateWSDTO apiCampaignOperationValidateService(long agentId, String operationId) {

        Optional<UserDBModel> userDBModel = userRepository.findById(agentId);
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (userDBModel.isPresent() && !operationDBModels.isEmpty()){
            userDBModel.get().setPassword("");
            return operationHelpers.operationValidateHelper(userDBModel.get(),operationDBModels.get(0));
        }
        return null;
    }



}
