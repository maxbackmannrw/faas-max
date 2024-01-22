package com.faas.core.api.middleware.operation.details.client;

import com.faas.core.api.framework.operation.details.client.ApiOperationClientFramework;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationClientWSModel;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationNoteWSModel;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationOSINTWSModel;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationNoteWSDTO;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationOSINTWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationClientMiddleware {


    @Autowired
    ApiOperationClientFramework apiOperationClientFramework;


    public ApiOperationClientWSModel apiGetOperationClient(long agentId, long sessionId, long clientId) {

        ApiOperationClientWSModel response = new ApiOperationClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationClientWSDTO operationClientWSDTO = apiOperationClientFramework.apiGetOperationClientService(agentId,sessionId,clientId);
        if (operationClientWSDTO != null){
            response.setOperationClient(operationClientWSDTO);
        }

        general.setOperation("apiGetOperationClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationNoteWSModel apiGetOperationNotes(long agentId, long clientId) {

        ApiOperationNoteWSModel response = new ApiOperationNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationNoteWSDTO> clientNoteWSDTOS = apiOperationClientFramework.apiGetOperationNotesService(agentId,clientId);
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

        ApiOperationNoteWSDTO clientNoteWSDTO = apiOperationClientFramework.apiGetOperationNoteService(agentId,sessionId,clientId,noteId);
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

        ApiOperationNoteWSDTO clientNoteWSDTO = apiOperationClientFramework.apiCreateOperationNoteService(agentId,sessionId,clientId,noteTitle,noteText,noteAsset);
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

        ApiOperationNoteWSDTO clientNoteWSDTO = apiOperationClientFramework.apiUpdateOperationNoteService(agentId,sessionId,clientId,noteId,noteTitle,noteText,noteAsset);
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

        ApiOperationNoteWSDTO clientNoteWSDTO = apiOperationClientFramework.apiRemoveOperationNoteService(agentId,sessionId,clientId,noteId);
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



    public ApiOperationOSINTWSModel apiGetOperationOSINTs(long agentId, long clientId) {

        ApiOperationOSINTWSModel response = new ApiOperationOSINTWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationOSINTWSDTO> operationOSINTWSDTOS = apiOperationClientFramework.apiGetOperationOSINTsService(agentId,clientId);
        if (operationOSINTWSDTOS != null){
            response.setOperationOSINTs(operationOSINTWSDTOS);
        }

        general.setOperation("apiGetOperationOSINTs");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationOSINTWSModel apiGetOperationOSINT(long agentId, long clientId) {

        ApiOperationOSINTWSModel response = new ApiOperationOSINTWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationOSINTWSDTO> operationOSINTWSDTOS = new ArrayList<>();

        ApiOperationOSINTWSDTO operationOSINTWSDTO = apiOperationClientFramework.apiGetOperationOSINTService(agentId,clientId);
        if (operationOSINTWSDTO != null){
            operationOSINTWSDTOS.add(operationOSINTWSDTO);
        }

        response.setOperationOSINTs(operationOSINTWSDTOS);
        general.setOperation("apiGetOperationOSINT");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
