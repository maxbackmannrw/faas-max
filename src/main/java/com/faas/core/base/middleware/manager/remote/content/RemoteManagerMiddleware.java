package com.faas.core.base.middleware.manager.remote.content;

import com.faas.core.base.framework.manager.remote.content.RemoteManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.app.AppManagerOperationWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteManagerMiddleware {


    @Autowired
    RemoteManagerFramework remoteManagerFramework;


    public AppManagerOperationWSModel getAppManager(long userId, int reqPage, int reqSize) {

        AppManagerOperationWSModel response = new AppManagerOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAppManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
