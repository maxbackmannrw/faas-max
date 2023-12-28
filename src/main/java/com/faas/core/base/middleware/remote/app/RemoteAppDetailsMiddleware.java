package com.faas.core.base.middleware.remote.app;

import com.faas.core.base.framework.remote.app.RemoteAppDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.RemoteAppSummaryWSModel;
import com.faas.core.base.model.ws.remote.app.RemoteAppWSModel;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppSummaryWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteAppDetailsMiddleware {


    @Autowired
    RemoteAppDetailsFramework remoteAppDetailsFramework;


    public RemoteAppWSModel getRemoteAppDetails(long userId) {

        RemoteAppWSModel response = new RemoteAppWSModel();
        GeneralWSModel general = new GeneralWSModel();



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

        RemoteAppSummaryWSDTO remoteAppSummaryWSDTO = remoteAppDetailsFramework.getClientRemoteSummaryService(userId);
        if (remoteAppSummaryWSDTO != null){
            response.setClientRemoteSummary(remoteAppSummaryWSDTO);
        }
        general.setOperation("getRemoteAppSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
