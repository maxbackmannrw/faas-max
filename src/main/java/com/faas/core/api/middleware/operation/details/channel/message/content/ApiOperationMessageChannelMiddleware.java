package com.faas.core.api.middleware.operation.details.channel.message.content;

import com.faas.core.api.framework.operation.details.channel.message.content.ApiOperationMessageChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.message.content.ApiOperationMessageChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.ApiOperationEmailChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiOperationSmsChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.ApiOperationWappMessageChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;
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

        ApiOperationMessageChannelWSDTO messageChannelWSDTO = apiOperationMessageChannelFramework.apiGetOperationMessageChannelService(agentId,operationId);
        if (messageChannelWSDTO != null){
            response.setOperationMessageChannel(messageChannelWSDTO);
        }

        general.setOperation("apiGetOperationMessageChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSmsChannelWSModel apiGetOperationSmsChannel(long agentId, String operationId) {

        ApiOperationSmsChannelWSModel response = new ApiOperationSmsChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSmsChannelWSDTO smsChannelWSDTO = apiOperationMessageChannelFramework.apiGetOperationSmsChannelService(agentId,operationId);
        if (smsChannelWSDTO != null){
            response.setOperationSmsChannel(smsChannelWSDTO);
        }

        general.setOperation("apiGetOperationSmsChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappMessageChannelWSModel apiGetOperationWappMessageChannel(long agentId, String operationId) {

        ApiOperationWappMessageChannelWSModel response = new ApiOperationWappMessageChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappMessageChannelWSDTO wappMessageChannelWSDTO = apiOperationMessageChannelFramework.apiGetOperationWappMessageChannelService(agentId,operationId);
        if (wappMessageChannelWSDTO != null){
            response.setOperationWappMessageChannel(wappMessageChannelWSDTO);
        }

        general.setOperation("apiGetOperationWappMessageChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationEmailChannelWSModel apiGetOperationEmailChannel(long agentId, String operationId) {

        ApiOperationEmailChannelWSModel response = new ApiOperationEmailChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationEmailChannelWSDTO emailChannelWSDTO = apiOperationMessageChannelFramework.apiGetOperationEmailChannelService(agentId,operationId);
        if (emailChannelWSDTO != null){
            response.setOperationEmailChannel(emailChannelWSDTO);
        }

        general.setOperation("apiGetOperationEmailChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationPushChannelWSModel apiGetOperationPushChannel(long agentId, String operationId) {

        ApiOperationPushChannelWSModel response = new ApiOperationPushChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationPushChannelWSDTO pushChannelWSDTO = apiOperationMessageChannelFramework.apiGetOperationPushChannelService(agentId,operationId);
        if (pushChannelWSDTO != null){
            response.setOperationPushChannel(pushChannelWSDTO);
        }

        general.setOperation("apiGetOperationPushChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
