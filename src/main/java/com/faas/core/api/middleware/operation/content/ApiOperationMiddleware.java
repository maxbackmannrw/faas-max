package com.faas.core.api.middleware.operation.content;

import com.faas.core.api.framework.operation.content.ApiOperationFramework;
import com.faas.core.api.model.ws.operation.content.ApiAgentOperationWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationListWSModel;
import com.faas.core.api.model.ws.operation.content.ApiOperationWSModel;
import com.faas.core.api.model.ws.operation.content.dto.ApiAgentOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationListWSDTO;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationWSDTO;
import com.faas.core.api.model.ws.operation.content.ApiOperationValidateWSModel;
import com.faas.core.api.model.ws.operation.content.dto.ApiOperationValidateWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiOperationMiddleware {

    @Autowired
    ApiOperationFramework apiOperationFramework;


    public ApiAgentOperationWSModel apiGetAgentOperations(long agentId,int reqPage,int reqSize) {

        ApiAgentOperationWSModel response = new ApiAgentOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentOperationWSDTO agentOperationWSDTO = apiOperationFramework.apiGetAgentOperationsService(agentId,reqPage,reqSize);
        if (agentOperationWSDTO != null) {
            response.setAgentOperation(agentOperationWSDTO);
        }

        general.setOperation("apiGetAgentOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationListWSModel apiGetOperations(long agentId,String operationType,String operationState,String operationInquiryState,String operationFlowState,int reqPage,int reqSize) {

        ApiOperationListWSModel response = new ApiOperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationListWSDTO operationListWSDTO = apiOperationFramework.apiGetOperationsService(agentId,operationType,operationState,operationInquiryState,operationFlowState,reqPage,reqSize);
        if (operationListWSDTO != null) {
            response.setOperationList(operationListWSDTO);
        }

        general.setOperation("apiGetOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiGetOperation(long agentId,String operationId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO>operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationFramework.apiGetOperationService(agentId,operationId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiGetOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiUpdateOperation(long agentId,String operationId,String operationState) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO>operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationFramework.apiUpdateOperationService(agentId,operationId,operationState);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiUpdateOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiOperationWSModel apiRemoveOperation(long agentId,String operationId) {

        ApiOperationWSModel response = new ApiOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiOperationWSDTO>operationWSDTOS = new ArrayList<>();

        ApiOperationWSDTO operationWSDTO = apiOperationFramework.apiRemoveOperationService(agentId,operationId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("apiRemoveOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ApiOperationValidateWSModel apiOperationValidate(long agentId,String operationId) {

        ApiOperationValidateWSModel response = new ApiOperationValidateWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiOperationValidateWSDTO operationValidateWSDTO = apiOperationFramework.apiOperationValidateService(agentId,operationId);
        if (operationValidateWSDTO != null){
            response.setOperationValidate(operationValidateWSDTO);
        }

        general.setOperation("apiOperationValidate");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
