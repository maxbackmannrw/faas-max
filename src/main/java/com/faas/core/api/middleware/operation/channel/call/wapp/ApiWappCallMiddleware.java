package com.faas.core.api.middleware.operation.channel.call.wapp;

import com.faas.core.api.framework.operation.channel.call.wapp.ApiWappCallFramework;
import com.faas.core.api.model.ws.operation.channel.call.wapp.ApiOperationWappCallWSModel;
import com.faas.core.api.model.ws.operation.channel.call.wapp.ApiWappCallWSModel;
import com.faas.core.api.model.ws.operation.channel.call.wapp.dto.ApiOperationWappCallWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiWappCallMiddleware {


    @Autowired
    ApiWappCallFramework apiWappCallFramework;


    public ApiOperationWappCallWSModel apiGetOperationWappCall(long agentId, long sessionId, long clientId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationWappCallWSDTO operationWappCallWSDTO = apiWappCallFramework.apiGetOperationWappCallService(agentId,sessionId,clientId);
        if (operationWappCallWSDTO != null){
            response.setOperationWappCall(operationWappCallWSDTO);
        }

        general.setOperation("apiGetOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiWappCallWSModel apiGetWappCalls(long agentId,long sessionId,String campaignId,String processId ) {

        ApiWappCallWSModel response = new ApiWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetWappCalls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiWappCallWSModel apiGetWappCall(long agentId,long sessionId,long clientId ,long callId) {

        ApiWappCallWSModel response = new ApiWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiWappCallWSModel apiCreateWappCall(long agentId,long sessionId,long clientId,String processId,long numberId) {

        ApiWappCallWSModel response = new ApiWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiCreateWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiWappCallWSModel apiMakeWappCall(long agentId,long sessionId,long clientId,String processId,long numberId) {

        ApiWappCallWSModel response = new ApiWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiCreateWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiWappCallWSModel apiEndWappCall(long agentId,long sessionId,long clientId,String processId,long numberId) {

        ApiWappCallWSModel response = new ApiWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiCreateWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiWappCallWSModel apiFinishWappCall(long agentId,long sessionId,long clientId,String processId,long numberId) {

        ApiWappCallWSModel response = new ApiWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiCreateWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiWappCallWSModel apiUpdateWappCall(long agentId,long sessionId,long clientId,long callId) {

        ApiWappCallWSModel response = new ApiWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiUpdateWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiWappCallWSModel apiRemoveWappCall(long agentId,long sessionId,long clientId, long callId) {

        ApiWappCallWSModel response = new ApiWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiRemoveWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
