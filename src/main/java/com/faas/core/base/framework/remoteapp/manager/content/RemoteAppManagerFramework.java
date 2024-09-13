package com.faas.core.base.framework.remoteapp.manager.content;

import com.faas.core.base.model.ws.remoteapp.content.dto.RemoteAppListWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.remoteapp.RemoteAppRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.remote.RemoteAppHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteAppManagerFramework {


    @Autowired
    RemoteAppHelpers remoteAppHelpers;

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


    public RemoteAppListWSDTO getRemoteAppManagersService(long userId, String appState, String baseType, int reqPage, int reqSize) {


        return null;
    }



}
