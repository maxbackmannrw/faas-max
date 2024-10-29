package com.faas.core.api.middleware.operation.manager.remote;

import com.faas.core.api.framework.operation.manager.remote.ApiOperationRemoteFramework;
import com.faas.core.api.model.ws.operation.manager.remote.ApiOperationRemoteAppWSModel;
import com.faas.core.api.model.ws.operation.manager.remote.dto.ApiOperationRemoteAppWSDTO;
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


    public ApiOperationRemoteAppWSModel apiGetOperationRemoteApps(long agentId, String operationId) {

        ApiOperationRemoteAppWSModel response = new ApiOperationRemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationRemoteAppWSDTO> operationRemoteAppWSDTOS = apiOperationRemoteFramework.apiGetOperationClientRemotesService(agentId, operationId);
        if (operationRemoteAppWSDTOS != null) {
            response.setOperationRemoteApps(operationRemoteAppWSDTOS);
        }

        general.setOperation("apiGetOperationRemoteApps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationRemoteAppWSModel apiGetOperationRemoteApp(long agentId, String operationId, String clientRemoteId) {

        ApiOperationRemoteAppWSModel response = new ApiOperationRemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationRemoteAppWSDTO> operationRemoteAppWSDTOS = new ArrayList<>();

        ApiOperationRemoteAppWSDTO operationRemoteAppWSDTO = apiOperationRemoteFramework.apiGetOperationClientRemoteService(agentId, operationId, clientRemoteId);
        if (operationRemoteAppWSDTO != null) {
            operationRemoteAppWSDTOS.add(operationRemoteAppWSDTO);
        }

        response.setOperationRemoteApps(operationRemoteAppWSDTOS);
        general.setOperation("apiGetOperationClientRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}