package com.faas.core.base.framework.remote.client;

import com.faas.core.base.model.db.remote.client.ClientRemoteDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.remote.client.dto.ClientRemoteListWSDTO;
import com.faas.core.base.model.ws.remote.client.dto.ClientRemoteSummaryWSDTO;
import com.faas.core.base.model.ws.remote.client.dto.ClientRemoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.flow.OperationFlowRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.operation.details.scenario.OperationScenarioRepository;
import com.faas.core.base.repo.remote.client.ClientRemoteRepository;
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
public class ClientRemoteFramework {


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


    public ClientRemoteListWSDTO getAllClientRemotesService(long userId, String remoteType, String remoteState, int reqPage, int reqSize) {

        ClientRemoteListWSDTO clientRemoteListWSDTO = new ClientRemoteListWSDTO();
        if (remoteType.equalsIgnoreCase(AppConstant.ALL_REMOTES) && remoteState.equalsIgnoreCase(AppConstant.ALL_REMOTES)){
            clientRemoteListWSDTO = remoteHelper.getRemoteListWSDTO(clientRemoteRepository.findAllByStatus(1, PageRequest.of(reqPage,reqSize)));
        }
        if (!remoteType.equalsIgnoreCase(AppConstant.ALL_REMOTES) && remoteState.equalsIgnoreCase(AppConstant.ALL_REMOTES)){
            clientRemoteListWSDTO = remoteHelper.getRemoteListWSDTO(clientRemoteRepository.findAllByRemoteTypeAndStatus(remoteType,1, PageRequest.of(reqPage,reqSize)));
        }
        if (remoteType.equalsIgnoreCase(AppConstant.ALL_REMOTES) && !remoteState.equalsIgnoreCase(AppConstant.ALL_REMOTES)){
            clientRemoteListWSDTO = remoteHelper.getRemoteListWSDTO(clientRemoteRepository.findAllByRemoteStateAndStatus(remoteState,1, PageRequest.of(reqPage,reqSize)));
        }
        if (!remoteType.equalsIgnoreCase(AppConstant.ALL_REMOTES) && !remoteState.equalsIgnoreCase(AppConstant.ALL_REMOTES)){
            clientRemoteListWSDTO = remoteHelper.getRemoteListWSDTO(clientRemoteRepository.findAllByRemoteTypeAndRemoteStateAndStatus(remoteType,remoteState,1, PageRequest.of(reqPage,reqSize)));
        }
        return clientRemoteListWSDTO;
    }

    public List<ClientRemoteWSDTO> getClientRemotesService(long userId, long clientId) {

        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();
        List<ClientRemoteDBModel> clientRemoteDBModels = clientRemoteRepository.findByClientId(clientId);
        for (ClientRemoteDBModel clientRemoteDBModel : clientRemoteDBModels) {
            ClientRemoteWSDTO clientRemoteWSDTO = remoteHelper.getRemoteWSDTO(clientRemoteDBModel);
            if (clientRemoteWSDTO != null){
                clientRemoteWSDTOS.add(clientRemoteWSDTO);
            }
        }
        return clientRemoteWSDTOS;
    }

    public ClientRemoteWSDTO getClientRemoteService(long userId, String remoteId) {

        Optional<ClientRemoteDBModel> remoteDBModel = clientRemoteRepository.findById(remoteId);
        if ( remoteDBModel.isPresent()){
            return remoteHelper.getRemoteWSDTO(remoteDBModel.get());
        }
        return null;
    }

    public ClientRemoteWSDTO createClientRemoteService(long userId, long sessionId, String deviceBrand, String deviceModel, String deviceOS, String deviceUrl, String remoteType, String remoteState) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty()){
            if (clientRepository.existsById(sessionDBModel.get().getClientId())){

                ClientRemoteDBModel clientRemoteDBModel = new ClientRemoteDBModel();
                clientRemoteDBModel.setClientId(sessionDBModel.get().getClientId());
                clientRemoteDBModel.setSessionId(sessionId);
                clientRemoteDBModel.setOperationId(operationDBModels.get(0).getId());
                clientRemoteDBModel.setCampaignId(sessionDBModel.get().getCampaignId());
                clientRemoteDBModel.setCampaign(sessionDBModel.get().getCampaign());
                clientRemoteDBModel.setProcessId(sessionDBModel.get().getProcessId());
                clientRemoteDBModel.setProcess(sessionDBModel.get().getProcess());
                clientRemoteDBModel.setRemoteType(remoteType);
                clientRemoteDBModel.setRemoteState(remoteState);
                clientRemoteDBModel.setuDate(appUtils.getCurrentTimeStamp());
                clientRemoteDBModel.setcDate(appUtils.getCurrentTimeStamp());
                clientRemoteDBModel.setStatus(1);

                return remoteHelper.getRemoteWSDTO(clientRemoteRepository.save(clientRemoteDBModel));
            }
        }
        return null;
    }

    public ClientRemoteWSDTO updateClientRemoteService(long userId, String remoteId, String deviceBrand, String deviceModel, String deviceOS, String deviceUrl, String remoteState) {

        Optional<ClientRemoteDBModel> remoteDBModel = clientRemoteRepository.findById(remoteId);

        return null;
    }

    public ClientRemoteWSDTO removeClientRemoteService(long userId, String remoteId) {

        Optional<ClientRemoteDBModel> remoteDBModel = clientRemoteRepository.findById(remoteId);
        if (remoteDBModel.isPresent()){
            clientRemoteRepository.delete(remoteDBModel.get());
            return remoteHelper.getRemoteWSDTO(remoteDBModel.get());
        }
        return null;
    }








}
