package com.faas.core.api.middleware.operation.channel.call.sip;

import com.faas.core.api.framework.operation.channel.call.sip.ApiSipCallFramework;
import com.faas.core.api.model.ws.operation.channel.call.sip.ApiOperationSipCallWSModel;
import com.faas.core.api.model.ws.operation.channel.call.sip.ApiSipCallWSModel;
import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiOperationSipCallWSDTO;
import com.faas.core.api.model.ws.operation.channel.call.sip.dto.ApiSipCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiSipCallMiddleware {


    @Autowired
    ApiSipCallFramework apiSipCallFramework;


    public ApiOperationSipCallWSModel apiGetOperationSipCall(long agentId,long sessionId,long clientId) {

        ApiOperationSipCallWSModel response = new ApiOperationSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationSipCallWSDTO operationSipCallWSDTO = apiSipCallFramework.apiGetOperationSipCallService(agentId,sessionId,clientId);
        if (operationSipCallWSDTO != null){
            response.setOperationSipCall(operationSipCallWSDTO);
        }

        general.setOperation("apiGetOperationSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSipCallWSModel apiGetSipCalls(long agentId,long sessionId,long clientId) {

        ApiSipCallWSModel response = new ApiSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiSipCallWSDTO> sipCallWSDTOS = apiSipCallFramework.apiGetSipCallsService(agentId,sessionId,clientId);
        if (sipCallWSDTOS != null){
            response.setSipCalls(sipCallWSDTOS);
        }

        general.setOperation("apiGetSipCalls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSipCallWSModel apiGetSipCall(long agentId,long sessionId,long clientId,long callId) {

        ApiSipCallWSModel response = new ApiSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSipCallWSDTO>sipCallWSDTOS = new ArrayList<>();

        ApiSipCallWSDTO sipCallWSDTO = apiSipCallFramework.apiGetSipCallService(agentId,sessionId,clientId,callId);
        if (sipCallWSDTO != null){
            sipCallWSDTOS.add(sipCallWSDTO);
        }

        response.setSipCalls(sipCallWSDTOS);
        general.setOperation("apiGetSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSipCallWSModel apiCreateSipCall(long agentId,long sessionId,long clientId,long numberId) {

        ApiSipCallWSModel response = new ApiSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSipCallWSDTO>sipCallWSDTOS = new ArrayList<>();

        ApiSipCallWSDTO sipCallWSDTO = apiSipCallFramework.apiCreateSipCallService(agentId,sessionId,clientId,numberId);
        if (sipCallWSDTO != null){
            sipCallWSDTOS.add(sipCallWSDTO);
        }

        response.setSipCalls(sipCallWSDTOS);
        general.setOperation("apiCreateSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSipCallWSModel apiMakeSipCall(long agentId,long sessionId,long clientId,long callId) {

        ApiSipCallWSModel response = new ApiSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSipCallWSDTO>sipCallWSDTOS = new ArrayList<>();

        ApiSipCallWSDTO sipCallWSDTO = apiSipCallFramework.apiMakeSipCallService(agentId,sessionId,clientId,callId);
        if (sipCallWSDTO != null){
            sipCallWSDTOS.add(sipCallWSDTO);
        }

        response.setSipCalls(sipCallWSDTOS);
        general.setOperation("apiMakeSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSipCallWSModel apiEndSipCall(long agentId,long sessionId,long clientId,long callId) {

        ApiSipCallWSModel response = new ApiSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSipCallWSDTO>sipCallWSDTOS = new ArrayList<>();

        ApiSipCallWSDTO sipCallWSDTO = apiSipCallFramework.apiEndSipCallService(agentId,sessionId,clientId,callId);
        if (sipCallWSDTO != null){
            sipCallWSDTOS.add(sipCallWSDTO);
        }

        response.setSipCalls(sipCallWSDTOS);
        general.setOperation("apiEndSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiSipCallWSModel apiFinishSipCall(long agentId,long sessionId,long clientId,long callId) {

        ApiSipCallWSModel response = new ApiSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSipCallWSDTO>sipCallWSDTOS = new ArrayList<>();

        ApiSipCallWSDTO sipCallWSDTO = apiSipCallFramework.apiFinishSipCallService(agentId,sessionId,clientId,callId);
        if (sipCallWSDTO != null){
            sipCallWSDTOS.add(sipCallWSDTO);
        }

        response.setSipCalls(sipCallWSDTOS);
        general.setOperation("apiFinishSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSipCallWSModel apiUpdateSipCall(long agentId,long sessionId,long clientId,long callId,String callState) {

        ApiSipCallWSModel response = new ApiSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSipCallWSDTO>sipCallWSDTOS = new ArrayList<>();

        ApiSipCallWSDTO sipCallWSDTO = apiSipCallFramework.apiUpdateSipCallService(agentId,sessionId,clientId,callId,callState);
        if (sipCallWSDTO != null){
            sipCallWSDTOS.add(sipCallWSDTO);
        }

        response.setSipCalls(sipCallWSDTOS);
        general.setOperation("apiUpdateSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiSipCallWSModel apiRemoveSipCall(long agentId,long sessionId,long clientId,long callId) {

        ApiSipCallWSModel response = new ApiSipCallWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiSipCallWSDTO>sipCallWSDTOS = new ArrayList<>();

        ApiSipCallWSDTO sipCallWSDTO = apiSipCallFramework.apiRemoveSipCallService(agentId,clientId,sessionId,callId);
        if (sipCallWSDTO != null){
            sipCallWSDTOS.add(sipCallWSDTO);
        }

        response.setSipCalls(sipCallWSDTOS);
        general.setOperation("apiRemoveSipCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





}
