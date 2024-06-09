package com.faas.core.api.middleware.operation.details.channel.message.wapp;

import com.faas.core.api.framework.operation.details.channel.message.wapp.ApiOperationWappMessageFramework;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.ApiOperationWappMessageAccountWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.ApiOperationWappMessageChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.ApiOperationWappMessageTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.ApiOperationWappMessageWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationWappMessageMiddleware {


    @Autowired
    ApiOperationWappMessageFramework apiOperationWappMessageFramework;


    public ApiOperationWappMessageChannelWSModel apiGetOperationWappMessageChannel(long agentId, String operationId) {

        ApiOperationWappMessageChannelWSModel response = new ApiOperationWappMessageChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappMessageChannelWSDTO wappMessageChannelWSDTO = apiOperationWappMessageFramework.apiGetOperationWappMessageChannelService(agentId,operationId);
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


    public ApiOperationWappMessageAccountWSModel apiGetOperationWappMessageAccount(long agentId, String operationId) {

        ApiOperationWappMessageAccountWSModel response = new ApiOperationWappMessageAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappMessageAccountWSDTO wappMessageAccountWSDTO = apiOperationWappMessageFramework.apiGetOperationWappMessageAccountService(agentId,operationId);
        if (wappMessageAccountWSDTO != null){
            response.setWappMessageAccount(wappMessageAccountWSDTO);
        }

        general.setOperation("apiGetOperationWappMessageAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappMessageTempWSModel apiGetOperationWappMessageTemps(long agentId,String operationId) {

        ApiOperationWappMessageTempWSModel response = new ApiOperationWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappMessageTempWSDTO wappMessageTempWSDTO = apiOperationWappMessageFramework.apiGetOperationWappMessageTempsService(agentId,operationId);
        if (wappMessageTempWSDTO != null){
            response.setWappMessageTemp(wappMessageTempWSDTO);
        }

        general.setOperation("apiGetOperationWappMessageTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWappMessageTempWSModel apiGetOperationWappMessageTemp(long agentId,String operationId,String tempId) {

        ApiOperationWappMessageTempWSModel response = new ApiOperationWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappMessageTempWSDTO wappMessageTempWSDTO = apiOperationWappMessageFramework.apiGetOperationWappMessageTempService(agentId,operationId,tempId);
        if (wappMessageTempWSDTO != null){
            response.setWappMessageTemp(wappMessageTempWSDTO);
        }

        general.setOperation("apiGetWappMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappMessageWSModel apiGetOperationWappMessages(long agentId,String operationId) {

        ApiOperationWappMessageWSModel response = new ApiOperationWappMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationWappMessageWSDTO> wappMessageWSDTOS = apiOperationWappMessageFramework.apiGetOperationWappMessagesService(agentId,operationId);
        if (wappMessageWSDTOS != null){
            response.setOperationWappMessages(wappMessageWSDTOS);
        }

        general.setOperation("apiGetOperationWappMessages");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWappMessageWSModel apiGetOperationWappMessage(long agentId,String operationId,String messageId) {

        ApiOperationWappMessageWSModel response = new ApiOperationWappMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();

        ApiOperationWappMessageWSDTO wappMessageWSDTO = apiOperationWappMessageFramework.apiGetOperationWappMessageService(agentId,operationId,messageId);
        if (wappMessageWSDTO != null){
            wappMessageWSDTOS.add(wappMessageWSDTO);
        }

        response.setOperationWappMessages(wappMessageWSDTOS);
        general.setOperation("apiGetOperationWappMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWappMessageWSModel apiSendOperationWappMessage(long agentId,String operationId,String tempId,String numberId) throws IOException {

        ApiOperationWappMessageWSModel response = new ApiOperationWappMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();

        ApiOperationWappMessageWSDTO wappMessageWSDTO = apiOperationWappMessageFramework.apiSendOperationWappMessageService(agentId,operationId,tempId,numberId);
        if (wappMessageWSDTO != null){
            wappMessageWSDTOS.add(wappMessageWSDTO);
        }

        response.setOperationWappMessages(wappMessageWSDTOS);
        general.setOperation("apiSendOperationWappMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWappMessageWSModel apiUpdateOperationWappMessage(long agentId,String operationId,String messageId,String messageState) {

        ApiOperationWappMessageWSModel response = new ApiOperationWappMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();

        ApiOperationWappMessageWSDTO wappMessageWSDTO = apiOperationWappMessageFramework.apiUpdateOperationWappMessageService(agentId,operationId,messageId,messageState);
        if (wappMessageWSDTO != null){
            wappMessageWSDTOS.add(wappMessageWSDTO);
        }

        response.setOperationWappMessages(wappMessageWSDTOS);
        general.setOperation("apiUpdateOperationWappMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWappMessageWSModel apiRemoveOperationWappMessage(long agentId,String operationId,String messageId) {

        ApiOperationWappMessageWSModel response = new ApiOperationWappMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();

        ApiOperationWappMessageWSDTO wappMessageWSDTO = apiOperationWappMessageFramework.apiRemoveOperationWappMessageService(agentId,operationId,messageId);
        if (wappMessageWSDTO != null){
            wappMessageWSDTOS.add(wappMessageWSDTO);
        }

        response.setOperationWappMessages(wappMessageWSDTOS);
        general.setOperation("apiRemoveOperationWappMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
