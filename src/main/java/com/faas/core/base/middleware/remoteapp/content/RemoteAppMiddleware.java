package com.faas.core.base.middleware.remoteapp.content;

import com.faas.core.base.framework.remoteapp.content.RemoteAppFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remoteapp.content.RemoteAppListWSModel;
import com.faas.core.base.model.ws.remoteapp.content.RemoteAppSummaryWSModel;
import com.faas.core.base.model.ws.remoteapp.content.RemoteAppWSModel;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppListWSDTO;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppSummaryWSDTO;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppWSDTO;
import com.faas.core.base.model.ws.remoteapp.details.RemoteAppDetailsWSModel;
import com.faas.core.base.model.ws.remoteapp.details.dto.RemoteAppDetailsWSDTO;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RemoteAppMiddleware {


    @Autowired
    RemoteAppFramework remoteAppFramework;


    public RemoteAppListWSModel getRemoteApps(long userId, String connState, int reqPage, int reqSize) {

        RemoteAppListWSModel response = new RemoteAppListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteAppListWSDTO remoteAppListWSDTO = remoteAppFramework.getRemoteAppsService(userId, connState, reqPage, reqSize);
        if (remoteAppListWSDTO != null) {
            response.setRemoteAppList(remoteAppListWSDTO);
        }

        general.setOperation("getRemoteApps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppListWSModel getRemoteAppsByBaseType(long userId, String connState, String baseType, int reqPage, int reqSize) {

        RemoteAppListWSModel response = new RemoteAppListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteAppListWSDTO remoteAppListWSDTO = remoteAppFramework.getRemoteAppsByBaseTypeService(userId, connState, baseType, reqPage, reqSize);
        if (remoteAppListWSDTO != null) {
            response.setRemoteAppList(remoteAppListWSDTO);
        }

        general.setOperation("getRemoteAppsByBaseType");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppListWSModel getClientRemoteApps(long userId, long clientId) {

        RemoteAppListWSModel response = new RemoteAppListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteAppListWSDTO remoteAppListWSDTO = remoteAppFramework.getClientRemoteAppsService(userId, clientId);
        if (remoteAppListWSDTO != null) {
            response.setRemoteAppList(remoteAppListWSDTO);
        }

        general.setOperation("getClientRemoteApps");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppWSModel getRemoteApp(long userId, String remoteAppId) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();

        RemoteAppWSDTO remoteAppWSDTO = remoteAppFramework.getRemoteAppService(userId, remoteAppId);
        if (remoteAppWSDTO != null) {
            remoteAppWSDTOS.add(remoteAppWSDTO);
        }

        response.setRemoteApps(remoteAppWSDTOS);
        general.setOperation("getRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppWSModel createRemoteApp(long userId, String operationId, String remoteId) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();

        RemoteAppWSDTO remoteAppWSDTO = remoteAppFramework.createRemoteAppService(userId, operationId, remoteId);
        if (remoteAppWSDTO != null) {
            remoteAppWSDTOS.add(remoteAppWSDTO);
        }

        response.setRemoteApps(remoteAppWSDTOS);
        general.setOperation("createRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppWSModel updateRemoteApp(long userId, String remoteAppId, String remoteState) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();

        RemoteAppWSDTO remoteAppWSDTO = remoteAppFramework.updateRemoteAppService(userId, remoteAppId, remoteState);
        if (remoteAppWSDTO != null) {
            remoteAppWSDTOS.add(remoteAppWSDTO);
        }

        response.setRemoteApps(remoteAppWSDTOS);
        general.setOperation("updateRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppWSModel removeRemoteApp(long userId, String remoteAppId) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<RemoteAppWSDTO> remoteAppWSDTOS = new ArrayList<>();

        RemoteAppWSDTO remoteAppWSDTO = remoteAppFramework.removeRemoteAppService(userId, remoteAppId);
        if (remoteAppWSDTO != null) {
            remoteAppWSDTOS.add(remoteAppWSDTO);
        }

        response.setRemoteApps(remoteAppWSDTOS);
        general.setOperation("removeRemoteApp");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppDetailsWSModel getRemoteAppDetails(long userId, String remoteAppId) {

        RemoteAppDetailsWSModel response = new RemoteAppDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteAppDetailsWSDTO remoteAppDetailsWSDTO = remoteAppFramework.getRemoteAppDetailsService(userId, remoteAppId);
        if (remoteAppDetailsWSDTO != null) {
            response.setRemoteAppDetails(remoteAppDetailsWSDTO);
        }

        general.setOperation("getRemoteAppDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteAppSummaryWSModel getRemoteAppsSummary(long userId) {

        RemoteAppSummaryWSModel response = new RemoteAppSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteAppSummaryWSDTO remoteAppSummaryWSDTO = remoteAppFramework.getRemoteAppsSummaryService(userId);
        if (remoteAppSummaryWSDTO != null) {
            response.setRemoteAppSummary(remoteAppSummaryWSDTO);
        }

        general.setOperation("getRemoteAppsSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
