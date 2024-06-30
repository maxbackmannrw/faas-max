package com.faas.core.base.framework.remote.app.details;

import com.faas.core.base.model.ws.remote.app.content.dto.RemoteClientSummaryWSDTO;
import com.faas.core.base.model.ws.remote.app.details.dto.RemoteClientDetailsWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.remote.app.RemoteAppRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteAppDetailsFramework {


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    RemoteAppRepository remoteAppRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteClientDetailsWSDTO getRemoteAppDetailsService(long userId, String clientRemoteId) {

        return null;
    }

    public RemoteClientSummaryWSDTO getRemoteAppsSummaryService(long userId) {

        RemoteClientSummaryWSDTO remoteClientSummaryWSDTO = new RemoteClientSummaryWSDTO();
        remoteClientSummaryWSDTO.setNewClientRemotes(remoteAppRepository.countByRemoteState(AppConstant.NEW_REMOTE));
        remoteClientSummaryWSDTO.setReadyClientRemotes(remoteAppRepository.countByRemoteState(AppConstant.READY_REMOTE));
        remoteClientSummaryWSDTO.setFailedClientRemotes(remoteAppRepository.countByRemoteState(AppConstant.FAILED_REMOTE));
        remoteClientSummaryWSDTO.setTotalClientRemotes(remoteAppRepository.count());

        return remoteClientSummaryWSDTO;
    }

}
