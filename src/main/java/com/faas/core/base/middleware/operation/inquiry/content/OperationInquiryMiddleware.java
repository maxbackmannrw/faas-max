package com.faas.core.base.middleware.operation.inquiry.content;

import com.faas.core.base.framework.operation.inquiry.content.OperationInquiryFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.inquiry.OperationInquiryCampaignWSModel;
import com.faas.core.base.model.ws.operation.inquiry.OperationInquiryWSModel;
import com.faas.core.base.model.ws.operation.inquiry.dto.OperationInquiryCampaignWSDTO;
import com.faas.core.base.model.ws.operation.inquiry.dto.OperationInquiryWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OperationInquiryMiddleware {


    @Autowired
    OperationInquiryFramework operationInquiryFramework;


    public OperationInquiryCampaignWSModel getOperationInquiryCampaigns(long userId, int reqPage, int reqSize) {

        OperationInquiryCampaignWSModel response = new OperationInquiryCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<OperationInquiryCampaignWSDTO> operationInquiryCampaignWSDTOS =  operationInquiryFramework.getInquiryCampaignsService(userId,reqPage,reqSize);
        if (operationInquiryCampaignWSDTOS != null){
            response.setInquiryCampaigns(operationInquiryCampaignWSDTOS);
        }

        general.setOperation("getOperationInquiryCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationInquiryCampaignWSModel getOperationInquiryCampaign(long userId, String campaignId, int reqPage, int reqSize) {

        OperationInquiryCampaignWSModel response = new OperationInquiryCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationInquiryCampaignWSDTO> operationInquiryCampaignWSDTOS = new ArrayList<>();

        OperationInquiryCampaignWSDTO operationInquiryCampaignWSDTO =  operationInquiryFramework.getInquiryCampaignService(userId,campaignId,reqPage,reqSize);
        if (operationInquiryCampaignWSDTO != null){
            operationInquiryCampaignWSDTOS.add(operationInquiryCampaignWSDTO);
        }

        response.setInquiryCampaigns(operationInquiryCampaignWSDTOS);
        general.setOperation("getOperationInquiryCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




    public OperationInquiryWSModel getAllOperationInquiries(long userId, int reqPage, int reqSize) {

        OperationInquiryWSModel response = new OperationInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<OperationInquiryWSDTO> operationInquiryWSDTOS =  operationInquiryFramework.getAllInquiriesService(userId,reqPage,reqSize);
        if (operationInquiryWSDTOS != null){
            response.setOperationInquiries(operationInquiryWSDTOS);
        }

        general.setOperation("getAllOperationInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationInquiryWSModel getOperationInquiriesByState(long userId, String inquiryState, int reqPage, int reqSize) {

        OperationInquiryWSModel response = new OperationInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<OperationInquiryWSDTO> operationInquiryWSDTOS =  operationInquiryFramework.getInquiriesByStateService(userId,inquiryState,reqPage,reqSize);
        if (operationInquiryWSDTOS != null){
            response.setOperationInquiries(operationInquiryWSDTOS);
        }

        general.setOperation("getOperationInquiriesByState");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationInquiryWSModel getOperationInquiry(long userId, long inquiryId, long clientId) {

        OperationInquiryWSModel response = new OperationInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationInquiryWSDTO> operationInquiryWSDTOS = new ArrayList<>();

        OperationInquiryWSDTO operationInquiryWSDTO =  operationInquiryFramework.getInquiryService(userId,inquiryId,clientId);
        if (operationInquiryWSDTO != null){
            operationInquiryWSDTOS.add(operationInquiryWSDTO);
        }

        response.setOperationInquiries(operationInquiryWSDTOS);
        general.setOperation("getOperationInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationInquiryWSModel createOperationInquiry(long userId, long clientId, long agentId, String campaignId) {

        OperationInquiryWSModel response = new OperationInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationInquiryWSDTO> operationInquiryWSDTOS = new ArrayList<>();

        OperationInquiryWSDTO operationInquiryWSDTO =  operationInquiryFramework.createInquiryService(userId,clientId,agentId,campaignId);
        if (operationInquiryWSDTO != null){
            operationInquiryWSDTOS.add(operationInquiryWSDTO);
        }

        response.setOperationInquiries(operationInquiryWSDTOS);
        general.setOperation("createOperationInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationInquiryWSModel updateOperationInquiry(long userId, long inquiryId, long clientId) {

        OperationInquiryWSModel response = new OperationInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationInquiryWSDTO> operationInquiryWSDTOS = new ArrayList<>();

        OperationInquiryWSDTO operationInquiryWSDTO =  operationInquiryFramework.updateInquiryService(userId,inquiryId,clientId);
        if (operationInquiryWSDTO != null){
            operationInquiryWSDTOS.add(operationInquiryWSDTO);
        }

        response.setOperationInquiries(operationInquiryWSDTOS);
        general.setOperation("updateOperationInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationInquiryWSModel removeOperationInquiry(long userId, long inquiryId, long clientId) {

        OperationInquiryWSModel response = new OperationInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationInquiryWSDTO> operationInquiryWSDTOS = new ArrayList<>();

        OperationInquiryWSDTO operationInquiryWSDTO =  operationInquiryFramework.removeInquiryService(userId,inquiryId,clientId);
        if (operationInquiryWSDTO != null){
            operationInquiryWSDTOS.add(operationInquiryWSDTO);
        }

        response.setOperationInquiries(operationInquiryWSDTOS);
        general.setOperation("removeOperationInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
