package com.faas.core.base.framework.manager.client.content;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.ClientRemoteDBModel;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientManagerRemoteWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientRemoteDeviceWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientRemoteListWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientRemoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.operation.details.scenario.OperationScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ClientManagerFramework {

    @Autowired
    ClientHelper clientHelper;

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


    public ClientManagerRemoteWSDTO getClientManagerRemoteService(long userId,int reqPage, int reqSize) {

        ClientManagerRemoteWSDTO clientManagerRemoteWSDTO = new ClientManagerRemoteWSDTO();
        clientManagerRemoteWSDTO.setActiveRemoteList(clientHelper.getClientRemoteListWSDTO(clientRepository.findAllByRemoteConnAndStatus(true, 1, PageRequest.of(reqPage,reqSize))));;
        clientManagerRemoteWSDTO.setInactiveRemoteList(clientHelper.getClientRemoteListWSDTO(clientRepository.findAllByRemoteConnAndStatus(false, 1, PageRequest.of(reqPage,reqSize))));

        return clientManagerRemoteWSDTO;
    }


    public ClientRemoteListWSDTO getClientRemotesService(long userId,boolean remoteConn,int reqPage,int reqSize) {

        return clientHelper.getClientRemoteListWSDTO(clientRepository.findAllByRemoteConnAndStatus(remoteConn,1, PageRequest.of(reqPage,reqSize)));
    }


    public ClientRemoteWSDTO getClientRemoteService(long userId,long clientId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        List<ClientRemoteDBModel> clientRemoteDBModels = clientRemoteRepository.findByClientId(clientId);
        if (clientDBModel.isPresent() && !clientRemoteDBModels.isEmpty()){
            ClientRemoteWSDTO clientRemoteWSDTO = new ClientRemoteWSDTO();
            clientRemoteWSDTO.setClient(clientDBModel.get());
            clientRemoteWSDTO.setClientRemote(clientRemoteDBModels.get(0));

            return clientRemoteWSDTO;
        }
        return null;
    }


    public List<ClientRemoteDeviceWSDTO> getClientRemoteDevicesService(long userId, long clientId) {

        List<ClientRemoteDeviceWSDTO> clientRemoteDeviceWSDTOS = new ArrayList<>();
        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        List<ClientRemoteDBModel> clientRemoteDBModels = clientRemoteRepository.findByClientId(clientId);
        if (clientDBModel.isPresent() && !clientRemoteDBModels.isEmpty() && clientRemoteDBModels.get(0).getRemoteDevices() != null){
            for (int i=0;i<clientRemoteDBModels.get(0).getRemoteDevices().size();i++){
                clientRemoteDeviceWSDTOS.add(new ClientRemoteDeviceWSDTO(clientRemoteDBModels.get(0).getRemoteDevices().get(i)));
            }
        }
        return clientRemoteDeviceWSDTOS;
    }

    public ClientRemoteDeviceWSDTO getClientRemoteDeviceService(long userId,long clientId,String remoteId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        List<ClientRemoteDBModel> clientRemoteDBModels = clientRemoteRepository.findByClientId(clientId);
        if (clientDBModel.isPresent() && !clientRemoteDBModels.isEmpty() && clientRemoteDBModels.get(0).getRemoteDevices() != null){
            for (int i=0;i<clientRemoteDBModels.get(0).getRemoteDevices().size();i++){
                if (clientRemoteDBModels.get(0).getRemoteDevices().get(i).getDeviceId().equalsIgnoreCase(remoteId)){
                    return new ClientRemoteDeviceWSDTO(clientRemoteDBModels.get(0).getRemoteDevices().get(i));
                }
            }
        }
        return null;
    }


}
