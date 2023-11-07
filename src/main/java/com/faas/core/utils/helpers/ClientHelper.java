package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.details.ClientRemoteDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientManagerRemoteWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientRemoteListWSDTO;
import com.faas.core.base.model.ws.manager.client.content.dto.ClientRemoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientRemoteRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientHelper {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientRemoteRepository clientRemoteRepository;

    @Autowired
    AppUtils appUtils;


    public ClientRemoteListWSDTO getClientRemoteListWSDTO(Page<ClientDBModel> clientDBModelPage){

        ClientRemoteListWSDTO clientRemoteList = new ClientRemoteListWSDTO();

        clientRemoteList.setPagination(createRemotePagination(clientDBModelPage));
        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();
        for (int i=0;i<clientDBModelPage.getContent().size();i++){
            ClientRemoteWSDTO clientRemoteWSDTO = getClientRemoteWSDTO(clientDBModelPage.getContent().get(i));
            if (clientRemoteWSDTO != null){
                clientRemoteWSDTOS.add(clientRemoteWSDTO);
            }
        }
        clientRemoteList.setClientRemotes(clientRemoteWSDTOS);

        return clientRemoteList;
    }

    public ClientRemoteWSDTO getClientRemoteWSDTO(ClientDBModel clientDBModel){

        ClientRemoteWSDTO clientRemoteWSDTO = new ClientRemoteWSDTO();

        clientRemoteWSDTO.setClient(clientDBModel);
        List<ClientRemoteDBModel> clientRemotes = clientRemoteRepository.findByClientId(clientDBModel.getId());
        if (!clientRemotes.isEmpty()){
            clientRemoteWSDTO.setClientRemote(clientRemotes.get(0));
        }
        return clientRemoteWSDTO;
    }


    public PaginationWSDTO createRemotePagination(Page<ClientDBModel> clientModelPage){

        PaginationWSDTO remotePagination = new PaginationWSDTO();

        remotePagination.setPageSize(clientModelPage.getPageable().getPageSize());
        remotePagination.setPageNumber(clientModelPage.getPageable().getPageNumber());
        remotePagination.setTotalPage(clientModelPage.getTotalPages());
        remotePagination.setTotalElements(clientModelPage.getTotalElements());

        return remotePagination;
    }




}
