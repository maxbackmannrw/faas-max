package com.faas.core.base.middleware.remote.app;

import com.faas.core.base.framework.remote.app.RemoteDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.RemoteDataWSModel;
import com.faas.core.base.model.ws.remote.app.RemoteDetailsWSModel;
import com.faas.core.base.model.ws.remote.app.RemoteUrlWSModel;
import com.faas.core.base.model.ws.remote.app.dto.RemoteDataWSDTO;
import com.faas.core.base.model.ws.remote.app.dto.RemoteDetailsWSDTO;
import com.faas.core.base.model.ws.remote.app.dto.RemoteUrlWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class RemoteDetailsMiddleware {


    @Autowired
    RemoteDetailsFramework remoteDetailsFramework;


    public RemoteDetailsWSModel getRemoteDetails(long userId, String remoteId) {

        RemoteDetailsWSModel response = new RemoteDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteDetailsWSDTO>remoteDetailsWSDTOS = new ArrayList<>();

        RemoteDetailsWSDTO remoteDetailsWSDTO = remoteDetailsFramework.getRemoteDetailsService(userId,remoteId);
        if (remoteDetailsWSDTO != null){
            remoteDetailsWSDTOS.add(remoteDetailsWSDTO);
        }

        response.setRemoteDetails(remoteDetailsWSDTOS);
        general.setOperation("getRemoteDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteDataWSModel getRemoteDatas(long userId, String remoteId) {

        RemoteDataWSModel response = new RemoteDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteDataWSDTO> remoteDataWSDTOS = remoteDetailsFramework.getRemoteDatasService(userId,remoteId);
        if (remoteDataWSDTOS != null){
            response.setRemoteDatas(remoteDataWSDTOS);
        }

        general.setOperation("getRemoteDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteDataWSModel getRemoteData(long userId, String remoteId, String dataId) {

        RemoteDataWSModel response = new RemoteDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteDataWSDTO> remoteDataWSDTOS = new ArrayList<>();

        RemoteDataWSDTO remoteDataWSDTO = remoteDetailsFramework.getRemoteDataService(userId,remoteId,dataId);
        if (remoteDataWSDTO != null){
            remoteDataWSDTOS.add(remoteDataWSDTO);
        }

        response.setRemoteDatas(remoteDataWSDTOS);
        general.setOperation("getRemoteData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteDataWSModel createRemoteData(long userId, String remoteId, long typeId, String value) {

        RemoteDataWSModel response = new RemoteDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteDataWSDTO> remoteDataWSDTOS = new ArrayList<>();

        RemoteDataWSDTO remoteDataWSDTO = remoteDetailsFramework.createRemoteDataService(userId,remoteId,typeId,value);
        if (remoteDataWSDTO != null){
            remoteDataWSDTOS.add(remoteDataWSDTO);
        }

        response.setRemoteDatas(remoteDataWSDTOS);
        general.setOperation("createRemoteData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteDataWSModel updateRemoteData(long userId, String remoteId, String dataId, long typeId, String value) {

        RemoteDataWSModel response = new RemoteDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteDataWSDTO> remoteDataWSDTOS = new ArrayList<>();

        RemoteDataWSDTO remoteDataWSDTO = remoteDetailsFramework.updateRemoteDataService(userId,remoteId,dataId,typeId,value);
        if (remoteDataWSDTO != null){
            remoteDataWSDTOS.add(remoteDataWSDTO);
        }

        response.setRemoteDatas(remoteDataWSDTOS);
        general.setOperation("updateRemoteData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteDataWSModel removeRemoteData(long userId, String remoteId, String dataId) {

        RemoteDataWSModel response = new RemoteDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteDataWSDTO> remoteDataWSDTOS = new ArrayList<>();

        RemoteDataWSDTO remoteDataWSDTO = remoteDetailsFramework.removeRemoteDataService(userId,remoteId,dataId);
        if (remoteDataWSDTO != null){
            remoteDataWSDTOS.add(remoteDataWSDTO);
        }

        response.setRemoteDatas(remoteDataWSDTOS);
        general.setOperation("removeRemoteData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public RemoteUrlWSModel getRemoteUrls(long userId, String remoteId) {

        RemoteUrlWSModel response = new RemoteUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<RemoteUrlWSDTO> remoteUrlWSDTOS = remoteDetailsFramework.getRemoteUrlsService(userId,remoteId);
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

    public RemoteUrlWSModel getRemoteUrl(long userId,String remoteId,String urlId) {

        RemoteUrlWSModel response = new RemoteUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteUrlWSDTO> remoteUrlWSDTOS = new ArrayList<>();

        RemoteUrlWSDTO remoteUrlWSDTO = remoteDetailsFramework.getRemoteUrlService(userId,remoteId,urlId);
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

    public RemoteUrlWSModel createRemoteUrl(long userId,String remoteId,String remoteUrl,String urlType) {

        RemoteUrlWSModel response = new RemoteUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteUrlWSDTO> remoteUrlWSDTOS = new ArrayList<>();

        RemoteUrlWSDTO remoteUrlWSDTO = remoteDetailsFramework.createRemoteUrlService(userId,remoteId,remoteUrl,urlType);
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

    public RemoteUrlWSModel updateRemoteUrl(long userId,String remoteId,String urlId,String remoteUrl,String urlType) {

        RemoteUrlWSModel response = new RemoteUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteUrlWSDTO> remoteUrlWSDTOS = new ArrayList<>();

        RemoteUrlWSDTO remoteUrlWSDTO = remoteDetailsFramework.updateRemoteUrlService(userId,remoteId,urlId,remoteUrl,urlType);
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

    public RemoteUrlWSModel removeRemoteUrl(long userId,String remoteId,String urlId) {

        RemoteUrlWSModel response = new RemoteUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteUrlWSDTO> remoteUrlWSDTOS = new ArrayList<>();

        RemoteUrlWSDTO remoteUrlWSDTO = remoteDetailsFramework.removeRemoteUrlService(userId,remoteId,urlId);
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
