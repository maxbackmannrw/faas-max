package com.faas.core.base.middleware.manager.client.content;

import com.faas.core.base.framework.manager.client.content.ClientManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.client.content.ClientRemoteDeviceWSModel;
import com.faas.core.base.model.ws.manager.client.content.ClientRemoteListWSModel;
import com.faas.core.base.model.ws.manager.client.content.ClientRemoteWSModel;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientManagerRemoteWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientRemoteDeviceWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientRemoteListWSDTO;
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


    public ClientManagerRemoteWSModel getClientManagerRemote(long userId,int reqPage, int reqSize) {

        ClientManagerRemoteWSModel response = new ClientManagerRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ClientManagerRemoteWSDTO clientManagerRemoteWSDTO = clientManagerFramework.getClientManagerRemoteService(userId,reqPage,reqSize);
        if (clientManagerRemoteWSDTO != null){
            response.setClientManagerRemote(clientManagerRemoteWSDTO);
        }

        general.setOperation("getClientManagerRemote");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientRemoteListWSModel getClientRemotes(long userId,boolean remoteConn,int reqPage, int reqSize) {

        ClientRemoteListWSModel response = new ClientRemoteListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ClientRemoteListWSDTO clientRemoteListWSDTO = clientManagerFramework.getClientRemotesService(userId,remoteConn,reqPage,reqSize);
        if (clientRemoteListWSDTO != null){
            response.setClientRemoteList(clientRemoteListWSDTO);
        }

        general.setOperation("getClientRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientRemoteWSModel getClientRemote(long userId,long clientId) {

        ClientRemoteWSModel response = new ClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientRemoteWSDTO>clientRemoteWSDTOS = new ArrayList<>();

        ClientRemoteWSDTO clientRemoteWSDTO = clientManagerFramework.getClientRemoteService(userId,clientId);
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



    public ClientRemoteDeviceWSModel getClientRemoteDevices(long userId, long clientId) {

        ClientRemoteDeviceWSModel response = new ClientRemoteDeviceWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientRemoteDeviceWSDTO> remoteDeviceWSDTOS = clientManagerFramework.getClientRemoteDevicesService(userId,clientId);
        if (remoteDeviceWSDTOS != null){
            response.setRemoteDevices(remoteDeviceWSDTOS);
        }

        general.setOperation("getClientRemoteDevices");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientRemoteDeviceWSModel getClientRemoteDevice(long userId,long clientId,String deviceId) {

        ClientRemoteDeviceWSModel response = new ClientRemoteDeviceWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientRemoteDeviceWSDTO>remoteDeviceWSDTOS = new ArrayList<>();

        ClientRemoteDeviceWSDTO remoteDeviceWSDTO = clientManagerFramework.getClientRemoteDeviceService(userId,clientId,deviceId);
        if (remoteDeviceWSDTO != null){
            remoteDeviceWSDTOS.add(remoteDeviceWSDTO);
        }

        response.setRemoteDevices(remoteDeviceWSDTOS);
        general.setOperation("getClientRemoteDevice");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
