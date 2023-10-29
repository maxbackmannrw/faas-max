package com.faas.core.base.middleware.operation.details.manual;

import com.faas.core.base.framework.operation.details.manual.ManualOperationFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.inquiry.InquiryOperationWSModel;
import com.faas.core.base.model.ws.operation.details.inquiry.dto.InquiryOperationWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ManualOperationMiddleware {


    @Autowired
    ManualOperationFramework manualOperationFramework;


    public InquiryOperationWSModel getManualOperations(long userId, int reqPage, int reqSize) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getManualOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public InquiryOperationWSModel getManualOperation(long userId, int reqPage, int reqSize) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getManualOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public InquiryOperationWSModel createManualOperation(long userId, int reqPage, int reqSize) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("createManualOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public InquiryOperationWSModel updateManualOperation(long userId, long inquiryId, long clientId) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryOperationWSDTO> inquiryOperationWSDTOS = new ArrayList<>();



        response.setOperationInquiries(inquiryOperationWSDTOS);
        general.setOperation("updateManualOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public InquiryOperationWSModel removeManualOperation(long userId, long sessionId, String operationId) {

        InquiryOperationWSModel response = new InquiryOperationWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryOperationWSDTO> inquiryOperationWSDTOS = new ArrayList<>();



        response.setOperationInquiries(inquiryOperationWSDTOS);
        general.setOperation("removeManualOperation");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
