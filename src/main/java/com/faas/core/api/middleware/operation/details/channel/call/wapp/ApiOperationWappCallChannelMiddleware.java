package com.faas.core.api.middleware.operation.details.channel.call.wapp;

import com.faas.core.api.framework.operation.details.channel.call.wapp.ApiOperationWappCallChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallAccountWSModel;
import com.faas.core.api.model.ws.operation.details.channel.call.wapp.ApiOperationWappCallWSModel;
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



        general.setOperation("apiCreateOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWappCallWSModel apiUpdateOperationWappCall(long agentId,String operationId,String callId,String callState) {

        ApiOperationWappCallWSModel response = new ApiOperationWappCallWSModel();
        GeneralWSModel general = new GeneralWSModel();



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



        general.setOperation("apiRemoveOperationWappCall");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationWappCallAccountWSModel apiGetOperationWappCallAccount(long agentId, String operationId) {

        ApiOperationWappCallAccountWSModel response = new ApiOperationWappCallAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetOperationWappCallAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
