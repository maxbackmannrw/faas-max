package com.faas.core.base.framework.client.details.osint;

import com.faas.core.base.model.ws.client.details.osint.dto.ClientOSINTWSDTO;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientOSINTFramework {


    @Autowired
    AppUtils appUtils;


    public List<ClientOSINTWSDTO> getClientOSINTSService(long userId, long clientId) {

        List<ClientOSINTWSDTO> clientOSINTWSDTOS = new ArrayList<>();

        return clientOSINTWSDTOS;
    }


}
