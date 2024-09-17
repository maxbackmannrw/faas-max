package com.faas.core.base.middleware.operation.manager.content;

import com.faas.core.base.framework.operation.manager.content.OperationManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.model.ws.operation.manager.content.OperationManagerWSModel;
import com.faas.core.base.model.ws.operation.manager.content.dto.OperationManagerWSDTO;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OperationManagerMiddleware {


    @Autowired
    OperationManagerFramework operationManagerFramework;


    public OperationManagerWSModel getOperationManagers(long userId, int reqPage, int reqSize) {

        OperationManagerWSModel response = new OperationManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        OperationManagerWSDTO operationManagerWSDTO = operationManagerFramework.getOperationManagersService(userId, reqPage, reqSize);
        if (operationManagerWSDTO != null) {
            response.setOperationManager(operationManagerWSDTO);
        }

        general.setOperation("getOperationManagers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationManagerWSModel getOperationManagersByType(long userId, String sessionType, int reqPage, int reqSize) {

        OperationManagerWSModel response = new OperationManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        OperationManagerWSDTO operationManagerWSDTO = operationManagerFramework.getOperationManagersByTypeService(userId, sessionType, reqPage, reqSize);
        if (operationManagerWSDTO != null) {
            response.setOperationManager(operationManagerWSDTO);
        }

        general.setOperation("getOperationManagersByType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationManagerWSModel getOperationManagersByState(long userId, String operationState, int reqPage, int reqSize) {

        OperationManagerWSModel response = new OperationManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        OperationManagerWSDTO operationManagerWSDTO = operationManagerFramework.getOperationManagersByStateService(userId, operationState, reqPage, reqSize);
        if (operationManagerWSDTO != null) {
            response.setOperationManager(operationManagerWSDTO);
        }

        general.setOperation("getOperationManagersByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel getOperationManager(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationManagerFramework.getOperationManagerService(userId, sessionId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("getOperationManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel updateOperationManager(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationManagerFramework.updateOperationManagerService(userId, sessionId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("updateOperationManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationWSModel removeOperationManager(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationManagerFramework.removeOperationManagerService(userId, sessionId);
        if (operationWSDTO != null) {
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("removeOperationManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
