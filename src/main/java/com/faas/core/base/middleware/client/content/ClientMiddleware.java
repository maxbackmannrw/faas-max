package com.faas.core.base.middleware.client.content;

import com.faas.core.base.framework.client.content.ClientFramework;
import com.faas.core.base.model.ws.client.content.AllClientWSModel;
import com.faas.core.base.model.ws.client.content.ClientListWSModel;
import com.faas.core.base.model.ws.client.content.ClientWSModel;
import com.faas.core.base.model.ws.client.content.CreateClientRequest;
import com.faas.core.base.model.ws.client.content.dto.AllClientWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientListWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ClientMiddleware {


    @Autowired
    ClientFramework clientFramework;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AppUtils appUtils;


    public AllClientWSModel getAllClients(long userId, int reqPage, int reqSize) {

        AllClientWSModel response = new AllClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        AllClientWSDTO allClientsWSDTO = clientFramework.getAllClientsService(userId, reqPage, reqSize);
        if (allClientsWSDTO != null) {
            response.setAllClient(allClientsWSDTO);
        }

        general.setOperation("getAllClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientListWSModel getClients(long userId, String clientState, int reqPage, int reqSize) {

        ClientListWSModel response = new ClientListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ClientListWSDTO clientListWSDTO = clientFramework.getClientsService(userId, clientState, reqPage, reqSize);
        if (clientListWSDTO != null) {
            response.setClientList(clientListWSDTO);
        }

        general.setOperation("getClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientWSModel getClient(long userId, long clientId) {

        ClientWSModel response = new ClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientWSDTO> clientWSDTOS = new ArrayList<>();

        ClientWSDTO clientWSDTO = clientFramework.getClientService(userId, clientId);
        if (clientWSDTO != null) {
            clientWSDTOS.add(clientWSDTO);
        }

        response.setClients(clientWSDTOS);
        general.setOperation("getClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientWSModel createClient(long userId, String clientName, String nationalId, String phoneNumber, String emailAddress, String clientCity, String clientCountry, long clientTypeId) {

        ClientWSModel response = new ClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientWSDTO> clientWSDTOS = new ArrayList<>();

        ClientWSDTO clientWSDTO = clientFramework.createClientService(clientName, nationalId, phoneNumber, emailAddress, clientCity, clientCountry, clientTypeId);
        if (clientWSDTO != null) {
            clientWSDTOS.add(clientWSDTO);
        }

        response.setClients(clientWSDTOS);
        general.setOperation("createClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientWSModel createVolumeClient(CreateClientRequest createClientRequest) {

        ClientWSModel response = new ClientWSModel();
        GeneralWSModel general = new GeneralWSModel();

        if (createClientRequest.getCreateClients() != null) {
            response.setClients(clientFramework.createVolumeClientService(createClientRequest.getCreateClients()));
        }

        general.setOperation("createVolumeClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientWSModel updateClient(long userId, long clientId, String clientName, String nationalId, String phoneNumber, String emailAddress, String clientCity, String clientCountry, long clientTypeId) {

        ClientWSModel response = new ClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientWSDTO> clientWSDTOS = new ArrayList<>();

        ClientWSDTO clientWSDTO = clientFramework.updateClientService(clientId, clientName, nationalId, phoneNumber, emailAddress, clientCity, clientCountry, clientTypeId);
        if (clientWSDTO != null) {
            clientWSDTOS.add(clientWSDTO);
        }

        response.setClients(clientWSDTOS);
        general.setOperation("updateClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientWSModel removeClient(long userId, long clientId) {

        ClientWSModel response = new ClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientWSDTO> clientWSDTOS = new ArrayList<>();

        ClientWSDTO clientWSDTO = clientFramework.removeClientService(clientId);
        if (clientWSDTO != null) {
            clientWSDTOS.add(clientWSDTO);
        }

        response.setClients(clientWSDTOS);
        general.setOperation("removeClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
