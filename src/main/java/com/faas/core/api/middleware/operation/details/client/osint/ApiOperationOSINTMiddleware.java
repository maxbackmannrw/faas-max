package com.faas.core.api.middleware.operation.details.client.osint;

import com.faas.core.api.framework.operation.details.client.content.ApiOperationClientFramework;
import com.faas.core.api.framework.operation.details.client.osint.ApiOperationOSINTFramework;
import com.faas.core.api.model.ws.operation.details.client.content.ApiOperationClientWSModel;
import com.faas.core.api.model.ws.operation.details.client.content.dto.ApiOperationClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationOSINTMiddleware {


    @Autowired
    ApiOperationOSINTFramework apiOperationOSINTFramework;


    public ApiOperationClientWSModel apiGetOperationClient(long agentId, long clientId) {

        ApiOperationClientWSModel response = new ApiOperationClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationClientWSDTO operationClientWSDTO = apiOperationOSINTFramework.apiGetOperationClientService(agentId,clientId);
        if (operationClientWSDTO != null){
            response.setOperationClient(operationClientWSDTO);
        }

        general.setOperation("apiGetOperationClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
