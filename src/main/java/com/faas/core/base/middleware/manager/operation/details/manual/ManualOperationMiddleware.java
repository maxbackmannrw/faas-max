package com.faas.core.base.middleware.manager.operation.details.manual;

import com.faas.core.base.framework.manager.operation.details.manual.ManualOperationFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.operation.details.inquiry.InquiryManagerWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ManualOperationMiddleware {


    @Autowired
    ManualOperationFramework manualOperationFramework;


    public InquiryManagerWSModel getOperationManagerDetails(long userId) {

        InquiryManagerWSModel response = new InquiryManagerWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getOperationManagerDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
