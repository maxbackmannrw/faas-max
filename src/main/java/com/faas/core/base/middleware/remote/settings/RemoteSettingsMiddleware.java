package com.faas.core.base.middleware.remote.settings;

import com.faas.core.base.framework.remote.settings.RemoteSettingsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.settings.RemoteTypeWSModel;
import com.faas.core.base.model.ws.remote.settings.dto.RemoteTypeWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class RemoteSettingsMiddleware {


    @Autowired
    RemoteSettingsFramework remoteSettingsFramework;


    public RemoteTypeWSModel getAllRemoteTypes(long userId) {

        RemoteTypeWSModel response = new RemoteTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteTypeWSDTO> remoteTypeWSDTOS = remoteSettingsFramework.getAllRemoteTypesService(userId);
        if (remoteTypeWSDTOS != null){
            response.setRemoteTypes(remoteTypeWSDTOS);
        }

        general.setOperation("getAllRemoteTypes");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteTypeWSModel getRemoteTypesByBase(long userId, String baseType) {

        RemoteTypeWSModel response = new RemoteTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteTypeWSDTO> remoteTypeWSDTOS = remoteSettingsFramework.getRemoteTypesByBaseService(userId,baseType);
        if (remoteTypeWSDTOS != null){
            response.setRemoteTypes(remoteTypeWSDTOS);
        }

        general.setOperation("getRemoteTypesByBase");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteTypeWSModel getRemoteType(long userId, long remoteTypeId) {

        RemoteTypeWSModel response = new RemoteTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteTypeWSDTO>remoteTypeWSDTOS = new ArrayList<>();

        RemoteTypeWSDTO remoteTypeWSDTO = remoteSettingsFramework.getRemoteTypeService(userId,remoteTypeId);
        if (remoteTypeWSDTO != null){
            remoteTypeWSDTOS.add(remoteTypeWSDTO);
        }

        response.setRemoteTypes(remoteTypeWSDTOS);
        general.setOperation("getRemoteType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteTypeWSModel createRemoteType(long userId,String remoteType,String baseType) {

        RemoteTypeWSModel response = new RemoteTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteTypeWSDTO>remoteTypeWSDTOS = new ArrayList<>();

        RemoteTypeWSDTO remoteTypeWSDTO = remoteSettingsFramework.createRemoteTypeService(userId,remoteType,baseType);
        if (remoteTypeWSDTO != null){
            remoteTypeWSDTOS.add(remoteTypeWSDTO);
        }

        response.setRemoteTypes(remoteTypeWSDTOS);
        general.setOperation("createRemoteType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteTypeWSModel updateRemoteType(long userId,long remoteTypeId,String remoteType,String baseType) {

        RemoteTypeWSModel response = new RemoteTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteTypeWSDTO>remoteTypeWSDTOS = new ArrayList<>();

        RemoteTypeWSDTO remoteTypeWSDTO = remoteSettingsFramework.updateRemoteTypeService(userId,remoteTypeId,remoteType,baseType);
        if (remoteTypeWSDTO != null){
            remoteTypeWSDTOS.add(remoteTypeWSDTO);
        }

        response.setRemoteTypes(remoteTypeWSDTOS);
        general.setOperation("updateRemoteType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteTypeWSModel removeRemoteType(long userId,long remoteTypeId) {

        RemoteTypeWSModel response = new RemoteTypeWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteTypeWSDTO>remoteTypeWSDTOS = new ArrayList<>();

        RemoteTypeWSDTO remoteTypeWSDTO = remoteSettingsFramework.removeRemoteTypeService(userId,remoteTypeId);
        if (remoteTypeWSDTO != null){
            remoteTypeWSDTOS.add(remoteTypeWSDTO);
        }

        response.setRemoteTypes(remoteTypeWSDTOS);
        general.setOperation("removeRemoteType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
