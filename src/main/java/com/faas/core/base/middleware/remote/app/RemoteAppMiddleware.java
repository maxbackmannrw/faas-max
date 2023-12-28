package com.faas.core.base.middleware.remote.app;

import com.faas.core.base.framework.remote.app.RemoteAppFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.RemoteAppListWSModel;
import com.faas.core.base.model.ws.remote.app.RemoteAppWSModel;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppListWSDTO;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class RemoteAppMiddleware {


    @Autowired
    RemoteAppFramework remoteAppFramework;


    public RemoteAppListWSModel getAllRemoteApps(long userId, String remoteType, String remoteState, int reqPage, int reqSize) {

        RemoteAppListWSModel response = new RemoteAppListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteAppListWSDTO remoteAppListWSDTO = remoteAppFramework.getAllClientRemotesService(userId,remoteType,remoteState,reqPage,reqSize);
        if (remoteAppListWSDTO != null){
        }

        general.setOperation("getAllRemoteApps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteAppWSModel getClientRemoteApps(long userId, long clientId) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteAppWSDTO> remoteAppWSDTOS = remoteAppFramework.getClientRemotesService(userId,clientId);
        if (remoteAppWSDTOS != null){
            response.setClientRemotes(remoteAppWSDTOS);
        }

        general.setOperation("getClientRemoteApps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteAppWSModel getRemoteApp(long userId, String remoteId) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();

        RemoteAppWSDTO remoteAppWSDTO = remoteAppFramework.getClientRemoteService(userId,remoteId);
        if (remoteAppWSDTO != null){
            remoteAppWSDTOS.add(remoteAppWSDTO);
        }

        response.setClientRemotes(remoteAppWSDTOS);
        general.setOperation("getRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteAppWSModel createRemoteApp(long userId, long sessionId, String deviceBrand, String deviceModel, String deviceOS, String deviceUrl, String remoteType, String remoteState) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();

        RemoteAppWSDTO remoteAppWSDTO = remoteAppFramework.createClientRemoteService(userId,sessionId,deviceBrand,deviceModel,deviceOS,deviceUrl,remoteType,remoteState);
        if (remoteAppWSDTO != null){
            remoteAppWSDTOS.add(remoteAppWSDTO);
        }

        response.setClientRemotes(remoteAppWSDTOS);
        general.setOperation("createClientRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteAppWSModel updateRemoteApp(long userId, String remoteId, String deviceBrand, String deviceModel, String deviceOS, String deviceUrl, String remoteState) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();

        RemoteAppWSDTO remoteAppWSDTO = remoteAppFramework.updateClientRemoteService(userId,remoteId,deviceBrand,deviceModel,deviceOS,deviceUrl,remoteState);
        if (remoteAppWSDTO != null){
            remoteAppWSDTOS.add(remoteAppWSDTO);
        }

        response.setClientRemotes(remoteAppWSDTOS);
        general.setOperation("updateRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteAppWSModel removeRemoteApp(long userId, String remoteId) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();

        RemoteAppWSDTO remoteAppWSDTO = remoteAppFramework.removeClientRemoteService(userId,remoteId);
        if (remoteAppWSDTO != null){
            remoteAppWSDTOS.add(remoteAppWSDTO);
        }

        response.setClientRemotes(remoteAppWSDTOS);
        general.setOperation("removeRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
