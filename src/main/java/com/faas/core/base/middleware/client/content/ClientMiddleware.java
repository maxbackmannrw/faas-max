package com.faas.core.base.middleware.client.content;

import com.faas.core.base.framework.client.content.ClientFramework;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.ws.client.content.AllClientsWSModel;
import com.faas.core.base.model.ws.client.content.ClientWSModel;
import com.faas.core.base.model.ws.client.content.ClientsByStateWSModel;
import com.faas.core.base.model.ws.client.content.CreateClientRequest;
import com.faas.core.base.model.ws.client.content.dto.AllClientsWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientsByStateWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
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


    public AllClientsWSModel getAllClients(long userId, int reqPage, int reqSize) {

        AllClientsWSModel response = new AllClientsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        AllClientsWSDTO allClientsWSDTO = new AllClientsWSDTO();

        ClientsByStateWSDTO allClientsByState = clientFramework.getClientsByStateService(userId,AppConstant.ALL_CLIENTS,reqPage,reqSize);
        if (allClientsByState != null){
            allClientsWSDTO.setAllClients(allClientsByState);
        }

        ClientsByStateWSDTO readyClientsByState = clientFramework.getClientsByStateService(userId,AppConstant.READY_CLIENT,reqPage,reqSize);
        if (readyClientsByState != null){
            allClientsWSDTO.setReadyClients(readyClientsByState);
        }

        ClientsByStateWSDTO busyClientsByState = clientFramework.getClientsByStateService(userId,AppConstant.BUSY_CLIENT,reqPage,reqSize);
        if (busyClientsByState != null){
            allClientsWSDTO.setBusyClients(busyClientsByState);
        }


        response.setAllClients(allClientsWSDTO);
        general.setOperation("getAllClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientsByStateWSModel getClientsByState(long userId, String clientState, int reqPage, int reqSize) {

        ClientsByStateWSModel response = new ClientsByStateWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ClientsByStateWSDTO clientsByStateWSDTO = clientFramework.getClientsByStateService(userId,clientState,reqPage,reqSize);
        if (clientsByStateWSDTO != null){
            response.setClients(clientsByStateWSDTO);
        }

        general.setOperation("getClientsByState");
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

        List<ClientDBModel> clientDBModels = clientRepository.findByIdAndStatus(clientId,1);
        if (clientDBModels.size()>0){
            clientWSDTOS.add(clientFramework.fillClientWSDTO(clientDBModels.get(0)));
        }

        response.setClients(clientWSDTOS);
        general.setOperation("getClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientWSModel createClient(long userId,String clientName,String nationalId,String phoneNumber,String emailAddress,String clientCity,String clientCountry,long clientTypeId) {

        ClientWSModel response = new ClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientWSDTO> clientWSDTOS = new ArrayList<>();

        ClientDBModel clientDBModel = clientFramework.createClientService(clientName,nationalId,phoneNumber,emailAddress,clientCity,clientCountry,clientTypeId);
        if (clientDBModel != null){
            clientWSDTOS.add(clientFramework.fillClientWSDTO(clientDBModel));
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
        List<ClientWSDTO> clientWSDTOS = new ArrayList<>();

        if (createClientRequest.getCreateClients() != null){
            for (int i=0;i<createClientRequest.getCreateClients().size();i++){
                ClientDBModel clientDBModel = clientFramework.createVolumeClientService(createClientRequest.getCreateClients().get(i));
                if (clientDBModel != null) {
                    clientWSDTOS.add(clientFramework.fillClientWSDTO(clientDBModel));
                }
            }
        }

        response.setClients(clientWSDTOS);
        general.setOperation("createVolumeClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ClientWSModel updateClient(long userId,long clientId,String clientName,String nationalId,String phoneNumber,String emailAddress,String clientCity,String clientCountry,long clientTypeId) {

        ClientWSModel response = new ClientWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientWSDTO> clientWSDTOS = new ArrayList<>();

        ClientDBModel clientDBModel = clientFramework.updateClientService(clientId,clientName,nationalId,phoneNumber,emailAddress,clientCity,clientCountry,clientTypeId);
        if (clientDBModel != null) {
            clientWSDTOS.add(clientFramework.fillClientWSDTO(clientDBModel));
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

        clientFramework.removeClientService(clientId);

        response.setClients(clientWSDTOS);
        general.setOperation("removeClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
