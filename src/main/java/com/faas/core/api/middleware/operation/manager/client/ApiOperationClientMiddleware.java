package com.faas.core.api.middleware.operation.manager.client;

import com.faas.core.api.framework.operation.manager.client.ApiOperationClientFramework;
import com.faas.core.api.model.ws.operation.manager.client.ApiOperationClientWSModel;
import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.manager.client.ApiOperationNoteWSModel;
import com.faas.core.api.model.ws.operation.manager.client.dto.ApiOperationNoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationClientMiddleware {


    @Autowired
    ApiOperationClientFramework apiOperationClientFramework;


    public ApiOperationClientWSModel apiGetClient(long agentId, long clientId) {

        ApiOperationClientWSModel response = new ApiOperationClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationClientWSDTO clientWSDTO = apiOperationClientFramework.apiGetClientService(agentId, clientId);
        if (clientWSDTO != null) {
            response.setClient(clientWSDTO);
        }

        general.setOperation("apiGetClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiGetOperationNotes(long agentId, String operationId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationNoteWSDTO> operationNoteWSDTOS = apiOperationClientFramework.apiGetOperationNotesService(agentId, operationId);
        if (operationNoteWSDTOS != null) {
            response.setOperationNotes(operationNoteWSDTOS);
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
        List<ApiOperationNoteWSDTO> operationNoteWSDTOS = new ArrayList<>();

        ApiOperationNoteWSDTO operationNoteWSDTO = apiOperationClientFramework.apiGetOperationNoteService(agentId, operationId, noteId);
        if (operationNoteWSDTO != null) {
            operationNoteWSDTOS.add(operationNoteWSDTO);
        }

        response.setOperationNotes(operationNoteWSDTOS);
        general.setOperation("apiGetOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiCreateOperationNote(long agentId, String operationId, String noteTitle, String noteText, String noteAsset) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationNoteWSDTO> operationNoteWSDTOS = new ArrayList<>();

        ApiOperationNoteWSDTO operationNoteWSDTO = apiOperationClientFramework.apiCreateOperationNoteService(agentId, operationId, noteTitle, noteText, noteAsset);
        if (operationNoteWSDTO != null) {
            operationNoteWSDTOS.add(operationNoteWSDTO);
        }

        response.setOperationNotes(operationNoteWSDTOS);
        general.setOperation("apiCreateOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiUpdateOperationNote(long agentId, String operationId, String noteId, String noteTitle, String noteText, String noteAsset) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationNoteWSDTO> operationNoteWSDTOS = new ArrayList<>();

        ApiOperationNoteWSDTO operationNoteWSDTO = apiOperationClientFramework.apiUpdateOperationNoteService(agentId, operationId, noteId, noteTitle, noteText, noteAsset);
        if (operationNoteWSDTO != null) {
            operationNoteWSDTOS.add(operationNoteWSDTO);
        }

        response.setOperationNotes(operationNoteWSDTOS);
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
        List<ApiOperationNoteWSDTO> operationNoteWSDTOS = new ArrayList<>();

        ApiOperationNoteWSDTO operationNoteWSDTO = apiOperationClientFramework.apiRemoveOperationNoteService(agentId, operationId, noteId);
        if (operationNoteWSDTO != null) {
            operationNoteWSDTOS.add(operationNoteWSDTO);
        }

        response.setOperationNotes(operationNoteWSDTOS);
        general.setOperation("apiRemoveOperationNote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
