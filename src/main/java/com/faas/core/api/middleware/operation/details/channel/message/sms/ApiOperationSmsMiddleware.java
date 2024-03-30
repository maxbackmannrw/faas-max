package com.faas.core.api.middleware.operation.details.channel.message.sms;

import com.faas.core.api.framework.operation.details.channel.message.sms.ApiOperationSmsFramework;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiOperationSmsAccountWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiOperationSmsChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiOperationSmsTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.ApiOperationSmsWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.sms.dto.ApiOperationSmsAccountWSDTO;
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
public class ApiOperationSmsMiddleware {


    @Autowired
    ApiOperationSmsFramework apiOperationSmsFramework;


    public ApiOperationSmsChannelWSModel apiGetOperationSmsChannel(long agentId, String operationId) {

        ApiOperationSmsChannelWSModel response = new ApiOperationSmsChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSmsChannelWSDTO smsChannelWSDTO = apiOperationSmsFramework.apiGetOperationSmsChannelService(agentId,operationId);
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


    public ApiOperationSmsAccountWSModel apiGetOperationSmsAccount(long agentId, String operationId) {

        ApiOperationSmsAccountWSModel response = new ApiOperationSmsAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSmsAccountWSDTO smsAccountWSDTO = apiOperationSmsFramework.apiGetOperationSmsAccountService(agentId,operationId);
        if (smsAccountWSDTO != null){
            response.setSmsAccount(smsAccountWSDTO);
        }

        general.setOperation("apiGetOperationSmsAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSmsTempWSModel apiGetOperationSmsTemps(long agentId,String operationId) {

        ApiOperationSmsTempWSModel response = new ApiOperationSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSmsTempWSDTO smsTempWSDTO = apiOperationSmsFramework.apiGetOperationSmsTempsService(agentId,operationId);
        if (smsTempWSDTO != null){
            response.setSmsTemp(smsTempWSDTO);
        }

        general.setOperation("apiGetOperationSmsTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSmsTempWSModel apiGetOperationSmsTemp(long agentId,String operationId,String tempId) {

        ApiOperationSmsTempWSModel response = new ApiOperationSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSmsTempWSDTO smsTempWSDTO = apiOperationSmsFramework.apiGetOperationSmsTempService(agentId,operationId,tempId);
        if (smsTempWSDTO != null){
            response.setSmsTemp(smsTempWSDTO);
        }

        general.setOperation("apiGetOperationSmsTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSmsWSModel apiGetOperationSmss(long agentId,String operationId) {

        ApiOperationSmsWSModel response = new ApiOperationSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationSmsWSDTO> operationSmsWSDTOS = apiOperationSmsFramework.apiGetOperationSmssService(agentId,operationId);
        if (operationSmsWSDTOS != null){
            response.setOperationSmss(operationSmsWSDTOS);
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
        List<ApiOperationSmsWSDTO> operationSmsWSDTOS = new ArrayList<>();

        ApiOperationSmsWSDTO operationSmsWSDTO = apiOperationSmsFramework.apiGetOperationSmsService(agentId,operationId,smsId);
        if (operationSmsWSDTO != null){
            operationSmsWSDTOS.add(operationSmsWSDTO);
        }

        response.setOperationSmss(operationSmsWSDTOS);
        general.setOperation("apiGetOperationSms");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSmsWSModel apiSendOperationSms(long agentId,String operationId,String tempId,String numberId) throws IOException {

        ApiOperationSmsWSModel response = new ApiOperationSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSmsWSDTO> operationSmsWSDTOS = new ArrayList<>();

        ApiOperationSmsWSDTO operationSmsWSDTO = apiOperationSmsFramework.apiSendOperationSmsService(agentId,operationId,tempId,numberId);
        if (operationSmsWSDTO != null){
            operationSmsWSDTOS.add(operationSmsWSDTO);
        }

        response.setOperationSmss(operationSmsWSDTOS);
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
        List<ApiOperationSmsWSDTO> operationSmsWSDTOS = new ArrayList<>();

        ApiOperationSmsWSDTO operationSmsWSDTO = apiOperationSmsFramework.apiUpdateOperationSmsService(agentId,operationId,smsId,smsState);
        if (operationSmsWSDTO != null){
            operationSmsWSDTOS.add(operationSmsWSDTO);
        }

        response.setOperationSmss(operationSmsWSDTOS);
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
        List<ApiOperationSmsWSDTO> operationSmsWSDTOS = new ArrayList<>();

        ApiOperationSmsWSDTO operationSmsWSDTO = apiOperationSmsFramework.apiRemoveOperationSmsService(agentId,operationId,smsId);
        if (operationSmsWSDTO != null){
            operationSmsWSDTOS.add(operationSmsWSDTO);
        }

        response.setOperationSmss(operationSmsWSDTOS);
        general.setOperation("apiRemoveOperationSms");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
