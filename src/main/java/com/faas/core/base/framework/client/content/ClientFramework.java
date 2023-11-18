package com.faas.core.base.framework.client.content;

import com.faas.core.base.framework.client.details.ClientDetailsFramework;
import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.settings.ClientTypeDBModel;
import com.faas.core.base.model.db.utils.CityDBModel;
import com.faas.core.base.model.db.utils.CountryDBModel;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientsByStateWSDTO;
import com.faas.core.base.model.ws.client.content.dto.CreateClientRequestDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.client.settings.ClientTypeRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.remote.RemoteRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.utils.CityRepository;
import com.faas.core.base.repo.utils.CountryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ClientFramework {

    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsFramework clientDetailsFramework;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    ClientNoteRepository clientNoteRepository;

    @Autowired
    ClientTypeRepository clientTypeRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationEmailMessageRepository operationEmailMessageRepository;

    @Autowired
    OperationPushMessageRepository operationPushMessageRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    OperationSmsMessageRepository operationSmsMessageRepository;

    @Autowired
    OperationWappCallRepository operationWappCallRepository;

    @Autowired
    OperationWappMessageRepository operationWappMessageRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    AppUtils appUtils;


    public ClientsByStateWSDTO fillClientsWSDTO(Page<ClientDBModel> clientDBModelPage) {

        ClientsByStateWSDTO clientsByStateWSDTO = new ClientsByStateWSDTO();
        List<ClientWSDTO>clientWSDTOS = new ArrayList<>();
        for (int i=0;i<clientDBModelPage.getContent().size();i++){
            clientWSDTOS.add(fillClientWSDTO(clientDBModelPage.getContent().get(i)));
        }
        clientsByStateWSDTO.setClients(clientWSDTOS);
        clientsByStateWSDTO.setPagination(sessionHelper.createClientPaginationWSDTO(clientDBModelPage));

        return clientsByStateWSDTO;
    }


    public ClientsByStateWSDTO getClientsByStateService(long userId, String clientState, int reqPage, int reqSize) {

        if (clientState.equalsIgnoreCase(AppConstant.ALL_CLIENTS)){
            return fillClientsWSDTO(clientRepository.findAllByStatus(1,PageRequest.of(reqPage,reqSize))) ;
        }
        return fillClientsWSDTO(clientRepository.findAllByClientStateAndStatus(clientState,1,PageRequest.of(reqPage,reqSize)));
    }


    public ClientWSDTO fillClientWSDTO(ClientDBModel clientDBModel) {

        ClientWSDTO clientWSDTO = new ClientWSDTO();
        clientWSDTO.setClient(clientDBModel);
        return clientWSDTO;
    }


    public ClientDBModel createClientService(String clientName,String nationalId,String phoneNumber,String emailAddress,String clientCity,String clientCountry,long clientTypeId) {

        if (clientRepository.findByPhoneNumber(phoneNumber).isEmpty()){

            ClientDBModel clientDBModel = new ClientDBModel();
            clientDBModel.setClientName(clientName);
            clientDBModel.setNationalId(nationalId);
            clientDBModel.setPhoneNumber(phoneNumber);
            clientDBModel.setEmailAddress(emailAddress);
            clientDBModel.setClientCity(clientCity);
            clientDBModel.setClientCountry(clientCountry);

            Optional<ClientTypeDBModel> clientTypeDBModel = clientTypeRepository.findById(clientTypeId);
            if (clientTypeDBModel.isPresent()) {
                clientDBModel.setClientTypeId(clientTypeId);
                clientDBModel.setClientType(clientTypeDBModel.get().getClientType());
            }

            clientDBModel.setClientState(AppConstant.READY_CLIENT);
            clientDBModel.setuDate(appUtils.getCurrentTimeStamp());
            clientDBModel.setcDate(appUtils.getCurrentTimeStamp());
            clientDBModel.setStatus(1);

            ClientDBModel createdClient = clientRepository.save(clientDBModel);
            createClientDetailsService(createdClient);
            checkAndInsertCityAndCountry(createdClient);

            return createdClient;
        }
        return null;
    }


    public ClientDBModel createVolumeClientService(CreateClientRequestDTO createClientRequestDTO) {

        if (clientRepository.findByPhoneNumber(createClientRequestDTO.getPhoneNumber()).isEmpty()){

            ClientDBModel clientDBModel = new ClientDBModel();
            clientDBModel.setClientName(createClientRequestDTO.getClientName());
            clientDBModel.setNationalId(createClientRequestDTO.getNationalId());
            clientDBModel.setPhoneNumber(createClientRequestDTO.getPhoneNumber());
            clientDBModel.setEmailAddress(createClientRequestDTO.getEmailAddress());
            clientDBModel.setClientCity(createClientRequestDTO.getClientCity());
            clientDBModel.setClientCountry(createClientRequestDTO.getClientCountry());

            List<ClientTypeDBModel> clientTypeDBModels = clientTypeRepository.findByClientType(createClientRequestDTO.getClientType());
            if (!clientTypeDBModels.isEmpty()) {
                clientDBModel.setClientTypeId(clientTypeDBModels.get(0).getId());
                clientDBModel.setClientType(clientTypeDBModels.get(0).getClientType());
            }

            clientDBModel.setClientState(AppConstant.READY_CLIENT);
            clientDBModel.setuDate(appUtils.getCurrentTimeStamp());
            clientDBModel.setcDate(appUtils.getCurrentTimeStamp());
            clientDBModel.setStatus(1);

            ClientDBModel createdClient = clientRepository.save(clientDBModel);
            createClientDetailsService(createdClient);
            checkAndInsertCityAndCountry(createdClient);

            return createdClient;
        }
        return null;
    }


    public void checkAndInsertCityAndCountry(ClientDBModel clientDBModel){

        if (!cityRepository.existsByCityAndCountry(clientDBModel.getClientCity().toUpperCase(),clientDBModel.getClientCountry().toUpperCase())){

            CityDBModel cityDBModel = new CityDBModel();
            cityDBModel.setCity(clientDBModel.getClientCity().toUpperCase());
            cityDBModel.setCountry(clientDBModel.getClientCountry().toUpperCase());
            cityDBModel.setuDate(appUtils.getCurrentTimeStamp());
            cityDBModel.setcDate(appUtils.getCurrentTimeStamp());
            cityDBModel.setStatus(1);

            cityRepository.save(cityDBModel);
        }
        if (!countryRepository.existsByCountry(clientDBModel.getClientCountry().toUpperCase())){

            CountryDBModel countryDBModel = new CountryDBModel();
            countryDBModel.setCountry(clientDBModel.getClientCountry().toUpperCase());
            countryDBModel.setuDate(appUtils.getCurrentTimeStamp());
            countryDBModel.setcDate(appUtils.getCurrentTimeStamp());
            countryDBModel.setStatus(1);

            countryRepository.save(countryDBModel);
        }

    }


    public void createClientDetailsService(ClientDBModel clientDBModel){

        if (clientDBModel.getPhoneNumber() != null && !clientDBModel.getPhoneNumber().equalsIgnoreCase("")){
            clientDetailsFramework.createClientPhoneService(clientDBModel.getId(),clientDBModel.getPhoneNumber(),"UNKNOWN");
        }
        if (clientDBModel.getEmailAddress() != null && !clientDBModel.getEmailAddress().equalsIgnoreCase("")){
            clientDetailsFramework.createClientEmailService(clientDBModel.getId(),clientDBModel.getEmailAddress());
        }
    }


    public ClientDBModel updateClientService(long clientId,String clientName,String nationalId,String phoneNumber,String emailAddress,String clientCity,String clientCountry,long clientTypeId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (clientDBModel.isPresent()) {

            clientDBModel.get().setClientName(clientName);
            clientDBModel.get().setNationalId(nationalId);
            clientDBModel.get().setPhoneNumber(phoneNumber);
            clientDBModel.get().setEmailAddress(emailAddress);
            clientDBModel.get().setClientCity(clientCity);
            clientDBModel.get().setClientCountry(clientCountry);
            Optional<ClientTypeDBModel> clientTypeDBModel = clientTypeRepository.findById(clientTypeId);
            if (clientTypeDBModel.isPresent()) {
                clientDBModel.get().setClientTypeId(clientTypeId);
                clientDBModel.get().setClientType(clientTypeDBModel.get().getClientType());
            }
            clientDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            clientDBModel.get().setcDate(appUtils.getCurrentTimeStamp());
            clientDBModel.get().setStatus(1);

            return clientRepository.save(clientDBModel.get());
        }
        return null;
    }


    public void removeClientService(long clientId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (clientDBModel.isPresent()){

            clientRepository.delete(clientDBModel.get());
            clientDataRepository.deleteAll(clientDataRepository.findByClientId(clientId));
            clientAddressRepository.deleteAll(clientAddressRepository.findByClientId(clientId));
            clientPhoneRepository.deleteAll(clientPhoneRepository.findByClientId(clientId));
            clientEmailRepository.deleteAll(clientEmailRepository.findByClientId(clientId));
            remoteRepository.deleteAll(remoteRepository.findByClientId(clientId));
            clientNoteRepository.deleteAll(clientNoteRepository.findByClientId(clientId));
            sessionRepository.deleteAll(sessionRepository.findByClientId(clientId));
            operationRepository.deleteAll(operationRepository.findByClientId(clientId));
            operationEmailMessageRepository.deleteAll(operationEmailMessageRepository.findByClientId(clientId));
            operationPushMessageRepository.deleteAll(operationPushMessageRepository.findByClientId(clientId));
            operationSipCallRepository.deleteAll(operationSipCallRepository.findByClientId(clientId));
            operationSmsMessageRepository.deleteAll(operationSmsMessageRepository.findByClientId(clientId));
            operationWappCallRepository.deleteAll(operationWappCallRepository.findByClientId(clientId));
            operationWappMessageRepository.deleteAll(operationWappMessageRepository.findByClientId(clientId));
        }
    }






}
