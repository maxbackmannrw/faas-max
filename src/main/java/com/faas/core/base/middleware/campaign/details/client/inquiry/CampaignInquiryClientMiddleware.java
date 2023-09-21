package com.faas.core.base.middleware.campaign.details.client.inquiry;

import com.faas.core.base.framework.campaign.details.client.inquiry.CampaignInquiryClientFramework;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquiryWSModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.dto.CampaignInquiryWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.campaign.details.client.inquiry.CampaignInquiryClientRequest;
import com.faas.core.base.model.ws.client.inquiry.ClientInquiryWSModel;
import com.faas.core.base.model.ws.client.inquiry.dto.ClientInquiryWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignInquiryClientMiddleware {


    @Autowired
    CampaignInquiryClientFramework campaignInquiryClientFramework;


    public CampaignInquiryWSModel searchCampaignInquiryClients(long userId, String campaignId,String clientCity,String clientCountry,int reqPage,int reqSize) {

        CampaignInquiryWSModel response = new CampaignInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignInquiryWSDTO campaignInquiryWSDTO = campaignInquiryClientFramework.searchCampaignInquiryClientsService(userId,campaignId,clientCity,clientCountry,reqPage,reqSize);
        if (campaignInquiryWSDTO != null){
            response.setCampaignInquiry(campaignInquiryWSDTO);
        }

        general.setOperation("searchCampaignInquiryClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public CampaignInquiryWSModel getCampaignInquiryClients(long userId,String campaignId,int reqPage,int reqSize) {

        CampaignInquiryWSModel response = new CampaignInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        CampaignInquiryWSDTO campaignInquiryWSDTO = campaignInquiryClientFramework.getCampaignInquiryClientsService(userId,campaignId,reqPage,reqSize);
        if (campaignInquiryWSDTO != null){
            response.setCampaignInquiry(campaignInquiryWSDTO);
        }

        general.setOperation("getCampaignInquiryClients");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel getCampaignInquiryClient(long userId, long inquiryId, long clientId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO = campaignInquiryClientFramework.getCampaignInquiryClientService(userId,inquiryId,clientId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("getCampaignInquiryClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ClientInquiryWSModel createCampaignInquiryClient(CampaignInquiryClientRequest campaignInquiryClientRequest) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientInquiryWSDTO> clientInquiryWSDTOS = campaignInquiryClientFramework.createCampaignInquiryClientService(campaignInquiryClientRequest);
        if (clientInquiryWSDTOS != null){
            response.setClientInquiries(clientInquiryWSDTOS);
        }

        general.setOperation("createCampaignInquiryClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel updateCampaignInquiryClient(long userId, long inquiryId, long clientId, String inquiryState) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO = campaignInquiryClientFramework.updateCampaignInquiryClientService(userId,inquiryId,clientId,inquiryState);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("updateCampaignInquiryClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public ClientInquiryWSModel removeCampaignInquiryClient(long userId, long inquiryId, long clientId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO = campaignInquiryClientFramework.removeCampaignInquiryClientService(userId,inquiryId,clientId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("removeCampaignInquiryClient");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
