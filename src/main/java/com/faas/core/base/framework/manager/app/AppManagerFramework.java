package com.faas.core.base.framework.manager.app;

import com.faas.core.base.model.ws.manager.app.dto.AppManagerWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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


    public AppManagerWSDTO getAppManagerService(long userId,int reqPage,int reqSize) {

        AppManagerWSDTO appManagerWSDTO = new AppManagerWSDTO();
        appManagerWSDTO.setManualCampaigns(managerHelper.getCampaignManagerWSDTOS(campaignRepository.findByCampaignCategoryAndCampaignState(AppConstant.MANUAL_CAMPAIGN,AppConstant.ACTIVE_CAMPAIGN)));
        appManagerWSDTO.setInquiryCampaigns(managerHelper.getCampaignManagerWSDTOS(campaignRepository.findByCampaignCategoryAndCampaignState(AppConstant.INQUIRY_CAMPAIGN,AppConstant.ACTIVE_CAMPAIGN)));
        appManagerWSDTO.setAutomaticCampaigns(managerHelper.getCampaignManagerWSDTOS(campaignRepository.findByCampaignCategoryAndCampaignState(AppConstant.AUTOMATIC_CAMPAIGN,AppConstant.ACTIVE_CAMPAIGN)));
        appManagerWSDTO.setReadyOperation(managerHelper.getOperationManagerWSDTO(operationRepository.findAllByOperationState(AppConstant.READY_OPERATION,PageRequest.of(reqPage,reqSize))));
        appManagerWSDTO.setActiveOperation(managerHelper.getOperationManagerWSDTO(operationRepository.findAllByOperationState(AppConstant.ACTIVE_OPERATION,PageRequest.of(reqPage,reqSize))));
        appManagerWSDTO.setFinishedOperation(managerHelper.getOperationManagerWSDTO(operationRepository.findAllByOperationState(AppConstant.FINISHED_OPERATION,PageRequest.of(reqPage,reqSize))));

        return appManagerWSDTO;
    }




}
