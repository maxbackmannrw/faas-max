package com.faas.core.base.middleware.client.intel;

import com.faas.core.base.framework.client.intel.ClientIntelFramework;
import com.faas.core.base.model.ws.client.details.ClientIntelWSModel;
import com.faas.core.base.model.ws.client.details.dto.ClientIntelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientIntelMiddleware {


    @Autowired
    ClientIntelFramework clientIntelFramework;


    public ClientIntelWSModel getClientIntels(long userId, long clientId) {

        ClientIntelWSModel response = new ClientIntelWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientIntelWSDTO> clientIntelWSDTOS = clientIntelFramework.getClientIntelsService(userId, clientId);
        if (clientIntelWSDTOS != null) {
            response.setClientIntels(clientIntelWSDTOS);
        }

        general.setOperation("getClientIntels");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientIntelWSModel getClientIntel(long userId, long clientId, String addressId) {

        ClientIntelWSModel response = new ClientIntelWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientIntelWSDTO> clientIntelWSDTOS = new ArrayList<>();

        ClientIntelWSDTO clientIntelWSDTO = clientIntelFramework.getClientIntelService(userId, clientId, addressId);
        if (clientIntelWSDTO != null) {
            clientIntelWSDTOS.add(clientIntelWSDTO);
        }

        response.setClientIntels(clientIntelWSDTOS);
        general.setOperation("getClientIntel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientIntelWSModel createClientIntel(long userId, long clientId, String street, String city, String zipCode, String state, String country) {

        ClientIntelWSModel response = new ClientIntelWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientIntelWSDTO> clientIntelWSDTOS = new ArrayList<>();

        ClientIntelWSDTO clientIntelWSDTO = clientIntelFramework.createClientIntelService(userId, clientId, street, city, zipCode, state, country);
        if (clientIntelWSDTO != null) {
            clientIntelWSDTOS.add(clientIntelWSDTO);
        }

        response.setClientIntels(clientIntelWSDTOS);
        general.setOperation("createClientIntel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientIntelWSModel updateClientIntel(long userId, long clientId, String addressId, String street, String city, String zipCode, String state, String country) {

        ClientIntelWSModel response = new ClientIntelWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientIntelWSDTO> clientIntelWSDTOS = new ArrayList<>();

        ClientIntelWSDTO clientIntelWSDTO = clientIntelFramework.updateClientIntelService(userId, clientId, addressId, street, city, zipCode, state, country);
        if (clientIntelWSDTO != null) {
            clientIntelWSDTOS.add(clientIntelWSDTO);
        }

        response.setClientIntels(clientIntelWSDTOS);
        general.setOperation("updateClientIntel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientIntelWSModel removeClientIntel(long userId, long clientId, String addressId) {

        ClientIntelWSModel response = new ClientIntelWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientIntelWSDTO> clientIntelWSDTOS = new ArrayList<>();

        ClientIntelWSDTO clientIntelWSDTO = clientIntelFramework.removeClientIntelService(userId, clientId, addressId);
        if (clientIntelWSDTOS != null) {
            clientIntelWSDTOS.add(clientIntelWSDTO);
        }

        response.setClientIntels(clientIntelWSDTOS);
        general.setOperation("removeClientIntel");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
