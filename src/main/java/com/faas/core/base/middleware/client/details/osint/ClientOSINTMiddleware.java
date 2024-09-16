package com.faas.core.base.middleware.client.details.osint;

import com.faas.core.base.framework.client.details.osint.ClientOSINTFramework;
import com.faas.core.data.ws.base.client.details.osint.ClientOSINTWSModel;
import com.faas.core.data.ws.base.client.details.osint.dto.ClientOSINTWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientOSINTMiddleware {


    @Autowired
    ClientOSINTFramework clientOSIntFramework;


    public ClientOSINTWSModel getClientOSINTS(long userId, long clientId) {

        ClientOSINTWSModel response = new ClientOSINTWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientOSINTWSDTO> clientOSINTWSDTOS = clientOSIntFramework.getClientOSINTSService(userId, clientId);
        if (clientOSINTWSDTOS != null) {
            response.setClientOSINTs(clientOSINTWSDTOS);
        }

        general.setOperation("getClientOSINTS");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
