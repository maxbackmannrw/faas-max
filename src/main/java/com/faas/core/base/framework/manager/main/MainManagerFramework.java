package com.faas.core.base.framework.manager.main;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.manager.main.dto.MainManagerContentWSDTO;
import com.faas.core.base.model.ws.manager.main.dto.MainManagerWSDTO;
import com.faas.core.base.model.ws.manager.campaign.content.dto.CampaignManagerWSDTO;
import com.faas.core.base.model.ws.operation.manager.content.dto.OperationManagerWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utility.config.AppConstant;
import com.faas.core.utility.config.AppUtils;
import com.faas.core.utility.helpers.manager.ManagerHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MainManagerFramework {


    @Autowired
    ManagerHelpers managerHelpers;

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
        mainManagerWSDTO.setManualContent(managerHelpers.getMainManagerContentWSDTO(userId,AppConstant.MANUAL_OPERATION,reqPage,reqSize));
        mainManagerWSDTO.setInquiryContent(managerHelpers.getMainManagerContentWSDTO(userId,AppConstant.INQUIRY_OPERATION,reqPage,reqSize));
        mainManagerWSDTO.setAutomaticContent(managerHelpers.getMainManagerContentWSDTO(userId,AppConstant.AUTOMATIC_OPERATION,reqPage,reqSize));

        return mainManagerWSDTO;
    }

    public MainManagerContentWSDTO getMainManagerContentService(long userId, String category, int reqPage, int reqSize) {
        return managerHelpers.getMainManagerContentWSDTO(userId,category,reqPage,reqSize);
    }


    public List<CampaignManagerWSDTO> getMainManagerCampaignsService(long userId, String category) {

        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(category);
        if (campaignDBModels != null){
            return managerHelpers.getCampaignManagerWSDTOS(campaignDBModels);
        }
        return null;
    }

    public CampaignManagerWSDTO getMainManagerCampaignService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            return managerHelpers.fillCampaignManagerWSDTO(campaignDBModel.get());
        }
        return null;
    }


    public OperationManagerWSDTO getMainManagerOperationsService(long userId, String category, int reqPage, int reqSize) {

        return managerHelpers.getOperationManagerWSDTOByOperationModel(operationRepository.findAllByOperationType(category,PageRequest.of(reqPage,reqSize)));
    }

    public OperationManagerWSDTO getMainManagerOperationsByStateService(long userId,String category,String operationState,int reqPage,int reqSize) {

        return managerHelpers.getOperationManagerWSDTOByOperationModel(operationRepository.findAllByOperationStateAndOperationType(operationState,category,PageRequest.of(reqPage,reqSize)));
    }

    public OperationWSDTO getMainManagerOperationService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()){
            return managerHelpers.fillManagerOperationWSDTOBySessionModel(sessionDBModel.get());
        }
        return null;
    }

    public OperationWSDTO removeMainManagerOperationService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        if (sessionDBModel.isPresent()){
            OperationWSDTO operationWSDTO = managerHelpers.fillManagerOperationWSDTOBySessionModel(sessionDBModel.get());
            managerHelpers.removeOperationManager(sessionDBModel.get());
            return operationWSDTO;
        }
        return null;
    }


}
