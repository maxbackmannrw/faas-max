package com.faas.core.base.middleware.manager.operation.details;

import com.faas.core.base.framework.manager.operation.details.OperationManagerDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.operation.details.OperationManagerDetailsWSModel;
import com.faas.core.base.model.ws.manager.operation.details.dto.OperationManagerDetailsWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OperationManagerDetailsMiddleware {

    @Autowired
    OperationManagerDetailsFramework operationManagerDetailsFramework;


    public OperationManagerDetailsWSModel getOperationManagerDetails(long userId,long sessionId) {

        OperationManagerDetailsWSModel response = new OperationManagerDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        OperationManagerDetailsWSDTO operationManagerDetailsWSDTO = operationManagerDetailsFramework.getOperationManagerDetailsService(userId,sessionId);
        if (operationManagerDetailsWSDTO != null){
            response.setOperationManagerDetails(operationManagerDetailsWSDTO);
        }

        general.setOperation("getOperationManagerDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
