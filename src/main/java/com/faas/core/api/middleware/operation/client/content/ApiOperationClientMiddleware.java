package com.faas.core.api.middleware.operation.client.content;

import com.faas.core.api.framework.operation.client.content.ApiOperationClientFramework;
import com.faas.core.api.model.ws.operation.client.content.ApiOperationClientWSModel;
import com.faas.core.api.model.ws.operation.client.content.dto.ApiOperationClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationClientMiddleware {


    @Autowired
    ApiOperationClientFramework apiOperationClientFramework;


    public ApiOperationClientWSModel apiAgentGetClients(long agentId, int reqPage, int reqSize) {

        ApiOperationClientWSModel response = new ApiOperationClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationClientWSDTO clientWSDTO = apiOperationClientFramework.apiAgentGetClientsService(agentId,reqPage,reqSize);
        if (clientWSDTO != null){
            response.setClient(clientWSDTO);
        }

        general.setOperation("apiGetClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientWSModel apiGetClient(long agentId, long clientId) {

        ApiOperationClientWSModel response = new ApiOperationClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationClientWSDTO clientWSDTO = apiOperationClientFramework.apiGetClientService(agentId,clientId);
        if (clientWSDTO != null){
            response.setClient(clientWSDTO);
        }

        general.setOperation("apiGetClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
