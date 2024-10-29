package com.faas.core.api.middleware.operation.manager.client;

import com.faas.core.api.framework.operation.manager.client.ApiOperationClientFramework;
import com.faas.core.api.model.ws.operation.manager.client.ApiOperationClientWSModel;
import com.faas.core.api.model.ws.operation.manager.client.ApiOperationClientIntelWSModel;
import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.manager.client.ApiOperationClientNoteWSModel;
import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientIntelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.data.db.client.details.dao.ClientNoteDAO;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationClientMiddleware {


    @Autowired
    ApiOperationClientFramework apiOperationClientFramework;


    public ApiOperationClientWSModel apiGetOperationClient(long agentId, long clientId) {

        ApiOperationClientWSModel response = new ApiOperationClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationClientWSDTO operationClientWSDTO = apiOperationClientFramework.apiGetOperationClientService(agentId, clientId);
        if (operationClientWSDTO != null) {
            response.setOperationClient(operationClientWSDTO);
        }

        general.setOperation("apiGetOperationClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientNoteWSModel apiGetOperationClientNotes(long agentId, String operationId) {

        ApiOperationClientNoteWSModel response = new ApiOperationClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientNoteDAO> operationClientNotes = apiOperationClientFramework.apiGetOperationClientNotesService(agentId, operationId);
        if (operationClientNotes != null) {
            response.setOperationClientNotes(operationClientNotes);
        }

        general.setOperation("apiGetOperationClientNotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientNoteWSModel apiGetOperationClientNote(long agentId, String operationId, String noteId) {

        ApiOperationClientNoteWSModel response = new ApiOperationClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientNoteDAO> operationClientNotes = new ArrayList<>();

        ClientNoteDAO operationClientNote = apiOperationClientFramework.apiGetOperationClientNoteService(agentId, operationId, noteId);
        if (operationClientNote != null) {
            operationClientNotes.add(operationClientNote);
        }

        response.setOperationClientNotes(operationClientNotes);
        general.setOperation("apiGetOperationClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientNoteWSModel apiCreateOperationClientNote(long agentId, String operationId, String noteTitle, String noteBody) {

        ApiOperationClientNoteWSModel response = new ApiOperationClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientNoteDAO> operationClientNotes = new ArrayList<>();

        ClientNoteDAO operationClientNote = apiOperationClientFramework.apiCreateOperationClientNoteService(agentId, operationId, noteTitle, noteBody);
        if (operationClientNote != null) {
            operationClientNotes.add(operationClientNote);
        }

        response.setOperationClientNotes(operationClientNotes);
        general.setOperation("apiCreateOperationClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientNoteWSModel apiUpdateOperationClientNote(long agentId, String operationId, String noteId, String noteTitle, String noteBody) {

        ApiOperationClientNoteWSModel response = new ApiOperationClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientNoteDAO> operationClientNotes = new ArrayList<>();

        ClientNoteDAO operationClientNote = apiOperationClientFramework.apiUpdateOperationClientNoteService(agentId, operationId, noteId, noteTitle, noteBody);
        if (operationClientNote != null) {
            operationClientNotes.add(operationClientNote);
        }

        response.setOperationClientNotes(operationClientNotes);
        general.setOperation("apiUpdateOperationClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientNoteWSModel apiRemoveOperationClientNote(long agentId, String operationId, String noteId) {

        ApiOperationClientNoteWSModel response = new ApiOperationClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientNoteDAO> operationClientNotes = new ArrayList<>();

        ClientNoteDAO operationClientNote = apiOperationClientFramework.apiRemoveOperationClientNoteService(agentId, operationId, noteId);
        if (operationClientNote != null) {
            operationClientNotes.add(operationClientNote);
        }

        response.setOperationClientNotes(operationClientNotes);
        general.setOperation("apiRemoveOperationClientNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationClientIntelWSModel apiGetOperationClientIntels(long agentId, long clientId) {

        ApiOperationClientIntelWSModel response = new ApiOperationClientIntelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationClientIntelWSDTO> operationClientIntelWSDTOS = apiOperationClientFramework.apiGetOperationClientIntelsService(agentId, clientId);
        if (operationClientIntelWSDTOS != null) {
            response.setOperationClientIntels(operationClientIntelWSDTOS);
        }

        general.setOperation("apiGetOperationClientIntels");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientIntelWSModel apiGetOperationClientIntel(long agentId, long clientId) {

        ApiOperationClientIntelWSModel response = new ApiOperationClientIntelWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationClientIntelWSDTO> operationClientIntelWSDTOS = new ArrayList<>();

        ApiOperationClientIntelWSDTO operationClientIntelWSDTO = apiOperationClientFramework.apiGetOperationClientIntelService(agentId, clientId);
        if (operationClientIntelWSDTO != null) {
            operationClientIntelWSDTOS.add(operationClientIntelWSDTO);
        }

        response.setOperationClientIntels(operationClientIntelWSDTOS);
        general.setOperation("apiGetOperationClientIntel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
