package com.faas.core.api.middleware.operation.details.note;

import com.faas.core.api.framework.operation.details.note.ApiOperationNoteFramework;
import com.faas.core.api.model.ws.operation.details.note.ApiOperationNoteWSModel;
import com.faas.core.api.model.ws.operation.details.note.dto.ApiOperationNoteWSDTO;
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


    public ApiOperationNoteWSModel apiGetOperationNotes(long agentId,String operationId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationNoteWSDTO> operationNoteWSDTOS = apiOperationNoteFramework.apiGetOperationNotesService(agentId,operationId);
        if (operationNoteWSDTOS != null){
            response.setOperationNotes(operationNoteWSDTOS);
        }

        general.setOperation("apiGetOperationNotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationNoteWSModel apiGetOperationNote(long agentId,String operationId,String noteId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationNoteWSDTO>operationNoteWSDTOS = new ArrayList<>();

        ApiOperationNoteWSDTO operationNoteWSDTO = apiOperationNoteFramework.apiGetOperationNoteService(agentId,operationId,noteId);
        if (operationNoteWSDTO != null){
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

    public ApiOperationNoteWSModel apiCreateOperationNote(long agentId,String operationId,String noteTitle,String noteText,String noteAsset) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationNoteWSDTO>operationNoteWSDTOS = new ArrayList<>();

        ApiOperationNoteWSDTO operationNoteWSDTO = apiOperationNoteFramework.apiCreateOperationNoteService(agentId,operationId,noteTitle,noteText,noteAsset);
        if (operationNoteWSDTO != null){
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

    public ApiOperationNoteWSModel apiUpdateOperationNote(long agentId,String operationId,String noteId,String noteTitle,String noteText, String noteAsset) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationNoteWSDTO>operationNoteWSDTOS = new ArrayList<>();

        ApiOperationNoteWSDTO operationNoteWSDTO = apiOperationNoteFramework.apiUpdateOperationNoteService(agentId,operationId,noteId,noteTitle,noteText,noteAsset);
        if (operationNoteWSDTO != null){
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

    public ApiOperationNoteWSModel apiRemoveOperationNote(long agentId,String operationId,String noteId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationNoteWSDTO>operationNoteWSDTOS = new ArrayList<>();

        ApiOperationNoteWSDTO operationNoteWSDTO = apiOperationNoteFramework.apiRemoveOperationNoteService(agentId,operationId,noteId);
        if (operationNoteWSDTO != null){
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
