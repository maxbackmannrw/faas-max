package com.faas.core.api.middleware.operation.details.channel.call.wapp;

import com.faas.core.api.framework.operation.details.channel.call.wapp.ApiOperationWappCallFramework;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallAccountWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationWappCallMiddleware {


    @Autowired
    ApiOperationWappCallFramework apiOperationWappCallFramework;


    public ApiOperationWappCallChannelWSModel apiGetOperationWappCallChannel(long agentId, String operationId) {

        ApiOperationWappCallChannelWSModel response = new ApiOperationWappCallChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappCallChannelWSDTO operationWappCallChannelWSDTO = apiOperationWappCallFramework.apiGetOperationWappCallChannelService(agentId,operationId);
        if (operationWappCallChannelWSDTO != null){
            response.setOperationWappCallChannel(operationWappCallChannelWSDTO);
        }

        general.setOperation("apiGetOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWappCallAccountWSModel apiGetOperationWappCallAccount(long agentId, String operationId) {

        ApiOperationWappCallAccountWSModel response = new ApiOperationWappCallAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappCallAccountWSDTO operationWappCallAccountWSDTO = apiOperationWappCallFramework.apiGetOperationWappCallAccountService(agentId,operationId);
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


    public ApiOperationWappCallWSModel apiGetOperationWappCalls(long agentId,String operationId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationWappCallWSDTO> operationWappCallWSDTOS =  apiOperationWappCallFramework.apiGetOperationWappCallsService(agentId,operationId);
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

        ApiOperationWappCallWSDTO operationWappCallWSDTO =  apiOperationWappCallFramework.apiGetOperationWappCallService(agentId,operationId,callId);
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

        ApiOperationWappCallWSDTO operationWappCallWSDTO =  apiOperationWappCallFramework.apiCreateOperationWappCallService(agentId,operationId,numberId);
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

        ApiOperationWappCallWSDTO operationWappCallWSDTO =  apiOperationWappCallFramework.apiStartOperationWappCallService(agentId,operationId,callId);
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


    public ApiOperationWappCallWSModel apiCancelOperationWappCall(long agentId,String operationId,String callId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWappCallWSDTO> operationWappCallWSDTOS = new ArrayList<>();

        ApiOperationWappCallWSDTO operationWappCallWSDTO =  apiOperationWappCallFramework.apiCancelOperationWappCallService(agentId,operationId,callId);
        if (operationWappCallWSDTO != null){
            operationWappCallWSDTOS.add(operationWappCallWSDTO);
        }

        response.setOperationWappCalls(operationWappCallWSDTOS);
        general.setOperation("apiCancelOperationWappCall");
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

        ApiOperationWappCallWSDTO operationWappCallWSDTO =  apiOperationWappCallFramework.apiHangUpOperationWappCallService(agentId,operationId,callId);
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

        ApiOperationWappCallWSDTO operationWappCallWSDTO =  apiOperationWappCallFramework.apiUpdateOperationWappCallService(agentId,operationId,callId,callState);
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

        ApiOperationWappCallWSDTO operationWappCallWSDTO =  apiOperationWappCallFramework.apiRemoveOperationWappCallService(agentId,operationId,callId);
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



}
