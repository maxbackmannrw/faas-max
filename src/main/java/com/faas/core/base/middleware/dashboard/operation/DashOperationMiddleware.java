package com.faas.core.base.middleware.dashboard.operation;

import com.faas.core.base.framework.dashboard.operation.DashOperationFramework;
import com.faas.core.base.model.ws.dashboard.operation.DashboardOperationWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DashOperationMiddleware {


    @Autowired
    DashOperationFramework dashOperationFramework;


    public DashboardOperationWSModel getDashboardOperations(long userId, int reqPage, int reqSize) {

        DashboardOperationWSModel response = new DashboardOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getDashboardOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
