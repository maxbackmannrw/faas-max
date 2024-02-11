package com.faas.core.api.middleware.operation.details.channel.call.sip;

import com.faas.core.api.framework.operation.details.channel.call.sip.ApiOperationSipChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipCallWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationSipChannelMiddleware {


    @Autowired
    ApiOperationSipChannelFramework apiOperationSipChannelFramework;


    public ApiOperationSipCallWSModel apiGetOperationSipCalls(long agentId, String operationId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationSipCallWSDTO> operationSipCallWSDTOS = apiOperationSipChannelFramework.apiGetOperationSipCallsService(agentId,operationId);
        if (operationSipCallWSDTOS != null){
            response.setOperationSipCalls(operationSipCallWSDTOS);
        }

        general.setOperation("apiGetOperationSipCalls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSipCallWSModel apiGetOperationSipCall(long agentId,String operationId,long callId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO>operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipChannelFramework.apiGetOperationSipCallService(agentId,operationId,callId);
        if (operationSipCallWSDTO != null){
            operationSipCallWSDTOS.add(operationSipCallWSDTO);
        }

        response.setOperationSipCalls(operationSipCallWSDTOS);
        general.setOperation("apiGetOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSipCallWSModel apiCreateOperationSipCall(long agentId,String operationId,String numberId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO>operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipChannelFramework.apiCreateOperationSipCallService(agentId,operationId,numberId);
        if (operationSipCallWSDTO != null){
            operationSipCallWSDTOS.add(operationSipCallWSDTO);
        }

        response.setOperationSipCalls(operationSipCallWSDTOS);
        general.setOperation("apiCreateOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSipCallWSModel apiMakeOperationSipCall(long agentId,String operationId,long callId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO>operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipChannelFramework.apiMakeOperationSipCallService(agentId,operationId,callId);
        if (operationSipCallWSDTO != null){
            operationSipCallWSDTOS.add(operationSipCallWSDTO);
        }

        response.setOperationSipCalls(operationSipCallWSDTOS);
        general.setOperation("apiMakeOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSipCallWSModel apiEndOperationSipCall(long agentId,String operationId,long callId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO>operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipChannelFramework.apiEndOperationSipCallService(agentId,operationId,callId);
        if (operationSipCallWSDTO != null){
            operationSipCallWSDTOS.add(operationSipCallWSDTO);
        }

        response.setOperationSipCalls(operationSipCallWSDTOS);
        general.setOperation("apiEndOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiOperationSipCallWSModel apiFinishOperationSipCall(long agentId,String operationId,long callId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO>operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipChannelFramework.apiFinishOperationSipCallService(agentId,operationId,callId);
        if (operationSipCallWSDTO != null){
            operationSipCallWSDTOS.add(operationSipCallWSDTO);
        }

        response.setOperationSipCalls(operationSipCallWSDTOS);
        general.setOperation("apiFinishOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSipCallWSModel apiUpdateOperationSipCall(long agentId,String operationId,long callId,String callState) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO>operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipChannelFramework.apiUpdateOperationSipCallService(agentId,operationId,callId,callState);
        if (operationSipCallWSDTO != null){
            operationSipCallWSDTOS.add(operationSipCallWSDTO);
        }

        response.setOperationSipCalls(operationSipCallWSDTOS);
        general.setOperation("apiUpdateOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSipCallWSModel apiRemoveOperationSipCall(long agentId,String operationId,long callId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO>operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipChannelFramework.apiRemoveOperationSipCallService(agentId,operationId,callId);
        if (operationSipCallWSDTO != null){
            operationSipCallWSDTOS.add(operationSipCallWSDTO);
        }

        response.setOperationSipCalls(operationSipCallWSDTOS);
        general.setOperation("apiRemoveOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
