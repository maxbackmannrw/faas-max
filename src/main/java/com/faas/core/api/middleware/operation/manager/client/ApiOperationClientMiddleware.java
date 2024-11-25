package com.faas.core.api.middleware.operation.manager.client;

import com.faas.core.api.framework.operation.manager.client.ApiOperationClientFramework;
import com.faas.core.api.model.ws.operation.manager.client.ApiOperationClientWSModel;
import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.manager.client.ApiOperationNoteWSModel;
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

    public ApiOperationNoteWSModel apiGetOperationNotes(long agentId, String operationId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientNoteDAO> operationNotes = apiOperationClientFramework.apiGetOperationNotesService(agentId, operationId);
        if (operationNotes != null) {
            response.setOperationNotes(operationNotes);
        }

        general.setOperation("apiGetOperationNotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiGetOperationNote(long agentId, String operationId, String noteId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientNoteDAO> operationNotes = new ArrayList<>();

        ClientNoteDAO operationNote = apiOperationClientFramework.apiGetOperationNoteService(agentId, operationId, noteId);
        if (operationNote != null) {
            operationNotes.add(operationNote);
        }

        response.setOperationNotes(operationNotes);
        general.setOperation("apiGetOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiCreateOperationNote(long agentId, String operationId, String noteTitle, String noteBody) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientNoteDAO> operationNotes = new ArrayList<>();

        ClientNoteDAO operationNote = apiOperationClientFramework.apiCreateOperationNoteService(agentId, operationId, noteTitle, noteBody);
        if (operationNote != null) {
            operationNotes.add(operationNote);
        }

        response.setOperationNotes(operationNotes);
        general.setOperation("apiCreateOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiUpdateOperationNote(long agentId, String operationId, String noteId, String noteTitle, String noteBody) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientNoteDAO> operationNotes = new ArrayList<>();

        ClientNoteDAO operationNote = apiOperationClientFramework.apiUpdateOperationNoteService(agentId, operationId, noteId, noteTitle, noteBody);
        if (operationNote != null) {
            operationNotes.add(operationNote);
        }

        response.setOperationNotes(operationNotes);
        general.setOperation("apiUpdateOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiRemoveOperationNote(long agentId, String operationId, String noteId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientNoteDAO> operationNotes = new ArrayList<>();

        ClientNoteDAO operationNote = apiOperationClientFramework.apiRemoveOperationNoteService(agentId, operationId, noteId);
        if (operationNote != null) {
            operationNotes.add(operationNote);
        }

        response.setOperationNotes(operationNotes);
        general.setOperation("apiRemoveOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
