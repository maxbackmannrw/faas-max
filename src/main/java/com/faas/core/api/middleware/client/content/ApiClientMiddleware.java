package com.faas.core.api.middleware.client.content;

import com.faas.core.api.framework.client.content.ApiClientFramework;
import com.faas.core.api.model.ws.session.ApiAgentSessionWSModel;
import com.faas.core.api.model.ws.session.dto.ApiAgentSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiClientMiddleware {


    @Autowired
    ApiClientFramework apiClientFramework;


    public ApiAgentSessionWSModel apiGetAgentClients(long agentId, int reqPage, int reqSize) {

        ApiAgentSessionWSModel response = new ApiAgentSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentSessionWSDTO agentSessionWSDTO = apiClientFramework.apiGetAgentClientsService(agentId,reqPage,reqSize);
        if (agentSessionWSDTO != null){
            response.setAgentSession(agentSessionWSDTO);
        }

        general.setOperation("apiGetAgentClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiAgentSessionWSModel apiGetClient(long agentId,long clientId) {

        ApiAgentSessionWSModel response = new ApiAgentSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
