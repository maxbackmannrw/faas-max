package com.faas.core.api.middleware.client.content;

import com.faas.core.api.framework.client.content.ApiClientFramework;
import com.faas.core.api.model.ws.client.content.ApiClientWSModel;
import com.faas.core.api.model.ws.client.content.dto.ApiClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiClientMiddleware {


    @Autowired
    ApiClientFramework apiClientFramework;


    public ApiClientWSModel apiGetClient(long agentId, long clientId) {

        ApiClientWSModel response = new ApiClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiClientWSDTO clientWSDTO = apiClientFramework.apiGetClientService(agentId,clientId);
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
