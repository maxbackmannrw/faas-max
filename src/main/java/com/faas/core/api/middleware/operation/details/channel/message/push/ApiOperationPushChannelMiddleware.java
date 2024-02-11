package com.faas.core.api.middleware.operation.details.channel.message.push;

import com.faas.core.api.framework.operation.details.channel.message.push.ApiOperationPushChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationPushChannelMiddleware {


    @Autowired
    ApiOperationPushChannelFramework apiOperationPushChannelFramework;


    public ApiOperationPushWSModel apiGetOperationPushes(long agentId,String operationId) {

        ApiOperationPushWSModel response = new ApiOperationPushWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationPushes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationPushWSModel apiGetOperationPush(long agentId,String operationId,String pushId) {

        ApiOperationPushWSModel response = new ApiOperationPushWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationPush");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationPushWSModel apiSendOperationPush(long agentId,String operationId) {

        ApiOperationPushWSModel response = new ApiOperationPushWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiSendOperationPush");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationPushWSModel apiUpdateOperationPush(long agentId,String operationId) {

        ApiOperationPushWSModel response = new ApiOperationPushWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiUpdateOperationPush");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationPushWSModel apiRemoveOperationPush(long agentId,String operationId) {

        ApiOperationPushWSModel response = new ApiOperationPushWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiRemoveOperationPush");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationPushTempWSModel apiGetOperationPushTemps(long agentId,String operationId) {

        ApiOperationPushTempWSModel response = new ApiOperationPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetOperationPushTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationPushTempWSModel apiGetOperationPushTemp(long agentId,String operationId,String pushTempId) {

        ApiOperationPushTempWSModel response = new ApiOperationPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
