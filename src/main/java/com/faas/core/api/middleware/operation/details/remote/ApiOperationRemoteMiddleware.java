package com.faas.core.api.middleware.operation.details.remote;

import com.faas.core.api.framework.operation.details.remote.ApiOperationRemoteFramework;
import com.faas.core.api.model.ws.operation.details.remote.ApiOperationClientRemoteWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationRemoteMiddleware {


    @Autowired
    ApiOperationRemoteFramework apiOperationRemoteFramework;


    public ApiOperationClientRemoteWSModel apiGetOperationClientRemotes(long agentId, long clientId) {

        ApiOperationClientRemoteWSModel response = new ApiOperationClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationClientRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientRemoteWSModel apiGetOperationClientRemote(long agentId, long clientId, String clientRemoteId) {

        ApiOperationClientRemoteWSModel response = new ApiOperationClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationClientRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
