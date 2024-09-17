package com.faas.core.api.middleware.operation.details.channel.call.sip;

import com.faas.core.api.framework.operation.details.channel.call.sip.ApiOperationSipFramework;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipAccountWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipCallWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.ApiOperationSipChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.call.sip.dto.ApiOperationSipChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationSipMiddleware {


    @Autowired
    ApiOperationSipFramework apiOperationSipFramework;


    public ApiOperationSipChannelWSModel apiGetOperationSipChannel(long agentId, String operationId) {

        ApiOperationSipChannelWSModel response = new ApiOperationSipChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSipChannelWSDTO operationSipChannelWSDTO = apiOperationSipFramework.apiGetOperationSipChannelService(agentId, operationId);
        if (operationSipChannelWSDTO != null) {
            response.setOperationSipChannel(operationSipChannelWSDTO);
        }

        general.setOperation("apiGetOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationSipAccountWSModel apiGetOperationSipAccount(long agentId, String operationId) {

        ApiOperationSipAccountWSModel response = new ApiOperationSipAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSipAccountWSDTO sipAccountWSDTO = apiOperationSipFramework.apiGetOperationSipAccountService(agentId, operationId);
        if (sipAccountWSDTO != null) {
            response.setSipAccount(sipAccountWSDTO);
        }

        general.setOperation("apiGetOperationSipAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationSipCallWSModel apiGetOperationSipCalls(long agentId, String operationId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationSipCallWSDTO> operationSipCallWSDTOS = apiOperationSipFramework.apiGetOperationSipCallsService(agentId, operationId);
        if (operationSipCallWSDTOS != null) {
            response.setOperationSipCalls(operationSipCallWSDTOS);
        }

        general.setOperation("apiGetOperationSipCalls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationSipCallWSModel apiGetOperationSipCall(long agentId, String operationId, String callId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO> operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipFramework.apiGetOperationSipCallService(agentId, operationId, callId);
        if (operationSipCallWSDTO != null) {
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

    public ApiOperationSipCallWSModel apiCreateOperationSipCall(long agentId, String operationId, String numberId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO> operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipFramework.apiCreateOperationSipCallService(agentId, operationId, numberId);
        if (operationSipCallWSDTO != null) {
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

    public ApiOperationSipCallWSModel apiStartOperationSipCall(long agentId, String operationId, String callId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO> operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipFramework.apiStartOperationSipCallService(agentId, operationId, callId);
        if (operationSipCallWSDTO != null) {
            operationSipCallWSDTOS.add(operationSipCallWSDTO);
        }

        response.setOperationSipCalls(operationSipCallWSDTOS);
        general.setOperation("apiStartOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationSipCallWSModel apiCancelOperationSipCall(long agentId, String operationId, String callId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO> operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipFramework.apiCancelOperationSipCallService(agentId, operationId, callId);
        if (operationSipCallWSDTO != null) {
            operationSipCallWSDTOS.add(operationSipCallWSDTO);
        }

        response.setOperationSipCalls(operationSipCallWSDTOS);
        general.setOperation("apiCancelOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationSipCallWSModel apiHangupOperationSipCall(long agentId, String operationId, String callId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO> operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipFramework.apiHangupOperationSipCallService(agentId, operationId, callId);
        if (operationSipCallWSDTO != null) {
            operationSipCallWSDTOS.add(operationSipCallWSDTO);
        }

        response.setOperationSipCalls(operationSipCallWSDTOS);
        general.setOperation("apiHangupOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationSipCallWSModel apiUpdateOperationSipCall(long agentId, String operationId, String callId, String callState) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO> operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipFramework.apiUpdateOperationSipCallService(agentId, operationId, callId, callState);
        if (operationSipCallWSDTO != null) {
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

    public ApiOperationSipCallWSModel apiRemoveOperationSipCall(long agentId, String operationId, String callId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationSipCallWSDTO> operationSipCallWSDTOS = new ArrayList<>();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiOperationSipFramework.apiRemoveOperationSipCallService(agentId, operationId, callId);
        if (operationSipCallWSDTO != null) {
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