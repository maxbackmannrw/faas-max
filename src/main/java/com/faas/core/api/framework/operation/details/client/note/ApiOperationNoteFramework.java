package com.faas.core.api.framework.operation.details.client.note;

import com.faas.core.api.model.ws.operation.details.client.note.dto.ApiOperationNoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationNoteFramework {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;


    @Autowired
    AppUtils appUtils;


    public List<ApiOperationNoteWSDTO> apiGetOperationNotesService(long agentId, long clientId) {

        List<ApiOperationNoteWSDTO> clientNoteWSDTOS = new ArrayList<>();

        return clientNoteWSDTOS;
    }

    public ApiOperationNoteWSDTO apiGetOperationNoteService(long agentId, long sessionId, long clientId, long noteId) {

        return null;
    }

    public ApiOperationNoteWSDTO apiCreateOperationNoteService(long agentId, long sessionId, long clientId, String noteTitle, String noteText, String noteAsset) {


        return null;
    }

    public ApiOperationNoteWSDTO apiUpdateOperationNoteService(long agentId, long sessionId, long clientId, long noteId, String noteTitle, String noteText, String noteAsset) {


        return null;
    }

    public ApiOperationNoteWSDTO apiRemoveOperationNoteService(long agentId, long sessionId, long clientId, long noteId) {


        return null;
    }


}
