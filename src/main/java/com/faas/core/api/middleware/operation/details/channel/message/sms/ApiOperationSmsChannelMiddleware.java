package com.faas.core.api.middleware.operation.details.channel.message.sms;

import com.faas.core.api.framework.operation.details.channel.message.sms.ApiOperationSmsChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiOperationSmsMessageWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiSmsMessageTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiSmsMessageWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsMessageWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiSmsMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiSmsMessageWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationSmsChannelMiddleware {


    @Autowired
    ApiOperationSmsChannelFramework apiOperationSmsChannelFramework;


    public ApiOperationSmsMessageWSModel apiGetOperationSmsMessage(long agentId,long sessionId) {

        ApiOperationSmsMessageWSModel response = new ApiOperationSmsMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSmsMessageWSDTO operationSmsWSDTO = apiOperationSmsChannelFramework.apiGetOperationSmsMessageService(agentId,sessionId);
        if (operationSmsWSDTO != null){
            response.setOperationSmsMessage(operationSmsWSDTO);
        }

        general.setOperation("apiGetOperationSmsMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSmsMessageWSModel apiGetSmsMessages(long agentId,long sessionId,String campaignId,String processId) {

        ApiSmsMessageWSModel response = new ApiSmsMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSmsMessageWSDTO> smsMessageWSDTOS = apiOperationSmsChannelFramework.apiGetSmsMessagesService(agentId,sessionId,campaignId,processId);
        if (smsMessageWSDTOS != null){
            response.setSmsMessages(smsMessageWSDTOS);
        }

        general.setOperation("apiGetSmsMessages");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSmsMessageWSModel apiGetSmsMessage(long agentId,long sessionId,String campaignId, String processId,String messageId) {

        ApiSmsMessageWSModel response = new ApiSmsMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSmsMessageWSDTO> smsMessageWSDTOS = new ArrayList<>();

        ApiSmsMessageWSDTO smsMessageWSDTO = apiOperationSmsChannelFramework.apiGetSmsMessageService(agentId,sessionId,campaignId,processId,messageId);
        if (smsMessageWSDTO != null){
            smsMessageWSDTOS.add(smsMessageWSDTO);
        }

        response.setSmsMessages(smsMessageWSDTOS);
        general.setOperation("apiGetSmsMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSmsMessageWSModel apiSendSmsMessage(long agentId,long sessionId,String campaignId,String processId,String tempId,long numberId) throws IOException {

        ApiSmsMessageWSModel response = new ApiSmsMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSmsMessageWSDTO> smsMessageWSDTOS = new ArrayList<>();

        ApiSmsMessageWSDTO smsMessageWSDTO = apiOperationSmsChannelFramework.apiSendSmsMessageService(agentId,sessionId,campaignId,processId,tempId,numberId);
        if (smsMessageWSDTO != null){
            smsMessageWSDTOS.add(smsMessageWSDTO);
        }

        response.setSmsMessages(smsMessageWSDTOS);
        general.setOperation("apiSendSmsMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSmsMessageWSModel apiUpdateSmsMessage(long agentId,long sessionId,String campaignId,String processId,String messageId) {

        ApiSmsMessageWSModel response = new ApiSmsMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSmsMessageWSDTO> smsMessageWSDTOS = new ArrayList<>();

        ApiSmsMessageWSDTO smsMessageWSDTO = apiOperationSmsChannelFramework.apiUpdateSmsMessageService(agentId,sessionId,campaignId,processId,messageId);
        if (smsMessageWSDTO != null){
            smsMessageWSDTOS.add(smsMessageWSDTO);
        }

        response.setSmsMessages(smsMessageWSDTOS);
        general.setOperation("apiUpdateSmsMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSmsMessageWSModel apiRemoveSmsMessage(long agentId,long sessionId,String campaignId,String processId,String messageId) {

        ApiSmsMessageWSModel response = new ApiSmsMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSmsMessageWSDTO> smsMessageWSDTOS = new ArrayList<>();

        ApiSmsMessageWSDTO smsMessageWSDTO = apiOperationSmsChannelFramework.apiRemoveSmsMessageService(agentId,sessionId,campaignId,processId,messageId);
        if (smsMessageWSDTO != null){
            smsMessageWSDTOS.add(smsMessageWSDTO);
        }

        response.setSmsMessages(smsMessageWSDTOS);
        general.setOperation("apiRemoveSmsMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiSmsMessageTempWSModel apiGetSmsMessageTemps(long agentId,long sessionId,String campaignId ,String processId) {

        ApiSmsMessageTempWSModel response = new ApiSmsMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiSmsMessageTempWSDTO smsMessageTempWSDTO = apiOperationSmsChannelFramework.apiGetSmsMessageTempsService(agentId,sessionId,campaignId,processId);
        if (smsMessageTempWSDTO != null){
            response.setSmsMessageTemp(smsMessageTempWSDTO);
        }

        general.setOperation("apiGetSmsMessageTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSmsMessageTempWSModel apiGetSmsMessageTemp(long agentId,long sessionId,String campaignId,String processId,String tempId) {

        ApiSmsMessageTempWSModel response = new ApiSmsMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiSmsMessageTempWSDTO smsMessageTempWSDTO = apiOperationSmsChannelFramework.apiGetSmsMessageTempService(agentId,sessionId,campaignId,processId,tempId);
        if (smsMessageTempWSDTO != null){
            response.setSmsMessageTemp(smsMessageTempWSDTO);
        }

        general.setOperation("apiGetSmsMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
