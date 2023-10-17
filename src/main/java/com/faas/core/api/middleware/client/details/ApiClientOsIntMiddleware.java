package com.faas.core.api.middleware.client.details;

import com.faas.core.api.framework.client.details.ApiClientOsIntFramework;
import com.faas.core.api.model.ws.client.session.ApiAgentSessionWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiClientOsIntMiddleware {


    @Autowired
    ApiClientOsIntFramework apiClientOsIntFramework;

    public ApiAgentSessionWSModel apiGetClientDevices(long agentId, long clientId) {

        ApiAgentSessionWSModel response = new ApiAgentSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetClientDevices");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
