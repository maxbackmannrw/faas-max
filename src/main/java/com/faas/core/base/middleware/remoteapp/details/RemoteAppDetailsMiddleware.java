package com.faas.core.base.middleware.remoteapp.details;

import com.faas.core.base.framework.remoteapp.details.RemoteAppDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remoteapp.content.RemoteAppSummaryWSModel;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppSummaryWSDTO;
import com.faas.core.base.model.ws.remoteapp.details.RemoteAppDetailsWSModel;
import com.faas.core.base.model.ws.remoteapp.details.dto.RemoteAppDetailsWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoteAppDetailsMiddleware {


    @Autowired
    RemoteAppDetailsFramework remoteAppDetailsFramework;


    public RemoteAppDetailsWSModel getRemoteAppDetails(long userId, String clientRemoteId) {

        RemoteAppDetailsWSModel response = new RemoteAppDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteAppDetailsWSDTO remoteAppDetailsWSDTO = remoteAppDetailsFramework.getRemoteAppDetailsService(userId,clientRemoteId);
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

    public RemoteAppSummaryWSModel getRemoteAppsSummary(long userId) {

        RemoteAppSummaryWSModel response = new RemoteAppSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        RemoteAppSummaryWSDTO remoteAppSummaryWSDTO = remoteAppDetailsFramework.getRemoteAppsSummaryService(userId);
        if (remoteAppSummaryWSDTO != null){
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
