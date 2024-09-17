package com.faas.core.base.middleware.remoteapp.manager.content;

import com.faas.core.base.framework.remoteapp.manager.content.RemoteAppManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remoteapp.content.RemoteAppListWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoteAppManagerMiddleware {


    @Autowired
    RemoteAppManagerFramework remoteAppManagerFramework;


    public RemoteAppListWSModel getRemoteAppManagers(long userId, String appState, String baseType, int reqPage, int reqSize) {

        RemoteAppListWSModel response = new RemoteAppListWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getRemoteAppManagers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteAppListWSModel getRemoteAppManager(long userId, String appState, String baseType, int reqPage, int reqSize) {

        RemoteAppListWSModel response = new RemoteAppListWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getRemoteAppManagers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppListWSModel createRemoteAppManager(long userId, String appState, String baseType, int reqPage, int reqSize) {

        RemoteAppListWSModel response = new RemoteAppListWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getRemoteAppManagers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppListWSModel updateRemoteAppManager(long userId, String appState, String baseType, int reqPage, int reqSize) {

        RemoteAppListWSModel response = new RemoteAppListWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getRemoteAppManagers");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppListWSModel removeRemoteAppManager(long userId, String appState, String baseType, int reqPage, int reqSize) {

        RemoteAppListWSModel response = new RemoteAppListWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("removeRemoteAppManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
