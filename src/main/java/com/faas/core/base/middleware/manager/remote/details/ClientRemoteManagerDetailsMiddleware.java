package com.faas.core.base.middleware.manager.remote.details;

import com.faas.core.base.framework.manager.remote.details.ClientRemoteManagerDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.main.MainManagerOperationWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientRemoteManagerDetailsMiddleware {


    @Autowired
    ClientRemoteManagerDetailsFramework clientRemoteManagerDetailsFramework;


    public MainManagerOperationWSModel getAppManager(long userId, int reqPage, int reqSize) {

        MainManagerOperationWSModel response = new MainManagerOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAppManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
