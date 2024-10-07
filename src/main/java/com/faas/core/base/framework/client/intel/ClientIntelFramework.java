package com.faas.core.base.framework.client.intel;

import com.faas.core.base.model.ws.client.details.dto.*;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientIntelFramework {

    @Autowired
    AppUtils appUtils;


    public List<ClientIntelWSDTO> getClientIntelsService(long userId, long clientId) {

        List<ClientIntelWSDTO> clientIntelWSDTOS = new ArrayList<>();
        return clientIntelWSDTOS;
    }

    public ClientIntelWSDTO getClientIntelService(long userId, long clientId, String addressId) {

        return null;
    }

    public ClientIntelWSDTO createClientIntelService(long userId, long clientId, String street, String city, String zipCode, String state, String country) {

        return null;
    }

    public ClientIntelWSDTO updateClientIntelService(long userId, long clientId, String addressId, String street, String city, String zipCode, String state, String country) {

        return null;
    }

    public ClientIntelWSDTO removeClientIntelService(long userId, long clientId, String addressId) {

        return null;
    }




}
