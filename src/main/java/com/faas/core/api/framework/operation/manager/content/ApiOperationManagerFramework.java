package com.faas.core.api.framework.operation.manager.content;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiValidateOperationWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationActivityWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationManagerWSDTO;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.helpers.operation.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationManagerFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OperationRepository operationRepository;


    public ApiValidateOperationWSDTO apiValidateOperationManagerService(long agentId, String operationId) {

        Optional<UserDBModel> agentDBModel = userRepository.findById(agentId);
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (agentDBModel.isPresent() && !operationDBModels.isEmpty()) {
            agentDBModel.get().setPassword("");
            return operationHelper.validateOperationHelper(agentDBModel.get(), operationDBModels.get(0));
        }
        return null;
    }

    public ApiOperationManagerWSDTO apiGetOperationManagerService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            return operationHelper.getApiOperationManagerWSDTO(operationDBModels.get(0));
        }
        return null;
    }

    public ApiOperationWSDTO apiStartOperationManagerService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);

        return null;
    }

    public ApiOperationWSDTO apiCompleteOperationManagerService(long agentId, String operationId, String operationResult) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentIdAndOperationState(operationId, agentId, AppConstant.ACTIVE_STATE);
        return null;
    }

    public List<ApiOperationWSDTO> apiGetSwitchOperationManagersService(long agentId, String operationId) {

        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();
        List<OperationDBModel> operationDBModels = operationRepository.findByAgentIdAndOperationState(agentId, AppConstant.ACTIVE_STATE);
        for (OperationDBModel operationDBModel : operationDBModels) {
            if (!operationDBModel.getId().equalsIgnoreCase(operationId)) {
                operationWSDTOS.add(operationHelper.getApiOperationWSDTO(operationDBModel));
            }
        }
        return operationWSDTOS;
    }

    public ApiOperationWSDTO apiSwitchOperationManagerService(long agentId, String operationId, String selectedId) {

        List<OperationDBModel> currentOperations = operationRepository.findByIdAndAgentId(operationId, agentId);
        List<OperationDBModel> selectedOperations = operationRepository.findByIdAndAgentId(selectedId, agentId);
        if (!currentOperations.isEmpty() && !selectedOperations.isEmpty() && selectedOperations.get(0).getOperationState().equalsIgnoreCase(AppConstant.ACTIVE_STATE)) {
            return operationHelper.getApiOperationWSDTO(selectedOperations.get(0));
        }
        return null;
    }

    public ApiCampaignDetailsWSDTO apiGetOperationManagerCampaignService(long agentId, String operationId) {

        return null;
    }

    public List<ApiOperationActivityWSDTO> apiGetOperationManagerActivitiesService(long agentId, String operationId) {

        List<ApiOperationActivityWSDTO> operationActivityWSDTOS = new ArrayList<>();

        return operationActivityWSDTOS;
    }

    public ApiOperationActivityWSDTO apiGetOperationManagerActivityService(long agentId, String operationId, String activityId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);

        return null;
    }


}
