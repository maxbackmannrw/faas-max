package com.faas.core.base.framework.remote.client;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remote.client.ClientRemoteDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.remote.client.content.dto.ClientRemoteListWSDTO;
import com.faas.core.base.model.ws.remote.client.content.dto.ClientRemoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.remote.client.ClientRemoteRepository;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ClientRemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientRemoteFramework {

    @Autowired
    ClientRemoteHelper clientRemoteHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ClientRemoteRepository clientRemoteRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    AppUtils appUtils;


    public ClientRemoteListWSDTO getAllClientRemotesService(long userId, String remoteState, int reqPage, int reqSize) {

        Page<ClientRemoteDBModel> clientRemoteModelPage = clientRemoteRepository.findAllByRemoteState(remoteState,PageRequest.of(reqPage,reqSize));
        if (clientRemoteModelPage != null){
            ClientRemoteListWSDTO clientRemoteListWSDTO = new ClientRemoteListWSDTO();
            List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();
            for (int i=0;i<clientRemoteModelPage.getContent().size();i++){
                clientRemoteWSDTOS.add(clientRemoteHelper.createClientRemoteWSDTO(clientRemoteModelPage.getContent().get(i)));
            }
            clientRemoteListWSDTO.setClientRemotes(clientRemoteWSDTOS);
            clientRemoteListWSDTO.setPagination(clientRemoteHelper.createClientRemotePagination(clientRemoteModelPage));

            return clientRemoteListWSDTO;
        }
        return null;
    }

    public ClientRemoteListWSDTO getAllClientRemotesByBaseTypeService(long userId, String remoteState, String baseType, int reqPage, int reqSize) {

        Page<ClientRemoteDBModel> clientRemoteModelPage = clientRemoteRepository.findAllByRemoteStateAndBaseType(remoteState,baseType,PageRequest.of(reqPage,reqSize));
        if (clientRemoteModelPage != null){
            ClientRemoteListWSDTO clientRemoteListWSDTO = new ClientRemoteListWSDTO();
            List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();
            for (int i=0;i<clientRemoteModelPage.getContent().size();i++){
                clientRemoteWSDTOS.add(clientRemoteHelper.createClientRemoteWSDTO(clientRemoteModelPage.getContent().get(i)));
            }
            clientRemoteListWSDTO.setPagination(clientRemoteHelper.createClientRemotePagination(clientRemoteModelPage));
            clientRemoteListWSDTO.setClientRemotes(clientRemoteWSDTOS);
            return clientRemoteListWSDTO;
        }
        return null;
    }

    public List<ClientRemoteWSDTO> getClientRemotesService(long userId, long clientId) {

        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();
        List<ClientRemoteDBModel> clientRemoteDBModels = clientRemoteRepository.findByClientId(clientId);
        for (ClientRemoteDBModel clientRemoteDBModel : clientRemoteDBModels) {
            clientRemoteWSDTOS.add(clientRemoteHelper.createClientRemoteWSDTO(clientRemoteDBModel));
        }
        return clientRemoteWSDTOS;
    }

    public ClientRemoteWSDTO getClientRemoteService(long userId, String clientRemoteId) {

        Optional<ClientRemoteDBModel> clientRemoteDBModel = clientRemoteRepository.findById(clientRemoteId);
        if (clientRemoteDBModel.isPresent()){
            return clientRemoteHelper.createClientRemoteWSDTO(clientRemoteDBModel.get());
        }
        return null;
    }

    public ClientRemoteWSDTO createClientRemoteService(long userId,String operationId,String remoteId) {

        Optional<OperationDBModel> operationDBModel = operationRepository.findById(operationId);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByOperationId(operationId);
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (!sessionDBModels.isEmpty() && operationDBModel.isPresent() && remoteDBModel.isPresent()){
            return clientRemoteHelper.createClientRemoteWSDTO(clientRemoteRepository.save(clientRemoteHelper.createClientRemoteDBModel(sessionDBModels.get(0),operationDBModel.get(),remoteDBModel.get())));
        }
        return null;
    }

    public ClientRemoteWSDTO updateClientRemoteService(long userId, String clientRemoteId, String remoteState) {

        Optional<ClientRemoteDBModel>clientRemoteDBModel = clientRemoteRepository.findById(clientRemoteId);
        if (clientRemoteDBModel.isPresent()){
            clientRemoteDBModel.get().setRemoteState(remoteState);
            clientRemoteDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            return clientRemoteHelper.createClientRemoteWSDTO(clientRemoteRepository.save(clientRemoteDBModel.get()));
        }
        return null;
    }

    public ClientRemoteWSDTO removeClientRemoteService(long userId, String clientRemoteId) {

        Optional<ClientRemoteDBModel> clientRemoteDBModel = clientRemoteRepository.findById(clientRemoteId);
        if (clientRemoteDBModel.isPresent()){
            clientRemoteRepository.delete(clientRemoteDBModel.get());
            return clientRemoteHelper.createClientRemoteWSDTO(clientRemoteDBModel.get());
        }
        return null;
    }


}
