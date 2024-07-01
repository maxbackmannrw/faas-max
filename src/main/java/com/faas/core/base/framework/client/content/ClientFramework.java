package com.faas.core.base.framework.client.content;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.settings.ClientTypeDBModel;
import com.faas.core.base.model.db.utils.CityDBModel;
import com.faas.core.base.model.db.utils.CountryDBModel;
import com.faas.core.base.model.ws.client.content.dto.AllClientWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientListWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.model.ws.client.content.dto.CreateClientRequestDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.client.settings.ClientTypeRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.utils.CityRepository;
import com.faas.core.base.repo.utils.CountryRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.client.ClientHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClientFramework {


    @Autowired
    ClientHelpers clientHelpers;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    ClientTypeRepository clientTypeRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationEmailRepository operationEmailRepository;

    @Autowired
    OperationPushRepository operationPushRepository;

    @Autowired
    OperationSipCallRepository operationSipCallRepository;

    @Autowired
    OperationSmsRepository OperationSmsRepository;

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


    public ClientWSDTO fillClientWSDTO(ClientDBModel clientDBModel) {

        ClientWSDTO clientWSDTO = new ClientWSDTO();
        clientWSDTO.setClient(clientDBModel);

        return clientWSDTO;
    }

    public ClientListWSDTO fillClientListWSDTO(Page<ClientDBModel> clientDBModelPage) {

        ClientListWSDTO clientListWSDTO = new ClientListWSDTO();
        List<ClientWSDTO>clientWSDTOS = new ArrayList<>();
        for (int i=0;i<clientDBModelPage.getContent().size();i++){
            clientWSDTOS.add(fillClientWSDTO(clientDBModelPage.getContent().get(i)));
        }
        clientListWSDTO.setClients(clientWSDTOS);
        clientListWSDTO.setPagination(clientHelpers.createClientPaginationWSDTO(clientDBModelPage));

        return clientListWSDTO;
    }



    public AllClientWSDTO getAllClientsService(long userId, int reqPage, int reqSize) {

        AllClientWSDTO allClientWSDTO = new AllClientWSDTO();
        ClientListWSDTO clients = getClientsService(userId,AppConstant.CLIENTS,reqPage,reqSize);
        if (clients != null){
            allClientWSDTO.setClients(clients);
        }
        ClientListWSDTO readyClients = getClientsService(userId,AppConstant.READY_CLIENT,reqPage,reqSize);
        if (readyClients != null){
            allClientWSDTO.setReadyClients(readyClients);
        }
        ClientListWSDTO busyClients = getClientsService(userId,AppConstant.BUSY_CLIENT,reqPage,reqSize);
        if (busyClients != null){
            allClientWSDTO.setBusyClients(busyClients);
        }
        return allClientWSDTO;
    }

    public ClientListWSDTO getClientsService(long userId, String clientState, int reqPage, int reqSize) {

        if (clientState.equalsIgnoreCase(AppConstant.CLIENTS)){
            return fillClientListWSDTO(clientRepository.findAllByStatus(1,PageRequest.of(reqPage,reqSize))) ;
        }
        return fillClientListWSDTO(clientRepository.findAllByClientStateAndStatus(clientState,1,PageRequest.of(reqPage,reqSize)));
    }

    public ClientWSDTO getClientService(long userId,long clientId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (clientDBModel.isPresent()){
            return fillClientWSDTO(clientDBModel.get());
        }
        return null;
    }


    public ClientWSDTO createClientService(String clientName,String nationalId,String phoneNumber,String emailAddress,String clientCity,String clientCountry,long clientTypeId) {

        Optional<ClientTypeDBModel> clientTypeDBModel = clientTypeRepository.findById(clientTypeId);
        if (clientRepository.findByPhoneNumber(phoneNumber).isEmpty() && clientTypeDBModel.isPresent()){

            ClientDBModel clientDBModel = new ClientDBModel();
            clientDBModel.setClientName(clientName);
            clientDBModel.setNationalId(nationalId);
            clientDBModel.setPhoneNumber(phoneNumber);
            clientDBModel.setEmailAddress(emailAddress);
            clientDBModel.setClientCity(clientCity.toUpperCase());
            clientDBModel.setClientCountry(clientCountry.toUpperCase());
            clientDBModel.setClientTypeId(clientTypeId);
            clientDBModel.setClientType(clientTypeDBModel.get().getClientType());
            clientDBModel.setClientState(AppConstant.READY_CLIENT);
            clientDBModel.setuDate(appUtils.getCurrentTimeStamp());
            clientDBModel.setcDate(appUtils.getCurrentTimeStamp());
            clientDBModel.setStatus(1);

            clientDBModel = clientRepository.save(clientDBModel);
            clientHelpers.createClientDetails(clientDBModel);
            checkAndInsertCityAndCountry(clientDBModel);

            return fillClientWSDTO(clientDBModel);
        }
        return null;
    }

    public List<ClientWSDTO> createVolumeClientService(List<CreateClientRequestDTO> clientRequestDTOS) {

        List<ClientWSDTO> clientWSDTOS = new ArrayList<>();
        for (CreateClientRequestDTO clientRequestDTO : clientRequestDTOS) {
            List<ClientTypeDBModel> clientTypeDBModels = clientTypeRepository.findByClientType(clientRequestDTO.getClientType());
            if (clientRepository.findByPhoneNumber(clientRequestDTO.getPhoneNumber()).isEmpty() && !clientTypeDBModels.isEmpty()) {

                ClientDBModel clientDBModel = new ClientDBModel();
                clientDBModel.setClientName(clientRequestDTO.getClientName());
                clientDBModel.setNationalId(clientRequestDTO.getNationalId());
                clientDBModel.setPhoneNumber(clientRequestDTO.getPhoneNumber());
                clientDBModel.setEmailAddress(clientRequestDTO.getEmailAddress());
                clientDBModel.setClientCity(clientRequestDTO.getClientCity().toUpperCase());
                clientDBModel.setClientCountry(clientRequestDTO.getClientCountry().toUpperCase());
                clientDBModel.setClientTypeId(clientTypeDBModels.get(0).getId());
                clientDBModel.setClientType(clientTypeDBModels.get(0).getClientType());
                clientDBModel.setClientState(AppConstant.READY_CLIENT);
                clientDBModel.setuDate(appUtils.getCurrentTimeStamp());
                clientDBModel.setcDate(appUtils.getCurrentTimeStamp());
                clientDBModel.setStatus(1);

                clientDBModel = clientRepository.save(clientDBModel);
                clientHelpers.createClientDetails(clientDBModel);
                checkAndInsertCityAndCountry(clientDBModel);

                clientWSDTOS.add(fillClientWSDTO(clientDBModel));
            }
        }
        return clientWSDTOS;
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



    public ClientWSDTO updateClientService(long clientId,String clientName,String nationalId,String phoneNumber,String emailAddress,String clientCity,String clientCountry,long clientTypeId) {

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

            return fillClientWSDTO(clientRepository.save(clientDBModel.get()));
        }
        return null;
    }

    public ClientWSDTO removeClientService(long clientId) {

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientId);
        if (clientDBModel.isPresent()){
            return fillClientWSDTO(clientHelpers.deleteClient(clientDBModel.get()));
        }
        return null;
    }






}
