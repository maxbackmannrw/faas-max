package com.faas.core.api.framework.operation.flow;

import com.faas.core.api.model.ws.operation.device.dto.ApiOperationDeviceWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationFlowFramework {


    @Autowired
    AppUtils appUtils;


    public ApiOperationDeviceWSDTO apiGetOperationFlowService(){

        ApiOperationDeviceWSDTO operationDeviceWSDTO = new ApiOperationDeviceWSDTO();

        return operationDeviceWSDTO;
    }



}
