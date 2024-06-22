package com.faas.core.base.framework.remote.app.content;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remote.app.RemoteAppDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.remote.app.content.dto.RemoteClientListWSDTO;
import com.faas.core.base.model.ws.remote.app.content.dto.RemoteClientWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.remote.app.RemoteAppRepository;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.remote.RemoteClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteAppFramework {

    @Autowired
    RemoteClientHelper remoteClientHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    RemoteAppRepository remoteAppRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteClientListWSDTO getRemoteClientsService(long userId, String remoteState, int reqPage, int reqSize) {

        Page<RemoteAppDBModel> clientRemoteModelPage = remoteAppRepository.findAllByRemoteState(remoteState,PageRequest.of(reqPage,reqSize));
        if (clientRemoteModelPage != null){
            RemoteClientListWSDTO remoteClientListWSDTO = new RemoteClientListWSDTO();
            List<RemoteClientWSDTO> remoteClientWSDTOS = new ArrayList<>();
            for (int i=0;i<clientRemoteModelPage.getContent().size();i++){
                remoteClientWSDTOS.add(remoteClientHelper.createClientRemoteWSDTO(clientRemoteModelPage.getContent().get(i)));
            }
            remoteClientListWSDTO.setClientRemotes(remoteClientWSDTOS);
            remoteClientListWSDTO.setPagination(remoteClientHelper.createClientRemotePagination(clientRemoteModelPage));

            return remoteClientListWSDTO;
        }
        return null;
    }

    public RemoteClientListWSDTO getRemoteClientsByStateService(long userId, String remoteState, String baseType, int reqPage, int reqSize) {

        Page<RemoteAppDBModel> clientRemoteModelPage = remoteAppRepository.findAllByRemoteStateAndBaseType(remoteState,baseType,PageRequest.of(reqPage,reqSize));
        if (clientRemoteModelPage != null){
            RemoteClientListWSDTO remoteClientListWSDTO = new RemoteClientListWSDTO();
            List<RemoteClientWSDTO> remoteClientWSDTOS = new ArrayList<>();
            for (int i=0;i<clientRemoteModelPage.getContent().size();i++){
                remoteClientWSDTOS.add(remoteClientHelper.createClientRemoteWSDTO(clientRemoteModelPage.getContent().get(i)));
            }
            remoteClientListWSDTO.setPagination(remoteClientHelper.createClientRemotePagination(clientRemoteModelPage));
            remoteClientListWSDTO.setClientRemotes(remoteClientWSDTOS);
            return remoteClientListWSDTO;
        }
        return null;
    }

    public RemoteClientListWSDTO getClientRemoteClientsService(long userId, String remoteState, String baseType, int reqPage, int reqSize) {

        Page<RemoteAppDBModel> clientRemoteModelPage = remoteAppRepository.findAllByRemoteStateAndBaseType(remoteState,baseType,PageRequest.of(reqPage,reqSize));
        if (clientRemoteModelPage != null){
            RemoteClientListWSDTO remoteClientListWSDTO = new RemoteClientListWSDTO();
            List<RemoteClientWSDTO> remoteClientWSDTOS = new ArrayList<>();
            for (int i=0;i<clientRemoteModelPage.getContent().size();i++){
                remoteClientWSDTOS.add(remoteClientHelper.createClientRemoteWSDTO(clientRemoteModelPage.getContent().get(i)));
            }
            remoteClientListWSDTO.setPagination(remoteClientHelper.createClientRemotePagination(clientRemoteModelPage));
            remoteClientListWSDTO.setClientRemotes(remoteClientWSDTOS);
            return remoteClientListWSDTO;
        }
        return null;
    }

    public List<RemoteClientWSDTO> getClientRemotesService(long userId, long clientId) {

        List<RemoteClientWSDTO> remoteClientWSDTOS = new ArrayList<>();
        List<RemoteAppDBModel> remoteAppDBModels = remoteAppRepository.findByClientId(clientId);
        for (RemoteAppDBModel remoteAppDBModel : remoteAppDBModels) {
            remoteClientWSDTOS.add(remoteClientHelper.createClientRemoteWSDTO(remoteAppDBModel));
        }
        return remoteClientWSDTOS;
    }

    public RemoteClientWSDTO getRemoteClientService(long userId, String clientRemoteId) {

        Optional<RemoteAppDBModel> clientRemoteDBModel = remoteAppRepository.findById(clientRemoteId);
        if (clientRemoteDBModel.isPresent()){
            return remoteClientHelper.createClientRemoteWSDTO(clientRemoteDBModel.get());
        }
        return null;
    }

    public RemoteClientWSDTO createRemoteClientService(long userId, String operationId, String remoteId) {

        Optional<OperationDBModel> operationDBModel = operationRepository.findById(operationId);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByOperationId(operationId);
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (!sessionDBModels.isEmpty() && operationDBModel.isPresent() && remoteDBModel.isPresent()){
            return remoteClientHelper.createClientRemoteWSDTO(remoteAppRepository.save(remoteClientHelper.createClientRemoteDBModel(sessionDBModels.get(0),operationDBModel.get(),remoteDBModel.get())));
        }
        return null;
    }

    public RemoteClientWSDTO updateRemoteClientService(long userId, String clientRemoteId, String remoteState) {

        Optional<RemoteAppDBModel>clientRemoteDBModel = remoteAppRepository.findById(clientRemoteId);
        if (clientRemoteDBModel.isPresent()){
            clientRemoteDBModel.get().setRemoteState(remoteState);
            clientRemoteDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            return remoteClientHelper.createClientRemoteWSDTO(remoteAppRepository.save(clientRemoteDBModel.get()));
        }
        return null;
    }

    public RemoteClientWSDTO removeClientRemoteService(long userId, String clientRemoteId) {

        Optional<RemoteAppDBModel> clientRemoteDBModel = remoteAppRepository.findById(clientRemoteId);
        if (clientRemoteDBModel.isPresent()){
            remoteAppRepository.delete(clientRemoteDBModel.get());
            return remoteClientHelper.createClientRemoteWSDTO(clientRemoteDBModel.get());
        }
        return null;
    }


}
