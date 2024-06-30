package com.faas.core.utility.helpers.client;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.ClientDetailsDBModel;
import com.faas.core.base.model.db.client.details.dao.ClientAddressDAO;
import com.faas.core.base.model.db.client.details.dao.ClientEmailDAO;
import com.faas.core.base.model.db.client.details.dao.ClientPhoneDAO;
import com.faas.core.base.model.ws.campaign.details.client.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.agent.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientDetailsRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.remote.app.RemoteAppRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientHelpers {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    RemoteAppRepository remoteAppRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    PushRepository pushRepository;

    @Autowired
    SipCallRepository sipCallRepository;

    @Autowired
    SmsRepository SmsRepository;

    @Autowired
    WappCallRepository wappCallRepository;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    AppUtils appUtils;


    public ClientDetailsDBModel createClientDetails(ClientDBModel clientDBModel){

        if (!clientDetailsRepository.existsByClientId(clientDBModel.getId())){

            ClientDetailsDBModel clientDetailsDBModel = new ClientDetailsDBModel();
            clientDetailsDBModel.setClientId(clientDBModel.getId());
            clientDetailsDBModel.setClientNotes(new ArrayList<>());
            clientDetailsDBModel.setClientDatas(new ArrayList<>());

            if (clientDBModel.getPhoneNumber() != null){
                List<ClientPhoneDAO>clientPhoneDAOS = new ArrayList<>();
                clientPhoneDAOS.add(createClientPhoneDAO(clientDBModel.getPhoneNumber(),AppConstant.NONE,AppConstant.MAIN_TYPE));
                clientDetailsDBModel.setClientPhones(clientPhoneDAOS);
            }else {
                clientDetailsDBModel.setClientPhones(new ArrayList<>());
            }

            if (clientDBModel.getEmailAddress() != null){
                List<ClientEmailDAO>clientEmailDAOS = new ArrayList<>();
                clientEmailDAOS.add(createClientEmailDAO(clientDBModel.getEmailAddress(),AppConstant.MAIN_TYPE));
                clientDetailsDBModel.setClientEmails(clientEmailDAOS);
            }else {
                clientDetailsDBModel.setClientEmails(new ArrayList<>());
            }

            if (clientDBModel.getClientCountry() != null){
                List<ClientAddressDAO>clientAddressDAOS = new ArrayList<>();
                clientAddressDAOS.add(createClientAddressDAO(AppConstant.NONE,clientDBModel.getClientCity(),AppConstant.NONE,AppConstant.NONE,clientDBModel.getClientCountry(),AppConstant.MAIN_TYPE));
                clientDetailsDBModel.setClientAddresses(clientAddressDAOS);
            }else {
                clientDetailsDBModel.setClientAddresses(new ArrayList<>());
            }
            clientDetailsDBModel.setuDate(appUtils.getCurrentTimeStamp());
            clientDetailsDBModel.setcDate(appUtils.getCurrentTimeStamp());
            clientDetailsDBModel.setStatus(1);

            return clientDetailsRepository.save(clientDetailsDBModel);
        }
        return null;
    }


    public ClientPhoneDAO createClientPhoneDAO(String phoneNumber,String phoneCarrier,String phoneType){

        ClientPhoneDAO clientPhoneDAO = new ClientPhoneDAO();
        clientPhoneDAO.setId(appUtils.generateUUID());
        clientPhoneDAO.setPhoneNumber(phoneNumber);
        clientPhoneDAO.setPhoneCarrier(phoneCarrier);
        clientPhoneDAO.setPhoneType(phoneType);
        clientPhoneDAO.setcDate(appUtils.getCurrentTimeStamp());
        clientPhoneDAO.setStatus(1);

        return clientPhoneDAO;
    }


    public ClientEmailDAO createClientEmailDAO(String emailAddress,String emailType){

        ClientEmailDAO clientEmailDAO = new ClientEmailDAO();
        clientEmailDAO.setId(appUtils.generateUUID());
        clientEmailDAO.setEmailAddress(emailAddress);
        clientEmailDAO.setEmailType(emailType);
        clientEmailDAO.setcDate(appUtils.getCurrentTimeStamp());
        clientEmailDAO.setStatus(1);

        return clientEmailDAO;
    }


    public ClientAddressDAO createClientAddressDAO(String street,String city,String zipCode,String state,String country,String addressType){

        ClientAddressDAO clientAddressDAO = new ClientAddressDAO();
        clientAddressDAO.setId(appUtils.generateUUID());
        clientAddressDAO.setStreet(street);
        clientAddressDAO.setCity(city);
        clientAddressDAO.setZipCode(zipCode);
        clientAddressDAO.setState(state);
        clientAddressDAO.setCountry(country);
        clientAddressDAO.setAddressType(addressType);
        clientAddressDAO.setcDate(appUtils.getCurrentTimeStamp());
        clientAddressDAO.setStatus(1);

        return clientAddressDAO;
    }


    public ClientDBModel deleteClient(ClientDBModel clientDBModel){

        operationRepository.deleteAll(operationRepository.findByClientId(clientDBModel.getId()));
        emailRepository.deleteAll(emailRepository.findByClientId(clientDBModel.getId()));
        pushRepository.deleteAll(pushRepository.findByClientId(clientDBModel.getId()));
        sipCallRepository.deleteAll(sipCallRepository.findByClientId(clientDBModel.getId()));
        SmsRepository.deleteAll(SmsRepository.findByClientId(clientDBModel.getId()));
        wappCallRepository.deleteAll(wappCallRepository.findByClientId(clientDBModel.getId()));
        wappMessageRepository.deleteAll(wappMessageRepository.findByClientId(clientDBModel.getId()));
        remoteAppRepository.deleteAll(remoteAppRepository.findByClientId(clientDBModel.getId()));
        clientDetailsRepository.deleteAll(clientDetailsRepository.findByClientId(clientDBModel.getId()));
        clientRepository.delete(clientDBModel);

        return clientDBModel;
    }


    public CampaignClientWSDTO mapCampaignClientWSDTO(Page<ClientDBModel>clientPageModels){

        CampaignClientWSDTO campaignClientWSDTO = new CampaignClientWSDTO();
        List<ClientWSDTO>clientWSDTOS = new ArrayList<>();
        List<ClientDBModel> clientDBModels = clientPageModels.getContent();
        for (ClientDBModel clientDBModel : clientDBModels) {
            clientWSDTOS.add(new ClientWSDTO(clientDBModel));
        }
        campaignClientWSDTO.setClients(clientWSDTOS);
        campaignClientWSDTO.setPagination(createClientPaginationWSDTO(clientPageModels));

        return campaignClientWSDTO;
    }


    public PaginationWSDTO createClientPaginationWSDTO(Page<ClientDBModel> clientPage){

        PaginationWSDTO paginationWSDTO = new PaginationWSDTO();
        paginationWSDTO.setPageSize(clientPage.getPageable().getPageSize());
        paginationWSDTO.setPageNumber(clientPage.getPageable().getPageNumber());
        paginationWSDTO.setTotalPage(clientPage.getTotalPages());
        paginationWSDTO.setTotalElements(clientPage.getTotalElements());

        return paginationWSDTO;
    }


}
