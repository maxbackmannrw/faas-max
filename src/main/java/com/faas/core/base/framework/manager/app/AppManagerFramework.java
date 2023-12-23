package com.faas.core.base.framework.manager.app;

import com.faas.core.base.model.ws.manager.app.dto.AppManagerCampaignWSDTO;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerContentWSDTO;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerOperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AppManagerFramework {

    @Autowired
    ManagerHelper managerHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public AppManagerContentWSDTO getAppManagerContentService(long userId, String category, int reqPage, int reqSize) {

        AppManagerContentWSDTO appManagerContentWSDTO = new AppManagerContentWSDTO();

        return appManagerContentWSDTO;
    }


    public AppManagerCampaignWSDTO getAppManagerCampaignsService(long userId, String category) {

        AppManagerCampaignWSDTO appManagerCampaignWSDTO = new AppManagerCampaignWSDTO();

        return appManagerCampaignWSDTO;
    }

    public AppManagerCampaignWSDTO getAppManagerCampaignService(long userId,String campaignId) {

        AppManagerCampaignWSDTO appManagerCampaignWSDTO = new AppManagerCampaignWSDTO();

        return appManagerCampaignWSDTO;
    }


    public AppManagerOperationWSDTO getAppManagerOperationsService(long userId, String category, int reqPage, int reqSize) {

        AppManagerOperationWSDTO appManagerOperationWSDTO = new AppManagerOperationWSDTO();

        return appManagerOperationWSDTO;
    }

    public AppManagerOperationWSDTO getAppManagerOperationsByStateService(long userId,String category,String operationState,int reqPage,int reqSize) {

        AppManagerOperationWSDTO appManagerOperationWSDTO = new AppManagerOperationWSDTO();

        return appManagerOperationWSDTO;
    }

    public AppManagerOperationWSDTO getAppManagerOperationService(long userId,long sessionId) {

        AppManagerOperationWSDTO appManagerOperationWSDTO = new AppManagerOperationWSDTO();

        return appManagerOperationWSDTO;
    }


}
