package com.faas.core.base.middleware.remote.app.details;

import com.faas.core.base.framework.remote.app.details.RemoteAppDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.app.content.RemoteClientSummaryWSModel;
import com.faas.core.base.model.ws.remote.app.content.dto.RemoteClientSummaryWSDTO;
import com.faas.core.base.model.ws.remote.app.details.RemoteClientDetailsWSModel;
import com.faas.core.base.model.ws.remote.app.details.dto.RemoteClientDetailsWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoteAppDetailsMiddleware {


    @Autowired
    RemoteAppDetailsFramework remoteAppDetailsFramework;


    public RemoteClientDetailsWSModel getRemoteAppDetails(long userId, String clientRemoteId) {

        RemoteClientDetailsWSModel response = new RemoteClientDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteClientDetailsWSDTO remoteClientDetailsWSDTO = remoteAppDetailsFramework.getRemoteAppDetailsService(userId,clientRemoteId);
        if (remoteClientDetailsWSDTO != null){
            response.setClientRemoteDetails(remoteClientDetailsWSDTO);
        }

        general.setOperation("getRemoteAppDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientSummaryWSModel getRemoteAppsSummary(long userId) {

        RemoteClientSummaryWSModel response = new RemoteClientSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteClientSummaryWSDTO remoteClientSummaryWSDTO = remoteAppDetailsFramework.getRemoteAppsSummaryService(userId);
        if (remoteClientSummaryWSDTO != null){
            response.setClientRemoteSummary(remoteClientSummaryWSDTO);
        }

        general.setOperation("getRemoteAppsSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
