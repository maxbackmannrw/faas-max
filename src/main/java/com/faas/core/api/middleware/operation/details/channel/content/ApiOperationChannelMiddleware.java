package com.faas.core.api.middleware.operation.details.channel.content;

import com.faas.core.api.framework.operation.details.channel.call.sip.ApiOperationSipChannelFramework;
import com.faas.core.api.framework.operation.details.channel.content.ApiOperationChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipCallWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationChannelMiddleware {


    @Autowired
    ApiOperationChannelFramework apiOperationChannelFramework;


    public ApiOperationSipCallWSModel apiGetOperationChannel(long agentId,long sessionId,long clientId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationChannelFramework.apiGetOperationChannelService(agentId,sessionId,clientId);
        if (operationSipCallWSDTO != null){
            response.setOperationSipCall(operationSipCallWSDTO);
        }

        general.setOperation("apiGetOperationChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
