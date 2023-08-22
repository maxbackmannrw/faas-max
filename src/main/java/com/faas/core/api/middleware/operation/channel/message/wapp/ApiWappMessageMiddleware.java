package com.faas.core.api.middleware.operation.channel.message.wapp;

import com.faas.core.api.framework.operation.channel.message.wapp.ApiWappMessageFramework;
import com.faas.core.api.model.ws.operation.channel.message.wapp.ApiOperationWappMessageWSModel;
import com.faas.core.api.model.ws.operation.channel.message.wapp.ApiWappMessageTempWSModel;
import com.faas.core.api.model.ws.operation.channel.message.wapp.ApiWappMessageWSModel;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiWappMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.wapp.dto.ApiWappMessageWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApiWappMessageMiddleware {


    @Autowired
    ApiWappMessageFramework apiWappMessageFramework;


    public ApiOperationWappMessageWSModel apiGetOperationWappMessage(long agentId,long sessionId) {

        ApiOperationWappMessageWSModel response = new ApiOperationWappMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappMessageWSDTO operationWappMessageWSDTO = apiWappMessageFramework.apiGetOperationWappMessagesService(agentId,sessionId);
        if (operationWappMessageWSDTO != null){
            response.setOperationWappMessage(operationWappMessageWSDTO);
        }

        general.setOperation("apiGetOperationWappMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiWappMessageWSModel apiGetWappMessages(long agentId,long sessionId,String campaignId,String processId) {

        ApiWappMessageWSModel response = new ApiWappMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiWappMessageWSDTO> wappMessageWSDTOS = apiWappMessageFramework.apiGetWappMessagesService(agentId,sessionId,campaignId,processId);
        if (wappMessageWSDTOS != null){
            response.setWappMessages(wappMessageWSDTOS);
        }

        general.setOperation("apiGetWappMessages");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiWappMessageWSModel apiGetWappMessage(long agentId,long sessionId,String campaignId,String processId,String messageId) {

        ApiWappMessageWSModel response = new ApiWappMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();

        ApiWappMessageWSDTO wappMessageWSDTO = apiWappMessageFramework.apiGetWappMessageService(agentId,sessionId,campaignId,processId,messageId);
        if (wappMessageWSDTO != null){
            wappMessageWSDTOS.add(wappMessageWSDTO);
        }

        response.setWappMessages(wappMessageWSDTOS);
        general.setOperation("apiGetWappMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiWappMessageWSModel apiSendWappMessage(long agentId,long sessionId,String campaignId,String processId,String tempId,long numberId) throws IOException {

        ApiWappMessageWSModel response = new ApiWappMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();

        ApiWappMessageWSDTO wappMessageWSDTO = apiWappMessageFramework.apiSendWappMessageService(agentId,sessionId,campaignId,processId,tempId,numberId);
        if (wappMessageWSDTO != null){
            wappMessageWSDTOS.add(wappMessageWSDTO);
        }

        response.setWappMessages(wappMessageWSDTOS);
        general.setOperation("apiSendWappMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiWappMessageWSModel apiUpdateWappMessage(long agentId,long sessionId,String campaignId,String processId,String messageId) {

        ApiWappMessageWSModel response = new ApiWappMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();

        ApiWappMessageWSDTO wappMessageWSDTO = apiWappMessageFramework.apiUpdateWappMessageService(agentId,sessionId,campaignId,processId,messageId);
        if (wappMessageWSDTO != null){
            wappMessageWSDTOS.add(wappMessageWSDTO);
        }

        response.setWappMessages(wappMessageWSDTOS);
        general.setOperation("apiUpdateWappMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiWappMessageWSModel apiRemoveWappMessage(long agentId,long sessionId,String campaignId,String processId,String messageId) {

        ApiWappMessageWSModel response = new ApiWappMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiWappMessageWSDTO>wappMessageWSDTOS = new ArrayList<>();

        ApiWappMessageWSDTO wappMessageWSDTO = apiWappMessageFramework.apiRemoveWappMessageService(agentId,sessionId,campaignId,processId,messageId);
        if (wappMessageWSDTO != null){
            wappMessageWSDTOS.add(wappMessageWSDTO);
        }

        response.setWappMessages(wappMessageWSDTOS);
        general.setOperation("apiRemoveWappMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public ApiWappMessageTempWSModel apiGetWappMessageTemps(long agentId,long sessionId,String campaignId,String processId) {

        ApiWappMessageTempWSModel response = new ApiWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiWappMessageTempWSDTO wappMessageTempWSDTO = apiWappMessageFramework.apiGetWappMessageTempsService(agentId,sessionId,campaignId,processId);
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



    public ApiWappMessageTempWSModel apiGetWappMessageTemp(long agentId,long sessionId,String campaignId,String processId,String tempId) {

        ApiWappMessageTempWSModel response = new ApiWappMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiWappMessageTempWSDTO wappMessageTempWSDTO = apiWappMessageFramework.apiGetWappMessageTempService(agentId,sessionId,campaignId,processId,tempId);
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
