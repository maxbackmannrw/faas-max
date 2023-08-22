package com.faas.core.base.middleware.client.details;

import com.faas.core.base.framework.client.details.ClientOSIntelFramework;
import com.faas.core.base.model.ws.client.details.ClientDetailsWSModel;
import com.faas.core.base.model.ws.client.details.dto.ClientDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientOSIntelMiddleware {

    @Autowired
    ClientOSIntelFramework clientOSIntelFramework;

    @Autowired
    AppUtils appUtils;


    public ClientDetailsWSModel getClientOSIntels(long userId, long clientId) {

        ClientDetailsWSModel response = new ClientDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientDetailsWSDTO>clientDetailsWSDTOS = new ArrayList<>();




        response.setClientDetails(clientDetailsWSDTOS);
        general.setOperation("getClientOsIntDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





}
