package com.faas.core.base.middleware.manager.remote.details;

import com.faas.core.base.framework.manager.app.AppManagerFramework;
import com.faas.core.base.framework.manager.remote.details.RemoteManagerDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.app.AppManagerWSModel;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteManagerDetailsMiddleware {


    @Autowired
    RemoteManagerDetailsFramework remoteManagerDetailsFramework;


    public AppManagerWSModel getAppManager(long userId,int reqPage,int reqSize) {

        AppManagerWSModel response = new AppManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAppManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
