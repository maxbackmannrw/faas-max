package com.faas.core.base.middleware.remote.content;

import com.faas.core.base.framework.remote.content.RemoteFramework;
import com.faas.core.base.model.ws.remote.content.RemoteListWSModel;
import com.faas.core.base.model.ws.remote.content.RemoteWSModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteListWSDTO;
import com.faas.core.base.model.ws.remote.content.dto.RemoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class RemoteMiddleware {


    @Autowired
    RemoteFramework remoteFramework;


    public RemoteListWSModel getAllRemotes(long userId, String remoteType, String remoteState, int reqPage, int reqSize) {

        RemoteListWSModel response = new RemoteListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteListWSDTO remoteListWSDTO = remoteFramework.getAllRemotesService(userId,remoteType,remoteState,reqPage,reqSize);
        if (remoteListWSDTO != null){
            response.setRemoteList(remoteListWSDTO);
        }

        general.setOperation("getAllRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteWSModel getClientRemotes(long userId, long clientId) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteWSDTO> remoteWSDTOS = remoteFramework.getClientRemotesService(userId,clientId);
        if (remoteWSDTOS != null){
            response.setRemotes(remoteWSDTOS);
        }

        general.setOperation("getClientRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteWSModel getRemote(long userId, String remoteId) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteWSDTO> remoteWSDTOS = new ArrayList<>();

        RemoteWSDTO remoteWSDTO = remoteFramework.getRemoteService(userId,remoteId);
        if (remoteWSDTO != null){
            remoteWSDTOS.add(remoteWSDTO);
        }

        response.setRemotes(remoteWSDTOS);
        general.setOperation("getRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteWSModel createRemote(long userId, long sessionId, String deviceBrand, String deviceModel, String deviceOS, String deviceUrl, String remoteType, String remoteState) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteWSDTO> remoteWSDTOS = new ArrayList<>();

        RemoteWSDTO remoteWSDTO = remoteFramework.createRemoteService(userId,sessionId,deviceBrand,deviceModel,deviceOS,deviceUrl,remoteType,remoteState);
        if (remoteWSDTO != null){
            remoteWSDTOS.add(remoteWSDTO);
        }

        response.setRemotes(remoteWSDTOS);
        general.setOperation("createRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteWSModel updateRemote(long userId, String remoteId, String deviceBrand, String deviceModel, String deviceOS, String deviceUrl, String remoteState) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteWSDTO> remoteWSDTOS = new ArrayList<>();

        RemoteWSDTO remoteWSDTO = remoteFramework.updateRemoteService(userId,remoteId,deviceBrand,deviceModel,deviceOS,deviceUrl,remoteState);
        if (remoteWSDTO != null){
            remoteWSDTOS.add(remoteWSDTO);
        }

        response.setRemotes(remoteWSDTOS);
        general.setOperation("updateRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteWSModel removeRemote(long userId, String remoteId) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteWSDTO> remoteWSDTOS = new ArrayList<>();

        RemoteWSDTO remoteWSDTO = remoteFramework.removeRemoteService(userId,remoteId);
        if (remoteWSDTO != null){
            remoteWSDTOS.add(remoteWSDTO);
        }

        response.setRemotes(remoteWSDTOS);
        general.setOperation("removeRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
