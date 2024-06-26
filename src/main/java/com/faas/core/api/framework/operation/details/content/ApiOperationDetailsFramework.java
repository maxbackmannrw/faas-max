package com.faas.core.api.framework.operation.details.content;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.details.content.dto.ApiOperationDetailsWSDTO;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.operation.OperationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationDetailsFramework {

    @Autowired
    OperationHelpers operationHelpers;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationDetailsWSDTO apiGetOperationDetailsService(long agentId,String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            return operationHelpers.getApiOperationDetailsWSDTO(operationDBModels.get(0));
        }
        return null;
    }

    public ApiOperationWSDTO apiStartOperationService(long agentId,String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);

        return null;
    }

    public ApiOperationWSDTO apiCompleteOperationService(long agentId,String operationId,String operationResult) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentIdAndOperationState(operationId,agentId,AppConstant.ACTIVE_STATE);
        return null;
    }

    public List<ApiOperationWSDTO> apiGetSwitchOperationsService(long agentId,String operationId) {

        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByAgentIdAndOperationState(agentId,AppConstant.ACTIVE_STATE);
        for (OperationDBModel operationDBModel : operationDBModels) {
            if (!operationDBModel.getId().equalsIgnoreCase(operationId)) {
                operationWSDTOS.add(operationHelpers.getApiOperationWSDTO(operationDBModel));
            }
        }
        return operationWSDTOS;
    }

    public ApiOperationWSDTO apiSwitchOperationService(long agentId,String operationId,String selectedId) {

        List<OperationDBModel> currentOperations = operationRepository.findByIdAndAgentId(operationId,agentId);
        List<OperationDBModel> selectedOperations = operationRepository.findByIdAndAgentId(selectedId,agentId);
        if (!currentOperations.isEmpty() && !selectedOperations.isEmpty() && selectedOperations.get(0).getOperationState().equalsIgnoreCase(AppConstant.ACTIVE_STATE)){
            return operationHelpers.getApiOperationWSDTO(selectedOperations.get(0));
        }
        return null;
    }

    public ApiCampaignDetailsWSDTO apiGetOperationCampaignService(long agentId, String operationId) {

        return null;
    }


    public List<ApiOperationActivityWSDTO> apiGetOperationActivitiesService(long agentId, String operationId) {

        List<ApiOperationActivityWSDTO> operationActivityWSDTOS = new ArrayList<>();

        return operationActivityWSDTOS;
    }

    public ApiOperationActivityWSDTO apiGetOperationActivityService(long agentId,String operationId,String activityId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);

        return null;
    }


}
