package com.faas.core.api.middleware.operation.details.channel.call.wapp;

import com.faas.core.api.framework.operation.details.channel.call.wapp.ApiOperationWappCallChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.dto.ApiOperationWappCallChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationWappCallChannelMiddleware {


    @Autowired
    ApiOperationWappCallChannelFramework apiOperationWappCallChannelFramework;


    public ApiOperationWappCallWSModel apiGetOperationWappCalls(long agentId,String operationId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetWappCalls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappCallWSModel apiGetOperationWappCall(long agentId,String operationId,long callId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappCallWSModel apiCreateOperationWappCall(long agentId,String operationId,String numberId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiCreateOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappCallWSModel apiMakeOperationWappCall(long agentId,String operationId,long callId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiMakeOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappCallWSModel apiEndOperationWappCall(long agentId,String operationId,long numberId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiEndOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappCallWSModel apiFinishOperationWappCall(long agentId,String operationId,long callId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiFinishOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappCallWSModel apiUpdateOperationWappCall(long agentId,String operationId,long callId,String callState) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiUpdateOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiOperationWappCallWSModel apiRemoveOperationWappCall(long agentId,String operationId,long callId) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiRemoveOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
