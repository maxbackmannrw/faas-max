package com.faas.core.base.framework.remote.client;

import com.faas.core.base.model.ws.remote.client.dto.ClientRemoteSummaryWSDTO;
import com.faas.core.base.model.ws.remote.client.dto.ClientRemoteWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.remote.client.ClientRemoteRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
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


    public ClientRemoteWSDTO getClientRemoteDetailsService(long userId) {

        return null;
    }


    public ClientRemoteSummaryWSDTO getClientRemoteSummaryService(long userId) {

        ClientRemoteSummaryWSDTO clientRemoteSummaryWSDTO = new ClientRemoteSummaryWSDTO();
        clientRemoteSummaryWSDTO.setTotalRemote(clientRemoteRepository.count());
        clientRemoteSummaryWSDTO.setReadyRemote(clientRemoteRepository.countByRemoteState(AppConstant.READY_REMOTE));
        clientRemoteSummaryWSDTO.setActiveRemote(clientRemoteRepository.countByRemoteState(AppConstant.ACTIVE_REMOTE));
        clientRemoteSummaryWSDTO.setTerminatedRemote(clientRemoteRepository.countByRemoteState(AppConstant.TERMINATED_REMOTE));

        return clientRemoteSummaryWSDTO;
    }


}
