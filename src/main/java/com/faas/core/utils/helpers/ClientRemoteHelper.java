package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.client.remote.ClientRemoteDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.client.remote.content.dto.ClientRemoteListWSDTO;
import com.faas.core.base.model.ws.client.remote.content.dto.ClientRemoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.remote.ClientRemoteRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientRemoteHelper {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientRemoteRepository clientRemoteRepository;

    @Autowired
    AppUtils appUtils;


    public ClientRemoteListWSDTO getClientRemoteListWSDTO(Page<ClientRemoteDBModel> clientRemotePage){

        ClientRemoteListWSDTO clientRemoteListWSDTO = new ClientRemoteListWSDTO();
        clientRemoteListWSDTO.setClientRemotes(getClientRemoteWSDTOS(clientRemotePage.getContent()));
        clientRemoteListWSDTO.setPagination(createClientRemotePagination(clientRemotePage));

        return clientRemoteListWSDTO;
    }


    public List<ClientRemoteWSDTO> getClientRemoteWSDTOS(List<ClientRemoteDBModel> clientRemoteDBModels){

        List<ClientRemoteWSDTO> clientRemoteWSDTOS = new ArrayList<>();
        for (ClientRemoteDBModel clientRemoteDBModel : clientRemoteDBModels) {
            ClientRemoteWSDTO clientRemoteWSDTO = getClientRemoteWSDTO(clientRemoteDBModel);
            if (clientRemoteWSDTO != null) {
                clientRemoteWSDTOS.add(clientRemoteWSDTO);
            }
        }
        return clientRemoteWSDTOS;
    }


    public ClientRemoteWSDTO getClientRemoteWSDTO(ClientRemoteDBModel clientRemoteDBModel){

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientRemoteDBModel.getClientId());
        if (clientDBModel.isPresent()) {
            ClientRemoteWSDTO clientRemoteWSDTO = new ClientRemoteWSDTO();
            clientRemoteWSDTO.setClient(clientDBModel.get());
            clientRemoteWSDTO.setClientRemote(clientRemoteDBModel);

            return clientRemoteWSDTO;
        }
        return new ;
    }


    public PaginationWSDTO createClientRemotePagination(Page<ClientRemoteDBModel> clientRemotePage){

        PaginationWSDTO clientRemotePagination = new PaginationWSDTO();
        clientRemotePagination.setPageSize(clientRemotePage.getPageable().getPageSize());
        clientRemotePagination.setPageNumber(clientRemotePage.getPageable().getPageNumber());
        clientRemotePagination.setTotalPage(clientRemotePage.getTotalPages());
        clientRemotePagination.setTotalElements(clientRemotePage.getTotalElements());

        return clientRemotePagination;
    }



}
