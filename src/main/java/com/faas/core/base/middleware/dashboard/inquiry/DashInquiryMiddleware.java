package com.faas.core.base.middleware.dashboard.inquiry;

import com.faas.core.base.framework.dashboard.inquiry.DashInquiryFramework;
import com.faas.core.base.model.ws.dashboard.inquiry.DashboardInquiryWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DashInquiryMiddleware {


    @Autowired
    DashInquiryFramework dashInquiryFramework;


    public DashboardInquiryWSModel getDashboardInquiries(long userId, int reqPage, int reqSize) {

        DashboardInquiryWSModel response = new DashboardInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getDashboardInquiries");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
