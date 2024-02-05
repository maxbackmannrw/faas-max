package com.faas.core.api.middleware.operation.details.channel.content;

import com.faas.core.api.framework.operation.details.channel.content.ApiOperationChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.content.ApiOperationCallChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.content.ApiOperationMessageChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationChannelMiddleware {


    @Autowired
    ApiOperationChannelFramework apiOperationChannelFramework;


    public ApiOperationCallChannelWSModel apiGetOperationCallChannel(long agentId, String operationId) {

        ApiOperationCallChannelWSModel response = new ApiOperationCallChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationCallChannelWSDTO operationCallChannelWSDTO = apiOperationChannelFramework.apiGetOperationCallChannelService(agentId,operationId);
        if (operationCallChannelWSDTO != null){
            response.setOperationCallChannel(operationCallChannelWSDTO);
        }

        general.setOperation("apiGetOperationCallChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationMessageChannelWSModel apiGetOperationMessageChannel(long agentId, String operationId) {

        ApiOperationMessageChannelWSModel response = new ApiOperationMessageChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationMessageChannelWSDTO operationMessageChannelWSDTO = apiOperationChannelFramework.apiGetOperationMessageChannelService(agentId,operationId);
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
