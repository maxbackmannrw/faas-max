package com.faas.core.base.framework.operation.inquiry.content;

import com.faas.core.base.model.db.campaign.content.CampaignDBModel;
import com.faas.core.base.model.db.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.inquiry.OperationInquiryDBModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationCampaignWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.model.ws.operation.inquiry.content.dto.InquiryManagerWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class InquiryManagerFramework {

    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    AppUtils appUtils;


    public InquiryManagerWSDTO getInquiryManagerService(long userId, int reqPage, int reqSize) {

        return null;
    }


    public OperationListWSDTO getInquiryOperationsService(long userId, String sessionState, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionModelPage = sessionRepository.findAllBySessionTypeAndSessionState(AppConstant.INQUIRY_CAMPAIGN, sessionState,PageRequest.of(reqPage,reqSize));
        if (sessionModelPage != null){
        }
        return null;
    }


    public OperationWSDTO getInquiryOperationService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        List<OperationInquiryDBModel> operationInquiryDBModels = operationInquiryRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty() && !operationInquiryDBModels.isEmpty()){
        }
        return null;
    }


    public OperationWSDTO createInquiryOperationService(long userId, long clientId,long agentId,String campaignId) {


        return null;
    }


    public OperationWSDTO updateInquiryOperationService(long userId, long sessionId) {


        return null;
    }


    public OperationWSDTO removeInquiryOperationService(long userId,long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        List<OperationInquiryDBModel> operationInquiryDBModels = operationInquiryRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty() && !operationInquiryDBModels.isEmpty()){
            sessionRepository.delete(sessionDBModel.get());
            operationRepository.delete(operationDBModels.get(0));
            operationInquiryRepository.delete(operationInquiryDBModels.get(0));
        }
        return null;
    }


    public List<OperationCampaignWSDTO> getInquiryCampaignsService(long userId) {

        List<OperationCampaignWSDTO> campaignWSDTOS = new ArrayList<>();
        List<CampaignDBModel> campaignDBModels = campaignRepository.findByCampaignCategory(AppConstant.INQUIRY_CAMPAIGN);
        for (CampaignDBModel campaignDBModel : campaignDBModels) {
            OperationCampaignWSDTO campaignWSDTO = new OperationCampaignWSDTO();
            campaignWSDTO.setCampaign(campaignDBModel);
            campaignWSDTOS.add(campaignWSDTO);
        }
        return campaignWSDTOS;
    }


    public OperationCampaignWSDTO getInquiryCampaignService(long userId,String campaignId) {

        Optional<CampaignDBModel> campaignDBModel = campaignRepository.findById(campaignId);
        if (campaignDBModel.isPresent()){
            OperationCampaignWSDTO campaignWSDTO = new OperationCampaignWSDTO();
            campaignWSDTO.setCampaign(campaignDBModel.get());
            return campaignWSDTO;
        }
        return null;
    }



}
