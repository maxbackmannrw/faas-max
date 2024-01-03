package com.faas.core.base.middleware.remote.app;

import com.faas.core.base.framework.remote.app.RemoteAppFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.content.RemoteAppListWSModel;
import com.faas.core.base.model.ws.remote.app.content.RemoteAppWSModel;
import com.faas.core.base.model.ws.remote.app.content.dto.RemoteAppListWSDTO;
import com.faas.core.base.model.ws.remote.app.content.dto.RemoteAppWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class RemoteAppMiddleware {


    @Autowired
    RemoteAppFramework remoteAppFramework;


    public RemoteAppListWSModel getRemoteApps(long userId,String appConn,int reqPage,int reqSize) {

        RemoteAppListWSModel response = new RemoteAppListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteAppListWSDTO remoteAppListWSDTO = remoteAppFramework.getRemoteAppsService(userId,appConn,reqPage,reqSize);
        if (remoteAppListWSDTO != null){
            response.setRemoteAppList(remoteAppListWSDTO);
        }

        general.setOperation("getRemoteApps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppListWSModel getRemoteAppsByBaseType(long userId,String appConn,String baseType,int reqPage,int reqSize) {

        RemoteAppListWSModel response = new RemoteAppListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteAppListWSDTO remoteAppListWSDTO = remoteAppFramework.getRemoteAppsByBaseTypeService(userId,appConn,baseType,reqPage,reqSize);
        if (remoteAppListWSDTO != null){
            response.setRemoteAppList(remoteAppListWSDTO);
        }

        general.setOperation("getRemoteAppsByBaseType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppWSModel getClientRemoteApps(long userId,long clientId) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteAppWSDTO> remoteAppWSDTOS = remoteAppFramework.getClientRemoteAppsService(userId,clientId);
        if (remoteAppWSDTOS != null){
            response.setRemoteApps(remoteAppWSDTOS);
        }

        general.setOperation("getClientRemoteApps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppWSModel getRemoteApp(long userId,String appId) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();

        RemoteAppWSDTO remoteAppWSDTO = remoteAppFramework.getRemoteAppService(userId,appId);
        if (remoteAppWSDTO != null){
            remoteAppWSDTOS.add(remoteAppWSDTO);
        }

        response.setRemoteApps(remoteAppWSDTOS);
        general.setOperation("getRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppWSModel createRemoteApp(long userId,long sessionId,String remoteId) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();

        RemoteAppWSDTO remoteAppWSDTO = remoteAppFramework.createRemoteAppService(userId,sessionId,remoteId);
        if (remoteAppWSDTO != null){
            remoteAppWSDTOS.add(remoteAppWSDTO);
        }

        response.setRemoteApps(remoteAppWSDTOS);
        general.setOperation("createRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppWSModel updateRemoteApp(long userId,String appId,String appConn) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();

        RemoteAppWSDTO remoteAppWSDTO = remoteAppFramework.updateRemoteAppService(userId,appId,appConn);
        if (remoteAppWSDTO != null){
            remoteAppWSDTOS.add(remoteAppWSDTO);
        }

        response.setRemoteApps(remoteAppWSDTOS);
        general.setOperation("updateRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppWSModel removeRemoteApp(long userId,String appId) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();

        RemoteAppWSDTO remoteAppWSDTO = remoteAppFramework.removeRemoteAppService(userId,appId);
        if (remoteAppWSDTO != null){
            remoteAppWSDTOS.add(remoteAppWSDTO);
        }

        response.setRemoteApps(remoteAppWSDTOS);
        general.setOperation("removeRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
