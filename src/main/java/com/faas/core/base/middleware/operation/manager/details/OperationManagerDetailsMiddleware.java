package com.faas.core.base.middleware.operation.manager.details;

import com.faas.core.base.framework.operation.manager.details.OperationManagerDetailsFramework;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.operation.manager.details.OperationManagerDetailsWSModel;
import com.faas.core.data.ws.base.operation.manager.details.dto.OperationManagerDetailsWSDTO;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OperationManagerDetailsMiddleware {

    @Autowired
    OperationManagerDetailsFramework operationManagerDetailsFramework;


    public OperationManagerDetailsWSModel getOperationManagerDetails(long userId, long sessionId) {

        OperationManagerDetailsWSModel response = new OperationManagerDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        OperationManagerDetailsWSDTO operationManagerDetailsWSDTO = operationManagerDetailsFramework.getOperationManagerDetailsService(userId, sessionId);
        if (operationManagerDetailsWSDTO != null) {
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
