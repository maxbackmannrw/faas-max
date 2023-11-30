package com.faas.core.base.middleware.operation.inquiry;

import com.faas.core.base.framework.operation.inquiry.InquiryManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.content.OperationCampaignWSModel;
import com.faas.core.base.model.ws.operation.content.OperationListWSModel;
import com.faas.core.base.model.ws.operation.content.OperationWSModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationCampaignWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationListWSDTO;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.model.ws.operation.inquiry.InquiryManagerWSModel;
import com.faas.core.base.model.ws.operation.inquiry.dto.InquiryManagerWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class InquiryManagerMiddleware {


    @Autowired
    InquiryManagerFramework operationInquiryFramework;


    public InquiryManagerWSModel getInquiryManager(long userId, int reqPage, int reqSize) {

        InquiryManagerWSModel response = new InquiryManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();

        InquiryManagerWSDTO inquiryManagerWSDTO = operationInquiryFramework.getInquiryManagerService(userId,reqPage,reqSize);
        if (inquiryManagerWSDTO != null){
            response.setInquiryManager(inquiryManagerWSDTO);
        }

        general.setOperation("getInquiryManager");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationListWSModel getInquiryOperations(long userId, String sessionState, int reqPage, int reqSize) {

        OperationListWSModel response = new OperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        OperationListWSDTO operationListWSDTO = operationInquiryFramework.getInquiryOperationsService(userId,sessionState,reqPage,reqSize);
        if (operationListWSDTO != null){
            response.setOperationList(operationListWSDTO);
        }

        general.setOperation("getInquiryOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationWSModel getInquiryOperation(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationInquiryFramework.getInquiryOperationService(userId,sessionId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("getInquiryOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationWSModel createInquiryOperation(long userId, long clientId,long agentId,String campaignId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationInquiryFramework.createInquiryOperationService(userId,clientId,agentId,campaignId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("createInquiryOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationWSModel updateInquiryOperation(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationInquiryFramework.updateInquiryOperationService(userId,sessionId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("updateInquiryOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public OperationWSModel removeInquiryOperation(long userId, long sessionId) {

        OperationWSModel response = new OperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationWSDTO> operationWSDTOS = new ArrayList<>();

        OperationWSDTO operationWSDTO = operationInquiryFramework.removeInquiryOperationService(userId,sessionId);
        if (operationWSDTO != null){
            operationWSDTOS.add(operationWSDTO);
        }

        response.setOperations(operationWSDTOS);
        general.setOperation("removeInquiryOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public OperationCampaignWSModel getInquiryCampaigns(long userId) {

        OperationCampaignWSModel response = new OperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<OperationCampaignWSDTO> operationCampaignWSDTOS = operationInquiryFramework.getInquiryCampaignsService(userId);
        if (operationCampaignWSDTOS != null){
            response.setCampaigns(operationCampaignWSDTOS);
        }

        general.setOperation("getInquiryCampaigns");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public OperationCampaignWSModel getInquiryCampaign(long userId,String campaignId) {

        OperationCampaignWSModel response = new OperationCampaignWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<OperationCampaignWSDTO>operationCampaignWSDTOS = new ArrayList<>();

        OperationCampaignWSDTO operationCampaignWSDTO = operationInquiryFramework.getInquiryCampaignService(userId,campaignId);
        if (operationCampaignWSDTO != null){
            operationCampaignWSDTOS.add(operationCampaignWSDTO);
        }

        response.setCampaigns(operationCampaignWSDTOS);
        general.setOperation("getInquiryCampaign");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
