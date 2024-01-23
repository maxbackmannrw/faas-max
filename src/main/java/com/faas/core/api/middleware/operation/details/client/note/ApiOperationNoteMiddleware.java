package com.faas.core.api.middleware.operation.details.client.note;

import com.faas.core.api.framework.operation.details.client.note.ApiOperationNoteFramework;
import com.faas.core.api.model.ws.operation.details.client.note.ApiOperationNoteWSModel;
import com.faas.core.api.model.ws.operation.details.client.note.dto.ApiOperationNoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationNoteMiddleware {


    @Autowired
    ApiOperationNoteFramework apiOperationNoteFramework;


    public ApiOperationNoteWSModel apiGetOperationNotes(long agentId, long clientId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationNoteWSDTO> clientNoteWSDTOS = apiOperationNoteFramework.apiGetOperationNotesService(agentId,clientId);
        if (clientNoteWSDTOS != null){
        }

        general.setOperation("apiGetOperationNotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiGetOperationNote(long agentId, long sessionId, long clientId, long noteId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationNoteWSDTO>clientNoteWSDTOS = new ArrayList<>();

        ApiOperationNoteWSDTO clientNoteWSDTO = apiOperationNoteFramework.apiGetOperationNoteService(agentId,sessionId,clientId,noteId);
        if (clientNoteWSDTO != null){
            clientNoteWSDTOS.add(clientNoteWSDTO);
        }

        general.setOperation("apiGetOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiCreateOperationNote(long agentId, long sessionId, long clientId, String noteTitle, String noteText, String noteAsset) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationNoteWSDTO>clientNoteWSDTOS = new ArrayList<>();

        ApiOperationNoteWSDTO clientNoteWSDTO = apiOperationNoteFramework.apiCreateOperationNoteService(agentId,sessionId,clientId,noteTitle,noteText,noteAsset);
        if (clientNoteWSDTO != null){
            clientNoteWSDTOS.add(clientNoteWSDTO);
        }

        general.setOperation("apiCreateOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiUpdateOperationNote(long agentId, long sessionId, long clientId, long noteId, String noteTitle, String noteText, String noteAsset) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationNoteWSDTO>clientNoteWSDTOS = new ArrayList<>();

        ApiOperationNoteWSDTO clientNoteWSDTO = apiOperationNoteFramework.apiUpdateOperationNoteService(agentId,sessionId,clientId,noteId,noteTitle,noteText,noteAsset);
        if (clientNoteWSDTO != null){
            clientNoteWSDTOS.add(clientNoteWSDTO);
        }

        general.setOperation("apiUpdateOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiRemoveOperationNote(long agentId, long sessionId, long clientId, long noteId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationNoteWSDTO>clientNoteWSDTOS = new ArrayList<>();

        ApiOperationNoteWSDTO clientNoteWSDTO = apiOperationNoteFramework.apiRemoveOperationNoteService(agentId,sessionId,clientId,noteId);
        if (clientNoteWSDTO != null){
            clientNoteWSDTOS.add(clientNoteWSDTO);
        }

        general.setOperation("apiRemoveOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
