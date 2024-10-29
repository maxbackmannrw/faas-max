package com.faas.core.api.framework.operation.manager.remote;

import com.faas.core.api.model.ws.operation.manager.remote.dto.ApiOperationRemoteAppWSDTO;
import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.db.remoteapp.RemoteAppDBModel;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.remoteapp.RemoteAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationRemoteFramework {


    @Autowired
    OperationRepository operationRepository;

    @Autowired
    RemoteAppRepository remoteAppRepository;


    public List<ApiOperationRemoteAppWSDTO> apiGetOperationClientRemotesService(long agentId, String operationId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<ApiOperationRemoteAppWSDTO> operationClientRemoteWSDTOS = new ArrayList<>();
            List<RemoteAppDBModel> remoteAppDBModels = remoteAppRepository.findByClientId(operationDBModels.get(0).getClientId());
            for (RemoteAppDBModel remoteAppDBModel : remoteAppDBModels) {
                operationClientRemoteWSDTOS.add(new ApiOperationRemoteAppWSDTO(remoteAppDBModel));
            }
            return operationClientRemoteWSDTOS;
        }
        return null;
    }

    public ApiOperationRemoteAppWSDTO apiGetOperationClientRemoteService(long agentId, String operationId, String clientRemoteId) {

        List<OperationDBModel> operationDBModels = operationRepository.findByIdAndAgentId(operationId, agentId);
        if (!operationDBModels.isEmpty()) {
            List<RemoteAppDBModel> remoteAppDBModels = remoteAppRepository.findByIdAndClientId(clientRemoteId, operationDBModels.get(0).getClientId());
            if (!remoteAppDBModels.isEmpty()) {
                return new ApiOperationRemoteAppWSDTO(remoteAppDBModels.get(0));
            }
        }
        return null;
    }


}
