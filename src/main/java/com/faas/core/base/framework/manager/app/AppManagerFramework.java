package com.faas.core.base.framework.manager.app;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerContentWSDTO;
import com.faas.core.base.model.ws.manager.app.dto.AppManagerWSDTO;
import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.manager.operation.content.dto.OperationManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
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

import java.util.List;
import java.util.Optional;


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

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(category);
        if (campaignDBModels != null){
            return managerHelper.getCampaignManagerWSDTOS(campaignDBModels);
        }
        return null;
    }

    public CampaignManagerWSDTO getAppManagerCampaignService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            return managerHelper.fillCampaignManagerWSDTO(campaignDBModel.get());
        }
        return null;
    }


    public OperationManagerWSDTO getAppManagerOperationsService(long userId, String category, int reqPage, int reqSize) {

        return managerHelper.getOperationManagerWSDTOByOperationModel(operationRepository.findAllByOperationType(category,PageRequest.of(reqPage,reqSize)));
    }

    public OperationManagerWSDTO getAppManagerOperationsByStateService(long userId,String category,String operationState,int reqPage,int reqSize) {

        return managerHelper.getOperationManagerWSDTOByOperationModel(operationRepository.findAllByOperationStateAndOperationType(operationState,category,PageRequest.of(reqPage,reqSize)));
    }

    public OperationWSDTO getAppManagerOperationService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()){
            return managerHelper.fillManagerOperationWSDTOBySessionModel(sessionDBModel.get());
        }
        return null;
    }

    public OperationWSDTO removeAppManagerOperationService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()){
            OperationWSDTO operationWSDTO = managerHelper.fillManagerOperationWSDTOBySessionModel(sessionDBModel.get());
            managerHelper.removeOperationManager(sessionDBModel.get());
            return operationWSDTO;
        }
        return null;
    }


}
