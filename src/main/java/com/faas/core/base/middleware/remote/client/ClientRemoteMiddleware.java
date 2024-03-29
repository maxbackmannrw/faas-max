package com.faas.core.base.middleware.remote.client;

import com.faas.core.base.framework.remote.client.ClientRemoteFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.client.content.ClientRemoteListWSModel;
import com.faas.core.base.model.ws.remote.client.content.ClientRemoteWSModel;
import com.faas.core.base.model.ws.remote.client.content.dto.ClientRemoteListWSDTO;
import com.faas.core.base.model.ws.remote.client.content.dto.ClientRemoteWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientRemoteMiddleware {


    @Autowired
    ClientRemoteFramework clientRemoteFramework;


    public ClientRemoteListWSModel getAllClientRemotes(long userId, String remoteState, int reqPage, int reqSize) {

        ClientRemoteListWSModel response = new ClientRemoteListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ClientRemoteListWSDTO clientRemoteListWSDTO = clientRemoteFramework.getAllClientRemotesService(userId,remoteState,reqPage,reqSize);
        if (clientRemoteListWSDTO != null){
            response.setClientRemoteList(clientRemoteListWSDTO);
        }

        general.setOperation("getAllClientRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientRemoteListWSModel getAllClientRemotesByBaseType(long userId, String remoteState, String baseType, int reqPage, int reqSize) {

        ClientRemoteListWSModel response = new ClientRemoteListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ClientRemoteListWSDTO clientRemoteListWSDTO = clientRemoteFramework.getAllClientRemotesByBaseTypeService(userId,remoteState,baseType,reqPage,reqSize);
        if (clientRemoteListWSDTO != null){
            response.setClientRemoteList(clientRemoteListWSDTO);
        }

        general.setOperation("getRemoteAppsByBaseType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientRemoteWSModel getClientRemotes(long userId, long clientId) {

        ClientRemoteWSModel response = new ClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientRemoteWSDTO> clientRemoteWSDTOS = clientRemoteFramework.getClientRemotesService(userId,clientId);
        if (clientRemoteWSDTOS != null){
            response.setClientRemotes(clientRemoteWSDTOS);
        }

        general.setOperation("getClientRemoteApps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientRemoteWSModel getClientRemote(long userId, String clientRemoteId) {

        ClientRemoteWSModel response = new ClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();

        ClientRemoteWSDTO clientRemoteWSDTO = clientRemoteFramework.getClientRemoteService(userId,clientRemoteId);
        if (clientRemoteWSDTO != null){
            clientRemoteWSDTOS.add(clientRemoteWSDTO);
        }

        response.setClientRemotes(clientRemoteWSDTOS);
        general.setOperation("getClientRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientRemoteWSModel createClientRemote(long userId,String operationId, String remoteId) {

        ClientRemoteWSModel response = new ClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();

        ClientRemoteWSDTO clientRemoteWSDTO = clientRemoteFramework.createClientRemoteService(userId,operationId,remoteId);
        if (clientRemoteWSDTO != null){
            clientRemoteWSDTOS.add(clientRemoteWSDTO);
        }

        response.setClientRemotes(clientRemoteWSDTOS);
        general.setOperation("createClientRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientRemoteWSModel updateClientRemote(long userId, String clientRemoteId, String remoteState) {

        ClientRemoteWSModel response = new ClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();

        ClientRemoteWSDTO clientRemoteWSDTO = clientRemoteFramework.updateClientRemoteService(userId,clientRemoteId,remoteState);
        if (clientRemoteWSDTO != null){
            clientRemoteWSDTOS.add(clientRemoteWSDTO);
        }

        response.setClientRemotes(clientRemoteWSDTOS);
        general.setOperation("updateClientRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientRemoteWSModel removeClientRemote(long userId, String clientRemoteId) {

        ClientRemoteWSModel response = new ClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();

        ClientRemoteWSDTO clientRemoteWSDTO = clientRemoteFramework.removeClientRemoteService(userId,clientRemoteId);
        if (clientRemoteWSDTO != null){
            clientRemoteWSDTOS.add(clientRemoteWSDTO);
        }

        response.setClientRemotes(clientRemoteWSDTOS);
        general.setOperation("removeClientRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
