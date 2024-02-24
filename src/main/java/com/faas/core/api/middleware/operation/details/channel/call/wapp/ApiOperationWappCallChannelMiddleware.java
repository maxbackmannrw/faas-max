package com.faas.core.api.middleware.operation.details.channel.call.wapp;

import com.faas.core.api.framework.operation.details.channel.call.wapp.ApiOperationWappCallChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationActiveWappCallWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallAccountWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationActiveWappCallWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationWappCallChannelMiddleware {


    @Autowired
    ApiOperationWappCallChannelFramework apiOperationWappCallChannelFramework;


    public ApiOperationWappCallWSModel apiGetOperationWappCalls(long agentId,String operationId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationWappCallWSDTO> operationWappCallWSDTOS =  apiOperationWappCallChannelFramework.apiGetOperationWappCallsService(agentId,operationId);
        if (operationWappCallWSDTOS != null){
            response.setOperationWappCalls(operationWappCallWSDTOS);
        }

        general.setOperation("apiGetOperationWappCalls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWappCallWSModel apiGetOperationWappCall(long agentId,String operationId,String callId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWappCallWSDTO> operationWappCallWSDTOS = new ArrayList<>();

        ApiOperationWappCallWSDTO operationWappCallWSDTO =  apiOperationWappCallChannelFramework.apiGetOperationWappCallService(agentId,operationId,callId);
        if (operationWappCallWSDTO != null){
            operationWappCallWSDTOS.add(operationWappCallWSDTO);
        }

        response.setOperationWappCalls(operationWappCallWSDTOS);
        general.setOperation("apiGetOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWappCallWSModel apiCreateOperationWappCall(long agentId,String operationId,String numberId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWappCallWSDTO> operationWappCallWSDTOS = new ArrayList<>();

        ApiOperationWappCallWSDTO operationWappCallWSDTO =  apiOperationWappCallChannelFramework.apiCreateOperationWappCallService(agentId,operationId,numberId);
        if (operationWappCallWSDTO != null){
            operationWappCallWSDTOS.add(operationWappCallWSDTO);
        }

        response.setOperationWappCalls(operationWappCallWSDTOS);
        general.setOperation("apiCreateOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWappCallWSModel apiStartOperationWappCall(long agentId,String operationId,String callId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWappCallWSDTO> operationWappCallWSDTOS = new ArrayList<>();

        ApiOperationWappCallWSDTO operationWappCallWSDTO =  apiOperationWappCallChannelFramework.apiStartOperationWappCallService(agentId,operationId,callId);
        if (operationWappCallWSDTO != null){
            operationWappCallWSDTOS.add(operationWappCallWSDTO);
        }

        response.setOperationWappCalls(operationWappCallWSDTOS);
        general.setOperation("apiStartOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWappCallWSModel apiHangUpOperationWappCall(long agentId,String operationId,String callId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWappCallWSDTO> operationWappCallWSDTOS = new ArrayList<>();

        ApiOperationWappCallWSDTO operationWappCallWSDTO =  apiOperationWappCallChannelFramework.apiHangUpOperationWappCallService(agentId,operationId,callId);
        if (operationWappCallWSDTO != null){
            operationWappCallWSDTOS.add(operationWappCallWSDTO);
        }

        response.setOperationWappCalls(operationWappCallWSDTOS);
        general.setOperation("apiHangUpOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWappCallWSModel apiUpdateOperationWappCall(long agentId,String operationId,String callId,String callState) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWappCallWSDTO> operationWappCallWSDTOS = new ArrayList<>();

        ApiOperationWappCallWSDTO operationWappCallWSDTO =  apiOperationWappCallChannelFramework.apiUpdateOperationWappCallService(agentId,operationId,callId,callState);
        if (operationWappCallWSDTO != null){
            operationWappCallWSDTOS.add(operationWappCallWSDTO);
        }

        response.setOperationWappCalls(operationWappCallWSDTOS);
        general.setOperation("apiUpdateOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWappCallWSModel apiRemoveOperationWappCall(long agentId,String operationId,String callId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWappCallWSDTO> operationWappCallWSDTOS = new ArrayList<>();

        ApiOperationWappCallWSDTO operationWappCallWSDTO =  apiOperationWappCallChannelFramework.apiRemoveOperationWappCallService(agentId,operationId,callId);
        if (operationWappCallWSDTO != null){
            operationWappCallWSDTOS.add(operationWappCallWSDTO);
        }

        response.setOperationWappCalls(operationWappCallWSDTOS);
        general.setOperation("apiRemoveOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationActiveWappCallWSModel apiGetOperationActiveWappCall(long agentId, String operationId) {

        ApiOperationActiveWappCallWSModel response = new ApiOperationActiveWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationActiveWappCallWSDTO operationActiveWappCallWSDTO =  apiOperationWappCallChannelFramework.apiGetOperationActiveWappCallService(agentId,operationId);
        if (operationActiveWappCallWSDTO != null){
            response.setOperationActiveWappCall(operationActiveWappCallWSDTO);
        }

        general.setOperation("apiGetOperationActiveWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappCallAccountWSModel apiGetOperationWappCallAccount(long agentId, String operationId) {

        ApiOperationWappCallAccountWSModel response = new ApiOperationWappCallAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappCallAccountWSDTO operationWappCallAccountWSDTO =  apiOperationWappCallChannelFramework.apiGetOperationWappCallAccountService(agentId,operationId);
        if (operationWappCallAccountWSDTO != null){
            response.setWappCallAccount(operationWappCallAccountWSDTO);
        }

        general.setOperation("apiGetOperationWappCallAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
