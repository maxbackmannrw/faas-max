package com.faas.core.base.middleware.client.inquiry.content;

import com.faas.core.base.framework.client.inquiry.content.ClientInquiryFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.client.inquiry.InquiryCampaignWSModel;
import com.faas.core.base.model.ws.client.inquiry.ClientInquiryWSModel;
import com.faas.core.base.model.ws.client.inquiry.dto.InquiryCampaignWSDTO;
import com.faas.core.base.model.ws.client.inquiry.dto.ClientInquiryWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ClientInquiryMiddleware {


    @Autowired
    ClientInquiryFramework clientInquiryFramework;


    public InquiryCampaignWSModel getInquiryCampaigns(long userId,int reqPage,int reqSize) {

        InquiryCampaignWSModel response = new InquiryCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<InquiryCampaignWSDTO> inquiryCampaignWSDTOS =  clientInquiryFramework.getInquiryCampaignsService(userId,reqPage,reqSize);
        if (inquiryCampaignWSDTOS != null){
            response.setInquiryCampaigns(inquiryCampaignWSDTOS);
        }

        general.setOperation("getInquiryCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryCampaignWSModel getInquiryCampaign(long userId,String campaignId,int reqPage,int reqSize) {

        InquiryCampaignWSModel response = new InquiryCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryCampaignWSDTO> inquiryCampaignWSDTOS = new ArrayList<>();

        InquiryCampaignWSDTO inquiryCampaignWSDTO =  clientInquiryFramework.getInquiryCampaignService(userId,campaignId,reqPage,reqSize);
        if (inquiryCampaignWSDTO != null){
            inquiryCampaignWSDTOS.add(inquiryCampaignWSDTO);
        }

        response.setInquiryCampaigns(inquiryCampaignWSDTOS);
        general.setOperation("getInquiryCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public ClientInquiryWSModel getAllInquiries(long userId, int reqPage, int reqSize) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientInquiryWSDTO> clientInquiryWSDTOS =  clientInquiryFramework.getAllInquiriesService(userId,reqPage,reqSize);
        if (clientInquiryWSDTOS != null){
            response.setClientInquiries(clientInquiryWSDTOS);
        }

        general.setOperation("getAllInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel getInquiriesByState(long userId, String inquiryState, int reqPage, int reqSize) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<ClientInquiryWSDTO> clientInquiryWSDTOS =  clientInquiryFramework.getInquiriesByStateService(userId,inquiryState,reqPage,reqSize);
        if (clientInquiryWSDTOS != null){
            response.setClientInquiries(clientInquiryWSDTOS);
        }

        general.setOperation("getInquiriesByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel getInquiry(long userId, long inquiryId, long clientId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO =  clientInquiryFramework.getInquiryService(userId,inquiryId,clientId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("getInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel createInquiry(long userId, long clientId, long agentId, String campaignId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO =  clientInquiryFramework.createInquiryService(userId,clientId,agentId,campaignId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("createInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel updateInquiry(long userId, long inquiryId, long clientId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO =  clientInquiryFramework.updateInquiryService(userId,inquiryId,clientId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("updateInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ClientInquiryWSModel removeInquiry(long userId, long inquiryId, long clientId) {

        ClientInquiryWSModel response = new ClientInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ClientInquiryWSDTO> clientInquiryWSDTOS = new ArrayList<>();

        ClientInquiryWSDTO clientInquiryWSDTO =  clientInquiryFramework.removeInquiryService(userId,inquiryId,clientId);
        if (clientInquiryWSDTO != null){
            clientInquiryWSDTOS.add(clientInquiryWSDTO);
        }

        response.setClientInquiries(clientInquiryWSDTOS);
        general.setOperation("removeInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
