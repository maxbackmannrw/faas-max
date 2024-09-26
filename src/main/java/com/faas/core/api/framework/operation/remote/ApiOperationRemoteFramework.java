package com.faas.core.api.framework.operation.remote;

import com.faas.core.api.model.ws.operation.remote.dto.ApiOperationClientRemoteWSDTO;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.remoteapp.RemoteAppDBModel;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.remoteapp.RemoteAppRepository;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationRemoteFramework {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    RemoteAppRepository remoteAppRepository;

    @Autowired
    AppUtils appUtils;

    public List<ApiOperationClientRemoteWSDTO> apiGetOperationClientRemotesService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ApiOperationClientRemoteWSDTO> operationClientRemoteWSDTOS = new ArrayList<>();
            List<RemoteAppDBModel> remoteAppDBModels = remoteAppRepository.findByClientId(operationDBModels.get(0).getClientId());
            for (RemoteAppDBModel remoteAppDBModel : remoteAppDBModels) {
                operationClientRemoteWSDTOS.add(new ApiOperationClientRemoteWSDTO(remoteAppDBModel));
            }
            return operationClientRemoteWSDTOS;
        }
        return null;
    }

    public ApiOperationClientRemoteWSDTO apiGetOperationClientRemoteService(long agentId, String operationId, String clientRemoteId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<RemoteAppDBModel> remoteAppDBModels = remoteAppRepository.findByIdAndClientId(clientRemoteId, operationDBModels.get(0).getClientId());
            if (!remoteAppDBModels.isEmpty()) {
                return new ApiOperationClientRemoteWSDTO(remoteAppDBModels.get(0));
            }
        }
        return null;
    }


}
