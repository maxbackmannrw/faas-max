package com.faas.core.base.framework.remote.client.details;

import com.faas.core.base.model.ws.remote.client.content.dto.RemoteClientSummaryWSDTO;
import com.faas.core.base.model.ws.remote.client.details.dto.RemoteClientDetailsWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.remote.client.RemoteClientRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteClientDetailsFramework {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RemoteClientRepository remoteClientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteClientDetailsWSDTO getRemoteClientDetailsService(long userId, String clientRemoteId) {

        return null;
    }

    public RemoteClientSummaryWSDTO getClientRemoteSummaryService(long userId) {

        RemoteClientSummaryWSDTO remoteClientSummaryWSDTO = new RemoteClientSummaryWSDTO();
        remoteClientSummaryWSDTO.setNewClientRemotes(remoteClientRepository.countByRemoteState(AppConstant.NEW_REMOTE));
        remoteClientSummaryWSDTO.setReadyClientRemotes(remoteClientRepository.countByRemoteState(AppConstant.READY_REMOTE));
        remoteClientSummaryWSDTO.setFailedClientRemotes(remoteClientRepository.countByRemoteState(AppConstant.FAILED_REMOTE));
        remoteClientSummaryWSDTO.setTotalClientRemotes(remoteClientRepository.count());

        return remoteClientSummaryWSDTO;
    }

}
