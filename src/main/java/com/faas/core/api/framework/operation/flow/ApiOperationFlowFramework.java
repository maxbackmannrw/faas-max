package com.faas.core.api.framework.operation.flow;

import com.faas.core.api.model.ws.operation.flow.dto.ApiOperationFlowWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationFlowFramework {


    @Autowired
    AppUtils appUtils;


    public ApiOperationFlowWSDTO apiGetOperationFlowService(){

        ApiOperationFlowWSDTO operationFlowWSDTO = new ApiOperationFlowWSDTO();

        return operationFlowWSDTO;
    }



}
