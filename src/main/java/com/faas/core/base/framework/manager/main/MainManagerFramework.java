package com.faas.core.base.framework.manager.main;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.manager.main.dto.MainManagerContentWSDTO;
import com.faas.core.base.model.ws.manager.main.dto.MainManagerWSDTO;
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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MainManagerFramework {


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


    public MainManagerWSDTO getMainManagerService(long userId, int reqPage, int reqSize) {

        MainManagerWSDTO mainManagerWSDTO = new MainManagerWSDTO();
        mainManagerWSDTO.setManualContent(managerHelper.getMainManagerContentWSDTO(userId,AppConstant.MANUAL_OPERATION,reqPage,reqSize));
        mainManagerWSDTO.setInquiryContent(managerHelper.getMainManagerContentWSDTO(userId,AppConstant.INQUIRY_OPERATION,reqPage,reqSize));
        mainManagerWSDTO.setAutomaticContent(managerHelper.getMainManagerContentWSDTO(userId,AppConstant.AUTOMATIC_OPERATION,reqPage,reqSize));

        return mainManagerWSDTO;
    }

    public MainManagerContentWSDTO getMainManagerContentService(long userId, String category, int reqPage, int reqSize) {
        return managerHelper.getMainManagerContentWSDTO(userId,category,reqPage,reqSize);
    }


    public List<CampaignManagerWSDTO> getMainManagerCampaignsService(long userId, String category) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(category);
        if (campaignDBModels != null){
            return managerHelper.getCampaignManagerWSDTOS(campaignDBModels);
        }
        return null;
    }

    public CampaignManagerWSDTO getMainManagerCampaignService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            return managerHelper.fillCampaignManagerWSDTO(campaignDBModel.get());
        }
        return null;
    }


    public OperationManagerWSDTO getMainManagerOperationsService(long userId, String category, int reqPage, int reqSize) {

        return managerHelper.getOperationManagerWSDTOByOperationModel(operationRepository.findAllByOperationType(category,PageRequest.of(reqPage,reqSize)));
    }

    public OperationManagerWSDTO getMainManagerOperationsByStateService(long userId,String category,String operationState,int reqPage,int reqSize) {

        return managerHelper.getOperationManagerWSDTOByOperationModel(operationRepository.findAllByOperationStateAndOperationType(operationState,category,PageRequest.of(reqPage,reqSize)));
    }

    public OperationWSDTO getMainManagerOperationService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()){
            return managerHelper.fillManagerOperationWSDTOBySessionModel(sessionDBModel.get());
        }
        return null;
    }

    public OperationWSDTO removeMainManagerOperationService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()){
            OperationWSDTO operationWSDTO = managerHelper.fillManagerOperationWSDTOBySessionModel(sessionDBModel.get());
            managerHelper.removeOperationManager(sessionDBModel.get());
            return operationWSDTO;
        }
        return null;
    }


}
