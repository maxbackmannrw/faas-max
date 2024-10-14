package com.faas.core.api.framework.operation.manager.content;

import com.faas.core.api.model.ws.campaign.details.dto.ApiCampaignDetailsWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.manager.call.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationManagerWSDTO;
import com.faas.core.api.model.ws.operation.manager.message.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.operation.content.OperationHelper;
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
    OperationRepository operationRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationManagerWSDTO apiGetOperationManagerService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            return operationHelper.getApiOperationManagerWSDTO(operationDBModels.get(0));
        }
        return null;
    }

    public ApiCampaignDetailsWSDTO apiGetOperationCampaignService(long agentId, String operationId) {

        return null;
    }

    public ApiOperationWSDTO apiStartOperationService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        Optional<UserDBModel> agentModel = userRepository.findById(agentId);
        if (!operationDBModels.isEmpty() && agentModel.isPresent()){
            operationDBModels.get(0).setOperationState(AppConstant.ACTIVE_STATE);
            operationDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return new ApiOperationWSDTO(operationRepository.save(operationDBModels.get(0)));
        }
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

    public ApiOperationCallChannelWSDTO apiGetOperationCallChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()) {
                return operationHelper.getApiOperationCallChannelWSDTO(operationDBModels.get(0), clientDetailsDBModels.get(0));
            }
        }
        return null;
    }

    public ApiOperationMessageChannelWSDTO apiGetOperationMessageChannelService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(operationDBModels.get(0).getClientId());
            if (!clientDetailsDBModels.isEmpty()) {
                return operationHelper.getApiOperationMessageChannelWSDTO(operationDBModels.get(0), clientDetailsDBModels.get(0));
            }
        }
        return null;
    }


}
