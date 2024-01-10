package com.faas.core.api.middleware.operation.details.channel.message.email;

import com.faas.core.api.framework.operation.details.channel.message.email.ApiEmailMessageFramework;
import com.faas.core.api.model.ws.operation.details.channel.message.email.ApiEmailTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.email.ApiEmailWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.email.ApiOperationEmailWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiEmailMessageMiddleware {


    @Autowired
    ApiEmailMessageFramework apiEmailMessageFramework;


    public ApiOperationEmailWSModel apiGetOperationEmail(long agentId, long sessionId) {

        ApiOperationEmailWSModel response = new ApiOperationEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetOperationEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiEmailWSModel apiGetEmails(long agentId,long sessionId,String campaignId,String processId) {

        ApiEmailWSModel response = new ApiEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetEmails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiEmailWSModel apiGetEmail(long agentId, long sessionId,String campaignId,String processId,String emailId) {

        ApiEmailWSModel response = new ApiEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiEmailWSModel apiSendEmail(long agentId, long sessionId,String campaignId,String processId,String tempId,long emailAddressId) {

        ApiEmailWSModel response = new ApiEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiSendEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiEmailWSModel apiUpdateEmail(long agentId, long sessionId,String campaignId,String processId,String emailId) {

        ApiEmailWSModel response = new ApiEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiUpdateEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiEmailWSModel apiRemoveEmail(long agentId, long sessionId,String campaignId,String processId,String emailId) {

        ApiEmailWSModel response = new ApiEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiRemoveEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ApiEmailTempWSModel apiGetEmailTemps(long agentId,long sessionId,String campaignId,String processId) {

        ApiEmailTempWSModel response = new ApiEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetEmailTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiEmailTempWSModel apiGetEmailTemp(long agentId, long sessionId,String campaignId,String processId,String tempId) {

        ApiEmailTempWSModel response = new ApiEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("apiGetEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
