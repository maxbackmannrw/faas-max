package com.faas.core.base.framework.client.remote.content;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.remote.ClientRemoteDBModel;
import com.faas.core.base.model.ws.client.remote.content.dto.ClientRemoteListWSDTO;
import com.faas.core.base.model.ws.client.remote.content.dto.ClientRemoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.operation.details.scenario.OperationScenarioRepository;
import com.faas.core.base.repo.client.remote.ClientRemoteRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ClientRemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ClientRemoteFramework {


    @Autowired
    ClientRemoteHelper clientRemoteHelper;

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


    public ClientRemoteListWSDTO getAllClientRemotesService(long userId,String remoteType,String remoteState, int reqPage, int reqSize) {

        ClientRemoteListWSDTO clientRemoteListWSDTO = new ClientRemoteListWSDTO();
        if (remoteType.equalsIgnoreCase(AppConstant.ALL_CLIENT_REMOTES) && remoteState.equalsIgnoreCase(AppConstant.ALL_CLIENT_REMOTES)){
            clientRemoteListWSDTO = clientRemoteHelper.getClientRemoteListWSDTO(clientRemoteRepository.findAllByStatus(1, PageRequest.of(reqPage,reqSize)));
        }
        if (!remoteType.equalsIgnoreCase(AppConstant.ALL_CLIENT_REMOTES) && remoteState.equalsIgnoreCase(AppConstant.ALL_CLIENT_REMOTES)){
            clientRemoteListWSDTO = clientRemoteHelper.getClientRemoteListWSDTO(clientRemoteRepository.findAllByRemoteTypeAndStatus(remoteType,1, PageRequest.of(reqPage,reqSize)));
        }
        if (remoteType.equalsIgnoreCase(AppConstant.ALL_CLIENT_REMOTES) && !remoteState.equalsIgnoreCase(AppConstant.ALL_CLIENT_REMOTES)){
            clientRemoteListWSDTO = clientRemoteHelper.getClientRemoteListWSDTO(clientRemoteRepository.findAllByRemoteStateAndStatus(remoteState,1, PageRequest.of(reqPage,reqSize)));
        }
        if (!remoteType.equalsIgnoreCase(AppConstant.ALL_CLIENT_REMOTES) && !remoteState.equalsIgnoreCase(AppConstant.ALL_CLIENT_REMOTES)){
            clientRemoteListWSDTO = clientRemoteHelper.getClientRemoteListWSDTO(clientRemoteRepository.findAllByRemoteTypeAndRemoteStateAndStatus(remoteType,remoteState,1, PageRequest.of(reqPage,reqSize)));
        }
        return clientRemoteListWSDTO;
    }


    public List<ClientRemoteWSDTO> getClientRemotesService(long userId, long clientId) {

        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();
        List<ClientRemoteDBModel> clientRemoteDBModels = clientRemoteRepository.findByClientId(clientId);
        for (ClientRemoteDBModel clientRemoteDBModel : clientRemoteDBModels) {
            ClientRemoteWSDTO clientRemoteWSDTO = clientRemoteHelper.getClientRemoteWSDTO(clientRemoteDBModel);
            if (clientRemoteWSDTO != null){
                clientRemoteWSDTOS.add(clientRemoteWSDTO);
            }
        }
        return clientRemoteWSDTOS;
    }


    public ClientRemoteWSDTO getClientRemoteService(long userId, long clientId, String remoteId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        Optional<ClientRemoteDBModel> clientRemoteDBModel = clientRemoteRepository.findById(remoteId);
        if (clientDBModel.isPresent() && clientRemoteDBModel.isPresent()){
            return new ClientRemoteWSDTO(clientDBModel.get(),clientRemoteDBModel.get());
        }
        return null;
    }


    public ClientRemoteWSDTO createClientRemoteService(long userId, long clientId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);

        return null;
    }


    public ClientRemoteWSDTO updateClientRemoteService(long userId, long clientId, String remoteId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        Optional<ClientRemoteDBModel> clientRemoteDBModel = clientRemoteRepository.findById(remoteId);
        if (clientDBModel.isPresent() && clientRemoteDBModel.isPresent()){
            return new ClientRemoteWSDTO(clientDBModel.get(),clientRemoteDBModel.get());
        }
        return null;
    }


    public ClientRemoteWSDTO removeClientRemoteService(long userId, long clientId, String remoteId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        Optional<ClientRemoteDBModel> clientRemoteDBModel = clientRemoteRepository.findById(remoteId);
        if (clientDBModel.isPresent() && clientRemoteDBModel.isPresent()){
            return new ClientRemoteWSDTO(clientDBModel.get(),clientRemoteDBModel.get());
        }
        return null;
    }

}
