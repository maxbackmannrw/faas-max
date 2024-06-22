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


    public RemoteClientWSModel getRemoteClients(long userId, long clientId) {

        RemoteClientWSModel response = new RemoteClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteClientWSDTO> remoteClientWSDTOS = remoteAppFramework.getClientRemotesService(userId,clientId);
        if (remoteClientWSDTOS != null){
            response.setRemoteClients(remoteClientWSDTOS);
        }

        general.setOperation("getRemoteClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientListWSModel getRemoteClientsByState(long userId, String remoteState, int reqPage, int reqSize) {

        RemoteClientListWSModel response = new RemoteClientListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteClientListWSDTO remoteClientListWSDTO = remoteAppFramework.getRemoteClientsService(userId,remoteState,reqPage,reqSize);
        if (remoteClientListWSDTO != null){
            response.setRemoteClientList(remoteClientListWSDTO);
        }

        general.setOperation("getRemoteClientsByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientListWSModel getRemoteClientsByBaseType(long userId, String remoteState, String baseType, int reqPage, int reqSize) {

        RemoteClientListWSModel response = new RemoteClientListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteClientListWSDTO remoteClientListWSDTO = remoteAppFramework.getClientRemoteClientsService(userId,remoteState,baseType,reqPage,reqSize);
        if (remoteClientListWSDTO != null){
            response.setRemoteClientList(remoteClientListWSDTO);
        }

        general.setOperation("getRemoteClientsByBaseType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientListWSModel getClientRemoteClients(long userId, String remoteState, String baseType, int reqPage, int reqSize) {

        RemoteClientListWSModel response = new RemoteClientListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteClientListWSDTO remoteClientListWSDTO = remoteAppFramework.getClientRemoteClientsService(userId,remoteState,baseType,reqPage,reqSize);
        if (remoteClientListWSDTO != null){
            response.setRemoteClientList(remoteClientListWSDTO);
        }

        general.setOperation("getClientRemoteClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientWSModel getRemoteClient(long userId, String clientRemoteId) {

        RemoteClientWSModel response = new RemoteClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteClientWSDTO> remoteClientWSDTOS = new ArrayList<>();

        RemoteClientWSDTO remoteClientWSDTO = remoteAppFramework.getRemoteClientService(userId,clientRemoteId);
        if (remoteClientWSDTO != null){
            remoteClientWSDTOS.add(remoteClientWSDTO);
        }

        response.setRemoteClients(remoteClientWSDTOS);
        general.setOperation("getRemoteClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientWSModel createRemoteClient(long userId, String operationId, String remoteId) {

        RemoteClientWSModel response = new RemoteClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteClientWSDTO> remoteClientWSDTOS = new ArrayList<>();

        RemoteClientWSDTO remoteClientWSDTO = remoteAppFramework.createRemoteClientService(userId,operationId,remoteId);
        if (remoteClientWSDTO != null){
            remoteClientWSDTOS.add(remoteClientWSDTO);
        }

        response.setRemoteClients(remoteClientWSDTOS);
        general.setOperation("createRemoteClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientWSModel updateRemoteClient(long userId, String clientRemoteId, String remoteState) {

        RemoteClientWSModel response = new RemoteClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteClientWSDTO> remoteClientWSDTOS = new ArrayList<>();

        RemoteClientWSDTO remoteClientWSDTO = remoteAppFramework.updateRemoteClientService(userId,clientRemoteId,remoteState);
        if (remoteClientWSDTO != null){
            remoteClientWSDTOS.add(remoteClientWSDTO);
        }

        response.setRemoteClients(remoteClientWSDTOS);
        general.setOperation("updateRemoteClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientWSModel removeRemoteClient(long userId, String clientRemoteId) {

        RemoteClientWSModel response = new RemoteClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteClientWSDTO> remoteClientWSDTOS = new ArrayList<>();

        RemoteClientWSDTO remoteClientWSDTO = remoteAppFramework.removeClientRemoteService(userId,clientRemoteId);
        if (remoteClientWSDTO != null){
            remoteClientWSDTOS.add(remoteClientWSDTO);
        }

        response.setRemoteClients(remoteClientWSDTOS);
        general.setOperation("removeRemoteClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
