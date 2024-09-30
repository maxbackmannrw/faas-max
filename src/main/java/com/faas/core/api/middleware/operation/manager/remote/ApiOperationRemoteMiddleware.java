package com.faas.core.api.middleware.operation.manager.remote;

import com.faas.core.api.framework.operation.manager.remote.ApiOperationRemoteFramework;
import com.faas.core.api.model.ws.operation.manager.remote.ApiOperationClientRemoteWSModel;
import com.faas.core.api.model.ws.operation.manager.remote.dto.ApiOperationClientRemoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationRemoteMiddleware {


    @Autowired
    ApiOperationRemoteFramework apiOperationRemoteFramework;


    public ApiOperationClientRemoteWSModel apiGetOperationClientRemotes(long agentId, String operationId) {

        ApiOperationClientRemoteWSModel response = new ApiOperationClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationClientRemoteWSDTO> operationClientRemoteWSDTOS = apiOperationRemoteFramework.apiGetOperationClientRemotesService(agentId, operationId);
        if (operationClientRemoteWSDTOS != null) {
            response.setClientRemotes(operationClientRemoteWSDTOS);
        }

        general.setOperation("apiGetOperationClientRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationClientRemoteWSModel apiGetOperationClientRemote(long agentId, String operationId, String clientRemoteId) {

        ApiOperationClientRemoteWSModel response = new ApiOperationClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationClientRemoteWSDTO> operationClientRemoteWSDTOS = new ArrayList<>();

        ApiOperationClientRemoteWSDTO operationClientRemoteWSDTO = apiOperationRemoteFramework.apiGetOperationClientRemoteService(agentId, operationId, clientRemoteId);
        if (operationClientRemoteWSDTO != null) {
            operationClientRemoteWSDTOS.add(operationClientRemoteWSDTO);
        }

        response.setClientRemotes(operationClientRemoteWSDTOS);
        general.setOperation("apiGetOperationClientRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}