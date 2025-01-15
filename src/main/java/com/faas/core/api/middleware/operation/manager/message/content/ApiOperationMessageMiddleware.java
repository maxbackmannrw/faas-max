package com.faas.core.api.middleware.operation.manager.message.content;

import com.faas.core.api.framework.operation.manager.call.content.ApiOperationCallFramework;
import com.faas.core.api.framework.operation.manager.message.content.ApiOperationMessageFramework;
import com.faas.core.api.model.ws.operation.manager.message.content.ApiOperationMessageChannelWSModel;
import com.faas.core.api.model.ws.operation.manager.message.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationMessageMiddleware {


    @Autowired
    ApiOperationMessageFramework apiOperationMessageFramework;


    public ApiOperationMessageChannelWSModel apiGetOperationMessageChannel(long agentId, String operationId) {

        ApiOperationMessageChannelWSModel response = new ApiOperationMessageChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationMessageChannelWSDTO messageChannelWSDTO = apiOperationMessageFramework.apiGetOperationMessageChannelService(agentId, operationId);
        if (messageChannelWSDTO != null) {
            response.setOperationMessageChannel(messageChannelWSDTO);
        }

        general.setOperation("apiGetOperationMessageChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}