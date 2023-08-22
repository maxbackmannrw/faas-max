package com.faas.core.api.middleware.operation.channel.messenger;

import com.faas.core.api.framework.operation.channel.messenger.ApiMessengerFramework;
import com.faas.core.api.model.ws.operation.channel.messenger.ApiOperationMessengerWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiMessengerMiddleware {


    @Autowired
    ApiMessengerFramework apiMessengerFramework;


    public ApiOperationMessengerWSModel apiGetOperationMessenger(long agentId, long sessionId) {

        ApiOperationMessengerWSModel response = new ApiOperationMessengerWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationMessenger");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
