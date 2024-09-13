package com.faas.core.utility.helpers.remote;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remoteapp.RemoteAppDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppListWSDTO;
import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.remoteapp.RemoteAppRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RemoteAppHelpers {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    RemoteAppRepository remoteAppRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteAppListWSDTO getRemoteAppListWSDTO(Page<RemoteAppDBModel> remoteAppModelPage){

       /* Optional<ClientDBModel> clientDBModel = clientRepository.findById(remoteAppDBModel.getClientId());
        if (clientDBModel.isPresent()){

            RemoteAppWSDTO remoteAppWSDTO = new RemoteAppWSDTO();
            remoteAppWSDTO.setClient(clientDBModel.get());
            Optional<OperationDBModel> operationDBModel = operationRepository.findById(remoteAppDBModel.getOperationId());
            operationDBModel.ifPresent(remoteAppWSDTO::setOperation);

            return remoteAppWSDTO;
        }
        */
        return null;
    }


    public RemoteAppWSDTO getRemoteAppWSDTO(RemoteAppDBModel remoteAppDBModel){

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(remoteAppDBModel.getClientId());
        if (clientDBModel.isPresent()){

            RemoteAppWSDTO remoteAppWSDTO = new RemoteAppWSDTO();
            remoteAppWSDTO.setClient(clientDBModel.get());
            Optional<OperationDBModel> operationDBModel = operationRepository.findById(remoteAppDBModel.getOperationId());
            operationDBModel.ifPresent(remoteAppWSDTO::setOperation);

            return remoteAppWSDTO;
        }
        return null;
    }


    public RemoteAppDBModel createRemoteAppDBModel(OperationDBModel operationDBModel, RemoteDBModel remoteDBModel){

        RemoteAppDBModel remoteAppDBModel = new RemoteAppDBModel();
        remoteAppDBModel.setClientId(operationDBModel.getClientId());
        remoteAppDBModel.setOperationId(operationDBModel.getId());
        remoteAppDBModel.setCampaignId(operationDBModel.getCampaignId());
        remoteAppDBModel.setCampaign(operationDBModel.getCampaign());
        remoteAppDBModel.setRemoteId(remoteDBModel.getId());
        remoteAppDBModel.setRemote(remoteDBModel.getRemote());
        remoteAppDBModel.setTypeId(remoteDBModel.getTypeId());
        remoteAppDBModel.setRemoteType(remoteDBModel.getRemoteType());
        remoteAppDBModel.setBaseType(remoteDBModel.getBaseType());
        remoteAppDBModel.setuDate(appUtils.getCurrentTimeStamp());
        remoteAppDBModel.setcDate(appUtils.getCurrentTimeStamp());
        remoteAppDBModel.setStatus(1);

        return remoteAppDBModel;
    }

    public PaginationWSDTO createClientRemotePagination(Page<RemoteAppDBModel> remoteAppModelPage){

        PaginationWSDTO remoteAppPagination = new PaginationWSDTO();
        remoteAppPagination.setPageSize(remoteAppModelPage.getPageable().getPageSize());
        remoteAppPagination.setPageNumber(remoteAppModelPage.getPageable().getPageNumber());
        remoteAppPagination.setTotalPage(remoteAppModelPage.getTotalPages());
        remoteAppPagination.setTotalElements(remoteAppModelPage.getTotalElements());

        return remoteAppPagination;
    }


}
