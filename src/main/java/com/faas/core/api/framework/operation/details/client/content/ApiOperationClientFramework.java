package com.faas.core.api.framework.operation.details.client.content;

import com.faas.core.api.model.ws.operation.details.client.content.dto.ApiOperationClientWSDTO;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationClientFramework {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientNoteRepository clientNoteRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationClientWSDTO apiGetOperationClientService(long agentId, long sessionId,long clientId){


        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        if (clientDBModel.isPresent() && sessionDBModels.size()>0){

            ApiOperationClientWSDTO operationClientWSDTO = new ApiOperationClientWSDTO();

            operationClientWSDTO.setClient(clientDBModel.get());
            operationClientWSDTO.setClientDatas(clientDataRepository.findByClientId(clientId));
            operationClientWSDTO.setClientAddresses(clientAddressRepository.findByClientId(clientId));
            operationClientWSDTO.setClientPhones(clientPhoneRepository.findByClientId(clientId));
            operationClientWSDTO.setClientEmails(clientEmailRepository.findByClientId(clientId));

            return operationClientWSDTO;
        }
        return null;
    }


}
