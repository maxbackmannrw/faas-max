package com.faas.core.api.middleware.client.details;

import com.faas.core.api.framework.client.details.ApiClientDetailsFramework;
import com.faas.core.api.model.ws.session.ApiAgentSessionWSModel;
import com.faas.core.api.model.ws.session.dto.ApiAgentSessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiClientDetailsMiddleware {


    @Autowired
    ApiClientDetailsFramework apiClientDetailsFramework;


    public ApiAgentSessionWSModel apiGetAgentSession(long agentId, int reqPage, int reqSize) {

        ApiAgentSessionWSModel response = new ApiAgentSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentSessionWSDTO agentSessionWSDTO = apiClientDetailsFramework.apiGetAgentSessionService(agentId,reqPage,reqSize);
        if (agentSessionWSDTO != null){
            response.setAgentSession(agentSessionWSDTO);
        }

        general.setOperation("apiGetAgentSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
