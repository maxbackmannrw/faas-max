package com.faas.core.base.middleware.remote.client;

import com.faas.core.base.framework.remote.client.ClientRemoteDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.client.content.ClientRemoteSummaryWSModel;
import com.faas.core.base.model.ws.remote.client.content.dto.ClientRemoteSummaryWSDTO;
import com.faas.core.base.model.ws.remote.client.details.ClientRemoteDetailsWSModel;
import com.faas.core.base.model.ws.remote.client.details.dto.ClientRemoteDetailsWSDTO;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientRemoteDetailsMiddleware {


    @Autowired
    ClientRemoteDetailsFramework clientRemoteDetailsFramework;


    public ClientRemoteDetailsWSModel getClientRemoteDetails(long userId,String clientRemoteId) {

        ClientRemoteDetailsWSModel response = new ClientRemoteDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ClientRemoteDetailsWSDTO clientRemoteDetailsWSDTO = clientRemoteDetailsFramework.getClientRemoteDetailsService(userId,clientRemoteId);
        if (clientRemoteDetailsWSDTO != null){
            response.setClientRemoteDetails(clientRemoteDetailsWSDTO);
        }

        general.setOperation("getClientRemoteDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientRemoteSummaryWSModel getClientRemoteSummary(long userId) {

        ClientRemoteSummaryWSModel response = new ClientRemoteSummaryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ClientRemoteSummaryWSDTO clientRemoteSummaryWSDTO = clientRemoteDetailsFramework.getClientRemoteSummaryService(userId);
        if (clientRemoteSummaryWSDTO != null){
            response.setClientRemoteSummary(clientRemoteSummaryWSDTO);
        }

        general.setOperation("getClientRemoteSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
