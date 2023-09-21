package com.faas.core.base.middleware.campaign.details.client.inquiry;

import com.faas.core.base.framework.campaign.details.client.inquiry.CampaignInquirySessionFramework;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquirySessionWSModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquirySessionWSDTO;
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

    public ClientInquiryWSModel getCampaignInquirySession(long userId, long inquiryId, long clientId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO = campaignInquirySessionFramework.getCampaignInquirySessionService(userId,inquiryId,clientId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("getCampaignInquirySession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ClientInquiryWSModel createCampaignInquirySession(CampaignInquirySessionRequest campaignInquirySessionRequest) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientInquiryWSDTO> clientInquiryWSDTOS = campaignInquirySessionFramework.createCampaignInquirySessionService(campaignInquirySessionRequest);
        if (clientInquiryWSDTOS != null){
            response.setClientInquiries(clientInquiryWSDTOS);
        }

        general.setOperation("createCampaignInquirySession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel updateCampaignInquirySession(long userId, long inquiryId, long clientId, String inquiryState) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO = campaignInquirySessionFramework.updateCampaignInquirySessionService(userId,inquiryId,clientId,inquiryState);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("updateCampaignInquirySession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ClientInquiryWSModel removeCampaignInquirySession(long userId, long inquiryId, long clientId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO = campaignInquirySessionFramework.removeCampaignInquirySessionService(userId,inquiryId,clientId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("removeCampaignInquirySession");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
