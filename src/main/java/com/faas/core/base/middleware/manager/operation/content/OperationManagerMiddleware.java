package com.faas.core.base.middleware.manager.operation.content;

import com.faas.core.base.framework.manager.operation.content.OperationManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.operation.content.OperationManagerWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OperationManagerMiddleware {


    @Autowired
    OperationManagerFramework operationManagerFramework;


    public OperationManagerWSModel getOperationManagers(long userId,int reqPage,int reqSize) {

        OperationManagerWSModel response = new OperationManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAutomaticOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationManagerWSModel getOperationManagersByType(long userId, int reqPage, int reqSize) {

        OperationManagerWSModel response = new OperationManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAutomaticOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationManagerWSModel getOperationManagersByState(long userId,int reqPage,int reqSize) {

        OperationManagerWSModel response = new OperationManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAutomaticOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationManagerWSModel getOperationManager(long userId,int reqPage,int reqSize) {

        OperationManagerWSModel response = new OperationManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getOperationManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
