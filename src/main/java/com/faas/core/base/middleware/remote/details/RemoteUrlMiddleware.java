package com.faas.core.base.middleware.remote.details;

import com.faas.core.base.framework.remote.details.RemoteUrlFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.details.RemoteUrlWSModel;
import com.faas.core.base.model.ws.remote.details.dto.RemoteUrlWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class RemoteUrlMiddleware {


    @Autowired
    RemoteUrlFramework remoteUrlFramework;


    public RemoteUrlWSModel getAllRemoteUrls(long userId) {

        RemoteUrlWSModel response = new RemoteUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteUrlWSDTO> remoteUrlWSDTOS = remoteUrlFramework.getAllRemoteUrlsService(userId);
        if (remoteUrlWSDTOS != null){
            response.setRemoteUrls(remoteUrlWSDTOS);
        }

        general.setOperation("getAllRemoteUrls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteUrlWSModel getRemoteUrls(long userId, String remoteId) {

        RemoteUrlWSModel response = new RemoteUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteUrlWSDTO> remoteUrlWSDTOS = remoteUrlFramework.getRemoteUrlsService(userId,remoteId);
        if (remoteUrlWSDTOS != null){
            response.setRemoteUrls(remoteUrlWSDTOS);
        }

        general.setOperation("getRemoteUrls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteUrlWSModel getRemoteUrl(long userId, long urlId) {

        RemoteUrlWSModel response = new RemoteUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteUrlWSDTO> remoteUrlWSDTOS = new ArrayList<>();

        RemoteUrlWSDTO remoteUrlWSDTO = remoteUrlFramework.getRemoteUrlService(userId,urlId);
        if (remoteUrlWSDTO != null){
            remoteUrlWSDTOS.add(remoteUrlWSDTO);
        }

        response.setRemoteUrls(remoteUrlWSDTOS);
        general.setOperation("getRemoteUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteUrlWSModel createRemoteUrl(long userId, String remoteId, String remoteUrl, String urlType) {

        RemoteUrlWSModel response = new RemoteUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteUrlWSDTO> remoteUrlWSDTOS = new ArrayList<>();

        RemoteUrlWSDTO remoteUrlWSDTO = remoteUrlFramework.createRemoteUrlService(userId,remoteId,remoteUrl,urlType);
        if (remoteUrlWSDTO != null){
            remoteUrlWSDTOS.add(remoteUrlWSDTO);
        }

        response.setRemoteUrls(remoteUrlWSDTOS);
        general.setOperation("createRemoteUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteUrlWSModel updateRemoteUrl(long userId, long urlId, String remoteUrl, String urlType) {

        RemoteUrlWSModel response = new RemoteUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteUrlWSDTO> remoteUrlWSDTOS = new ArrayList<>();

        RemoteUrlWSDTO remoteUrlWSDTO = remoteUrlFramework.updateRemoteUrlService(userId,urlId,remoteUrl,urlType);
        if (remoteUrlWSDTO != null){
            remoteUrlWSDTOS.add(remoteUrlWSDTO);
        }

        response.setRemoteUrls(remoteUrlWSDTOS);
        general.setOperation("updateRemoteUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteUrlWSModel removeRemoteUrl(long userId, long urlId) {

        RemoteUrlWSModel response = new RemoteUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteUrlWSDTO> remoteUrlWSDTOS = new ArrayList<>();

        RemoteUrlWSDTO remoteUrlWSDTO = remoteUrlFramework.removeRemoteUrlService(userId,urlId);
        if (remoteUrlWSDTO != null){
            remoteUrlWSDTOS.add(remoteUrlWSDTO);
        }

        response.setRemoteUrls(remoteUrlWSDTOS);
        general.setOperation("removeRemoteUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
