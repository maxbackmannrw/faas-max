package com.faas.core.api.middleware.operation.manager.channel.call.content;

import com.faas.core.api.framework.operation.manager.channel.call.content.ApiOperationCallFramework;
import com.faas.core.api.model.ws.operation.manager.channel.call.content.ApiOperationCallChannelWSModel;
import com.faas.core.api.model.ws.operation.manager.channel.call.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationCallMiddleware {


    @Autowired
    ApiOperationCallFramework apiOperationCallFramework;


    public ApiOperationCallChannelWSModel apiGetOperationCallChannel(long agentId, String operationId) {

        ApiOperationCallChannelWSModel response = new ApiOperationCallChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationCallChannelWSDTO operationCallChannelWSDTO = apiOperationCallFramework.apiGetOperationCallChannelService(agentId, operationId);
        if (operationCallChannelWSDTO != null) {
            response.setOperationCallChannel(operationCallChannelWSDTO);
        }

        general.setOperation("apiGetOperationCallChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}