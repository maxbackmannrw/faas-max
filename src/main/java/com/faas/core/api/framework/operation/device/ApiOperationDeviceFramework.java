package com.faas.core.api.framework.operation.device;

import com.faas.core.api.model.ws.operation.device.dto.ApiOperationDeviceWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationDeviceFramework {


    @Autowired
    AppUtils appUtils;


    public ApiOperationDeviceWSDTO apiGetOperationDevicesService(){

        ApiOperationDeviceWSDTO operationDeviceWSDTO = new ApiOperationDeviceWSDTO();
        return operationDeviceWSDTO;
    }

    public ApiOperationDeviceWSDTO apiGetOperationDeviceService(){

        ApiOperationDeviceWSDTO operationDeviceWSDTO = new ApiOperationDeviceWSDTO();
        return operationDeviceWSDTO;
    }

    public ApiOperationDeviceWSDTO apiCreateOperationDeviceService(){

        ApiOperationDeviceWSDTO operationDeviceWSDTO = new ApiOperationDeviceWSDTO();
        return operationDeviceWSDTO;
    }

    public ApiOperationDeviceWSDTO apiUpdateOperationDeviceService(){

        ApiOperationDeviceWSDTO operationDeviceWSDTO = new ApiOperationDeviceWSDTO();
        return operationDeviceWSDTO;
    }

    public ApiOperationDeviceWSDTO apiRemoveOperationDeviceService(){

        ApiOperationDeviceWSDTO operationDeviceWSDTO = new ApiOperationDeviceWSDTO();
        return operationDeviceWSDTO;
    }

}
