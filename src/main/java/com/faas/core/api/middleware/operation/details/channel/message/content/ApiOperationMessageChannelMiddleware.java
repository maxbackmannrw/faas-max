package com.faas.core.api.middleware.operation.details.channel.message.content;

import com.faas.core.api.framework.operation.details.channel.message.content.ApiOperationMessageChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.message.content.ApiOperationMessageChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationMessageChannelMiddleware {


    @Autowired
    ApiOperationMessageChannelFramework apiOperationMessageChannelFramework;


    public ApiOperationMessageChannelWSModel apiGetOperationMessageChannel(long agentId, String operationId) {

        ApiOperationMessageChannelWSModel response = new ApiOperationMessageChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationMessageChannelWSDTO operationMessageChannelWSDTO = apiOperationMessageChannelFramework.apiGetOperationMessageChannelService(agentId,operationId);
        if (operationMessageChannelWSDTO != null){
            response.setOperationMessageChannel(operationMessageChannelWSDTO);
        }

        general.setOperation("apiGetOperationMessageChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
