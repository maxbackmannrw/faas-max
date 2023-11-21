package com.faas.core.base.framework.operation.manual.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationCampaignWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.model.ws.operation.manual.content.dto.ManualManagerWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ManualHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ManualManagerFramework {


    @Autowired
    ManualHelper manualHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

    @Autowired
    AppUtils appUtils;


    public ManualManagerWSDTO getManualManagerService(long userId,int reqPage,int reqSize) {

        ManualManagerWSDTO manualManagerWSDTO = new ManualManagerWSDTO();
        manualManagerWSDTO.setReadyOperationList(getManualOperationsService(userId,AppConstant.READY_SESSION,reqPage,reqSize));
        manualManagerWSDTO.setActiveOperationList(getManualOperationsService(userId,AppConstant.ACTIVE_SESSION,reqPage,reqSize));
        manualManagerWSDTO.setCampaigns(getManualCampaignsService(userId));

        return manualManagerWSDTO;
    }


    public OperationListWSDTO getManualOperationsService(long userId, String sessionState, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionModelPage = sessionRepository.findAllBySessionTypeAndSessionState(AppConstant.MANUAL_CAMPAIGN, sessionState,PageRequest.of(reqPage,reqSize));
        if (sessionModelPage != null){
            return manualHelper.getManualOperationListWSDTO(sessionModelPage);
        }
        return null;
    }


    public OperationWSDTO getManualOperationService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty()){
        }
        return null;
    }


    public OperationWSDTO createManualOperationService(long userId,long clientId,long agentId,String campaignId) {


        return null;
    }


    public OperationWSDTO updateManualOperationService(long userId, long sessionId) {


        return null;
    }

    public OperationWSDTO removeManualOperationService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty()){
            sessionRepository.delete(sessionDBModel.get());
            operationRepository.delete(operationDBModels.get(0));

        }
        return null;
    }


    public List<OperationCampaignWSDTO> getManualCampaignsService(long userId) {

        List<OperationCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.MANUAL_CAMPAIGN);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            OperationCampaignWSDTO campaignWSDTO = new OperationCampaignWSDTO();
            campaignWSDTO.setCampaign(campaignDBModel);
            campaignWSDTOS.add(campaignWSDTO);
        }
        return campaignWSDTOS;
    }


    public OperationCampaignWSDTO getManualCampaignService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            OperationCampaignWSDTO campaignWSDTO = new OperationCampaignWSDTO();
            campaignWSDTO.setCampaign(campaignDBModel.get());
            return campaignWSDTO;
        }
        return null;
    }

}
