package com.faas.core.base.middleware.client.details;

import com.faas.core.base.framework.client.details.ClientDetailsFramework;
import com.faas.core.base.model.db.client.details.ClientAddressDBModel;
import com.faas.core.base.model.db.client.details.ClientDataDBModel;
import com.faas.core.base.model.db.client.details.ClientEmailDBModel;
import com.faas.core.base.model.db.client.details.ClientPhoneDBModel;
import com.faas.core.base.model.ws.client.details.*;
import com.faas.core.base.model.ws.client.details.dto.*;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.repo.client.details.ClientAddressRepository;
import com.faas.core.base.repo.client.details.ClientDataRepository;
import com.faas.core.base.repo.client.details.ClientEmailRepository;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientDetailsMiddleware {

    @Autowired
    ClientDetailsFramework clientDetailsFramework;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    AppUtils appUtils;


    public ClientDetailsWSModel getClientDetails(long userId, long clientId) {

        ClientDetailsWSModel response = new ClientDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientDetailsWSDTO>clientDetailsWSDTOS = new ArrayList<>();


        response.setClientDetails(clientDetailsWSDTOS);
        general.setOperation("getClientDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ClientDataWSModel getClientDatas(long userId, long clientId) {

        ClientDataWSModel response = new ClientDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientDataWSDTO>clientDataWSDTOS = new ArrayList<>();

        List<ClientDataDBModel> clientDataDBModels = clientDataRepository.findByClientId(clientId);
        for (ClientDataDBModel clientDataDBModel : clientDataDBModels) {
            clientDataWSDTOS.add(clientDetailsFramework.fillClientDataWSDTO(clientDataDBModel));
        }

        response.setClientDatas(clientDataWSDTOS);
        general.setOperation("getClientDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientDataWSModel getClientData(long userId,long dataId) {

        ClientDataWSModel response = new ClientDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientDataWSDTO>clientDataWSDTOS = new ArrayList<>();

        Optional<ClientDataDBModel> clientDataDBModel = clientDataRepository.findById(dataId);
        if (clientDataDBModel.isPresent()) {
            clientDataWSDTOS.add(clientDetailsFramework.fillClientDataWSDTO(clientDataDBModel.get()));
        }

        response.setClientDatas(clientDataWSDTOS);
        general.setOperation("getClientData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientDataWSModel createClientData(long userId,long clientId,long typeId,String value) {

        ClientDataWSModel response = new ClientDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientDataWSDTO>clientDataWSDTOS = new ArrayList<>();

        ClientDataDBModel clientDataDBModel = clientDetailsFramework.createClientDataService(clientId,typeId,value);
        if (clientDataDBModel != null) {
            clientDataWSDTOS.add(clientDetailsFramework.fillClientDataWSDTO(clientDataDBModel));
        }

        response.setClientDatas(clientDataWSDTOS);
        general.setOperation("createClientData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientDataWSModel updateClientData(long userId,long dataId,long typeId,String value) {

        ClientDataWSModel response = new ClientDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientDataWSDTO>clientDataWSDTOS = new ArrayList<>();

        ClientDataDBModel clientDataDBModel = clientDetailsFramework.updateClientDataService(dataId,typeId,value);
        if (clientDataDBModel != null) {
            clientDataWSDTOS.add(clientDetailsFramework.fillClientDataWSDTO(clientDataDBModel));
        }

        response.setClientDatas(clientDataWSDTOS);
        general.setOperation("updateClientData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientDataWSModel removeClientData(long userId,long dataId) {

        ClientDataWSModel response = new ClientDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientDataWSDTO>clientDataWSDTOS = new ArrayList<>();

        ClientDataDBModel clientDataDBModel = clientDetailsFramework.removeClientDataService(dataId);
        if (clientDataDBModel != null) {
            clientDataWSDTOS.add(clientDetailsFramework.fillClientDataWSDTO(clientDataDBModel));
        }

        response.setClientDatas(clientDataWSDTOS);
        general.setOperation("removeClientData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public ClientAddressWSModel getClientAddresses(long userId, long clientId) {

        ClientAddressWSModel response = new ClientAddressWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientAddressWSDTO> clientAddressWSDTOS = new ArrayList<>();

        List<ClientAddressDBModel> clientAddressDBModels = clientAddressRepository.findByClientId(clientId);
        for (ClientAddressDBModel clientAddressDBModel : clientAddressDBModels) {
            clientAddressWSDTOS.add(clientDetailsFramework.fillClientAddressWSDTO(clientAddressDBModel));
        }

        response.setClientAddresses(clientAddressWSDTOS);
        general.setOperation("getClientAddresses");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientAddressWSModel getClientAddress(long userId,long addressId) {

        ClientAddressWSModel response = new ClientAddressWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientAddressWSDTO> clientAddressWSDTOS = new ArrayList<>();

        Optional<ClientAddressDBModel> clientAddressDBModel = clientAddressRepository.findById(addressId);
        if (clientAddressDBModel.isPresent()){
            clientAddressWSDTOS.add(clientDetailsFramework.fillClientAddressWSDTO(clientAddressDBModel.get()));
        }

        response.setClientAddresses(clientAddressWSDTOS);
        general.setOperation("getClientAddress");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientAddressWSModel createClientAddress(long userId,long clientId,String street,String city,String zipCode,String state,String country) {

        ClientAddressWSModel response = new ClientAddressWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientAddressWSDTO> clientAddressWSDTOS = new ArrayList<>();

        ClientAddressDBModel clientAddressDBModel = clientDetailsFramework.createClientAddressService(clientId,street,city,zipCode,state,country);
        if (clientAddressDBModel != null){
            clientAddressWSDTOS.add(clientDetailsFramework.fillClientAddressWSDTO(clientAddressDBModel));
        }

        response.setClientAddresses(clientAddressWSDTOS);
        general.setOperation("createClientAddress");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientAddressWSModel updateClientAddress(long userId,long addressId,String street,String city,String zipCode,String state,String country) {

        ClientAddressWSModel response = new ClientAddressWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientAddressWSDTO> clientAddressWSDTOS = new ArrayList<>();

        ClientAddressDBModel clientAddressDBModel = clientDetailsFramework.updateClientAddressService(addressId,street,city,zipCode,state,country);
        if (clientAddressDBModel != null){
            clientAddressWSDTOS.add(clientDetailsFramework.fillClientAddressWSDTO(clientAddressDBModel));
        }

        response.setClientAddresses(clientAddressWSDTOS);
        general.setOperation("updateClientAddress");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientAddressWSModel removeClientAddress(long userId,long addressId) {

        ClientAddressWSModel response = new ClientAddressWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientAddressWSDTO> clientAddressWSDTOS = new ArrayList<>();

        ClientAddressDBModel clientAddressDBModel = clientDetailsFramework.removeClientAddressService(addressId);
        if (clientAddressDBModel != null){
            clientAddressWSDTOS.add(clientDetailsFramework.fillClientAddressWSDTO(clientAddressDBModel));
        }

        response.setClientAddresses(clientAddressWSDTOS);
        general.setOperation("removeClientAddress");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }





    public ClientEmailWSModel getClientEmails(long userId, long clientId) {

        ClientEmailWSModel response = new ClientEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientEmailWSDTO> clientEmailWSDTOS = new ArrayList<>();

        List<ClientEmailDBModel> clientEmailDBModels = clientEmailRepository.findByClientId(clientId);
        for (ClientEmailDBModel clientEmailDBModel : clientEmailDBModels) {
            clientEmailWSDTOS.add(clientDetailsFramework.fillClientEmailWSDTO(clientEmailDBModel));
        }

        response.setClientEmails(clientEmailWSDTOS);
        general.setOperation("getClientEmails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientEmailWSModel getClientEmail(long userId,long emailId) {

        ClientEmailWSModel response = new ClientEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientEmailWSDTO> clientEmailWSDTOS = new ArrayList<>();

        Optional<ClientEmailDBModel> clientEmailDBModel = clientEmailRepository.findById(emailId);
        if (clientEmailDBModel.isPresent()){
            clientEmailWSDTOS.add(clientDetailsFramework.fillClientEmailWSDTO(clientEmailDBModel.get()));
        }

        response.setClientEmails(clientEmailWSDTOS);
        general.setOperation("getClientEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientEmailWSModel createClientEmail(long userId,long clientId,String emailAddress) {

        ClientEmailWSModel response = new ClientEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientEmailWSDTO> clientEmailWSDTOS = new ArrayList<>();

        ClientEmailDBModel clientEmailDBModel = clientDetailsFramework.createClientEmailService(clientId,emailAddress);
        if (clientEmailDBModel != null){
            clientEmailWSDTOS.add(clientDetailsFramework.fillClientEmailWSDTO(clientEmailDBModel));
        }

        response.setClientEmails(clientEmailWSDTOS);
        general.setOperation("createClientEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientEmailWSModel updateClientEmail(long userId,long emailId,String emailAddress) {

        ClientEmailWSModel response = new ClientEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientEmailWSDTO> clientEmailWSDTOS = new ArrayList<>();

        ClientEmailDBModel clientEmailDBModel = clientDetailsFramework.updateClientEmailService(emailId,emailAddress);
        if (clientEmailDBModel != null){
            clientEmailWSDTOS.add(clientDetailsFramework.fillClientEmailWSDTO(clientEmailDBModel));
        }

        response.setClientEmails(clientEmailWSDTOS);
        general.setOperation("updateClientEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientEmailWSModel removeClientEmail(long userId,long emailId) {

        ClientEmailWSModel response = new ClientEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientEmailWSDTO> clientEmailWSDTOS = new ArrayList<>();

        ClientEmailDBModel clientEmailDBModel = clientDetailsFramework.removeClientEmailService(emailId);
        if (clientEmailDBModel != null){
            clientEmailWSDTOS.add(clientDetailsFramework.fillClientEmailWSDTO(clientEmailDBModel));
        }

        response.setClientEmails(clientEmailWSDTOS);
        general.setOperation("removeClientEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public ClientPhoneWSModel getClientPhones(long userId, long clientId) {

        ClientPhoneWSModel response = new ClientPhoneWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientPhoneWSDTO> clientPhoneWSDTOS = new ArrayList<>();

        List<ClientPhoneDBModel> clientPhoneDBModels = clientPhoneRepository.findByClientId(clientId);
        for (ClientPhoneDBModel clientPhoneDBModel : clientPhoneDBModels) {
            clientPhoneWSDTOS.add(clientDetailsFramework.fillClientPhoneWSDTO(clientPhoneDBModel));
        }

        response.setClientPhones(clientPhoneWSDTOS);
        general.setOperation("getClientPhones");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientPhoneWSModel getClientPhone(long userId,long numberId) {

        ClientPhoneWSModel response = new ClientPhoneWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientPhoneWSDTO> clientPhoneWSDTOS = new ArrayList<>();

        Optional<ClientPhoneDBModel> clientPhoneDBModel = clientPhoneRepository.findById(numberId);
        if (clientPhoneDBModel.isPresent()) {
            clientPhoneWSDTOS.add(clientDetailsFramework.fillClientPhoneWSDTO(clientPhoneDBModel.get()));
        }

        response.setClientPhones(clientPhoneWSDTOS);
        general.setOperation("getClientPhone");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientPhoneWSModel createClientPhone(long userId,long clientId,String phoneNumber,String phoneCarrier) {

        ClientPhoneWSModel response = new ClientPhoneWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientPhoneWSDTO> clientPhoneWSDTOS = new ArrayList<>();

        ClientPhoneDBModel clientPhoneDBModel = clientDetailsFramework.createClientPhoneService(clientId,phoneNumber,phoneCarrier);
        if (clientPhoneDBModel != null) {
            clientPhoneWSDTOS.add(clientDetailsFramework.fillClientPhoneWSDTO(clientPhoneDBModel));
        }

        response.setClientPhones(clientPhoneWSDTOS);
        general.setOperation("createClientPhone");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientPhoneWSModel updateClientPhone(long userId,long numberId,String phoneNumber,String phoneCarrier) {

        ClientPhoneWSModel response = new ClientPhoneWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientPhoneWSDTO> clientPhoneWSDTOS = new ArrayList<>();

        ClientPhoneDBModel clientPhoneDBModel = clientDetailsFramework.updateClientPhoneService(numberId,phoneNumber,phoneCarrier);
        if (clientPhoneDBModel != null) {
            clientPhoneWSDTOS.add(clientDetailsFramework.fillClientPhoneWSDTO(clientPhoneDBModel));
        }

        response.setClientPhones(clientPhoneWSDTOS);
        general.setOperation("updateClientPhone");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientPhoneWSModel removeClientPhone(long userId,long numberId) {

        ClientPhoneWSModel response = new ClientPhoneWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientPhoneWSDTO> clientPhoneWSDTOS = new ArrayList<>();

        ClientPhoneDBModel clientPhoneDBModel = clientDetailsFramework.removeClientPhoneService(numberId);
        if (clientPhoneDBModel != null) {
            clientPhoneWSDTOS.add(clientDetailsFramework.fillClientPhoneWSDTO(clientPhoneDBModel));
        }

        response.setClientPhones(clientPhoneWSDTOS);
        general.setOperation("removeClientPhone");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
