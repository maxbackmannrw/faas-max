package com.faas.core.utility.helpers.remote;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.remote.app.RemoteAppDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.remote.app.content.dto.RemoteClientWSDTO;
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

    public RemoteClientWSDTO createClientRemoteWSDTO(RemoteAppDBModel remoteAppDBModel){

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(remoteAppDBModel.getClientId());
        if (clientDBModel.isPresent()){

            RemoteClientWSDTO remoteClientWSDTO = new RemoteClientWSDTO();
            remoteClientWSDTO.setRemoteClient(remoteAppDBModel);
            remoteClientWSDTO.setClient(clientDBModel.get());
            Optional<OperationDBModel> operationDBModel = operationRepository.findById(remoteAppDBModel.getOperationId());
            operationDBModel.ifPresent(remoteClientWSDTO::setOperation);

            return remoteClientWSDTO;
        }
        return null;
    }


    public RemoteAppDBModel createClientRemoteDBModel(SessionDBModel sessionDBModel, OperationDBModel operationDBModel, RemoteDBModel remoteDBModel){

        RemoteAppDBModel remoteAppDBModel = new RemoteAppDBModel();
        remoteAppDBModel.setClientId(sessionDBModel.getClientId());
        remoteAppDBModel.setSessionId(sessionDBModel.getId());
        remoteAppDBModel.setOperationId(operationDBModel.getId());
        remoteAppDBModel.setCampaignId(sessionDBModel.getCampaignId());
        remoteAppDBModel.setCampaign(sessionDBModel.getCampaign());
        remoteAppDBModel.setCampaignType(sessionDBModel.getCampaignType());
        remoteAppDBModel.setCampaignCategory(sessionDBModel.getCampaignCategory());
        remoteAppDBModel.setProcessId(sessionDBModel.getProcessId());
        remoteAppDBModel.setProcess(sessionDBModel.getProcess());
        remoteAppDBModel.setProcessType(sessionDBModel.getProcessType());
        remoteAppDBModel.setProcessCategory(sessionDBModel.getProcessCategory());
        remoteAppDBModel.setRemoteId(remoteDBModel.getId());
        remoteAppDBModel.setRemote(remoteDBModel.getRemote());
        remoteAppDBModel.setRemoteDesc(remoteDBModel.getRemoteDesc());
        remoteAppDBModel.setVersion(remoteDBModel.getVersion());
        remoteAppDBModel.setRemoteDatas(remoteDBModel.getRemoteDatas());
        remoteAppDBModel.setTypeId(remoteDBModel.getTypeId());
        remoteAppDBModel.setRemoteType(remoteDBModel.getRemoteType());
        remoteAppDBModel.setBaseType(remoteDBModel.getBaseType());
        remoteAppDBModel.setRemoteState(AppConstant.NEW_REMOTE);
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
