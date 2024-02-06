package com.faas.core.api.middleware.operation.details.channel.message.wapp;

import com.faas.core.api.framework.operation.details.channel.message.wapp.ApiOperationWappMessageChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.ApiOperationWappMessageChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.ApiOperationWappMessageTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.ApiOperationWappMessageWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationWappMessageChannelMiddleware {


    @Autowired
    ApiOperationWappMessageChannelFramework apiOperationWappMessageChannelFramework;


    public ApiOperationWappMessageChannelWSModel apiGetOperationWappMessageChannel(long agentId,String operationId) {

        ApiOperationWappMessageChannelWSModel response = new ApiOperationWappMessageChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappMessageChannelWSDTO operationWappMessageWSDTO = apiOperationWappMessageChannelFramework.apiGetOperationWappMessageChannelService(agentId,operationId);
        if (operationWappMessageWSDTO != null){
            response.setOperationWappMessage(operationWappMessageWSDTO);
        }

        general.setOperation("apiGetOperationWappMessageChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappMessageWSModel apiGetOperationWappMessages(long agentId,String operationId) {

        ApiOperationWappMessageWSModel response = new ApiOperationWappMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationWappMessageWSDTO> wappMessageWSDTOS = apiOperationWappMessageChannelFramework.apiGetOperationWappMessagesService(agentId,operationId);
        if (wappMessageWSDTOS != null){
            response.setWappMessages(wappMessageWSDTOS);
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

        ApiOperationWappMessageWSDTO wappMessageWSDTO = apiOperationWappMessageChannelFramework.apiGetOperationWappMessageService(agentId,operationId,messageId);
        if (wappMessageWSDTO != null){
            wappMessageWSDTOS.add(wappMessageWSDTO);
        }

        response.setWappMessages(wappMessageWSDTOS);
        general.setOperation("apiGetOperationWappMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiOperationWappMessageWSModel apiSendOperationWappMessage(long agentId,String operationId,String messageTempId,String numberId) throws IOException {

        ApiOperationWappMessageWSModel response = new ApiOperationWappMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();

        ApiOperationWappMessageWSDTO wappMessageWSDTO = apiOperationWappMessageChannelFramework.apiSendOperationWappMessageService(agentId,operationId,messageTempId,numberId);
        if (wappMessageWSDTO != null){
            wappMessageWSDTOS.add(wappMessageWSDTO);
        }

        response.setWappMessages(wappMessageWSDTOS);
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

        ApiOperationWappMessageWSDTO wappMessageWSDTO = apiOperationWappMessageChannelFramework.apiUpdateOperationWappMessageService(agentId,operationId,messageId,messageState);
        if (wappMessageWSDTO != null){
            wappMessageWSDTOS.add(wappMessageWSDTO);
        }

        response.setWappMessages(wappMessageWSDTOS);
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

        ApiOperationWappMessageWSDTO wappMessageWSDTO = apiOperationWappMessageChannelFramework.apiRemoveOperationWappMessageService(agentId,operationId,messageId);
        if (wappMessageWSDTO != null){
            wappMessageWSDTOS.add(wappMessageWSDTO);
        }

        response.setWappMessages(wappMessageWSDTOS);
        general.setOperation("apiRemoveOperationWappMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiOperationWappMessageTempWSModel apiGetOperationWappMessageTemps(long agentId,String operationId) {

        ApiOperationWappMessageTempWSModel response = new ApiOperationWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappMessageTempWSDTO wappMessageTempWSDTO = apiOperationWappMessageChannelFramework.apiGetOperationWappMessageTempsService(agentId,operationId);
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



    public ApiOperationWappMessageTempWSModel apiGetOperationWappMessageTemp(long agentId,String operationId,String messageTempId) {

        ApiOperationWappMessageTempWSModel response = new ApiOperationWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappMessageTempWSDTO wappMessageTempWSDTO = apiOperationWappMessageChannelFramework.apiGetOperationWappMessageTempService(agentId,operationId,messageTempId);
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


}