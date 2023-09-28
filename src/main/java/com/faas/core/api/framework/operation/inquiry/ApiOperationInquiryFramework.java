package com.faas.core.api.framework.operation.inquiry;

import com.faas.core.api.model.ws.operation.device.dto.ApiOperationDeviceWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationInquiryFramework {


    @Autowired
    AppUtils appUtils;


    public ApiOperationDeviceWSDTO apiGetOperationClientInquiryService(){

        ApiOperationDeviceWSDTO operationPeerWSDTO = new ApiOperationDeviceWSDTO();
        return operationPeerWSDTO;
    }



}
