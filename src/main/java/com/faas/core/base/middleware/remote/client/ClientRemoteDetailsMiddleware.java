package com.faas.core.base.middleware.remote.client;

import com.faas.core.base.framework.remote.client.ClientRemoteDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.remote.client.ClientRemoteSummaryWSModel;
import com.faas.core.base.model.ws.remote.client.ClientRemoteWSModel;
import com.faas.core.base.model.ws.remote.client.dto.ClientRemoteSummaryWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientRemoteDetailsMiddleware {


    @Autowired
    ClientRemoteDetailsFramework clientRemoteDetailsFramework;


    public ClientRemoteWSModel getClientRemoteDetails(long userId) {

        ClientRemoteWSModel response = new ClientRemoteWSModel();
        GeneralWSModel general = new GeneralWSModel();



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
        general.setOperation("getRemoteSummary");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
