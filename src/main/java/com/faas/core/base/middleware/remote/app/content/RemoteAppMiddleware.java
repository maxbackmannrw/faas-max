package com.faas.core.base.middleware.remote.app.content;

import com.faas.core.base.framework.remote.app.content.RemoteAppFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.content.RemoteClientListWSModel;
import com.faas.core.base.model.ws.remote.app.content.RemoteClientWSModel;
import com.faas.core.base.model.ws.remote.app.content.dto.RemoteClientListWSDTO;
import com.faas.core.base.model.ws.remote.app.content.dto.RemoteClientWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RemoteAppMiddleware {


    @Autowired
    RemoteAppFramework remoteAppFramework;


    public RemoteClientListWSModel getRemoteApps(long userId,String remoteState,String baseType, int reqPage, int reqSize) {

        RemoteClientListWSModel response = new RemoteClientListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteClientListWSDTO remoteClientListWSDTO = remoteAppFramework.getRemoteAppsService(userId,remoteState,baseType,reqPage,reqSize);
        if (remoteClientListWSDTO != null){
            response.setRemoteClientList(remoteClientListWSDTO);
        }

        general.setOperation("getRemoteApps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientListWSModel getClientRemoteApps(long userId, long clientId) {

        RemoteClientListWSModel response = new RemoteClientListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteClientListWSDTO remoteClientListWSDTO = remoteAppFramework.getClientRemoteAppsService(userId,clientId);
        if (remoteClientListWSDTO != null){
            response.setRemoteClientList(remoteClientListWSDTO);
        }

        general.setOperation("getClientRemoteApps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientWSModel getRemoteApp(long userId, String clientRemoteId) {

        RemoteClientWSModel response = new RemoteClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteClientWSDTO> remoteClientWSDTOS = new ArrayList<>();

        RemoteClientWSDTO remoteClientWSDTO = remoteAppFramework.getRemoteAppService(userId,clientRemoteId);
        if (remoteClientWSDTO != null){
            remoteClientWSDTOS.add(remoteClientWSDTO);
        }

        response.setRemoteClients(remoteClientWSDTOS);
        general.setOperation("getRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientWSModel createRemoteApp(long userId, String operationId, String remoteId) {

        RemoteClientWSModel response = new RemoteClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteClientWSDTO> remoteClientWSDTOS = new ArrayList<>();

        RemoteClientWSDTO remoteClientWSDTO = remoteAppFramework.createRemoteAppService(userId,operationId,remoteId);
        if (remoteClientWSDTO != null){
            remoteClientWSDTOS.add(remoteClientWSDTO);
        }

        response.setRemoteClients(remoteClientWSDTOS);
        general.setOperation("createRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientWSModel updateRemoteApp(long userId, String clientRemoteId, String remoteState) {

        RemoteClientWSModel response = new RemoteClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteClientWSDTO> remoteClientWSDTOS = new ArrayList<>();

        RemoteClientWSDTO remoteClientWSDTO = remoteAppFramework.updateRemoteAppService(userId,clientRemoteId,remoteState);
        if (remoteClientWSDTO != null){
            remoteClientWSDTOS.add(remoteClientWSDTO);
        }

        response.setRemoteClients(remoteClientWSDTOS);
        general.setOperation("updateRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientWSModel removeRemoteApp(long userId, String clientRemoteId) {

        RemoteClientWSModel response = new RemoteClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteClientWSDTO> remoteClientWSDTOS = new ArrayList<>();

        RemoteClientWSDTO remoteClientWSDTO = remoteAppFramework.removeRemoteAppService(userId,clientRemoteId);
        if (remoteClientWSDTO != null){
            remoteClientWSDTOS.add(remoteClientWSDTO);
        }

        response.setRemoteClients(remoteClientWSDTOS);
        general.setOperation("removeRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
