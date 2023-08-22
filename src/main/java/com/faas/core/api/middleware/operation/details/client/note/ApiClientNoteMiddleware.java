package com.faas.core.api.middleware.operation.details.client.note;

import com.faas.core.api.framework.operation.details.client.note.ApiClientNoteFramework;
import com.faas.core.api.model.ws.operation.details.client.note.ApiClientNoteWSModel;
import com.faas.core.api.model.ws.operation.details.client.note.dto.ApiClientNoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiClientNoteMiddleware {


    @Autowired
    ApiClientNoteFramework apiClientNoteFramework;


    public ApiClientNoteWSModel apiGetClientNotes(long agentId, long clientId) {

        ApiClientNoteWSModel response = new ApiClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiClientNoteWSDTO> clientNoteWSDTOS = apiClientNoteFramework.apiGetClientNotesService(agentId,clientId);
        if (clientNoteWSDTOS != null){
            response.setClientNotes(clientNoteWSDTOS);
        }

        general.setOperation("apiGetOperationNotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiClientNoteWSModel apiGetClientNote(long agentId, long sessionId, long clientId, long noteId) {

        ApiClientNoteWSModel response = new ApiClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiClientNoteWSDTO>clientNoteWSDTOS = new ArrayList<>();

        ApiClientNoteWSDTO clientNoteWSDTO = apiClientNoteFramework.apiGetClientNoteService(agentId,sessionId,clientId,noteId);
        if (clientNoteWSDTO != null){
            clientNoteWSDTOS.add(clientNoteWSDTO);
        }

        response.setClientNotes(clientNoteWSDTOS);
        general.setOperation("apiGetClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiClientNoteWSModel apiCreateClientNote(long agentId, long sessionId, long clientId, String noteTitle, String noteText, String noteAsset) {

        ApiClientNoteWSModel response = new ApiClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiClientNoteWSDTO>clientNoteWSDTOS = new ArrayList<>();

        ApiClientNoteWSDTO clientNoteWSDTO = apiClientNoteFramework.apiCreateClientNoteService(agentId,sessionId,clientId,noteTitle,noteText,noteAsset);
        if (clientNoteWSDTO != null){
            clientNoteWSDTOS.add(clientNoteWSDTO);
        }

        response.setClientNotes(clientNoteWSDTOS);
        general.setOperation("apiCreateClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiClientNoteWSModel apiUpdateClientNote(long agentId, long sessionId, long clientId, long noteId, String noteTitle, String noteText, String noteAsset) {

        ApiClientNoteWSModel response = new ApiClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiClientNoteWSDTO>clientNoteWSDTOS = new ArrayList<>();

        ApiClientNoteWSDTO clientNoteWSDTO = apiClientNoteFramework.apiUpdateClientNoteService(agentId,sessionId,clientId,noteId,noteTitle,noteText,noteAsset);
        if (clientNoteWSDTO != null){
            clientNoteWSDTOS.add(clientNoteWSDTO);
        }

        response.setClientNotes(clientNoteWSDTOS);
        general.setOperation("apiUpdateClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiClientNoteWSModel apiRemoveClientNote(long agentId, long sessionId, long clientId, long noteId) {

        ApiClientNoteWSModel response = new ApiClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiClientNoteWSDTO>clientNoteWSDTOS = new ArrayList<>();

        ApiClientNoteWSDTO clientNoteWSDTO = apiClientNoteFramework.apiRemoveClientNoteService(agentId,sessionId,clientId,noteId);
        if (clientNoteWSDTO != null){
            clientNoteWSDTOS.add(clientNoteWSDTO);
        }

        response.setClientNotes(clientNoteWSDTOS);
        general.setOperation("apiRemoveClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
