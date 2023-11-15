package com.faas.core.base.middleware.client.remote.content;

import com.faas.core.base.framework.client.remote.content.ClientRemoteFramework;
import com.faas.core.base.model.ws.client.remote.content.ClientRemoteListWSModel;
import com.faas.core.base.model.ws.client.remote.content.ClientRemoteWSModel;
import com.faas.core.base.model.ws.client.remote.content.dto.ClientRemoteListWSDTO;
import com.faas.core.base.model.ws.client.remote.content.dto.ClientRemoteWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ClientRemoteMiddleware {


    @Autowired
    ClientRemoteFramework clientRemoteFramework;


    public ClientRemoteListWSModel getAllClientRemotes(long userId,String remoteType,String remoteState, int reqPage, int reqSize) {

        ClientRemoteListWSModel response = new ClientRemoteListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ClientRemoteListWSDTO remoteListWSDTO = clientRemoteFramework.getAllClientRemotesService(userId,remoteType,remoteState,reqPage,reqSize);
        if (remoteListWSDTO != null){
            response.setRemoteList(remoteListWSDTO);
        }

        general.setOperation("getAllClientRemotes");
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

        general.setOperation("getClientRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientRemoteWSModel getClientRemote(long userId, long clientId, String remoteId) {

        ClientRemoteWSModel response = new ClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();

        ClientRemoteWSDTO clientRemoteWSDTO = clientRemoteFramework.getClientRemoteService(userId,clientId,remoteId);
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


    public ClientRemoteWSModel createClientRemote(long userId,long clientId,long sessionId,String deviceBrand,String deviceModel,String deviceOS,String deviceUrl,String remoteType,String remoteState) {

        ClientRemoteWSModel response = new ClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();

        ClientRemoteWSDTO clientRemoteWSDTO = clientRemoteFramework.createClientRemoteService(userId,clientId,sessionId,deviceBrand,deviceModel,deviceOS,deviceUrl,remoteType,remoteState);
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


    public ClientRemoteWSModel updateClientRemote(long userId,long clientId,String remoteId,String deviceBrand,String deviceModel,String deviceOS,String deviceUrl,String remoteState) {

        ClientRemoteWSModel response = new ClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();

        ClientRemoteWSDTO clientRemoteWSDTO = clientRemoteFramework.updateClientRemoteService(userId,clientId,remoteId,deviceBrand,deviceModel,deviceOS,deviceUrl,remoteState);
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


    public ClientRemoteWSModel removeClientRemote(long userId, long clientId, String remoteId) {

        ClientRemoteWSModel response = new ClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();

        ClientRemoteWSDTO clientRemoteWSDTO = clientRemoteFramework.removeClientRemoteService(userId,clientId,remoteId);
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
