package com.faas.core.api.middleware.operation.details.client.hook;

import com.faas.core.api.framework.operation.details.client.hook.ApiClientHookFramework;
import com.faas.core.api.model.ws.operation.details.client.hook.ApiClientHookWSModel;
import com.faas.core.api.model.ws.operation.details.client.hook.dto.ApiClientHookWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiClientHookMiddleware {


    @Autowired
    ApiClientHookFramework operationHookFramework;


    public ApiClientHookWSModel apiGetClientHooks(long agentId, long sessionId, long clientId,String campaignId) {

        ApiClientHookWSModel response = new ApiClientHookWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiClientHookWSDTO> clientHookWSDTOS = operationHookFramework.apiGetClientHooksService();
        if (clientHookWSDTOS != null){
            response.setClientHooks(clientHookWSDTOS);
        }

        general.setOperation("apiGetClientHooks");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
