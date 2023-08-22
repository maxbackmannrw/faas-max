package com.faas.core.api.middleware.operation.details.client.osint;

import com.faas.core.api.framework.operation.details.client.osint.ApiClientOsIntFramework;
import com.faas.core.api.model.ws.operation.details.client.osint.ApiClientOsIntWSModel;
import com.faas.core.api.model.ws.operation.details.client.osint.dto.ApiClientOsIntWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiClientOsIntMiddleware {


    @Autowired
    ApiClientOsIntFramework apiClientOsIntFramework;


    public ApiClientOsIntWSModel apiGetClientOsInts(long agentId, long sessionId, long clientId) {

        ApiClientOsIntWSModel response = new ApiClientOsIntWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiClientOsIntWSDTO> clientOsIntWSDTOS = apiClientOsIntFramework.apiGetClientOsIntsService();
        if (clientOsIntWSDTOS != null){
            response.setClientOsInts(clientOsIntWSDTOS);
        }

        general.setOperation("apiGetClientOsInts");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
