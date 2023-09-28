package com.faas.core.api.middleware.client.device;

import com.faas.core.api.framework.client.device.ApiClientDeviceFramework;
import com.faas.core.api.model.ws.client.session.ApiAgentSessionWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiClientDeviceMiddleware {


    @Autowired
    ApiClientDeviceFramework apiClientDeviceFramework;


    public ApiAgentSessionWSModel apiGetAgentSession(long agentId, int reqPage, int reqSize) {

        ApiAgentSessionWSModel response = new ApiAgentSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetAgentSession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
