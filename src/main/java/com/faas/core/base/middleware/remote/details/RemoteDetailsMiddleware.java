package com.faas.core.base.middleware.remote.details;

import com.faas.core.base.framework.remote.details.RemoteDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.content.RemoteWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteDetailsMiddleware {


    @Autowired
    RemoteDetailsFramework remoteDetailsFramework;


    public RemoteWSModel getRemoteDetails(long userId) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getRemoteDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
