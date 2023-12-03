package com.faas.core.base.middleware.remote.content;

import com.faas.core.base.framework.remote.content.RemoteDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.client.ClientRemoteListWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteDetailsMiddleware {


    @Autowired
    RemoteDetailsFramework remoteDetailsFramework;


    public ClientRemoteListWSModel getRemoteDetails(long userId) {

        ClientRemoteListWSModel response = new ClientRemoteListWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getRemoteDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientRemoteListWSModel getRemoteSummary(long userId) {

        ClientRemoteListWSModel response = new ClientRemoteListWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getRemoteSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
