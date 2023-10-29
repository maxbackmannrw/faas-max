package com.faas.core.base.framework.operation.details.manual;

import com.faas.core.base.model.db.operation.details.inquiry.OperationInquiryDBModel;
import com.faas.core.base.model.ws.operation.details.inquiry.dto.InquiryOperationWSDTO;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.operation.details.inquiry.OperationInquiryRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.InquiryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ManualOperationFramework {


    @Autowired
    InquiryHelper inquiryHelper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    OperationInquiryRepository operationInquiryRepository;

    @Autowired
    AppUtils appUtils;


    public List<InquiryOperationWSDTO> getManualOperationsService(long userId, int reqPage, int reqSize) {

        List<InquiryOperationWSDTO> inquiryOperationWSDTOS = new ArrayList<>();
        Page<OperationInquiryDBModel> inquiryModelPage = operationInquiryRepository.findAll(PageRequest.of(reqPage,reqSize));
        for (int i=0;i<inquiryModelPage.getContent().size();i++){
            inquiryOperationWSDTOS.add(new InquiryOperationWSDTO(inquiryModelPage.getContent().get(i)));
        }
        return inquiryOperationWSDTOS;
    }


    public InquiryOperationWSDTO getManualOperationService(long userId, long inquiryId, long clientId) {


        return null;
    }


    public InquiryOperationWSDTO createManualOperationService(long userId, long clientId, long agentId, String campaignId) {



        return null;
    }


    public InquiryOperationWSDTO updateManualOperationService(long userId, long inquiryId, long clientId) {


        return null;
    }


    public InquiryOperationWSDTO removeManualOperationService(long userId, long inquiryId, long clientId) {

        return null;
    }

}
