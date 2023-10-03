package com.faas.core.api.middleware.operation.details.client;

import com.faas.core.api.framework.operation.details.client.ApiOperationClientFramework;
import com.faas.core.api.model.ws.client.details.ApiClientNoteWSModel;
import com.faas.core.api.model.ws.client.details.ApiClientOsIntWSModel;
import com.faas.core.api.model.ws.client.details.dto.ApiClientNoteWSDTO;
import com.faas.core.api.model.ws.client.details.dto.ApiClientOsIntWSDTO;
import com.faas.core.api.model.ws.client.device.ApiClientDeviceWSModel;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationClientWSModel;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationDeviceWSDTO;
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



    public ApiClientDeviceWSModel apiGetOperationDevices(long agentId, long sessionId, long clientId, String campaignId) {

        ApiClientDeviceWSModel response = new ApiClientDeviceWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationDeviceWSDTO operationDeviceWSDTO = apiOperationClientFramework.apiGetOperationDevicesService();
        if (operationDeviceWSDTO != null){
        }

        general.setOperation("apiGetOperationDevices");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientDeviceWSModel apiGetOperationDevice(long agentId, long sessionId, long clientId, String campaignId) {

        ApiClientDeviceWSModel response = new ApiClientDeviceWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationDeviceWSDTO operationDeviceWSDTO = apiOperationClientFramework.apiGetOperationDeviceService();
        if (operationDeviceWSDTO != null){
        }

        general.setOperation("apiGetOperationDevice");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiClientNoteWSModel apiGetClientNotes(long agentId, long clientId) {

        ApiClientNoteWSModel response = new ApiClientNoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiClientNoteWSDTO> clientNoteWSDTOS = apiOperationClientFramework.apiGetClientNotesService(agentId,clientId);
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

        ApiClientNoteWSDTO clientNoteWSDTO = apiOperationClientFramework.apiGetClientNoteService(agentId,sessionId,clientId,noteId);
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

        ApiClientNoteWSDTO clientNoteWSDTO = apiOperationClientFramework.apiCreateClientNoteService(agentId,sessionId,clientId,noteTitle,noteText,noteAsset);
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

        ApiClientNoteWSDTO clientNoteWSDTO = apiOperationClientFramework.apiUpdateClientNoteService(agentId,sessionId,clientId,noteId,noteTitle,noteText,noteAsset);
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

        ApiClientNoteWSDTO clientNoteWSDTO = apiOperationClientFramework.apiRemoveClientNoteService(agentId,sessionId,clientId,noteId);
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



    public ApiClientOsIntWSModel apiGetClientOsInt(long agentId, long sessionId, long clientId) {

        ApiClientOsIntWSModel response = new ApiClientOsIntWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiClientOsIntWSDTO> clientOsIntWSDTOS = apiOperationClientFramework.apiGetClientOsIntService();
        if (clientOsIntWSDTOS != null){
            response.setClientOsInts(clientOsIntWSDTOS);
        }

        general.setOperation("apiGetClientOsInt");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
