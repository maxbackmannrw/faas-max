package com.faas.core.base.middleware.remote.client.details;

import com.faas.core.base.framework.remote.client.details.RemoteClientDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.client.content.RemoteClientSummaryWSModel;
import com.faas.core.base.model.ws.remote.client.content.dto.RemoteClientSummaryWSDTO;
import com.faas.core.base.model.ws.remote.client.details.RemoteClientDetailsWSModel;
import com.faas.core.base.model.ws.remote.client.details.dto.RemoteClientDetailsWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoteClientDetailsMiddleware {


    @Autowired
    RemoteClientDetailsFramework remoteClientDetailsFramework;


    public RemoteClientDetailsWSModel getRemoteClientDetails(long userId, String clientRemoteId) {

        RemoteClientDetailsWSModel response = new RemoteClientDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteClientDetailsWSDTO remoteClientDetailsWSDTO = remoteClientDetailsFramework.getRemoteClientDetailsService(userId,clientRemoteId);
        if (remoteClientDetailsWSDTO != null){
            response.setClientRemoteDetails(remoteClientDetailsWSDTO);
        }

        general.setOperation("getRemoteClientDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public RemoteClientSummaryWSModel getRemoteClientSummary(long userId) {

        RemoteClientSummaryWSModel response = new RemoteClientSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteClientSummaryWSDTO remoteClientSummaryWSDTO = remoteClientDetailsFramework.getClientRemoteSummaryService(userId);
        if (remoteClientSummaryWSDTO != null){
            response.setClientRemoteSummary(remoteClientSummaryWSDTO);
        }

        general.setOperation("getRemoteClientSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
