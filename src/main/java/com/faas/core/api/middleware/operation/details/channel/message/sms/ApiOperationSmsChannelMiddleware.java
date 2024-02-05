package com.faas.core.api.middleware.operation.details.channel.message.sms;

import com.faas.core.api.framework.operation.details.channel.message.sms.ApiOperationSmsChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiOperationSmsChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiOperationSmsTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiOperationSmsWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsWSDTO;
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


    public ApiOperationSmsChannelWSModel apiGetOperationSmsChannel(long agentId,String operationId) {

        ApiOperationSmsChannelWSModel response = new ApiOperationSmsChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSmsChannelWSDTO operationSmsWSDTO = apiOperationSmsChannelFramework.apiGetOperationSmsChannelService(agentId,operationId);
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


    public ApiOperationSmsWSModel apiGetOperationSmss(long agentId,String operationId) {

        ApiOperationSmsWSModel response = new ApiOperationSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationSmsWSDTO> smsMessageWSDTOS = apiOperationSmsChannelFramework.apiGetOperationSmssService(agentId,operationId);
        if (smsMessageWSDTOS != null){
            response.setSmsMessages(smsMessageWSDTOS);
        }

        general.setOperation("apiGetOperationSmss");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSmsWSModel apiGetOperationSms(long agentId,String operationId,String smsId) {

        ApiOperationSmsWSModel response = new ApiOperationSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSmsWSDTO> smsMessageWSDTOS = new ArrayList<>();

        ApiOperationSmsWSDTO smsMessageWSDTO = apiOperationSmsChannelFramework.apiGetOperationSmsService(agentId,operationId,smsId);
        if (smsMessageWSDTO != null){
            smsMessageWSDTOS.add(smsMessageWSDTO);
        }

        response.setSmsMessages(smsMessageWSDTOS);
        general.setOperation("apiGetOperationSms");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSmsWSModel apiSendOperationSms(long agentId,String operationId,String smsTempId,String numberId) throws IOException {

        ApiOperationSmsWSModel response = new ApiOperationSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSmsWSDTO> smsMessageWSDTOS = new ArrayList<>();

        ApiOperationSmsWSDTO smsMessageWSDTO = apiOperationSmsChannelFramework.apiSendOperationSmsService(agentId,operationId,smsTempId,numberId);
        if (smsMessageWSDTO != null){
            smsMessageWSDTOS.add(smsMessageWSDTO);
        }

        response.setSmsMessages(smsMessageWSDTOS);
        general.setOperation("apiSendOperationSms");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSmsWSModel apiUpdateOperationSms(long agentId,String operationId,String smsId,String smsState) {

        ApiOperationSmsWSModel response = new ApiOperationSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSmsWSDTO> smsMessageWSDTOS = new ArrayList<>();

        ApiOperationSmsWSDTO smsMessageWSDTO = apiOperationSmsChannelFramework.apiUpdateOperationSmsService(agentId,operationId,smsId,smsState);
        if (smsMessageWSDTO != null){
            smsMessageWSDTOS.add(smsMessageWSDTO);
        }

        response.setSmsMessages(smsMessageWSDTOS);
        general.setOperation("apiUpdateOperationSms");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSmsWSModel apiRemoveOperationSms(long agentId,String operationId,String smsId) {

        ApiOperationSmsWSModel response = new ApiOperationSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSmsWSDTO> smsMessageWSDTOS = new ArrayList<>();

        ApiOperationSmsWSDTO smsMessageWSDTO = apiOperationSmsChannelFramework.apiRemoveOperationSmsService(agentId,operationId,smsId);
        if (smsMessageWSDTO != null){
            smsMessageWSDTOS.add(smsMessageWSDTO);
        }

        response.setSmsMessages(smsMessageWSDTOS);
        general.setOperation("apiRemoveOperationSms");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiOperationSmsTempWSModel apiGetOperationSmsTemps(long agentId,String operationId) {

        ApiOperationSmsTempWSModel response = new ApiOperationSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSmsTempWSDTO smsMessageTempWSDTO = apiOperationSmsChannelFramework.apiGetOperationSmsTempsService(agentId,operationId);
        if (smsMessageTempWSDTO != null){
            response.setSmsMessageTemp(smsMessageTempWSDTO);
        }

        general.setOperation("apiGetOperationSmsTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSmsTempWSModel apiGetOperationSmsTemp(long agentId,String operationId,String smsTempId) {

        ApiOperationSmsTempWSModel response = new ApiOperationSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSmsTempWSDTO smsMessageTempWSDTO = apiOperationSmsChannelFramework.apiGetOperationSmsTempService(agentId,operationId,smsTempId);
        if (smsMessageTempWSDTO != null){
            response.setSmsMessageTemp(smsMessageTempWSDTO);
        }

        general.setOperation("apiGetOperationSmsTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
