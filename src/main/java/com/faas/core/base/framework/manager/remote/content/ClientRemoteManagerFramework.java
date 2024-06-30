package com.faas.core.base.framework.manager.remote.content;

import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.manager.ManagerHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientRemoteManagerFramework {


    @Autowired
    ManagerHelpers managerHelpers;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public void getAppManagerService(long userId, int reqPage, int reqSize) {


    }



}
