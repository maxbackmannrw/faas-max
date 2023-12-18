package com.faas.core.base.middleware.client.details.content;

import com.faas.core.base.framework.client.details.content.ClientDetailsFramework;
import com.faas.core.base.model.ws.client.details.content.*;
import com.faas.core.base.model.ws.client.details.content.dto.*;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientDetailsMiddleware {


    @Autowired
    ClientDetailsFramework clientDetailsFramework;


    public ClientDetailsWSModel getClientDetails(long userId, long clientId) {

        ClientDetailsWSModel response = new ClientDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ClientDetailsWSDTO clientDetailsWSDTO = clientDetailsFramework.getClientDetailsService(userId,clientId);
        if (clientDetailsWSDTO != null){
            response.setClientDetails(clientDetailsWSDTO);
        }

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

        List<ClientDataWSDTO> clientDataWSDTOS = clientDetailsFramework.getClientDatasService(userId,clientId);
        if (clientDataWSDTOS != null){
            response.setClientDatas(clientDataWSDTOS);
        }

        general.setOperation("getClientDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientDataWSModel getClientData(long userId,long clientId,String dataId) {

        ClientDataWSModel response = new ClientDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientDataWSDTO>clientDataWSDTOS = new ArrayList<>();

        ClientDataWSDTO clientDataWSDTO = clientDetailsFramework.getClientDataService(userId,clientId,dataId);
        if (clientDataWSDTO != null){
            clientDataWSDTOS.add(clientDataWSDTO);
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

        ClientDataWSDTO clientDataWSDTO = clientDetailsFramework.createClientDataService(userId,clientId,typeId,value);
        if (clientDataWSDTO != null){
            clientDataWSDTOS.add(clientDataWSDTO);
        }

        response.setClientDatas(clientDataWSDTOS);
        general.setOperation("createClientData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientDataWSModel updateClientData(long userId,long clientId,String dataId,long typeId,String value) {

        ClientDataWSModel response = new ClientDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientDataWSDTO>clientDataWSDTOS = new ArrayList<>();

        ClientDataWSDTO clientDataWSDTO = clientDetailsFramework.updateClientDataService(userId,clientId,dataId,typeId,value);
        if (clientDataWSDTO != null){
            clientDataWSDTOS.add(clientDataWSDTO);
        }

        response.setClientDatas(clientDataWSDTOS);
        general.setOperation("updateClientData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientDataWSModel removeClientData(long userId,long clientId,String dataId) {

        ClientDataWSModel response = new ClientDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientDataWSDTO>clientDataWSDTOS = new ArrayList<>();

        ClientDataWSDTO clientDataWSDTO = clientDetailsFramework.removeClientDataService(userId,clientId,dataId);
        if (clientDataWSDTO != null){
            clientDataWSDTOS.add(clientDataWSDTO);
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

        List<ClientAddressWSDTO> clientAddressWSDTOS = clientDetailsFramework.getClientAddressesService(userId,clientId);
        if (clientAddressWSDTOS != null){
            response.setClientAddresses(clientAddressWSDTOS);
        }

        general.setOperation("getClientAddresses");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientAddressWSModel getClientAddress(long userId,long clientId,String addressId) {

        ClientAddressWSModel response = new ClientAddressWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientAddressWSDTO> clientAddressWSDTOS = new ArrayList<>();

        ClientAddressWSDTO clientAddressWSDTO = clientDetailsFramework.getClientAddressService(userId,clientId,addressId);
        if (clientAddressWSDTO != null){
            clientAddressWSDTOS.add(clientAddressWSDTO);
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

        ClientAddressWSDTO clientAddressWSDTO = clientDetailsFramework.createClientAddressService(userId,clientId,street,city,zipCode,state,country);
        if (clientAddressWSDTO != null){
            clientAddressWSDTOS.add(clientAddressWSDTO);
        }

        response.setClientAddresses(clientAddressWSDTOS);
        general.setOperation("createClientAddress");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientAddressWSModel updateClientAddress(long userId,long clientId,String addressId,String street,String city,String zipCode,String state,String country) {

        ClientAddressWSModel response = new ClientAddressWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientAddressWSDTO> clientAddressWSDTOS = new ArrayList<>();

        ClientAddressWSDTO clientAddressWSDTO = clientDetailsFramework.updateClientAddressService(userId,clientId,addressId,street,city,zipCode,state,country);
        if (clientAddressWSDTO != null){
            clientAddressWSDTOS.add(clientAddressWSDTO);
        }

        response.setClientAddresses(clientAddressWSDTOS);
        general.setOperation("updateClientAddress");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientAddressWSModel removeClientAddress(long userId,long clientId,String addressId) {

        ClientAddressWSModel response = new ClientAddressWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientAddressWSDTO> clientAddressWSDTOS = new ArrayList<>();

        ClientAddressWSDTO clientAddressWSDTO = clientDetailsFramework.removeClientAddressService(userId,clientId,addressId);
        if (clientAddressWSDTO != null){
            clientAddressWSDTOS.add(clientAddressWSDTO);
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

        List<ClientEmailWSDTO> clientEmailWSDTOS = clientDetailsFramework.getClientEmailsService(userId,clientId);
        if (clientEmailWSDTOS != null){
            response.setClientEmails(clientEmailWSDTOS);
        }

        general.setOperation("getClientEmails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientEmailWSModel getClientEmail(long userId,long clientId,String emailId) {

        ClientEmailWSModel response = new ClientEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientEmailWSDTO> clientEmailWSDTOS = new ArrayList<>();

        ClientEmailWSDTO clientEmailWSDTO = clientDetailsFramework.getClientEmailService(userId,clientId,emailId);
        if (clientEmailWSDTO != null){
            clientEmailWSDTOS.add(clientEmailWSDTO);
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

        ClientEmailWSDTO clientEmailWSDTO = clientDetailsFramework.createClientEmailService(userId,clientId,emailAddress);
        if (clientEmailWSDTO != null){
            clientEmailWSDTOS.add(clientEmailWSDTO);
        }

        response.setClientEmails(clientEmailWSDTOS);
        general.setOperation("createClientEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientEmailWSModel updateClientEmail(long userId,long clientId,String emailId,String emailAddress) {

        ClientEmailWSModel response = new ClientEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientEmailWSDTO> clientEmailWSDTOS = new ArrayList<>();

        ClientEmailWSDTO clientEmailWSDTO = clientDetailsFramework.updateClientEmailService(userId,clientId,emailId,emailAddress);
        if (clientEmailWSDTO != null){
            clientEmailWSDTOS.add(clientEmailWSDTO);
        }

        response.setClientEmails(clientEmailWSDTOS);
        general.setOperation("updateClientEmail");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientEmailWSModel removeClientEmail(long userId,long clientId,String emailId) {

        ClientEmailWSModel response = new ClientEmailWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientEmailWSDTO> clientEmailWSDTOS = new ArrayList<>();

        ClientEmailWSDTO clientEmailWSDTO = clientDetailsFramework.removeClientEmailService(userId,clientId,emailId);
        if (clientEmailWSDTO != null){
            clientEmailWSDTOS.add(clientEmailWSDTO);
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

        List<ClientPhoneWSDTO> clientPhoneWSDTOS = clientDetailsFramework.getClientPhonesService(userId,clientId);
        if (clientPhoneWSDTOS != null){
            response.setClientPhones(clientPhoneWSDTOS);
        }

        general.setOperation("getClientPhones");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientPhoneWSModel getClientPhone(long userId,long clientId,String numberId) {

        ClientPhoneWSModel response = new ClientPhoneWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientPhoneWSDTO> clientPhoneWSDTOS = new ArrayList<>();

        ClientPhoneWSDTO clientPhoneWSDTO = clientDetailsFramework.getClientPhoneService(userId,clientId,numberId);
        if (clientPhoneWSDTO != null){
            clientPhoneWSDTOS.add(clientPhoneWSDTO);
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

        ClientPhoneWSDTO clientPhoneWSDTO = clientDetailsFramework.createClientPhoneService(userId,clientId,phoneNumber,phoneCarrier);
        if (clientPhoneWSDTO != null){
            clientPhoneWSDTOS.add(clientPhoneWSDTO);
        }

        response.setClientPhones(clientPhoneWSDTOS);
        general.setOperation("createClientPhone");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientPhoneWSModel updateClientPhone(long userId,long clientId,String numberId,String phoneNumber,String phoneCarrier) {

        ClientPhoneWSModel response = new ClientPhoneWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientPhoneWSDTO> clientPhoneWSDTOS = new ArrayList<>();

        ClientPhoneWSDTO clientPhoneWSDTO = clientDetailsFramework.updateClientPhoneService(userId,clientId,numberId,phoneNumber,phoneCarrier);
        if (clientPhoneWSDTO != null){
            clientPhoneWSDTOS.add(clientPhoneWSDTO);
        }

        response.setClientPhones(clientPhoneWSDTOS);
        general.setOperation("updateClientPhone");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientPhoneWSModel removeClientPhone(long userId,long clientId,String numberId) {

        ClientPhoneWSModel response = new ClientPhoneWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientPhoneWSDTO> clientPhoneWSDTOS = new ArrayList<>();

        ClientPhoneWSDTO clientPhoneWSDTO = clientDetailsFramework.removeClientPhoneService(userId,clientId,numberId);
        if (clientPhoneWSDTO != null){
            clientPhoneWSDTOS.add(clientPhoneWSDTO);
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
