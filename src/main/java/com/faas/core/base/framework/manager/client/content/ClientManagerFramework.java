package com.faas.core.base.framework.manager.client.content;

import com.faas.core.base.model.ws.manager.client.content.dto.ClientManagerRemoteWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientRemoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.operation.details.scenario.OperationScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientManagerFramework {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    ClientNoteRepository clientNoteRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientRemoteRepository clientRemoteRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

    @Autowired
    OperationFlowRepository operationFlowRepository;

    @Autowired
    OperationScenarioRepository operationScenarioRepository;

    @Autowired
    AppUtils appUtils;



    public ClientManagerRemoteWSDTO getClientManagerRemotesService(long userId,String remoteType,String remoteState,int reqPage, int reqSize) {

        ClientManagerRemoteWSDTO clientManagerRemoteWSDTO = new ClientManagerRemoteWSDTO();


        return clientManagerRemoteWSDTO;
    }


    public ClientRemoteWSDTO getClientRemotesService(long userId,long clientId) {

        ClientRemoteWSDTO clientRemoteWSDTO = new ClientRemoteWSDTO();

        return clientRemoteWSDTO;
    }


    public ClientRemoteWSDTO getClientRemoteService(long userId,long clientId,String remoteId) {

        ClientRemoteWSDTO clientRemoteWSDTO = new ClientRemoteWSDTO();

        return clientRemoteWSDTO;
    }



}
