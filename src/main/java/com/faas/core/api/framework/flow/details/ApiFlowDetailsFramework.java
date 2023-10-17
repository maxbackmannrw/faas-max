package com.faas.core.api.framework.flow.details;

import com.faas.core.api.model.ws.flow.details.dto.ApiFlowDetailsWSDTO;
import com.faas.core.api.model.ws.general.ApiSummaryWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiFlowDetailsFramework {


    @Autowired
    AppUtils appUtils;


    public ApiFlowDetailsWSDTO apiGetOperationFlowDetailsService(long agentId, long inquiryId){

        ApiFlowDetailsWSDTO flowDetailsWSDTO = new ApiFlowDetailsWSDTO();

        return flowDetailsWSDTO;
    }


    public List<ApiSummaryWSDTO> apiGetOperationFlowSummaryService(long agentId){

        return null;
    }




}
