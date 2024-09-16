package com.faas.core.base.framework.remoteapp.manager.details;

import com.faas.core.data.ws.base.remoteapp.content.dto.RemoteAppListWSDTO;
import com.faas.core.data.repo.campaign.content.CampaignRepository;
import com.faas.core.data.repo.client.content.ClientRepository;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.data.repo.remote.content.RemoteRepository;
import com.faas.core.data.repo.remoteapp.RemoteAppRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.remoteapp.RemoteAppHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteAppManagerDetailsFramework {


    @Autowired
    RemoteAppHelper remoteAppHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    RemoteAppRepository remoteAppRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    AppUtils appUtils;


    public RemoteAppListWSDTO getRemoteAppManagerDetailsService(long userId, String appState, String baseType, int reqPage, int reqSize) {


        return null;
    }


}
