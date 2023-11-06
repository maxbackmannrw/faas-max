package com.faas.core.base.middleware.manager.client.content;

import com.faas.core.base.framework.manager.client.content.ClientManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.client.content.ClientRemoteWSModel;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientManagerRemoteWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientRemoteWSDTO;
import com.faas.core.base.model.ws.manager.client.content.ClientManagerRemoteWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ClientManagerMiddleware {


    @Autowired
    ClientManagerFramework clientManagerFramework;


    public ClientManagerRemoteWSModel getClientManagerRemotes(long userId,String remoteType,String remoteState, int reqPage, int reqSize) {

        ClientManagerRemoteWSModel response = new ClientManagerRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ClientManagerRemoteWSDTO clientManagerRemoteWSDTO = clientManagerFramework.getClientManagerRemotesService(userId,remoteType,remoteState,reqPage,reqSize);
        if (clientManagerRemoteWSDTO != null){
            response.setClientManagerRemote(clientManagerRemoteWSDTO);
        }

        general.setOperation("getClientManagerRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientRemoteWSModel getClientRemotes(long userId,long clientId) {

        ClientRemoteWSModel response = new ClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientRemoteWSDTO>clientRemoteWSDTOS = new ArrayList<>();

        ClientRemoteWSDTO clientRemoteWSDTO = clientManagerFramework.getClientRemotesService(userId,clientId);
        if (clientRemoteWSDTO != null){
            clientRemoteWSDTOS.add(clientRemoteWSDTO);
        }

        response.setClientRemotes(clientRemoteWSDTOS);
        general.setOperation("getClientRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientRemoteWSModel getClientRemote(long userId,long clientId,String remoteId) {

        ClientRemoteWSModel response = new ClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientRemoteWSDTO>clientRemoteWSDTOS = new ArrayList<>();

        ClientRemoteWSDTO clientRemoteWSDTO = clientManagerFramework.getClientRemoteService(userId,clientId,remoteId);
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




}
