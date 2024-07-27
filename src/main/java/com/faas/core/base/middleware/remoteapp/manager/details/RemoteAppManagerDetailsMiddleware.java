package com.faas.core.base.middleware.remoteapp.manager.details;

import com.faas.core.base.framework.remoteapp.manager.details.RemoteAppManagerDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remoteapp.content.RemoteAppListWSModel;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppListWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoteAppManagerDetailsMiddleware {


    @Autowired
    RemoteAppManagerDetailsFramework remoteAppManagerDetailsFramework;


    public RemoteAppListWSModel getRemoteAppManagerDetails(long userId, String appState, String baseType, int reqPage, int reqSize) {

        RemoteAppListWSModel response = new RemoteAppListWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getRemoteAppManagerDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
