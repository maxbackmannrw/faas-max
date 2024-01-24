package com.faas.core.api.framework.operation.details.campaign.transaction.inquiry;

import com.faas.core.api.model.ws.operation.details.campaign.scenario.dto.ApiOperationScenarioWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationInquiryFramework {


    @Autowired
    AppUtils appUtils;


    public List<ApiOperationScenarioWSDTO> apiGetOperationScenariosService(long agentId,long sessionId,String processId) {

        List<ApiOperationScenarioWSDTO> operationScenarioWSDTOS = new ArrayList<>();

        return operationScenarioWSDTOS;
    }



}
