package com.faas.core.base.middleware.campaign.details.client.inquiry;

import com.faas.core.base.framework.campaign.details.client.inquiry.CampaignInquirySessionFramework;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquirySessionWSModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquirySessionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquirySessionRequest;
import com.faas.core.base.model.ws.operation.details.content.OperationInquirySessionWSModel;
import com.faas.core.base.model.ws.operation.details.content.dto.OperationInquirySessionWSDTO;
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

    public OperationInquirySessionWSModel getCampaignInquirySession(long userId, long sessionId) {

        OperationInquirySessionWSModel response = new OperationInquirySessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationInquirySessionWSDTO> operationInquirySessionWSDTOS = new ArrayList<>();

        OperationInquirySessionWSDTO operationInquirySessionWSDTO = campaignInquirySessionFramework.getCampaignInquirySessionService(userId,sessionId);
        if (operationInquirySessionWSDTO != null){
            operationInquirySessionWSDTOS.add(operationInquirySessionWSDTO);
        }

        response.setInquirySessions(operationInquirySessionWSDTOS);
        general.setOperation("getCampaignInquirySession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationInquirySessionWSModel createCampaignInquirySession(CampaignInquirySessionRequest inquirySessionRequest) {

        OperationInquirySessionWSModel response = new OperationInquirySessionWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<OperationInquirySessionWSDTO> operationInquirySessionWSDTOS = campaignInquirySessionFramework.createCampaignInquirySessionService(inquirySessionRequest);
        if (operationInquirySessionWSDTOS != null){
            response.setInquirySessions(operationInquirySessionWSDTOS);
        }

        general.setOperation("createCampaignInquirySession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationInquirySessionWSModel updateCampaignInquirySession(long userId, long sessionId, long agentId, String campaignId, String inquiryState) {

        OperationInquirySessionWSModel response = new OperationInquirySessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationInquirySessionWSDTO> operationInquirySessionWSDTOS = new ArrayList<>();

        OperationInquirySessionWSDTO operationInquirySessionWSDTO = campaignInquirySessionFramework.updateCampaignInquirySessionService(userId,sessionId,agentId,campaignId,inquiryState);
        if (operationInquirySessionWSDTO != null){
            operationInquirySessionWSDTOS.add(operationInquirySessionWSDTO);
        }

        response.setInquirySessions(operationInquirySessionWSDTOS);
        general.setOperation("updateCampaignInquirySession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public OperationInquirySessionWSModel removeCampaignInquirySession(long userId, long sessionId) {

        OperationInquirySessionWSModel response = new OperationInquirySessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationInquirySessionWSDTO> operationInquirySessionWSDTOS = new ArrayList<>();

        OperationInquirySessionWSDTO operationInquirySessionWSDTO = campaignInquirySessionFramework.removeCampaignInquirySessionService(userId,sessionId);
        if (operationInquirySessionWSDTO != null){
            operationInquirySessionWSDTOS.add(operationInquirySessionWSDTO);
        }

        response.setInquirySessions(operationInquirySessionWSDTOS);
        general.setOperation("removeCampaignInquirySession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
