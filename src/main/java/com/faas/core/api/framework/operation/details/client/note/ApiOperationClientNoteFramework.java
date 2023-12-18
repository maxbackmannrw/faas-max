package com.faas.core.api.framework.operation.details.client.note;

import com.faas.core.api.model.ws.client.details.dto.ApiClientNoteWSDTO;
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
    AppUtils appUtils;


    public List<ApiClientNoteWSDTO> apiGetClientNotesService(long agentId, long clientId) {

        List<ApiClientNoteWSDTO> clientNoteWSDTOS = new ArrayList<>();

        return clientNoteWSDTOS;
    }

    public ApiClientNoteWSDTO apiGetClientNoteService(long agentId, long sessionId, long clientId, long noteId) {

        return null;
    }

    public ApiClientNoteWSDTO apiCreateClientNoteService(long agentId, long sessionId, long clientId, String noteTitle, String noteText, String noteAsset) {


        return null;
    }

    public ApiClientNoteWSDTO apiUpdateClientNoteService(long agentId, long sessionId, long clientId, long noteId, String noteTitle, String noteText, String noteAsset) {


        return null;
    }

    public ApiClientNoteWSDTO apiRemoveClientNoteService(long agentId, long sessionId, long clientId, long noteId) {


        return null;
    }


}
