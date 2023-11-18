package com.faas.core.base.framework.client.details;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.ws.client.details.dto.ClientAddressWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientOSINTFramework {


    @Autowired
    AppUtils appUtils;


    public ClientAddressWSDTO getClientDetailsService(ClientDBModel clientDBModel) {

        ClientAddressWSDTO clientAddressWSDTO = new ClientAddressWSDTO();
        return clientAddressWSDTO;
    }




}
