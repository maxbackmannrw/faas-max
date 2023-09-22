package com.faas.core.base.middleware.campaign.details.client.inquiry;

import com.faas.core.base.framework.campaign.details.client.inquiry.CampaignInquirySessionFramework;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquirySessionWSModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquirySessionWSDTO;
import com.faas.core.base.model.ws.client.inquiry.InquirySessionWSModel;
import com.faas.core.base.model.ws.client.inquiry.dto.InquirySessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquirySessionRequest;
import com.faas.core.base.model.ws.client.inquiry.ClientInquiryWSModel;
import com.faas.core.base.model.ws.client.inquiry.dto.ClientInquiryWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignInquirySessionMiddleware {

    @Autowired
    CampaignInquirySessionFramework campaignInquirySessionFramework;


    public CampaignInquirySessionWSModel searchCampaignInquirySessions(long userId, String campaignId, String city, String country, int reqPage, int reqSize) {

        CampaignInquirySessionWSModel response = new CampaignInquirySessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignInquirySessionWSDTO campaignInquirySessionWSDTO = campaignInquirySessionFramework.searchCampaignInquirySessionsService(userId,campaignId,city,country,reqPage,reqSize);
        if (campaignInquirySessionWSDTO != null){
            response.setCampaignInquiry(campaignInquirySessionWSDTO);
        }

        general.setOperation("searchCampaignInquirySessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public CampaignInquirySessionWSModel getCampaignInquirySessions(long userId, String campaignId, int reqPage, int reqSize) {

        CampaignInquirySessionWSModel response = new CampaignInquirySessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignInquirySessionWSDTO campaignInquirySessionWSDTO = campaignInquirySessionFramework.getCampaignInquirySessionsService(userId,campaignId,reqPage,reqSize);
        if (campaignInquirySessionWSDTO != null){
            response.setCampaignInquiry(campaignInquirySessionWSDTO);
        }

        general.setOperation("getCampaignInquirySessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public InquirySessionWSModel getCampaignInquirySession(long userId,long sessionId) {

        InquirySessionWSModel response = new InquirySessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquirySessionWSDTO>inquirySessionWSDTOS = new ArrayList<>();

        InquirySessionWSDTO inquirySessionWSDTO = campaignInquirySessionFramework.getCampaignInquirySessionService(userId,sessionId);
        if (inquirySessionWSDTO != null){
            inquirySessionWSDTOS.add(inquirySessionWSDTO);
        }

        response.setInquirySessions(inquirySessionWSDTOS);
        general.setOperation("getCampaignInquirySession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public InquirySessionWSModel createCampaignInquirySession(CampaignInquirySessionRequest inquirySessionRequest) {

        InquirySessionWSModel response = new InquirySessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<InquirySessionWSDTO> inquirySessionWSDTOS = campaignInquirySessionFramework.createCampaignInquirySessionService(inquirySessionRequest);
        if (inquirySessionWSDTOS != null){
            response.setInquirySessions(inquirySessionWSDTOS);
        }

        general.setOperation("createCampaignInquirySession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquirySessionWSModel updateCampaignInquirySession(long userId,long sessionId,long agentId,String campaignId,String inquiryState) {

        InquirySessionWSModel response = new InquirySessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquirySessionWSDTO> inquirySessionWSDTOS = new ArrayList<>();

        InquirySessionWSDTO inquirySessionWSDTO = campaignInquirySessionFramework.updateCampaignInquirySessionService(userId,sessionId,agentId,campaignId,inquiryState);
        if (inquirySessionWSDTO != null){
            inquirySessionWSDTOS.add(inquirySessionWSDTO);
        }

        response.setInquirySessions(inquirySessionWSDTOS);
        general.setOperation("updateCampaignInquirySession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public InquirySessionWSModel removeCampaignInquirySession(long userId, long sessionId) {

        InquirySessionWSModel response = new InquirySessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquirySessionWSDTO> inquirySessionWSDTOS = new ArrayList<>();

        InquirySessionWSDTO inquirySessionWSDTO = campaignInquirySessionFramework.removeCampaignInquirySessionService(userId,sessionId);
        if (inquirySessionWSDTO != null){
            inquirySessionWSDTOS.add(inquirySessionWSDTO);
        }

        response.setInquirySessions(inquirySessionWSDTOS);
        general.setOperation("removeCampaignInquirySession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
