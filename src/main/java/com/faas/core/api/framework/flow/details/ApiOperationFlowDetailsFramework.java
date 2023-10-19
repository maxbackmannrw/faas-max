package com.faas.core.api.framework.flow.details;

import com.faas.core.api.model.ws.flow.details.dto.ApiOperationFlowDetailsWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationFlowDetailsFramework {


    @Autowired
    AppUtils appUtils;


    public ApiOperationFlowDetailsWSDTO apiGetOperationFlowDetailsService(long agentId, long inquiryId){

        ApiOperationFlowDetailsWSDTO flowDetailsWSDTO = new ApiOperationFlowDetailsWSDTO();

        return flowDetailsWSDTO;
    }


}
