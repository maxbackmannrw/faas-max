package com.faas.core.api.middleware.operation.device;

import com.faas.core.api.framework.operation.device.ApiOperationDeviceFramework;
import com.faas.core.api.model.ws.client.device.ApiClientDeviceWSModel;
import com.faas.core.api.model.ws.operation.device.dto.ApiOperationDeviceWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationDeviceMiddleware {


    @Autowired
    ApiOperationDeviceFramework apiOperationDeviceFramework;


    public ApiClientDeviceWSModel apiGetOperationDevices(long agentId, long sessionId, long clientId, String campaignId) {

        ApiClientDeviceWSModel response = new ApiClientDeviceWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationDeviceWSDTO operationDeviceWSDTO = apiOperationDeviceFramework.apiGetOperationDevicesService();
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

        ApiOperationDeviceWSDTO operationDeviceWSDTO = apiOperationDeviceFramework.apiGetOperationDeviceService();
        if (operationDeviceWSDTO != null){
        }

        general.setOperation("apiGetOperationDevice");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientDeviceWSModel apiCreateOperationDevice(long agentId, long sessionId, long clientId, String campaignId) {

        ApiClientDeviceWSModel response = new ApiClientDeviceWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationDeviceWSDTO operationDeviceWSDTO = apiOperationDeviceFramework.apiCreateOperationDeviceService();
        if (operationDeviceWSDTO != null){
        }

        general.setOperation("apiCreateOperationDevice");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientDeviceWSModel apiUpdateOperationDevice(long agentId, long sessionId, long clientId, String campaignId) {

        ApiClientDeviceWSModel response = new ApiClientDeviceWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationDeviceWSDTO operationDeviceWSDTO = apiOperationDeviceFramework.apiUpdateOperationDeviceService();
        if (operationDeviceWSDTO != null){
        }

        general.setOperation("apiUpdateOperationDevice");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiClientDeviceWSModel apiRemoveOperationDevice(long agentId, long sessionId, long clientId, String campaignId) {

        ApiClientDeviceWSModel response = new ApiClientDeviceWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationDeviceWSDTO operationDeviceWSDTO = apiOperationDeviceFramework.apiRemoveOperationDeviceService();
        if (operationDeviceWSDTO != null){
        }

        general.setOperation("apiRemoveOperationDevice");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
