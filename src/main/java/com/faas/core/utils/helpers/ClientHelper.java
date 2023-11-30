package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.ws.campaign.details.client.content.dto.CampaignClientWSDTO;
import com.faas.core.base.model.ws.client.content.dto.ClientWSDTO;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.channel.*;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.remote.client.ClientRemoteRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientHelper {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientNoteRepository clientNoteRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    ClientRemoteRepository clientRemoteRepository;

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
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public ClientDBModel deleteClient(ClientDBModel clientDBModel){

        clientDataRepository.deleteAll(clientDataRepository.findByClientId(clientDBModel.getId()));
        clientAddressRepository.deleteAll(clientAddressRepository.findByClientId(clientDBModel.getId()));
        clientPhoneRepository.deleteAll(clientPhoneRepository.findByClientId(clientDBModel.getId()));
        clientEmailRepository.deleteAll(clientEmailRepository.findByClientId(clientDBModel.getId()));
        clientRemoteRepository.deleteAll(clientRemoteRepository.findByClientId(clientDBModel.getId()));
        clientNoteRepository.deleteAll(clientNoteRepository.findByClientId(clientDBModel.getId()));
        sessionRepository.deleteAll(sessionRepository.findByClientId(clientDBModel.getId()));
        operationRepository.deleteAll(operationRepository.findByClientId(clientDBModel.getId()));
        operationEmailMessageRepository.deleteAll(operationEmailMessageRepository.findByClientId(clientDBModel.getId()));
        operationPushMessageRepository.deleteAll(operationPushMessageRepository.findByClientId(clientDBModel.getId()));
        operationSipCallRepository.deleteAll(operationSipCallRepository.findByClientId(clientDBModel.getId()));
        operationSmsMessageRepository.deleteAll(operationSmsMessageRepository.findByClientId(clientDBModel.getId()));
        operationWappCallRepository.deleteAll(operationWappCallRepository.findByClientId(clientDBModel.getId()));
        operationWappMessageRepository.deleteAll(operationWappMessageRepository.findByClientId(clientDBModel.getId()));
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
