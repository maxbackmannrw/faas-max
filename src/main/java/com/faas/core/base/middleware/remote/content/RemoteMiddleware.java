package com.faas.core.base.middleware.remote.content;

import com.faas.core.base.framework.remote.content.RemoteFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.content.RemoteWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteMiddleware {


    @Autowired
    RemoteFramework remoteFramework;


    public RemoteWSModel getAllRemotes(long userId) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getAllRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteWSModel getRemotesByBaseType(long userId, String baseType) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getRemotesByBaseType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteWSModel getRemote(long userId, long remoteId) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteWSModel createRemote(long userId, String remoteType, String remoteState, int reqPage, int reqSize) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("createRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteWSModel updateRemote(long userId, String remoteType, String remoteState, int reqPage, int reqSize) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("updateRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteWSModel removeRemote(long userId,long remoteId) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("removeRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
