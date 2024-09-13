package com.faas.core.base.framework.client.details.content;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.ClientDetailsDBModel;
import com.faas.core.base.model.db.client.details.dao.ClientAddressDAO;
import com.faas.core.base.model.db.client.details.dao.ClientDataDAO;
import com.faas.core.base.model.db.client.details.dao.ClientEmailDAO;
import com.faas.core.base.model.db.client.details.dao.ClientPhoneDAO;
import com.faas.core.base.model.db.utilz.DataTypeDBModel;
import com.faas.core.base.model.ws.client.details.content.dto.*;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.remoteapp.RemoteAppRepository;
import com.faas.core.base.repo.utilz.DataTypeRepository;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClientDetailsFramework {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    RemoteAppRepository remoteAppRepository;

    @Autowired
    AppUtils appUtils;


    public ClientDetailsWSDTO getClientDetailsService(long userId,long clientId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (clientDBModel.isPresent() && !clientDetailsDBModels.isEmpty()){

            ClientDetailsWSDTO clientDetailsWSDTO = new ClientDetailsWSDTO();
            clientDetailsWSDTO.setClient(clientDBModel.get());
            clientDetailsWSDTO.setClientDetails(clientDetailsDBModels.get(0));

            return clientDetailsWSDTO;
        }
        return null;
    }



    public List<ClientDataWSDTO> getClientDatasService(long userId,long clientId) {

        List<ClientDataWSDTO> clientDataWSDTOS = new ArrayList<>();
        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientDatas() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientDatas().size();i++){
                clientDataWSDTOS.add(new ClientDataWSDTO(clientDetailsDBModels.get(0).getClientDatas().get(i)));
            }
        }
        return clientDataWSDTOS;
    }


    public ClientDataWSDTO getClientDataService(long userId,long clientId,String dataId) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientDatas() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientDatas().size();i++){
                if (clientDetailsDBModels.get(0).getClientDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new ClientDataWSDTO(clientDetailsDBModels.get(0).getClientDatas().get(i));
                }
            }
        }
        return null;
    }


    public ClientDataWSDTO createClientDataService(long userId,long clientId,long typeId,String value) {

        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (dataTypeDBModel.isPresent() && !clientDetailsDBModels.isEmpty()){

            ClientDataDAO clientDataDAO = new ClientDataDAO();
            clientDataDAO.setDataId(appUtils.generateUUID());
            clientDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            clientDataDAO.setValue(value);
            clientDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            clientDataDAO.setStatus(1);

            if (clientDetailsDBModels.get(0).getClientDatas() == null){
                List<ClientDataDAO>clientDataDAOS = new ArrayList<>();
                clientDataDAOS.add(clientDataDAO);
                clientDetailsDBModels.get(0).setClientDatas(clientDataDAOS);
            }else {
                clientDetailsDBModels.get(0).getClientDatas().add(clientDataDAO);
            }
            clientDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            clientDetailsRepository.save(clientDetailsDBModels.get(0));

            return new ClientDataWSDTO(clientDataDAO);
        }
        return null;
    }


    public ClientDataWSDTO updateClientDataService(long userId,long clientId,String dataId,long typeId,String value) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientDatas() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientDatas().size();i++){
                if (clientDetailsDBModels.get(0).getClientDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    clientDetailsDBModels.get(0).getClientDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    clientDetailsDBModels.get(0).getClientDatas().get(i).setValue(value);
                    clientDetailsDBModels.get(0).getClientDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    clientDetailsDBModels.get(0).getClientDatas().get(i).setStatus(1);
                    clientDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    clientDetailsRepository.save(clientDetailsDBModels.get(0));

                    return new ClientDataWSDTO(clientDetailsDBModels.get(0).getClientDatas().get(i));
                }
            }
        }
        return null;
    }


    public ClientDataWSDTO removeClientDataService(long userId,long clientId,String dataId) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientDatas() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientDatas().size();i++){
                if (clientDetailsDBModels.get(0).getClientDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    ClientDataDAO clientDataDAO = clientDetailsDBModels.get(0).getClientDatas().get(i);
                    clientDetailsDBModels.get(0).getClientDatas().remove(clientDataDAO);
                    clientDetailsDBModels.remove(0).setuDate(appUtils.getCurrentTimeStamp());
                    clientDetailsRepository.save(clientDetailsDBModels.get(0));

                    return new ClientDataWSDTO(clientDataDAO);
                }
            }
        }
        return null;
    }



    public List<ClientAddressWSDTO> getClientAddressesService(long userId,long clientId) {

        List<ClientAddressWSDTO> clientAddressWSDTOS = new ArrayList<>();
        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientAddresses() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientAddresses().size();i++){
                clientAddressWSDTOS.add(new ClientAddressWSDTO(clientDetailsDBModels.get(0).getClientAddresses().get(i)));
            }
        }
        return clientAddressWSDTOS;
    }


    public ClientAddressWSDTO getClientAddressService(long userId,long clientId,String addressId) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientAddresses() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientAddresses().size();i++){
                if (clientDetailsDBModels.get(0).getClientAddresses().get(i).getId().equalsIgnoreCase(addressId)){
                    return new ClientAddressWSDTO(clientDetailsDBModels.get(0).getClientAddresses().get(i));
                }
            }
        }
        return null;
    }


    public ClientAddressWSDTO createClientAddressService(long userId,long clientId,String street,String city,String zipCode,String state,String country) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty()){

            ClientAddressDAO clientAddressDAO = new ClientAddressDAO();
            clientAddressDAO.setId(appUtils.generateUUID());
            clientAddressDAO.setStreet(street);
            clientAddressDAO.setCity(city);
            clientAddressDAO.setZipCode(zipCode);
            clientAddressDAO.setState(state);
            clientAddressDAO.setCountry(country);
            clientAddressDAO.setcDate(appUtils.getCurrentTimeStamp());
            clientAddressDAO.setStatus(1);

            if (clientDetailsDBModels.get(0).getClientAddresses() == null){
                List<ClientAddressDAO>clientAddressDAOS = new ArrayList<>();
                clientAddressDAOS.add(clientAddressDAO);
                clientDetailsDBModels.get(0).setClientAddresses(clientAddressDAOS);

            }else {
                clientDetailsDBModels.get(0).getClientAddresses().add(clientAddressDAO);
            }
            clientDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            clientDetailsRepository.save(clientDetailsDBModels.get(0));

            return new ClientAddressWSDTO(clientAddressDAO);
        }
        return null;
    }


    public ClientAddressWSDTO updateClientAddressService(long userId,long clientId,String addressId,String street,String city,String zipCode,String state,String country) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientAddresses() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientAddresses().size();i++){
                if (clientDetailsDBModels.get(0).getClientAddresses().get(i).getId().equalsIgnoreCase(addressId)){

                    clientDetailsDBModels.get(0).getClientAddresses().get(i).setStreet(street);
                    clientDetailsDBModels.get(0).getClientAddresses().get(i).setCity(city);
                    clientDetailsDBModels.get(0).getClientAddresses().get(i).setZipCode(zipCode);
                    clientDetailsDBModels.get(0).getClientAddresses().get(i).setState(state);
                    clientDetailsDBModels.get(0).getClientAddresses().get(i).setCountry(country);
                    clientDetailsDBModels.get(0).getClientAddresses().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    clientDetailsDBModels.get(0).getClientAddresses().get(i).setStatus(1);
                    clientDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    clientDetailsRepository.save(clientDetailsDBModels.get(0));

                    return new ClientAddressWSDTO(clientDetailsDBModels.get(0).getClientAddresses().get(i));
                }
            }
        }
        return null;
    }


    public ClientAddressWSDTO removeClientAddressService(long userId,long clientId,String addressId) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientAddresses() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientAddresses().size();i++){
                if (clientDetailsDBModels.get(0).getClientAddresses().get(i).getId().equalsIgnoreCase(addressId)){
                    ClientAddressDAO clientAddressDAO = clientDetailsDBModels.get(0).getClientAddresses().get(i);
                    clientDetailsDBModels.get(0).getClientAddresses().remove(clientAddressDAO);
                    clientDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    clientDetailsRepository.save(clientDetailsDBModels.get(0));

                    return new ClientAddressWSDTO(clientAddressDAO);
                }
            }
        }
        return null;
    }



    public List<ClientEmailWSDTO> getClientEmailsService(long userId,long clientId) {

        List<ClientEmailWSDTO> clientEmailWSDTOS = new ArrayList<>();
        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientEmails() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientEmails().size();i++){
                clientEmailWSDTOS.add(new ClientEmailWSDTO(clientDetailsDBModels.get(0).getClientEmails().get(i)));
            }
        }
        return clientEmailWSDTOS;
    }


    public ClientEmailWSDTO getClientEmailService(long userId,long clientId,String emailId) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientEmails() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientEmails().size();i++){
                if (clientDetailsDBModels.get(0).getClientEmails().get(i).getId().equalsIgnoreCase(emailId)){
                    return new ClientEmailWSDTO(clientDetailsDBModels.get(0).getClientEmails().get(i));
                }
            }
        }
        return null;
    }


    public ClientEmailWSDTO createClientEmailService(long userId,long clientId,String emailAddress) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty()){

            ClientEmailDAO clientEmailDAO = new ClientEmailDAO();
            clientEmailDAO.setId(appUtils.generateUUID());
            clientEmailDAO.setEmailAddress(emailAddress);
            clientEmailDAO.setcDate(appUtils.getCurrentTimeStamp());
            clientEmailDAO.setStatus(1);

            if (clientDetailsDBModels.get(0).getClientEmails() == null){
                List<ClientEmailDAO>clientEmailDAOS = new ArrayList<>();
                clientEmailDAOS.add(clientEmailDAO);
                clientDetailsDBModels.get(0).setClientEmails(clientEmailDAOS);
            }else {
                clientDetailsDBModels.get(0).getClientEmails().add(clientEmailDAO);
            }
            clientDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            clientDetailsRepository.save(clientDetailsDBModels.get(0));

            return new ClientEmailWSDTO(clientEmailDAO);
        }
        return null;
    }


    public ClientEmailWSDTO updateClientEmailService(long userId,long clientId,String emailId,String emailAddress) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientEmails() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientEmails().size();i++){
                if (clientDetailsDBModels.get(0).getClientEmails().get(i).getId().equalsIgnoreCase(emailId)){

                    clientDetailsDBModels.get(0).getClientEmails().get(i).setEmailAddress(emailAddress);
                    clientDetailsDBModels.get(0).getClientEmails().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    clientDetailsDBModels.get(0).getClientEmails().get(i).setStatus(1);
                    clientDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    clientDetailsRepository.save(clientDetailsDBModels.get(0));

                    return new ClientEmailWSDTO(clientDetailsDBModels.get(0).getClientEmails().get(i));
                }
            }
        }
        return null;
    }


    public ClientEmailWSDTO removeClientEmailService(long userId,long clientId,String emailId) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientEmails() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientEmails().size();i++){
                if (clientDetailsDBModels.get(0).getClientEmails().get(i).getId().equalsIgnoreCase(emailId)){

                    ClientEmailDAO clientEmailDAO = clientDetailsDBModels.get(0).getClientEmails().get(i);
                    clientDetailsDBModels.get(0).getClientEmails().remove(clientEmailDAO);
                    clientDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    clientDetailsRepository.save(clientDetailsDBModels.get(0));

                    return new ClientEmailWSDTO(clientEmailDAO);
                }
            }
        }
        return null;
    }



    public List<ClientPhoneWSDTO> getClientPhonesService(long userId,long clientId) {

        List<ClientPhoneWSDTO> clientPhoneWSDTOS = new ArrayList<>();
        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientPhones().size();i++){
                clientPhoneWSDTOS.add(new ClientPhoneWSDTO(clientDetailsDBModels.get(0).getClientPhones().get(i)));
            }
        }
        return clientPhoneWSDTOS;
    }


    public ClientPhoneWSDTO getClientPhoneService(long userId,long clientId,String numberId) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientPhones().size();i++){
                if (clientDetailsDBModels.get(0).getClientPhones().get(i).getId().equalsIgnoreCase(numberId)){
                    return new ClientPhoneWSDTO(clientDetailsDBModels.get(0).getClientPhones().get(i));
                }
            }
        }
        return null;
    }


    public ClientPhoneWSDTO createClientPhoneService(long userId,long clientId,String phoneNumber,String phoneCarrier) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty()){

            ClientPhoneDAO clientPhoneDAO = new ClientPhoneDAO();
            clientPhoneDAO.setId(appUtils.generateUUID());
            clientPhoneDAO.setPhoneNumber(phoneNumber);
            clientPhoneDAO.setPhoneCarrier(phoneCarrier);
            clientPhoneDAO.setcDate(appUtils.getCurrentTimeStamp());
            clientPhoneDAO.setStatus(1);

            if (clientDetailsDBModels.get(0).getClientPhones() == null){
                List<ClientPhoneDAO>clientPhoneDAOS = new ArrayList<>();
                clientPhoneDAOS.add(clientPhoneDAO);
                clientDetailsDBModels.get(0).setClientPhones(clientPhoneDAOS);
            }else {
                clientDetailsDBModels.get(0).getClientPhones().add(clientPhoneDAO);
            }
            clientDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            clientDetailsRepository.save(clientDetailsDBModels.get(0));

            return new ClientPhoneWSDTO(clientPhoneDAO);
        }
        return null;
    }


    public ClientPhoneWSDTO updateClientPhoneService(long userId,long clientId,String numberId,String phoneNumber,String phoneCarrier) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientPhones().size();i++){
                if (clientDetailsDBModels.get(0).getClientPhones().get(i).getId().equalsIgnoreCase(numberId)){

                    clientDetailsDBModels.get(0).getClientPhones().get(i).setPhoneNumber(phoneNumber);
                    clientDetailsDBModels.get(0).getClientPhones().get(i).setPhoneCarrier(phoneCarrier);
                    clientDetailsDBModels.get(0).getClientPhones().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    clientDetailsDBModels.get(0).getClientPhones().get(i).setStatus(1);
                    clientDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    clientDetailsRepository.save(clientDetailsDBModels.get(0));

                    return new ClientPhoneWSDTO(clientDetailsDBModels.get(0).getClientPhones().get(i));
                }
            }
        }
        return null;
    }


    public ClientPhoneWSDTO removeClientPhoneService(long userId,long clientId,String numberId) {

        List<ClientDetailsDBModel> clientDetailsDBModels = clientDetailsRepository.findByClientId(clientId);
        if (!clientDetailsDBModels.isEmpty() && clientDetailsDBModels.get(0).getClientPhones() != null){
            for (int i=0;i<clientDetailsDBModels.get(0).getClientPhones().size();i++){
                if (clientDetailsDBModels.get(0).getClientPhones().get(i).getId().equalsIgnoreCase(numberId)){

                    ClientPhoneDAO clientPhoneDAO = clientDetailsDBModels.get(0).getClientPhones().get(i);
                    clientDetailsDBModels.get(0).getClientPhones().remove(clientPhoneDAO);
                    clientDetailsDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    clientDetailsRepository.save(clientDetailsDBModels.get(0));

                    return new ClientPhoneWSDTO(clientPhoneDAO);
                }
            }
        }
        return null;
    }



}
