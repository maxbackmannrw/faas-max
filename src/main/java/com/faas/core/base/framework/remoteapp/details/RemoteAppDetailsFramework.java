package com.faas.core.base.framework.remoteapp.details;

import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppSummaryWSDTO;
import com.faas.core.base.model.ws.remoteapp.details.dto.RemoteAppDetailsWSDTO;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.remoteapp.RemoteAppRepository;
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


    public RemoteAppDetailsWSDTO getRemoteAppDetailsService(long userId, String clientRemoteId) {

        return null;
    }

    public RemoteAppSummaryWSDTO getRemoteAppsSummaryService(long userId) {

        RemoteAppSummaryWSDTO remoteAppSummaryWSDTO = new RemoteAppSummaryWSDTO();
        remoteAppSummaryWSDTO.setNewClientRemotes(remoteAppRepository.countByAppState(AppConstant.NEW_REMOTE));
        remoteAppSummaryWSDTO.setReadyClientRemotes(remoteAppRepository.countByAppState(AppConstant.READY_REMOTE));
        remoteAppSummaryWSDTO.setFailedClientRemotes(remoteAppRepository.countByAppState(AppConstant.FAILED_REMOTE));
        remoteAppSummaryWSDTO.setTotalClientRemotes(remoteAppRepository.count());

        return remoteAppSummaryWSDTO;
    }

}
