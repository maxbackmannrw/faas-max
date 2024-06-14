package com.faas.core.base.middleware.remote.client.content;

import com.faas.core.base.framework.remote.client.content.RemoteClientFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.client.content.RemoteClientListWSModel;
import com.faas.core.base.model.ws.remote.client.content.RemoteClientWSModel;
import com.faas.core.base.model.ws.remote.client.content.dto.RemoteClientListWSDTO;
import com.faas.core.base.model.ws.remote.client.content.dto.RemoteClientWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RemoteClientMiddleware {


    @Autowired
    RemoteClientFramework remoteClientFramework;


    public RemoteClientWSModel getRemoteClients(long userId, long clientId) {

        RemoteClientWSModel response = new RemoteClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteClientWSDTO> remoteClientWSDTOS = remoteClientFramework.getClientRemotesService(userId,clientId);
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

        RemoteClientListWSDTO remoteClientListWSDTO = remoteClientFramework.getRemoteClientsService(userId,remoteState,reqPage,reqSize);
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

        RemoteClientListWSDTO remoteClientListWSDTO = remoteClientFramework.getClientRemoteClientsService(userId,remoteState,baseType,reqPage,reqSize);
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

        RemoteClientListWSDTO remoteClientListWSDTO = remoteClientFramework.getClientRemoteClientsService(userId,remoteState,baseType,reqPage,reqSize);
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

        RemoteClientWSDTO remoteClientWSDTO = remoteClientFramework.getRemoteClientService(userId,clientRemoteId);
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

        RemoteClientWSDTO remoteClientWSDTO = remoteClientFramework.createRemoteClientService(userId,operationId,remoteId);
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

        RemoteClientWSDTO remoteClientWSDTO = remoteClientFramework.updateRemoteClientService(userId,clientRemoteId,remoteState);
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

        RemoteClientWSDTO remoteClientWSDTO = remoteClientFramework.removeClientRemoteService(userId,clientRemoteId);
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
