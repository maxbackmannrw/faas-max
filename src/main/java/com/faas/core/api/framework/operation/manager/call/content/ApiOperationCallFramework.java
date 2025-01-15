package com.faas.core.api.framework.operation.manager.call.content;

import com.faas.core.api.model.ws.operation.manager.call.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.data.db.client.details.ClientDetailsDBModel;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.repo.client.details.ClientDetailsRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.misc.helpers.operation.content.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiOperationCallFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;


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


}
