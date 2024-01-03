package com.faas.core.base.middleware.remote.app;

import com.faas.core.base.framework.remote.app.RemoteAppDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.content.RemoteAppSummaryWSModel;
import com.faas.core.base.model.ws.remote.app.content.dto.RemoteAppSummaryWSDTO;
import com.faas.core.base.model.ws.remote.app.details.RemoteAppDetailsWSModel;
import com.faas.core.base.model.ws.remote.app.details.dto.RemoteAppDetailsWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteAppDetailsMiddleware {


    @Autowired
    RemoteAppDetailsFramework remoteAppDetailsFramework;


    public RemoteAppDetailsWSModel getRemoteAppDetails(long userId,String appId) {

        RemoteAppDetailsWSModel response = new RemoteAppDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteAppDetailsWSDTO remoteAppDetailsWSDTO = remoteAppDetailsFramework.getRemoteAppDetailsService(userId,appId);
        if (remoteAppDetailsWSDTO != null){
            response.setRemoteAppDetails(remoteAppDetailsWSDTO);
        }

        general.setOperation("getRemoteAppDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public RemoteAppSummaryWSModel getRemoteAppSummary(long userId) {

        RemoteAppSummaryWSModel response = new RemoteAppSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteAppSummaryWSDTO remoteAppSummaryWSDTO = remoteAppDetailsFramework.getRemoteAppSummaryService(userId);
        if (remoteAppSummaryWSDTO != null){
            response.setRemoteAppSummary(remoteAppSummaryWSDTO);
        }

        general.setOperation("getRemoteAppSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
