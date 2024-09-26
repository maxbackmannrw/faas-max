package com.faas.core.api.framework.operation.details;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.details.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.details.dto.ApiOperationDetailsWSDTO;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.operation.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationDetailsFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationDetailsWSDTO apiGetOperationDetailsService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            return operationHelper.getApiOperationDetailsWSDTO(operationDBModels.get(0));
        }
        return null;
    }

    public ApiOperationWSDTO apiStartOperationService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);

        return null;
    }

    public ApiOperationWSDTO apiCompleteOperationService(long agentId, String operationId, String operationResult) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentIdAndOperationState(operationId, agentId, AppConstant.ACTIVE_STATE);
        return null;
    }

    public List<ApiOperationWSDTO> apiGetSwitchOperationsService(long agentId, String operationId) {

        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE);
        for (OperationDBModel operationDBModel : operationDBModels) {
            if (!operationDBModel.getId().equalsIgnoreCase(operationId)) {
                operationWSDTOS.add(operationHelper.getApiOperationWSDTO(operationDBModel));
            }
        }
        return operationWSDTOS;
    }

    public ApiOperationWSDTO apiSwitchOperationService(long agentId, String operationId, String selectedId) {

        List<OperationDBModel> currentOperations = operationRepository.findByIdAndAgentId(operationId, agentId);
        List<OperationDBModel> selectedOperations = operationRepository.findByIdAndAgentId(selectedId, agentId);
        if (!currentOperations.isEmpty() && !selectedOperations.isEmpty() && selectedOperations.get(0).getOperationState().equalsIgnoreCase(AppConstant.ACTIVE_STATE)) {
            return operationHelper.getApiOperationWSDTO(selectedOperations.get(0));
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

    public ApiOperationActivityWSDTO apiGetOperationActivityService(long agentId, String operationId, String activityId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);

        return null;
    }


}
