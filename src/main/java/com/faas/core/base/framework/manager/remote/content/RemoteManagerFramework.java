package com.faas.core.base.framework.manager.remote.content;

import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


@Component
public class RemoteManagerFramework {

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


    public AppManagerCampaignWSDTO getAppManagerService(long userId, int reqPage, int reqSize) {

        AppManagerCampaignWSDTO appManagerCampaignWSDTO = new AppManagerCampaignWSDTO();
        appManagerCampaignWSDTO.setManualCampaigns(managerHelper.getCampaignManagerWSDTOS(campaignRepository.findByCampaignCategoryAndCampaignState(AppConstant.MANUAL_CAMPAIGN,AppConstant.ACTIVE_STATE)));
        appManagerCampaignWSDTO.setInquiryCampaigns(managerHelper.getCampaignManagerWSDTOS(campaignRepository.findByCampaignCategoryAndCampaignState(AppConstant.INQUIRY_CAMPAIGN,AppConstant.ACTIVE_STATE)));
        appManagerCampaignWSDTO.setAutomaticCampaigns(managerHelper.getCampaignManagerWSDTOS(campaignRepository.findByCampaignCategoryAndCampaignState(AppConstant.AUTOMATIC_CAMPAIGN,AppConstant.ACTIVE_STATE)));
        appManagerCampaignWSDTO.setReadyOperation(managerHelper.getOperationManagerWSDTOByOperationModel(operationRepository.findAllByOperationState(AppConstant.READY_STATE,PageRequest.of(reqPage,reqSize))));
        appManagerCampaignWSDTO.setActiveOperation(managerHelper.getOperationManagerWSDTOByOperationModel(operationRepository.findAllByOperationState(AppConstant.ACTIVE_STATE,PageRequest.of(reqPage,reqSize))));
        appManagerCampaignWSDTO.setFinishedOperation(managerHelper.getOperationManagerWSDTOByOperationModel(operationRepository.findAllByOperationState(AppConstant.FINISHED_STATE,PageRequest.of(reqPage,reqSize))));

        return appManagerCampaignWSDTO;
    }



}
