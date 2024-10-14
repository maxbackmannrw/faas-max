package com.faas.core.api.middleware.operation.manager.content;

import com.faas.core.api.framework.operation.manager.content.ApiOperationManagerFramework;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.manager.call.content.ApiOperationCallChannelWSModel;
import com.faas.core.api.model.ws.operation.manager.call.content.dto.ApiOperationCallChannelWSDTO;
import com.faas.core.api.model.ws.operation.manager.content.ApiOperationManagerWSModel;
import com.faas.core.api.model.ws.operation.manager.content.dto.ApiOperationManagerWSDTO;
import com.faas.core.api.model.ws.operation.manager.message.content.ApiOperationMessageChannelWSModel;
import com.faas.core.api.model.ws.operation.manager.message.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationManagerMiddleware {


    @Autowired
    ApiOperationManagerFramework apiOperationManagerFramework;


    public ApiOperationManagerWSModel apiGetOperationManager(long agentId, String operationId) {

        ApiOperationManagerWSModel response = new ApiOperationManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationManagerWSDTO operationManagerWSDTO = apiOperationManagerFramework.apiGetOperationManagerService(agentId, operationId);
        if (operationManagerWSDTO != null) {
            response.setOperationManager(operationManagerWSDTO);
        }

        general.setOperation("apiGetOperationManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiStartOperation(long agentId, String operationId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationManagerFramework.apiStartOperationService(agentId, operationId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiStartOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiCompleteOperation(long agentId, String operationId, String operationResult) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationManagerFramework.apiCompleteOperationService(agentId, operationId, operationResult);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiCompleteOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiGetSwitchOperations(long agentId, String operationId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ApiOperationWSDTO> operationWSDTOS = apiOperationManagerFramework.apiGetSwitchOperationsService(agentId, operationId);
        if (operationWSDTOS != null) {
            response.setOperations(operationWSDTOS);
        }

        general.setOperation("apiGetSwitchOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiSwitchOperation(long agentId, String operationId, String selectedId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO> operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationManagerFramework.apiSwitchOperationService(agentId, operationId, selectedId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiSwitchOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationCallChannelWSModel apiGetOperationCallChannel(long agentId, String operationId) {

        ApiOperationCallChannelWSModel response = new ApiOperationCallChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationCallChannelWSDTO operationCallChannelWSDTO = apiOperationManagerFramework.apiGetOperationCallChannelService(agentId, operationId);
        if (operationCallChannelWSDTO != null) {
            response.setOperationCallChannel(operationCallChannelWSDTO);
        }

        general.setOperation("apiGetOperationCallChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationMessageChannelWSModel apiGetOperationMessageChannel(long agentId, String operationId) {

        ApiOperationMessageChannelWSModel response = new ApiOperationMessageChannelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationMessageChannelWSDTO messageChannelWSDTO = apiOperationManagerFramework.apiGetOperationMessageChannelService(agentId, operationId);
        if (messageChannelWSDTO != null) {
            response.setOperationMessageChannel(messageChannelWSDTO);
        }

        general.setOperation("apiGetOperationMessageChannel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}