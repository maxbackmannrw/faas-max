package com.faas.core.api.middleware.operation.details.channel.message.email;

import com.faas.core.api.framework.operation.details.channel.message.email.ApiOperationEmailChannelFramework;
import com.faas.core.api.model.ws.operation.details.channel.message.email.ApiOperationEmailAccountWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.email.ApiOperationEmailChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.email.ApiOperationEmailTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.email.ApiOperationEmailWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiOperationEmailChannelMiddleware {


    @Autowired
    ApiOperationEmailChannelFramework apiOperationEmailChannelFramework;


    public ApiOperationEmailChannelWSModel apiGetOperationEmailChannel(long agentId, String operationId) {

        ApiOperationEmailChannelWSModel response = new ApiOperationEmailChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationEmailChannelWSDTO emailChannelWSDTO = apiOperationEmailChannelFramework.apiGetOperationEmailChannelService(agentId,operationId);
        if (emailChannelWSDTO != null){
            response.setOperationEmailChannel(emailChannelWSDTO);
        }

        general.setOperation("apiGetOperationEmailChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationEmailWSModel apiGetOperationEmails(long agentId,String operationId) {

        ApiOperationEmailWSModel response = new ApiOperationEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationEmailWSDTO> operationEmailWSDTOS =  apiOperationEmailChannelFramework.apiGetOperationEmailsService(agentId,operationId);
        if (operationEmailWSDTOS != null){
            response.setOperationEmails(operationEmailWSDTOS);
        }

        general.setOperation("apiGetOperationEmails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationEmailWSModel apiGetOperationEmail(long agentId,String operationId,String emailId) {

        ApiOperationEmailWSModel response = new ApiOperationEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationEmailWSDTO> operationEmailWSDTOS = new ArrayList<>();

        ApiOperationEmailWSDTO operationEmailWSDTO =  apiOperationEmailChannelFramework.apiGetOperationEmailService(agentId,operationId,emailId);
        if (operationEmailWSDTO != null){
            operationEmailWSDTOS.add(operationEmailWSDTO);
        }

        response.setOperationEmails(operationEmailWSDTOS);
        general.setOperation("apiGetOperationEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationEmailWSModel apiSendOperationEmail(long agentId, String operationId,String tempId,String emailAddressId) {

        ApiOperationEmailWSModel response = new ApiOperationEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationEmailWSDTO> operationEmailWSDTOS = new ArrayList<>();

        ApiOperationEmailWSDTO operationEmailWSDTO =  apiOperationEmailChannelFramework.apiSendOperationEmailService(agentId,operationId,tempId,emailAddressId);
        if (operationEmailWSDTO != null){
            operationEmailWSDTOS.add(operationEmailWSDTO);
        }

        response.setOperationEmails(operationEmailWSDTOS);
        general.setOperation("apiSendOperationEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationEmailWSModel apiUpdateOperationEmail(long agentId,String operationId,String emailId,String emailState) {

        ApiOperationEmailWSModel response = new ApiOperationEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationEmailWSDTO> operationEmailWSDTOS = new ArrayList<>();

        ApiOperationEmailWSDTO operationEmailWSDTO =  apiOperationEmailChannelFramework.apiUpdateOperationEmailService(agentId,operationId,emailId,emailState);
        if (operationEmailWSDTO != null){
            operationEmailWSDTOS.add(operationEmailWSDTO);
        }

        response.setOperationEmails(operationEmailWSDTOS);
        general.setOperation("apiUpdateOperationEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationEmailWSModel apiRemoveOperationEmail(long agentId,String operationId,String emailId) {

        ApiOperationEmailWSModel response = new ApiOperationEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationEmailWSDTO> operationEmailWSDTOS = new ArrayList<>();

        ApiOperationEmailWSDTO operationEmailWSDTO =  apiOperationEmailChannelFramework.apiRemoveOperationEmailService(agentId,operationId,emailId);
        if (operationEmailWSDTO != null){
            operationEmailWSDTOS.add(operationEmailWSDTO);
        }

        response.setOperationEmails(operationEmailWSDTOS);
        general.setOperation("apiRemoveOperationEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationEmailTempWSModel apiGetOperationEmailTemps(long agentId,String operationId) {

        ApiOperationEmailTempWSModel response = new ApiOperationEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationEmailTempWSDTO emailTempWSDTO = apiOperationEmailChannelFramework.apiGetOperationEmailTempsService(agentId,operationId);
        if (emailTempWSDTO != null) {
            response.setEmailTemp(emailTempWSDTO);
        }

        general.setOperation("apiGetOperationEmailTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationEmailTempWSModel apiGetOperationEmailTemp(long agentId,String operationId,String tempId) {

        ApiOperationEmailTempWSModel response = new ApiOperationEmailTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationEmailTempWSDTO emailTempWSDTO = apiOperationEmailChannelFramework.apiGetOperationEmailTempService(agentId,operationId,tempId);
        if (emailTempWSDTO != null) {
            response.setEmailTemp(emailTempWSDTO);
        }

        general.setOperation("apiGetOperationEmailTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationEmailAccountWSModel apiGetOperationEmailAccount(long agentId, String operationId) {

        ApiOperationEmailAccountWSModel response = new ApiOperationEmailAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationEmailAccountWSDTO emailAccountWSDTO = apiOperationEmailChannelFramework.apiGetOperationEmailAccountService(agentId,operationId);
        if (emailAccountWSDTO != null) {
            response.setEmailAccount(emailAccountWSDTO);
        }

        general.setOperation("apiGetOperationEmailAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
