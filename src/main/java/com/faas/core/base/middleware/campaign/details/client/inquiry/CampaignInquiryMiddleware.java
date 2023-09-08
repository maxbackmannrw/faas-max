package com.faas.core.base.middleware.campaign.details.client.inquiry;

import com.faas.core.base.framework.campaign.details.client.inquiry.CampaignInquiryFramework;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquiryWSModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.client.inquiry.ClientInquiryRequest;
import com.faas.core.base.model.ws.client.inquiry.ClientInquiryWSModel;
import com.faas.core.base.model.ws.client.inquiry.dto.ClientInquiryWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignInquiryMiddleware {


    @Autowired
    CampaignInquiryFramework campaignInquiryFramework;


    public CampaignInquiryWSModel searchCampaignInquiries(long userId, String campaignId,String clientCity,String clientCountry,int reqPage,int reqSize) {

        CampaignInquiryWSModel response = new CampaignInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignInquiryWSDTO campaignInquiryWSDTO = campaignInquiryFramework.searchCampaignInquiriesService(userId,campaignId,clientCity,clientCountry,reqPage,reqSize);
        if (campaignInquiryWSDTO != null){
            response.setCampaignInquiry(campaignInquiryWSDTO);
        }

        general.setOperation("getCampaignInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignInquiryWSModel getCampaignInquiries(long userId,String campaignId,int reqPage,int reqSize) {

        CampaignInquiryWSModel response = new CampaignInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignInquiryWSDTO campaignInquiryWSDTO = campaignInquiryFramework.getCampaignInquiriesService(userId,campaignId,reqPage,reqSize);
        if (campaignInquiryWSDTO != null){
            response.setCampaignInquiry(campaignInquiryWSDTO);
        }

        general.setOperation("getCampaignInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel getCampaignInquiry(long userId, long inquiryId, long clientId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO = campaignInquiryFramework.getCampaignInquiryService(userId,inquiryId,clientId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("getCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ClientInquiryWSModel createCampaignInquiry(ClientInquiryRequest clientInquiryRequest) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientInquiryWSDTO> clientInquiryWSDTOS = campaignInquiryFramework.createCampaignInquiryService(clientInquiryRequest);
        if (clientInquiryWSDTOS != null){
            response.setClientInquiries(clientInquiryWSDTOS);
        }

        general.setOperation("createCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel updateCampaignInquiry(long userId, long inquiryId, long clientId, String inquiryState) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO = campaignInquiryFramework.updateCampaignInquiryService(userId,inquiryId,clientId,inquiryState);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("updateCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ClientInquiryWSModel removeCampaignInquiry(long userId, long inquiryId, long clientId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO = campaignInquiryFramework.removeCampaignInquiryService(userId,inquiryId,clientId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("removeCampaignInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
