package com.faas.core.api.middleware.operation.channel.push;

import com.faas.core.api.framework.operation.channel.push.ApiPushMessageFramework;
import com.faas.core.api.model.ws.operation.channel.push.ApiOperationPushMessageWSModel;
import com.faas.core.api.model.ws.operation.channel.push.ApiPushMessageTempWSModel;
import com.faas.core.api.model.ws.operation.channel.push.ApiPushMessageWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiPushMessageMiddleware {


    @Autowired
    ApiPushMessageFramework apiPushMessageFramework;


    public ApiOperationPushMessageWSModel apiGetOperationPushMessage(long agentId, long sessionId) {

        ApiOperationPushMessageWSModel response = new ApiOperationPushMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationPushMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiPushMessageWSModel apiGetPushMessages(long agentId, long sessionId, long pushId) {

        ApiPushMessageWSModel response = new ApiPushMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetPushMessages");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiPushMessageWSModel apiGetPushMessage(long agentId, long sessionId, long pushId) {

        ApiPushMessageWSModel response = new ApiPushMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetPushMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiPushMessageWSModel apiSendPushMessage(long agentId, long sessionId) {

        ApiPushMessageWSModel response = new ApiPushMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiSendPushMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiPushMessageWSModel apiUpdatePushMessage(long agentId, long sessionId) {

        ApiPushMessageWSModel response = new ApiPushMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiUpdatePushMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiPushMessageWSModel apiRemovePushMessage(long agentId, long sessionId) {

        ApiPushMessageWSModel response = new ApiPushMessageWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiRemovePushMessage");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiPushMessageTempWSModel apiGetPushMessageTemps(long agentId, long sessionId) {

        ApiPushMessageTempWSModel response = new ApiPushMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetPushMessageTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiPushMessageTempWSModel apiGetPushMessageTemp(long agentId, long sessionId) {

        ApiPushMessageTempWSModel response = new ApiPushMessageTempWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("apiGetPushMessageTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
