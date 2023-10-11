package com.faas.core.api.middleware.operation.details.client;

import com.faas.core.api.framework.operation.details.client.ApiOperationClientFramework;
import com.faas.core.api.model.ws.client.details.ApiClientOsIntWSModel;
import com.faas.core.api.model.ws.client.details.dto.ApiClientOsIntWSDTO;
import com.faas.core.api.model.ws.client.details.ApiClientDeviceWSModel;
import com.faas.core.api.model.ws.operation.details.client.ApiOperationClientWSModel;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationClientWSDTO;
import com.faas.core.api.model.ws.operation.details.client.dto.ApiOperationDeviceWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
