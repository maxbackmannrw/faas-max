package com.faas.core.base.middleware.remote.content;

import com.faas.core.base.framework.remote.content.RemoteFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.content.RemoteWSModel;
import com.faas.core.base.model.ws.remote.content.dto.RemoteWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class RemoteMiddleware {


    @Autowired
    RemoteFramework remoteFramework;


    public RemoteWSModel getAllRemotes(long userId) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteWSDTO> remoteWSDTOS = remoteFramework.getAllRemotesService(userId);
        if (remoteWSDTOS != null){
            response.setRemotes(remoteWSDTOS);
        }

        general.setOperation("getAllRemotes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteWSModel getRemotesByBaseType(long userId, String baseType) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteWSDTO> remoteWSDTOS = remoteFramework.getRemotesByBaseTypeService(userId,baseType);
        if (remoteWSDTOS != null){
            response.setRemotes(remoteWSDTOS);
        }

        general.setOperation("getRemotesByBaseType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteWSModel getRemotesByType(long userId, String remoteType) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteWSDTO> remoteWSDTOS = remoteFramework.getRemotesByTypeService(userId,remoteType);
        if (remoteWSDTOS != null){
            response.setRemotes(remoteWSDTOS);
        }

        general.setOperation("getRemotesByType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteWSModel getRemote(long userId, String remoteId) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteWSDTO>remoteWSDTOS = new ArrayList<>();

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


    public RemoteWSModel createRemote(long userId, String remote, String remoteDesc, String remoteModel, String remoteVersion, long typeId) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteWSDTO>remoteWSDTOS = new ArrayList<>();

        RemoteWSDTO remoteWSDTO = remoteFramework.createRemoteService(userId,remote,remoteDesc,remoteModel,remoteVersion,typeId);
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


    public RemoteWSModel updateRemote(long userId, String remoteId, String remote, String remoteDesc, String remoteModel, String remoteVersion) {

        RemoteWSModel response = new RemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteWSDTO>remoteWSDTOS = new ArrayList<>();

        RemoteWSDTO remoteWSDTO = remoteFramework.updateRemoteService(userId,remoteId,remote,remoteDesc,remoteModel,remoteVersion);
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
        List<RemoteWSDTO>remoteWSDTOS = new ArrayList<>();

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
