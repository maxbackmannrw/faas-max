package com.faas.core.api.framework.operation.details.remote;

import com.faas.core.api.model.ws.operation.details.remote.dto.ApiOperationClientRemoteWSDTO;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remote.client.RemoteClientDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.remote.client.RemoteClientRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utility.config.AppUtils;
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
    RemoteClientRepository remoteClientRepository;

    @Autowired
    AppUtils appUtils;

    public List<ApiOperationClientRemoteWSDTO> apiGetOperationClientRemotesService(long agentId,String operationId){

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<ApiOperationClientRemoteWSDTO> operationClientRemoteWSDTOS = new ArrayList<>();
            List<RemoteClientDBModel> remoteClientDBModels = remoteClientRepository.findByClientId(operationDBModels.get(0).getClientId());
            for (RemoteClientDBModel remoteClientDBModel : remoteClientDBModels) {
                operationClientRemoteWSDTOS.add(new ApiOperationClientRemoteWSDTO(remoteClientDBModel));
            }
            return operationClientRemoteWSDTOS;
        }
        return null;
    }

    public ApiOperationClientRemoteWSDTO apiGetOperationClientRemoteService(long agentId,String operationId,String clientRemoteId){

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId,agentId);
        if (!operationDBModels.isEmpty()){
            List<RemoteClientDBModel> remoteClientDBModels = remoteClientRepository.findByIdAndClientId(clientRemoteId,operationDBModels.get(0).getClientId());
            if (!remoteClientDBModels.isEmpty()){
                return new ApiOperationClientRemoteWSDTO(remoteClientDBModels.get(0));
            }
        }
        return null;
    }


}
