package com.faas.core.base.middleware.operation.content;

import com.faas.core.base.framework.operation.content.OperationManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.OperationListWSModel;
import com.faas.core.base.model.ws.operation.content.OperationManagerWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationManagerMiddleware {


    @Autowired
    OperationManagerFramework operationManagerFramework;



    public OperationListWSModel getOperations(long userId, String sessionType,String sessionState,int reqPage,int reqSize) {

        OperationListWSModel response = new OperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        OperationListWSDTO operationListWSDTO = operationManagerFramework.getOperationsService(userId,sessionType,sessionState,reqPage,reqSize);
        if (operationListWSDTO != null){
            response.setOperationList(operationListWSDTO);
        }

        general.setOperation("getOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationWSModel getOperation(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationManagerFramework.getOperationService(userId,sessionId);
        if (operationWSDTO != null){
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

        OperationWSDTO operationWSDTO = operationManagerFramework.createOperationService(userId);
        if (operationWSDTO != null){
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

    public OperationWSModel updateOperation(long userId,long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationManagerFramework.updateOperationService(userId,sessionId);
        if (operationWSDTO != null){
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

    public OperationWSModel removeOperation(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationManagerFramework.removeOperationService(userId,sessionId);
        if (operationWSDTO != null){
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


}
