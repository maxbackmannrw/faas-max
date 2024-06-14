package com.faas.core.utility.helpers.remote;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remote.client.RemoteClientDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.remote.client.content.dto.RemoteClientWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RemoteClientHelper {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;

    public RemoteClientWSDTO createClientRemoteWSDTO(RemoteClientDBModel remoteClientDBModel){

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(remoteClientDBModel.getClientId());
        if (clientDBModel.isPresent()){

            RemoteClientWSDTO remoteClientWSDTO = new RemoteClientWSDTO();
            remoteClientWSDTO.setRemoteClient(remoteClientDBModel);
            remoteClientWSDTO.setClient(clientDBModel.get());
            Optional<OperationDBModel> operationDBModel = operationRepository.findById(remoteClientDBModel.getOperationId());
            operationDBModel.ifPresent(remoteClientWSDTO::setOperation);

            return remoteClientWSDTO;
        }
        return null;
    }


    public RemoteClientDBModel createClientRemoteDBModel(SessionDBModel sessionDBModel, OperationDBModel operationDBModel, RemoteDBModel remoteDBModel){

        RemoteClientDBModel remoteClientDBModel = new RemoteClientDBModel();
        remoteClientDBModel.setClientId(sessionDBModel.getClientId());
        remoteClientDBModel.setSessionId(sessionDBModel.getId());
        remoteClientDBModel.setOperationId(operationDBModel.getId());
        remoteClientDBModel.setCampaignId(sessionDBModel.getCampaignId());
        remoteClientDBModel.setCampaign(sessionDBModel.getCampaign());
        remoteClientDBModel.setCampaignType(sessionDBModel.getCampaignType());
        remoteClientDBModel.setCampaignCategory(sessionDBModel.getCampaignCategory());
        remoteClientDBModel.setProcessId(sessionDBModel.getProcessId());
        remoteClientDBModel.setProcess(sessionDBModel.getProcess());
        remoteClientDBModel.setProcessType(sessionDBModel.getProcessType());
        remoteClientDBModel.setProcessCategory(sessionDBModel.getProcessCategory());
        remoteClientDBModel.setRemoteId(remoteDBModel.getId());
        remoteClientDBModel.setRemote(remoteDBModel.getRemote());
        remoteClientDBModel.setRemoteDesc(remoteDBModel.getRemoteDesc());
        remoteClientDBModel.setVersion(remoteDBModel.getVersion());
        remoteClientDBModel.setRemoteDatas(remoteDBModel.getRemoteDatas());
        remoteClientDBModel.setTypeId(remoteDBModel.getTypeId());
        remoteClientDBModel.setRemoteType(remoteDBModel.getRemoteType());
        remoteClientDBModel.setBaseType(remoteDBModel.getBaseType());
        remoteClientDBModel.setRemoteState(AppConstant.NEW_REMOTE);
        remoteClientDBModel.setuDate(appUtils.getCurrentTimeStamp());
        remoteClientDBModel.setcDate(appUtils.getCurrentTimeStamp());
        remoteClientDBModel.setStatus(1);

        return remoteClientDBModel;
    }


    public PaginationWSDTO createClientRemotePagination(Page<RemoteClientDBModel> remoteAppModelPage){

        PaginationWSDTO remoteAppPagination = new PaginationWSDTO();
        remoteAppPagination.setPageSize(remoteAppModelPage.getPageable().getPageSize());
        remoteAppPagination.setPageNumber(remoteAppModelPage.getPageable().getPageNumber());
        remoteAppPagination.setTotalPage(remoteAppModelPage.getTotalPages());
        remoteAppPagination.setTotalElements(remoteAppModelPage.getTotalElements());

        return remoteAppPagination;
    }


}
