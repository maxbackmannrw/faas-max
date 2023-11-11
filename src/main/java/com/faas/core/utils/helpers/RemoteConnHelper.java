package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.remote.RemoteConnDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.remote.content.dto.RemoteConnListWSDTO;
import com.faas.core.base.model.ws.remote.content.dto.RemoteConnWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.remote.RemoteConnRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RemoteConnHelper {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RemoteConnRepository remoteConnRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteConnListWSDTO getRemoteConnListWSDTO(Page<RemoteConnDBModel> remoteConnModelPage){

        RemoteConnListWSDTO remoteConnListWSDTO = new RemoteConnListWSDTO();
        List<RemoteConnWSDTO> remoteConnWSDTOS = new ArrayList<>();
        for (int i=0;i<remoteConnModelPage.getContent().size();i++){
            RemoteConnWSDTO remoteConnWSDTO = getRemoteConnWSDTO(remoteConnModelPage.getContent().get(i));
            if (remoteConnWSDTO != null){
                remoteConnWSDTOS.add(remoteConnWSDTO);
            }
        }
        remoteConnListWSDTO.setRemoteConns(remoteConnWSDTOS);
        remoteConnListWSDTO.setPagination(createRemoteConnPagination(remoteConnModelPage));
        return remoteConnListWSDTO;
    }


    public RemoteConnWSDTO getRemoteConnWSDTO(RemoteConnDBModel remoteConnDBModel){

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(remoteConnDBModel.getClientId());
        if (clientDBModel.isPresent()){
            RemoteConnWSDTO remoteConnWSDTO = new RemoteConnWSDTO();
            remoteConnWSDTO.setClient(clientDBModel.get());
            remoteConnWSDTO.setRemoteConn(remoteConnDBModel);
            return remoteConnWSDTO;
        }
        return null;
    }


    public PaginationWSDTO createRemoteConnPagination(Page<RemoteConnDBModel> remoteConnModelPage){

        PaginationWSDTO remoteConnPagination = new PaginationWSDTO();
        remoteConnPagination.setPageSize(remoteConnModelPage.getPageable().getPageSize());
        remoteConnPagination.setPageNumber(remoteConnModelPage.getPageable().getPageNumber());
        remoteConnPagination.setTotalPage(remoteConnModelPage.getTotalPages());
        remoteConnPagination.setTotalElements(remoteConnModelPage.getTotalElements());

        return remoteConnPagination;
    }



}
