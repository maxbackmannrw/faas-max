package com.faas.core.base.framework.manager.client.content;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.RemoteConnDBModel;
import com.faas.core.base.model.ws.manager.client.content.dto.AllRemoteConnWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.RemoteConnListWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.RemoteConnWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.operation.details.scenario.OperationScenarioRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.RemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ClientManagerFramework {

    @Autowired
    RemoteHelper remoteHelper;

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
    RemoteConnRepository remoteConnRepository;

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


    public AllRemoteConnWSDTO getAllRemoteConnsService(long userId, int reqPage, int reqSize) {

        AllRemoteConnWSDTO allRemoteConnWSDTO = new AllRemoteConnWSDTO();
        allRemoteConnWSDTO.setReadyConnList(remoteHelper.getRemoteConnListWSDTO(remoteConnRepository.findAllByConnStateAndStatus(AppConstant.READY_CONN,1, PageRequest.of(reqPage,reqSize))));
        allRemoteConnWSDTO.setActiveConnList(remoteHelper.getRemoteConnListWSDTO(remoteConnRepository.findAllByConnStateAndStatus(AppConstant.ACTIVE_CONN,1, PageRequest.of(reqPage,reqSize))));
        allRemoteConnWSDTO.setInActiveConnList(remoteHelper.getRemoteConnListWSDTO(remoteConnRepository.findAllByConnStateAndStatus(AppConstant.INACTIVE_CONN,1, PageRequest.of(reqPage,reqSize))));

        return allRemoteConnWSDTO;
    }



    public List<RemoteConnWSDTO> getClientRemoteConnsService(long userId, long clientId) {

        List<RemoteConnWSDTO>remoteConnWSDTOS = new ArrayList<>();
        List<RemoteConnDBModel> remoteConnDBModels = remoteConnRepository.findByClientId(clientId);
        for (RemoteConnDBModel remoteConnDBModel : remoteConnDBModels) {
            RemoteConnWSDTO remoteConnWSDTO = remoteHelper.getRemoteConnWSDTO(remoteConnDBModel);
            if (remoteConnWSDTO != null) {
                remoteConnWSDTOS.add(remoteConnWSDTO);
            }
        }
        return remoteConnWSDTOS;
    }


    public RemoteConnListWSDTO getRemoteConnsService(long userId,String connType,String connState, int reqPage, int reqSize) {

        RemoteConnListWSDTO remoteConnListWSDTO = new RemoteConnListWSDTO();
        if (connType.equalsIgnoreCase(AppConstant.ALL_CONNS) && connState.equalsIgnoreCase(AppConstant.ALL_CONNS)){
            return remoteHelper.getRemoteConnListWSDTO(remoteConnRepository.findAllByStatus(1, PageRequest.of(reqPage,reqSize)));
        }
        if (connType.equalsIgnoreCase(AppConstant.ALL_CONNS) && !connState.equalsIgnoreCase(AppConstant.ALL_CONNS)){
            return remoteHelper.getRemoteConnListWSDTO(remoteConnRepository.findAllByConnStateAndStatus(connState,1, PageRequest.of(reqPage,reqSize)));
        }
        if (!connType.equalsIgnoreCase(AppConstant.ALL_CONNS) && connState.equalsIgnoreCase(AppConstant.ALL_CONNS)){
            return remoteHelper.getRemoteConnListWSDTO(remoteConnRepository.findAllByConnTypeAndStatus(connType,1, PageRequest.of(reqPage,reqSize)));
        }
        if (!connType.equalsIgnoreCase(AppConstant.ALL_CONNS) && !connState.equalsIgnoreCase(AppConstant.ALL_CONNS)){
            return remoteHelper.getRemoteConnListWSDTO(remoteConnRepository.findAllByConnTypeAndConnStateAndStatus(connType,connState,1, PageRequest.of(reqPage,reqSize)));
        }
        return remoteConnListWSDTO;
    }


    public RemoteConnWSDTO getRemoteConnService(long userId, long clientId,String connId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        Optional<RemoteConnDBModel> remoteConnDBModel = remoteConnRepository.findById(connId);
        if (clientDBModel.isPresent() && remoteConnDBModel.isPresent()){
            return new RemoteConnWSDTO(clientDBModel.get(),remoteConnDBModel.get());
        }
        return null;
    }



}
