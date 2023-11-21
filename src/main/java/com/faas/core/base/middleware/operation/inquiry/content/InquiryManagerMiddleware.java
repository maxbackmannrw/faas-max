package com.faas.core.base.middleware.operation.inquiry.content;

import com.faas.core.base.framework.operation.inquiry.content.InquiryManagerFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.inquiry.content.InquiryManagerWSModel;
import com.faas.core.base.model.ws.operation.inquiry.content.InquiryOperationListWSModel;
import com.faas.core.base.model.ws.operation.inquiry.content.InquiryOperationWSModel;
import com.faas.core.base.model.ws.operation.inquiry.content.dto.InquiryManagerWSDTO;
import com.faas.core.base.model.ws.operation.inquiry.content.dto.InquiryOperationListWSDTO;
import com.faas.core.base.model.ws.operation.inquiry.content.dto.InquiryOperationWSDTO;
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


    public InquiryOperationListWSModel getInquiryOperations(long userId, String sessionState, int reqPage, int reqSize) {

        InquiryOperationListWSModel response = new InquiryOperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();

        InquiryOperationListWSDTO operationListWSDTO = operationInquiryFramework.getInquiryOperationsService(userId,sessionState,reqPage,reqSize);
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


    public InquiryOperationWSModel getInquiryOperation(long userId, long sessionId) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryOperationWSDTO> inquiryOperationWSDTOS = new ArrayList<>();

        InquiryOperationWSDTO inquiryOperationWSDTO = operationInquiryFramework.getInquiryOperationService(userId,sessionId);
        if (inquiryOperationWSDTO != null){
            inquiryOperationWSDTOS.add(inquiryOperationWSDTO);
        }

        response.setInquiryOperations(inquiryOperationWSDTOS);
        general.setOperation("getInquiryOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryOperationWSModel createInquiryOperation(long userId, long clientId,long agentId,String campaignId) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryOperationWSDTO> inquiryOperationWSDTOS = new ArrayList<>();

        InquiryOperationWSDTO inquiryOperationWSDTO = operationInquiryFramework.createInquiryOperationService(userId,clientId,agentId,campaignId);
        if (inquiryOperationWSDTO != null){
            inquiryOperationWSDTOS.add(inquiryOperationWSDTO);
        }

        response.setInquiryOperations(inquiryOperationWSDTOS);
        general.setOperation("createInquiryOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryOperationWSModel updateInquiryOperation(long userId, long sessionId) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryOperationWSDTO> inquiryOperationWSDTOS = new ArrayList<>();

        InquiryOperationWSDTO inquiryOperationWSDTO = operationInquiryFramework.updateInquiryOperationService(userId,sessionId);
        if (inquiryOperationWSDTO != null){
            inquiryOperationWSDTOS.add(inquiryOperationWSDTO);
        }

        response.setInquiryOperations(inquiryOperationWSDTOS);
        general.setOperation("updateInquiryOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryOperationWSModel removeInquiryOperation(long userId, long sessionId) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryOperationWSDTO> inquiryOperationWSDTOS = new ArrayList<>();

        InquiryOperationWSDTO inquiryOperationWSDTO = operationInquiryFramework.removeInquiryOperationService(userId,sessionId);
        if (inquiryOperationWSDTO != null){
            inquiryOperationWSDTOS.add(inquiryOperationWSDTO);
        }

        response.setInquiryOperations(inquiryOperationWSDTOS);
        general.setOperation("removeInquiryOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
