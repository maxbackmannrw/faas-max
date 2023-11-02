package com.faas.core.base.framework.manager.inquiry.details;

import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.db.operation.details.inquiry.OperationInquiryDBModel;
import com.faas.core.base.model.ws.manager.inquiry.dto.InquiryOperationListWSDTO;
import com.faas.core.base.model.ws.manager.inquiry.dto.InquiryOperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class InquiryManagerDetailsFramework {

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


    public InquiryOperationListWSDTO getInquiryOperationsService(long userId, String sessionState, int reqPage, int reqSize) {

        Page<SessionDBModel> sessionModelPage = sessionRepository.findAllBySessionTypeAndSessionState(AppConstant.INQUIRY_CAMPAIGN, sessionState,PageRequest.of(reqPage,reqSize));
        if (sessionModelPage != null){
            return inquiryHelper.getInquiryOperationListWSDTO(sessionModelPage);
        }
        return null;
    }


    public InquiryOperationWSDTO getInquiryOperationService(long userId, long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        List<OperationInquiryDBModel> operationInquiryDBModels = operationInquiryRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty() && !operationInquiryDBModels.isEmpty()){
            return new InquiryOperationWSDTO(operationDBModels.get(0),sessionDBModel.get(),operationInquiryDBModels.get(0));
        }
        return null;
    }


    public InquiryOperationWSDTO createInquiryOperationService(long userId, long clientId,long agentId,String campaignId) {


        return null;
    }


    public InquiryOperationWSDTO updateInquiryOperationService(long userId, long sessionId) {


        return null;
    }


    public InquiryOperationWSDTO removeInquiryOperationService(long userId,long sessionId) {

        Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(sessionId);
        List<OperationDBModel> operationDBModels = operationRepository.findBySessionId(sessionId);
        List<OperationInquiryDBModel> operationInquiryDBModels = operationInquiryRepository.findBySessionId(sessionId);
        if (sessionDBModel.isPresent() && !operationDBModels.isEmpty() && !operationInquiryDBModels.isEmpty()){
            sessionRepository.delete(sessionDBModel.get());
            operationRepository.delete(operationDBModels.get(0));
            operationInquiryRepository.delete(operationInquiryDBModels.get(0));
            return new InquiryOperationWSDTO(operationDBModels.get(0),sessionDBModel.get(),operationInquiryDBModels.get(0));
        }
        return null;
    }


}
