package com.faas.core.api.framework.flow.details;

import com.faas.core.api.model.ws.flow.details.dto.ApiFlowDetailsWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiFlowDetailsFramework {


    @Autowired
    AppUtils appUtils;


    public ApiFlowDetailsWSDTO apiGetFlowDetailsService(long agentId, long inquiryId){

        ApiFlowDetailsWSDTO flowDetailsWSDTO = new ApiFlowDetailsWSDTO();

        return flowDetailsWSDTO;
    }


}
