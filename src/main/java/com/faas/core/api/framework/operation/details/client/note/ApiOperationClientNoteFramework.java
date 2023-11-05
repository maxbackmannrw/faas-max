package com.faas.core.api.framework.operation.details.client.note;

import com.faas.core.api.model.ws.client.details.dto.ApiClientNoteWSDTO;
import com.faas.core.base.model.db.client.details.ClientNoteDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationClientNoteFramework {

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


    public List<ApiClientNoteWSDTO> apiGetClientNotesService(long agentId, long clientId) {

        List<ApiClientNoteWSDTO> clientNoteWSDTOS = new ArrayList<>();
        List<ClientNoteDBModel> clientNoteDBModels = clientNoteRepository.findByClientId(clientId);
        for (ClientNoteDBModel clientNoteDBModel : clientNoteDBModels) {
            clientNoteWSDTOS.add(new ApiClientNoteWSDTO(clientNoteDBModel));
        }
        return clientNoteWSDTOS;
    }

    public ApiClientNoteWSDTO apiGetClientNoteService(long agentId, long sessionId, long clientId, long noteId) {

        List<ClientNoteDBModel> clientNoteDBModels = clientNoteRepository.findByIdAndSessionIdAndClientId(noteId,sessionId,clientId);
        if (!clientNoteDBModels.isEmpty()){
            return new ApiClientNoteWSDTO(clientNoteDBModels.get(0));
        }
        return null;
    }

    public ApiClientNoteWSDTO apiCreateClientNoteService(long agentId, long sessionId, long clientId, String noteTitle, String noteText, String noteAsset) {

        ClientNoteDBModel clientNoteDBModel = new ClientNoteDBModel();
        clientNoteDBModel.setClientId(clientId);
        clientNoteDBModel.setSessionId(sessionId);
        clientNoteDBModel.setCreatorId(agentId);
        clientNoteDBModel.setNoteTitle(noteTitle);
        clientNoteDBModel.setNoteText(noteText);
        clientNoteDBModel.setNoteAsset(noteAsset);
        clientNoteDBModel.setuDate(appUtils.getCurrentTimeStamp());
        clientNoteDBModel.setcDate(appUtils.getCurrentTimeStamp());
        clientNoteDBModel.setStatus(1);

        return new ApiClientNoteWSDTO(clientNoteRepository.save(clientNoteDBModel)) ;
    }

    public ApiClientNoteWSDTO apiUpdateClientNoteService(long agentId, long sessionId, long clientId, long noteId, String noteTitle, String noteText, String noteAsset) {

        List<ClientNoteDBModel> clientNoteDBModel = clientNoteRepository.findByIdAndSessionIdAndClientId(noteId,sessionId,clientId);
        if (!clientNoteDBModel.isEmpty()){

            clientNoteDBModel.get(0).setCreatorId(agentId);
            clientNoteDBModel.get(0).setNoteTitle(noteTitle);
            clientNoteDBModel.get(0).setNoteText(noteText);
            clientNoteDBModel.get(0).setNoteAsset(noteAsset);
            clientNoteDBModel.get(0).setuDate(appUtils.getCurrentTimeStamp());
            clientNoteDBModel.get(0).setStatus(1);

            return new ApiClientNoteWSDTO(clientNoteRepository.save(clientNoteDBModel.get(0)));
        }
        return null;
    }

    public ApiClientNoteWSDTO apiRemoveClientNoteService(long agentId, long sessionId, long clientId, long noteId) {

        List<ClientNoteDBModel> clientNoteDBModels = clientNoteRepository.findByIdAndSessionIdAndClientId(noteId,sessionId,clientId);
        if (!clientNoteDBModels.isEmpty()){
            ApiClientNoteWSDTO operationNoteWSDTO =  new ApiClientNoteWSDTO();
            clientNoteRepository.delete(clientNoteDBModels.get(0));

            return operationNoteWSDTO;
        }
        return null;
    }


}
