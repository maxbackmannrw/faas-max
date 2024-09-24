package com.faas.core.api.framework.operation.content;

import com.faas.core.api.model.ws.general.dto.ApiSummaryWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiAgentOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiValidateOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.user.content.UserRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.operation.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationFramework {

    @Autowired
    OperationHelper operationHelper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public ApiAgentOperationWSDTO apiGetAgentOperationListsService(long agentId, int reqPage, int reqSize) {

        ApiAgentOperationWSDTO agentOperationWSDTO = new ApiAgentOperationWSDTO();

        return agentOperationWSDTO;
    }

    public List<ApiOperationWSDTO> apiGetAgentOperationsService(long agentId, String operationCategory, String operationState, int reqPage, int reqSize) {

        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();

        return operationWSDTOS;
    }

    public ApiOperationWSDTO apiGetAgentOperationService(long agentId, String operationId) {

        Optional<OperationDBModel> operationDBModel = operationRepository.findById(operationId);
        if (operationDBModel.isPresent()) {
            return operationHelper.getApiOperationWSDTO(operationDBModel.get());
        }
        return null;
    }

    public ApiOperationWSDTO apiUpdateAgentOperationService(long agentId, String operationId, String operationState) {

        return null;
    }

    public ApiOperationWSDTO apiRemoveAgentOperationService(long agentId, String operationId) {

        return null;
    }

    public ApiValidateOperationWSDTO apiValidateAgentOperationService(long agentId, String operationId) {

        Optional<UserDBModel> userDBModel = userRepository.findById(agentId);
        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (userDBModel.isPresent() && !operationDBModels.isEmpty()) {
            userDBModel.get().setPassword("");
            return operationHelper.validateOperationHelper(userDBModel.get(), operationDBModels.get(0));
        }
        return null;
    }

    public List<ApiSummaryWSDTO> apiGetAgentOperationsSummaryService(long agentId) {
        return operationHelper.apiGetOperationSummaryHelper(agentId);
    }


}
