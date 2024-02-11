package com.faas.core.api.middleware.operation.details.channel.call.content;

import com.faas.core.api.framework.operation.details.channel.call.content.ApiOperationCallChannelFramework;
import com.faas.core.api.framework.operation.details.channel.message.content.ApiOperationMessageChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.call.content.ApiOperationCallChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.content.ApiOperationMessageChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationCallChannelMiddleware {


    @Autowired
    ApiOperationCallChannelFramework apiOperationCallChannelFramework;


    public ApiOperationCallChannelWSModel apiGetOperationCallChannel(long agentId, String operationId) {

        ApiOperationCallChannelWSModel response = new ApiOperationCallChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationCallChannelWSDTO operationCallChannelWSDTO = apiOperationCallChannelFramework.apiGetOperationCallChannelService(agentId,operationId);
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


    public ApiOperationSipChannelWSModel apiGetOperationSipChannel(long agentId, String operationId) {

        ApiOperationSipChannelWSModel response = new ApiOperationSipChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSipChannelWSDTO operationSipChannelWSDTO = apiOperationCallChannelFramework.apiGetOperationSipChannelService(agentId,operationId);
        if (operationSipChannelWSDTO != null){
            response.setOperationSipChannel(operationSipChannelWSDTO);
        }

        general.setOperation("apiGetOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappCallChannelWSModel apiGetOperationWappCallChannel(long agentId, String operationId) {

        ApiOperationWappCallChannelWSModel response = new ApiOperationWappCallChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappCallChannelWSDTO operationWappCallChannelWSDTO = apiOperationCallChannelFramework.apiGetOperationWappCallChannelService(agentId,operationId);
        if (operationWappCallChannelWSDTO != null){
            response.setOperationWappCallChannel(operationWappCallChannelWSDTO);
        }

        general.setOperation("apiGetOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
