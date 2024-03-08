package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remote.client.ClientRemoteDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.remote.client.content.dto.ClientRemoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientRemoteHelper {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;

    public ClientRemoteWSDTO createClientRemoteWSDTO(ClientRemoteDBModel clientRemoteDBModel){

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(clientRemoteDBModel.getClientId());
        if (clientDBModel.isPresent()){

            ClientRemoteWSDTO clientRemoteWSDTO = new ClientRemoteWSDTO();
            clientRemoteWSDTO.setClientRemote(clientRemoteDBModel);
            clientRemoteWSDTO.setClient(clientDBModel.get());
            Optional<OperationDBModel> operationDBModel = operationRepository.findById(clientRemoteDBModel.getOperationId());
            operationDBModel.ifPresent(clientRemoteWSDTO::setOperation);

            return clientRemoteWSDTO;
        }
        return null;
    }


    public ClientRemoteDBModel createClientRemoteDBModel(SessionDBModel sessionDBModel, OperationDBModel operationDBModel, RemoteDBModel remoteDBModel){

        ClientRemoteDBModel clientRemoteDBModel = new ClientRemoteDBModel();
        clientRemoteDBModel.setClientId(sessionDBModel.getClientId());
        clientRemoteDBModel.setSessionId(sessionDBModel.getId());
        clientRemoteDBModel.setOperationId(operationDBModel.getId());
        clientRemoteDBModel.setCampaignId(sessionDBModel.getCampaignId());
        clientRemoteDBModel.setCampaign(sessionDBModel.getCampaign());
        clientRemoteDBModel.setCampaignType(sessionDBModel.getCampaignType());
        clientRemoteDBModel.setCampaignCategory(sessionDBModel.getCampaignCategory());
        clientRemoteDBModel.setProcessId(sessionDBModel.getProcessId());
        clientRemoteDBModel.setProcess(sessionDBModel.getProcess());
        clientRemoteDBModel.setProcessType(sessionDBModel.getProcessType());
        clientRemoteDBModel.setProcessCategory(sessionDBModel.getProcessCategory());
        clientRemoteDBModel.setRemoteId(remoteDBModel.getId());
        clientRemoteDBModel.setRemote(remoteDBModel.getRemote());
        clientRemoteDBModel.setRemoteDesc(remoteDBModel.getRemoteDesc());
        clientRemoteDBModel.setRemoteVersion(remoteDBModel.getRemoteVersion());
        clientRemoteDBModel.setRemoteDatas(remoteDBModel.getRemoteDatas());
        clientRemoteDBModel.setRemoteUrls(remoteDBModel.getRemoteUrls());
        clientRemoteDBModel.setRemoteTypeId(remoteDBModel.getTypeId());
        clientRemoteDBModel.setRemoteType(remoteDBModel.getRemoteType());
        clientRemoteDBModel.setBaseType(remoteDBModel.getBaseType());
        clientRemoteDBModel.setRemoteState(AppConstant.NEW_REMOTE);
        clientRemoteDBModel.setuDate(appUtils.getCurrentTimeStamp());
        clientRemoteDBModel.setcDate(appUtils.getCurrentTimeStamp());
        clientRemoteDBModel.setStatus(1);

        return clientRemoteDBModel;
    }


    public PaginationWSDTO createClientRemotePagination(Page<ClientRemoteDBModel> remoteAppModelPage){

        PaginationWSDTO remoteAppPagination = new PaginationWSDTO();
        remoteAppPagination.setPageSize(remoteAppModelPage.getPageable().getPageSize());
        remoteAppPagination.setPageNumber(remoteAppModelPage.getPageable().getPageNumber());
        remoteAppPagination.setTotalPage(remoteAppModelPage.getTotalPages());
        remoteAppPagination.setTotalElements(remoteAppModelPage.getTotalElements());

        return remoteAppPagination;
    }


}
