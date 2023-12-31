package com.faas.core.utils.helpers;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessRemoteDAO;
import com.faas.core.base.model.db.remote.app.RemoteAppDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.general.PaginationWSDTO;
import com.faas.core.base.model.ws.remote.app.dto.RemoteAppWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RemoteAppHelper {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteAppWSDTO createRemoteAppWSDTO(RemoteAppDBModel remoteAppDBModel){

        Optional<ClientDBModel> clientDBModel = clientRepository.findById(remoteAppDBModel.getClientId());
        if (clientDBModel.isPresent()){
            RemoteAppWSDTO remoteAppWSDTO = new RemoteAppWSDTO();
            remoteAppWSDTO.setRemoteApp(remoteAppDBModel);
            remoteAppWSDTO.setClient(clientDBModel.get());

            return remoteAppWSDTO;
        }
        return null;
    }


    public RemoteAppDBModel createRemoteAppDBModel(SessionDBModel sessionDBModel, OperationDBModel operationDBModel, RemoteDBModel remoteDBModel){

        RemoteAppDBModel remoteAppDBModel = new RemoteAppDBModel();
        remoteAppDBModel.setClientId(sessionDBModel.getClientId());
        remoteAppDBModel.setSessionId(sessionDBModel.getId());
        remoteAppDBModel.setOperationId(operationDBModel.getId());
        remoteAppDBModel.setCampaignId(sessionDBModel.getCampaignId());
        remoteAppDBModel.setCampaign(sessionDBModel.getCampaign());
        remoteAppDBModel.setProcessId(sessionDBModel.getProcessId());
        remoteAppDBModel.setProcess(sessionDBModel.getProcess());
        remoteAppDBModel.setRemoteId(remoteDBModel.getId());
        remoteAppDBModel.setRemote(remoteDBModel.getRemote());
        remoteAppDBModel.setRemoteDesc(remoteDBModel.getRemoteDesc());
        remoteAppDBModel.setRemoteVersion(remoteDBModel.getRemoteVersion());



        return null;
    }


    public PaginationWSDTO createRemoteAppPagination(Page<RemoteAppDBModel> remoteAppModelPage){

        PaginationWSDTO remoteAppPagination = new PaginationWSDTO();
        remoteAppPagination.setPageSize(remoteAppModelPage.getPageable().getPageSize());
        remoteAppPagination.setPageNumber(remoteAppModelPage.getPageable().getPageNumber());
        remoteAppPagination.setTotalPage(remoteAppModelPage.getTotalPages());
        remoteAppPagination.setTotalElements(remoteAppModelPage.getTotalElements());

        return remoteAppPagination;
    }


}
