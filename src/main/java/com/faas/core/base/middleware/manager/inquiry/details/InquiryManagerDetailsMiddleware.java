package com.faas.core.base.middleware.manager.inquiry.details;

import com.faas.core.base.framework.manager.inquiry.details.InquiryManagerDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.inquiry.InquiryOperationListWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InquiryManagerDetailsMiddleware {


    @Autowired
    InquiryManagerDetailsFramework inquiryManagerDetailsFramework;


    public InquiryOperationListWSModel getInquiryOperations(long userId, String sessionState, int reqPage, int reqSize) {

        InquiryOperationListWSModel response = new InquiryOperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getInquiryOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }




}
