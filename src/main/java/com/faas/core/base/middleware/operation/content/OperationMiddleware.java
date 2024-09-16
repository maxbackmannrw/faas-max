package com.faas.core.base.middleware.operation.content;

import com.faas.core.base.framework.operation.content.OperationFramework;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.operation.content.OperationListWSModel;
import com.faas.core.data.ws.base.operation.content.OperationWSModel;
import com.faas.core.data.ws.base.operation.content.dto.OperationListWSDTO;
import com.faas.core.data.ws.base.operation.content.dto.OperationWSDTO;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationMiddleware {


    @Autowired
    OperationFramework operationFramework;


    public OperationListWSModel getOperations(long userId, String operationState, int reqPage, int reqSize) {

        OperationListWSModel response = new OperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        OperationListWSDTO operationListWSDTO = operationFramework.getOperationsService(userId, operationState, reqPage, reqSize);
        if (operationListWSDTO != null) {
            response.setOperationList(operationListWSDTO);
        }

        general.setOperation("getOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationListWSModel getOperationsByCategory(long userId, String operationCategory, String operationState, int reqPage, int reqSize) {

        OperationListWSModel response = new OperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        OperationListWSDTO operationListWSDTO = operationFramework.getOperationsByCategoryService(userId, operationCategory, operationState, reqPage, reqSize);
        if (operationListWSDTO != null) {
            response.setOperationList(operationListWSDTO);
        }

        general.setOperation("getOperationsByCategory");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel getOperation(long userId, String operationId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationFramework.getOperationService(userId, operationId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("getOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel createOperation(long userId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationFramework.createOperationService(userId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("createOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel updateOperation(long userId, String operationId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationFramework.updateOperationService(userId, operationId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("updateOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel removeOperation(long userId, String operationId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationFramework.removeOperationService(userId, operationId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("removeOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationListWSModel getOperationDetails(long userId, long sessionId) {

        OperationListWSModel response = new OperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getOperationDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
