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

        ApiOperationSmsChannelWSDTO operationSmsChannelWSDTO = apiOperationSmsChannelFramework.apiGetOperationSmsChannelService(agentId,operationId);
        if (operationSmsChannelWSDTO != null){
            response.setOperationSmsChannel(operationSmsChannelWSDTO);
        }

        general.setOperation("apiGetOperationSmsChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSmsWSModel apiGetOperationSmss(long agentId,String operationId) {

        ApiOperationSmsWSModel response = new ApiOperationSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationSmsWSDTO> operationSmsWSDTOS = apiOperationSmsChannelFramework.apiGetOperationSmssService(agentId,operationId);
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

        ApiOperationSmsWSDTO operationSmsWSDTO = apiOperationSmsChannelFramework.apiGetOperationSmsService(agentId,operationId,smsId);
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


    public ApiOperationSmsWSModel apiSendOperationSms(long agentId,String operationId,String smsTempId,String numberId) throws IOException {

        ApiOperationSmsWSModel response = new ApiOperationSmsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSmsWSDTO> operationSmsWSDTOS = new ArrayList<>();

        ApiOperationSmsWSDTO operationSmsWSDTO = apiOperationSmsChannelFramework.apiSendOperationSmsService(agentId,operationId,smsTempId,numberId);
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

        ApiOperationSmsWSDTO operationSmsWSDTO = apiOperationSmsChannelFramework.apiUpdateOperationSmsService(agentId,operationId,smsId,smsState);
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

        ApiOperationSmsWSDTO operationSmsWSDTO = apiOperationSmsChannelFramework.apiRemoveOperationSmsService(agentId,operationId,smsId);
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



    public ApiOperationSmsTempWSModel apiGetOperationSmsTemps(long agentId,String operationId) {

        ApiOperationSmsTempWSModel response = new ApiOperationSmsTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationSmsTempWSDTO> operationSmsTempWSDTOS = apiOperationSmsChannelFramework.apiGetOperationSmsTempsService(agentId,operationId);
        if (operationSmsTempWSDTOS != null){
            response.setOperationSmsTemps(operationSmsTempWSDTOS);
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
        List<ApiOperationSmsTempWSDTO> operationSmsTempWSDTOS = new ArrayList<>();

        ApiOperationSmsTempWSDTO operationSmsTempWSDTO = apiOperationSmsChannelFramework.apiGetOperationSmsTempService(agentId,operationId,smsTempId);
        if (operationSmsTempWSDTO != null){
            operationSmsTempWSDTOS.add(operationSmsTempWSDTO);
        }

        response.setOperationSmsTemps(operationSmsTempWSDTOS);
        general.setOperation("apiGetOperationSmsTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
