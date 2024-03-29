package com.faas.core.api.framework.operation.details.remote;

import com.faas.core.api.model.ws.operation.details.remote.dto.ApiOperationClientRemoteWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remote.client.ClientRemoteDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.remote.client.ClientRemoteRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationRemoteFramework {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRemoteRepository clientRemoteRepository;

    @Autowired
    AppUtils appUtils;

    public List<ApiOperationClientRemoteWSDTO> apiGetOperationClientRemotesService(long agentId,String operationId){

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ApiOperationClientRemoteWSDTO> operationClientRemoteWSDTOS = new ArrayList<>();
            List<ClientRemoteDBModel> clientRemoteDBModels = clientRemoteRepository.findByClientId(operationDBModels.get(0).getClientId());
            for (ClientRemoteDBModel clientRemoteDBModel : clientRemoteDBModels) {
                operationClientRemoteWSDTOS.add(new ApiOperationClientRemoteWSDTO(clientRemoteDBModel));
            }
            return operationClientRemoteWSDTOS;
        }
        return null;
    }

    public ApiOperationClientRemoteWSDTO apiGetOperationClientRemoteService(long agentId,String operationId,String clientRemoteId){

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ClientRemoteDBModel> clientRemoteDBModels = clientRemoteRepository.findByIdAndClientId(clientRemoteId,operationDBModels.get(0).getClientId());
            if (!clientRemoteDBModels.isEmpty()){
                return new ApiOperationClientRemoteWSDTO(clientRemoteDBModels.get(0));
            }
        }
        return null;
    }


}
