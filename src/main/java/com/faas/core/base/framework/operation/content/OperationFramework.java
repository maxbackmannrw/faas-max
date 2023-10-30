package com.faas.core.base.framework.operation.content;

import com.faas.core.base.model.ws.operation.content.dto.CampaignOperationWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.OperationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


@Component
public class OperationFramework {


    @Autowired
    OperationHelper operationHelper;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public CampaignOperationWSDTO getCampaignOperationsService(long userId, int reqPage, int reqSize) {

        CampaignOperationWSDTO campaignOperationWSDTO = new CampaignOperationWSDTO();
        campaignOperationWSDTO.setManualOperations(operationHelper.getOperationListWSDTO(sessionRepository.findAllByCampaignCategoryAndSessionState(AppConstant.MANUAL_CAMPAIGN,AppConstant.READY_SESSION, PageRequest.of(reqPage,reqSize))));
        campaignOperationWSDTO.setInquiryOperations(operationHelper.getOperationListWSDTO(sessionRepository.findAllByCampaignCategoryAndSessionState(AppConstant.INQUIRY_CAMPAIGN,AppConstant.READY_SESSION, PageRequest.of(reqPage,reqSize))));
        campaignOperationWSDTO.setAutomaticOperations(operationHelper.getOperationListWSDTO(sessionRepository.findAllByCampaignCategoryAndSessionState(AppConstant.AUTOMATIC_CAMPAIGN,AppConstant.READY_SESSION, PageRequest.of(reqPage,reqSize))));

        return campaignOperationWSDTO;
    }


    public OperationListWSDTO getOperationsService(long userId, String campaignCategory,String sessionState,int reqPage,int reqSize) {

        return operationHelper.getOperationListWSDTO(sessionRepository.findAllByCampaignCategoryAndSessionState(campaignCategory,sessionState,PageRequest.of(reqPage,reqSize)));
    }


    public OperationWSDTO getOperationService(long userId, long sessionId) {

        return null;
    }


    public OperationWSDTO createOperationService(long userId) {

        return null;
    }


    public OperationWSDTO updateOperationService(long userId,long sessionId) {

        return null;
    }


    public OperationWSDTO removeOperationService(long userId, long sessionId) {

        return null;
    }

}
