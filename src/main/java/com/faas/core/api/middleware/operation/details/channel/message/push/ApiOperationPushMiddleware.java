package com.faas.core.api.middleware.operation.details.channel.message.push;

import com.faas.core.api.framework.operation.details.channel.message.push.ApiOperationPushFramework;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushAccountWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushChannelWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushTempWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.ApiOperationPushWSModel;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushAccountWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationPushMiddleware {


    @Autowired
    ApiOperationPushFramework apiOperationPushFramework;


    public ApiOperationPushChannelWSModel apiGetOperationPushChannel(long agentId, String operationId) {

        ApiOperationPushChannelWSModel response = new ApiOperationPushChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationPushChannelWSDTO pushChannelWSDTO = apiOperationPushFramework.apiGetOperationPushChannelService(agentId,operationId);
        if (pushChannelWSDTO != null){
            response.setOperationPushChannel(pushChannelWSDTO);
        }

        general.setOperation("apiGetOperationPushChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationPushAccountWSModel apiGetOperationPushAccount(long agentId, String operationId) {

        ApiOperationPushAccountWSModel response = new ApiOperationPushAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationPushAccountWSDTO pushAccountWSDTO = apiOperationPushFramework.apiGetOperationPushAccountService(agentId,operationId);
        if (pushAccountWSDTO != null){
            response.setPushAccount(pushAccountWSDTO);
        }

        general.setOperation("apiGetOperationPushAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationPushTempWSModel apiGetOperationPushTemps(long agentId,String operationId) {

        ApiOperationPushTempWSModel response = new ApiOperationPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationPushTempWSDTO pushTempWSDTO = apiOperationPushFramework.apiGetOperationPushTempsService(agentId,operationId);
        if (pushTempWSDTO != null){
            response.setPushTemp(pushTempWSDTO);
        }

        general.setOperation("apiGetOperationPushTemps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationPushTempWSModel apiGetOperationPushTemp(long agentId,String operationId,String tempId) {

        ApiOperationPushTempWSModel response = new ApiOperationPushTempWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationPushTempWSDTO pushTempWSDTO = apiOperationPushFramework.apiGetOperationPushTempService(agentId,operationId,tempId);
        if (pushTempWSDTO != null){
            response.setPushTemp(pushTempWSDTO);
        }

        general.setOperation("apiGetOperationPushTemp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationPushWSModel apiGetOperationPushes(long agentId,String operationId) {

        ApiOperationPushWSModel response = new ApiOperationPushWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationPushWSDTO> operationPushWSDTOS = apiOperationPushFramework.apiGetOperationPushesService(agentId,operationId);
        if (operationPushWSDTOS != null){
            response.setOperationPushes(operationPushWSDTOS);
        }

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
        List<ApiOperationPushWSDTO> operationPushWSDTOS = new ArrayList<>();

        ApiOperationPushWSDTO operationPushWSDTO = apiOperationPushFramework.apiGetOperationPushService(agentId,operationId,pushId);
        if (operationPushWSDTO != null){
            operationPushWSDTOS.add(operationPushWSDTO);
        }

        response.setOperationPushes(operationPushWSDTOS);
        general.setOperation("apiGetOperationPush");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationPushWSModel apiSendOperationPush(long agentId,String operationId,String tempId,String remoteAppId) {

        ApiOperationPushWSModel response = new ApiOperationPushWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationPushWSDTO> operationPushWSDTOS = new ArrayList<>();

        ApiOperationPushWSDTO operationPushWSDTO = apiOperationPushFramework.apiSendOperationPushService(agentId,operationId,tempId,remoteAppId);
        if (operationPushWSDTO != null){
            operationPushWSDTOS.add(operationPushWSDTO);
        }

        response.setOperationPushes(operationPushWSDTOS);
        general.setOperation("apiSendOperationPush");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationPushWSModel apiUpdateOperationPush(long agentId,String operationId,String pushId,String pushState) {

        ApiOperationPushWSModel response = new ApiOperationPushWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationPushWSDTO> operationPushWSDTOS = new ArrayList<>();

        ApiOperationPushWSDTO operationPushWSDTO = apiOperationPushFramework.apiUpdateOperationPushService(agentId,operationId,pushId,pushState);
        if (operationPushWSDTO != null){
            operationPushWSDTOS.add(operationPushWSDTO);
        }

        response.setOperationPushes(operationPushWSDTOS);
        general.setOperation("apiUpdateOperationPush");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationPushWSModel apiRemoveOperationPush(long agentId,String operationId,String pushId) {

        ApiOperationPushWSModel response = new ApiOperationPushWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationPushWSDTO> operationPushWSDTOS = new ArrayList<>();

        ApiOperationPushWSDTO operationPushWSDTO = apiOperationPushFramework.apiRemoveOperationPushService(agentId,operationId,pushId);
        if (operationPushWSDTO != null){
            operationPushWSDTOS.add(operationPushWSDTO);
        }

        response.setOperationPushes(operationPushWSDTOS);
        general.setOperation("apiRemoveOperationPush");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





}
