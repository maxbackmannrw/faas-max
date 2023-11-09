package com.faas.core.base.middleware.manager.client.content;

import com.faas.core.base.framework.manager.client.content.ClientManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.client.content.AllRemoteConnWSModel;
import com.faas.core.base.model.ws.manager.client.content.RemoteConnListWSModel;
import com.faas.core.base.model.ws.manager.client.content.RemoteConnWSModel;
import com.faas.core.base.model.ws.manager.client.content.dto.AllRemoteConnWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.RemoteConnListWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.RemoteConnWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ClientManagerMiddleware {


    @Autowired
    ClientManagerFramework clientManagerFramework;


    public AllRemoteConnWSModel getAllRemoteConns(long userId, int reqPage, int reqSize) {

        AllRemoteConnWSModel response = new AllRemoteConnWSModel();
        GeneralWSModel general = new GeneralWSModel();

        AllRemoteConnWSDTO allRemoteConnWSDTO = clientManagerFramework.getAllRemoteConnsService(userId,reqPage,reqSize);
        if (allRemoteConnWSDTO != null){
            response.setAllRemoteConn(allRemoteConnWSDTO);
        }

        general.setOperation("getAllRemoteConns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteConnWSModel getClientRemoteConns(long userId, long clientId) {

        RemoteConnWSModel response = new RemoteConnWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteConnWSDTO> remoteConnWSDTOS = clientManagerFramework.getClientRemoteConnsService(userId,clientId);
        if (remoteConnWSDTOS != null){
            response.setRemoteConns(remoteConnWSDTOS);
        }

        general.setOperation("getClientRemoteConns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteConnListWSModel getRemoteConns(long userId,String connType,String connState, int reqPage, int reqSize) {

        RemoteConnListWSModel response = new RemoteConnListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteConnListWSDTO remoteConnListWSDTO = clientManagerFramework.getRemoteConnsService(userId,connType,connState,reqPage,reqSize);
        if (remoteConnListWSDTO != null){
            response.setRemoteConnList(remoteConnListWSDTO);
        }

        general.setOperation("getRemoteConns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteConnWSModel getRemoteConn(long userId, long clientId, String connId) {

        RemoteConnWSModel response = new RemoteConnWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteConnWSDTO> remoteConnWSDTOS = new ArrayList<>();

        RemoteConnWSDTO remoteConnWSDTO = clientManagerFramework.getRemoteConnService(userId,clientId,connId);
        if (remoteConnWSDTO != null){
            remoteConnWSDTOS.add(remoteConnWSDTO);
        }

        response.setRemoteConns(remoteConnWSDTOS);
        general.setOperation("getRemoteConn");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
