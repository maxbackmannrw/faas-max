package com.faas.core.api.framework.operation.details.client;

import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationNoteWSDTO;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationOSINTWSDTO;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ApiOperationClientFramework {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public ApiOperationClientWSDTO apiGetOperationClientService(long agentId, long sessionId,long clientId){

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        List<SessionDBModel> sessionDBModels = sessionRepository.findByIdAndClientId(sessionId,clientId);
        if (clientDBModel.isPresent() && !sessionDBModels.isEmpty()){

            ApiOperationClientWSDTO operationClientWSDTO = new ApiOperationClientWSDTO();
            operationClientWSDTO.setClient(clientDBModel.get());

            return operationClientWSDTO;
        }
        return null;
    }


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


    public List<ApiOperationOSINTWSDTO> apiGetOperationOSINTsService(long agentId, long clientId){

        return null;
    }

    public ApiOperationOSINTWSDTO apiGetOperationOSINTService(long agentId,long clientId){

        return null;
    }


}
