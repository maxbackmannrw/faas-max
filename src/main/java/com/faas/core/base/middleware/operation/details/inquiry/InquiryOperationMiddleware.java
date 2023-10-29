package com.faas.core.base.middleware.operation.details.inquiry;

import com.faas.core.base.framework.operation.details.inquiry.InquiryOperationFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.inquiry.InquiryOperationWSModel;
import com.faas.core.base.model.ws.operation.details.inquiry.dto.InquiryOperationWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class InquiryOperationMiddleware {


    @Autowired
    InquiryOperationFramework operationInquiryFramework;


    public InquiryOperationWSModel getInquiryOperations(long userId, String inquiryState, int reqPage, int reqSize) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getInquiryOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryOperationWSModel getInquiryOperation(long userId, long inquiryId, long clientId) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryOperationWSDTO> inquiryOperationWSDTOS = new ArrayList<>();



        response.setOperationInquiries(inquiryOperationWSDTOS);
        general.setOperation("getInquiryOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryOperationWSModel createInquiryOperation(long userId, long clientId, long agentId, String campaignId) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryOperationWSDTO> inquiryOperationWSDTOS = new ArrayList<>();



        response.setOperationInquiries(inquiryOperationWSDTOS);
        general.setOperation("createInquiryOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryOperationWSModel updateInquiryOperation(long userId, long inquiryId, long clientId) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryOperationWSDTO> inquiryOperationWSDTOS = new ArrayList<>();



        response.setOperationInquiries(inquiryOperationWSDTOS);
        general.setOperation("updateInquiryOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryOperationWSModel removeInquiryOperation(long userId, long inquiryId, long clientId) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryOperationWSDTO> inquiryOperationWSDTOS = new ArrayList<>();



        response.setOperationInquiries(inquiryOperationWSDTOS);
        general.setOperation("removeInquiryOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
