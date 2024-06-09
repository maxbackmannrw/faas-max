package com.faas.core.base.framework.remote.client;

import com.faas.core.base.model.ws.remote.client.content.dto.ClientRemoteSummaryWSDTO;
import com.faas.core.base.model.ws.remote.client.details.dto.ClientRemoteDetailsWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.remote.client.ClientRemoteRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientRemoteDetailsFramework {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientRemoteRepository clientRemoteRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public ClientRemoteDetailsWSDTO getClientRemoteDetailsService(long userId, String clientRemoteId) {

        return null;
    }

    public ClientRemoteSummaryWSDTO getClientRemoteSummaryService(long userId) {

        ClientRemoteSummaryWSDTO clientRemoteSummaryWSDTO = new ClientRemoteSummaryWSDTO();
        clientRemoteSummaryWSDTO.setNewClientRemotes(clientRemoteRepository.countByRemoteState(AppConstant.NEW_REMOTE));
        clientRemoteSummaryWSDTO.setReadyClientRemotes(clientRemoteRepository.countByRemoteState(AppConstant.READY_REMOTE));
        clientRemoteSummaryWSDTO.setFailedClientRemotes(clientRemoteRepository.countByRemoteState(AppConstant.FAILED_REMOTE));
        clientRemoteSummaryWSDTO.setTotalClientRemotes(clientRemoteRepository.count());

        return clientRemoteSummaryWSDTO;
    }

}
