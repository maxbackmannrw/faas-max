package com.faas.core.base.framework.manager.app;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.ws.manager.app.AppManagerContentWSModel;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerContentWSDTO;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerOperationWSDTO;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerWSDTO;
import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.manager.operation.content.dto.OperationManagerWSDTO;
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

import java.util.ArrayList;
import java.util.List;


@Component
public class AppManagerFramework {

    @Autowired
    ManagerHelper managerHelper;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public AppManagerWSDTO getAppManagerService(long userId,int reqPage,int reqSize) {

        AppManagerWSDTO appManagerWSDTO = new AppManagerWSDTO();
        appManagerWSDTO.setManualContent(managerHelper.getAppManagerContentWSDTO(userId,AppConstant.MANUAL_OPERATION,reqPage,reqSize));
        appManagerWSDTO.setInquiryContent(managerHelper.getAppManagerContentWSDTO(userId,AppConstant.INQUIRY_OPERATION,reqPage,reqSize));
        appManagerWSDTO.setAutomaticContent(managerHelper.getAppManagerContentWSDTO(userId,AppConstant.AUTOMATIC_OPERATION,reqPage,reqSize));

        return appManagerWSDTO;
    }


    public AppManagerContentWSDTO getAppManagerContentService(long userId,String category,int reqPage,int reqSize) {

        return managerHelper.getAppManagerContentWSDTO(userId,category,reqPage,reqSize);
    }



    public List<CampaignManagerWSDTO> getAppManagerCampaignsService(long userId, String category) {

        List<CampaignManagerWSDTO> campaignManagerWSDTOS = new ArrayList<>();

        return campaignManagerWSDTOS;
    }


    public CampaignManagerWSDTO getAppManagerCampaignService(long userId,String campaignId) {

        CampaignManagerWSDTO campaignManagerWSDTO = new CampaignManagerWSDTO();

        return campaignManagerWSDTO;
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
