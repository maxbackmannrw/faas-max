package com.faas.core.base.framework.client.details;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.*;
import com.faas.core.base.model.db.utils.datatype.DataTypeDBModel;
import com.faas.core.base.model.ws.client.details.dto.*;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.remote.RemoteRepository;
import com.faas.core.base.repo.utils.datatype.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ClientDetailsFramework {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    AppUtils appUtils;



    public ClientDetailsWSDTO getClientDetailsService(ClientDBModel clientDBModel) {

        ClientDetailsWSDTO clientDetailsWSDTO = new ClientDetailsWSDTO();

        clientDetailsWSDTO.setClient(clientDBModel);
        clientDetailsWSDTO.setClientDatas(clientDataRepository.findByClientId(clientDBModel.getId()));
        clientDetailsWSDTO.setClientPhones(clientPhoneRepository.findByClientId(clientDBModel.getId()));
        clientDetailsWSDTO.setClientAddresses(clientAddressRepository.findByClientId(clientDBModel.getId()));
        clientDetailsWSDTO.setClientEmails(clientEmailRepository.findByClientId(clientDBModel.getId()));

        return clientDetailsWSDTO;
    }



    public ClientDataWSDTO fillClientDataWSDTO(ClientDataDBModel clientDataDBModel) {

        ClientDataWSDTO clientDataWSDTO = new ClientDataWSDTO();
        clientDataWSDTO.setClientData(clientDataDBModel);
        return clientDataWSDTO;
    }


    public ClientDataDBModel createClientDataService(long clientId,long typeId,String value) {

        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent()){

            ClientDataDBModel clientDataDBModel = new ClientDataDBModel();
            clientDataDBModel.setClientId(clientId);
            clientDataDBModel.setDataType(dataTypeDBModel.get().getDataType());
            clientDataDBModel.setDataValue(value);
            clientDataDBModel.setuDate(appUtils.getCurrentTimeStamp());
            clientDataDBModel.setcDate(appUtils.getCurrentTimeStamp());
            clientDataDBModel.setStatus(1);
            return clientDataRepository.save(clientDataDBModel);
        }
        return null;
    }


    public ClientDataDBModel updateClientDataService(long dataId,long typeId,String value) {

        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        Optional<ClientDataDBModel> clientDataDBModel = clientDataRepository.findById(dataId);
        if (clientDataDBModel.isPresent() && dataTypeDBModel.isPresent()){

            clientDataDBModel.get().setDataType(dataTypeDBModel.get().getDataType());
            clientDataDBModel.get().setDataValue(value);
            clientDataDBModel.get().setuDate(appUtils.getCurrentTimeStamp());

            return clientDataRepository.save(clientDataDBModel.get());
        }
        return null;
    }

    public ClientDataDBModel removeClientDataService(long dataId) {

        Optional<ClientDataDBModel> clientDataDBModel = clientDataRepository.findById(dataId);
        if (clientDataDBModel.isPresent()){
            clientDataRepository.delete(clientDataDBModel.get());
            return clientDataDBModel.get();
        }
        return null;
    }




    public ClientAddressWSDTO fillClientAddressWSDTO(ClientAddressDBModel clientAddressDBModel) {

        ClientAddressWSDTO clientAddressWSDTO = new ClientAddressWSDTO();
        clientAddressWSDTO.setClientAddress(clientAddressDBModel);
        return clientAddressWSDTO;
    }


    public ClientAddressDBModel createClientAddressService(long clientId,String street,String city,String zipCode,String state,String country) {

        ClientAddressDBModel clientAddressDBModel = new ClientAddressDBModel();
        clientAddressDBModel.setClientId(clientId);
        clientAddressDBModel.setStreet(street);
        clientAddressDBModel.setCity(city);
        clientAddressDBModel.setZipCode(zipCode);
        clientAddressDBModel.setState(state);
        clientAddressDBModel.setCountry(country);
        clientAddressDBModel.setuDate(appUtils.getCurrentTimeStamp());
        clientAddressDBModel.setcDate(appUtils.getCurrentTimeStamp());
        clientAddressDBModel.setStatus(1);

        return clientAddressRepository.save(clientAddressDBModel);
    }

    public ClientAddressDBModel updateClientAddressService(long addressId,String street,String city,String zipCode,String state,String country) {

        Optional<ClientAddressDBModel> clientAddressDBModel = clientAddressRepository.findById(addressId);
        if (clientAddressDBModel.isPresent()){

            clientAddressDBModel.get().setStreet(street);
            clientAddressDBModel.get().setCity(city);
            clientAddressDBModel.get().setZipCode(zipCode);
            clientAddressDBModel.get().setState(state);
            clientAddressDBModel.get().setCountry(country);
            clientAddressDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientAddressDBModel.get().setStatus(1);

            return clientAddressRepository.save(clientAddressDBModel.get());
        }
        return null;
    }

    public ClientAddressDBModel removeClientAddressService(long addressId) {

        Optional<ClientAddressDBModel> clientAddressDBModel = clientAddressRepository.findById(addressId);
        if (clientAddressDBModel.isPresent()){
            clientAddressRepository.delete(clientAddressDBModel.get());
            return clientAddressDBModel.get();
        }
        return null;
    }




    public ClientEmailWSDTO fillClientEmailWSDTO(ClientEmailDBModel clientEmailDBModel) {

        ClientEmailWSDTO clientEmailWSDTO = new ClientEmailWSDTO();
        clientEmailWSDTO.setClientEmail(clientEmailDBModel);
        return clientEmailWSDTO;
    }


    public ClientEmailDBModel createClientEmailService(long clientId,String emailAddress) {

        ClientEmailDBModel clientEmailDBModel = new ClientEmailDBModel();
        clientEmailDBModel.setClientId(clientId);
        clientEmailDBModel.setEmailAddress(emailAddress);
        clientEmailDBModel.setuDate(appUtils.getCurrentTimeStamp());
        clientEmailDBModel.setcDate(appUtils.getCurrentTimeStamp());
        clientEmailDBModel.setStatus(1);

        return clientEmailRepository.save(clientEmailDBModel);
    }


    public ClientEmailDBModel updateClientEmailService(long emailId,String emailAddress) {

        Optional<ClientEmailDBModel> clientEmailDBModel = clientEmailRepository.findById(emailId);
        if (clientEmailDBModel.isPresent()){

            clientEmailDBModel.get().setEmailAddress(emailAddress);
            clientEmailDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientEmailDBModel.get().setStatus(1);

            return clientEmailRepository.save(clientEmailDBModel.get());
        }
        return null;
    }


    public ClientEmailDBModel removeClientEmailService(long emailId) {

        Optional<ClientEmailDBModel> clientEmailDBModel = clientEmailRepository.findById(emailId);
        if (clientEmailDBModel.isPresent()){
            clientEmailRepository.delete(clientEmailDBModel.get());
            return clientEmailDBModel.get();
        }
        return null;
    }



    public ClientPhoneWSDTO fillClientPhoneWSDTO(ClientPhoneDBModel clientPhoneDBModel) {

        ClientPhoneWSDTO clientPhoneWSDTO = new ClientPhoneWSDTO();
        clientPhoneWSDTO.setClientPhone(clientPhoneDBModel);
        return clientPhoneWSDTO;
    }


    public ClientPhoneDBModel createClientPhoneService(long clientId,String phoneNumber,String phoneCarrier) {

        ClientPhoneDBModel clientPhoneDBModel = new ClientPhoneDBModel();
        clientPhoneDBModel.setClientId(clientId);
        clientPhoneDBModel.setPhoneNumber(phoneNumber);
        clientPhoneDBModel.setPhoneCarrier(phoneCarrier);
        clientPhoneDBModel.setuDate(appUtils.getCurrentTimeStamp());
        clientPhoneDBModel.setcDate(appUtils.getCurrentTimeStamp());
        clientPhoneDBModel.setStatus(1);

        return clientPhoneRepository.save(clientPhoneDBModel);
    }

    public ClientPhoneDBModel updateClientPhoneService(long numberId,String phoneNumber,String phoneCarrier) {

        Optional<ClientPhoneDBModel> clientPhoneDBModel = clientPhoneRepository.findById(numberId);
        if (clientPhoneDBModel.isPresent()){
            clientPhoneDBModel.get().setPhoneNumber(phoneNumber);
            clientPhoneDBModel.get().setPhoneCarrier(phoneCarrier);
            clientPhoneDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientPhoneDBModel.get().setStatus(1);

            return clientPhoneRepository.save(clientPhoneDBModel.get());
        }
       return null;
    }

    public ClientPhoneDBModel removeClientPhoneService(long numberId) {

        Optional<ClientPhoneDBModel> clientPhoneDBModel = clientPhoneRepository.findById(numberId);
        if (clientPhoneDBModel.isPresent()){
            clientPhoneRepository.delete(clientPhoneDBModel.get());
            return clientPhoneDBModel.get();
        }
        return null;
    }



}
