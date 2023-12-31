package com.faas.core.api.framework.operation.details.client.content;

import com.faas.core.api.model.ws.client.details.dto.ApiClientOsIntWSDTO;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationDeviceWSDTO;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationClientFramework {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationClientWSDTO apiGetOperationClientService(long agentId, long sessionId,long clientId){

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        if (clientDBModel.isPresent() && !sessionDBModels.isEmpty()){

            ApiOperationClientWSDTO operationClientWSDTO = new ApiOperationClientWSDTO();
            operationClientWSDTO.setClient(clientDBModel.get());

            return operationClientWSDTO;
        }
        return null;
    }


    public ApiOperationDeviceWSDTO apiGetOperationDevicesService(){

        ApiOperationDeviceWSDTO operationDeviceWSDTO = new ApiOperationDeviceWSDTO();
        return operationDeviceWSDTO;
    }

    public ApiOperationDeviceWSDTO apiGetOperationDeviceService(){

        ApiOperationDeviceWSDTO operationDeviceWSDTO = new ApiOperationDeviceWSDTO();
        return operationDeviceWSDTO;
    }


    public List<ApiClientOsIntWSDTO> apiGetClientOsIntService(){

        List<ApiClientOsIntWSDTO> clientOsIntWSDTOS = new ArrayList<>();
        return clientOsIntWSDTOS;
    }


}
