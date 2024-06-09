package com.faas.core.base.middleware.dashboard.flow;

import com.faas.core.base.framework.dashboard.inquiry.DashInquiryFramework;
import com.faas.core.base.model.ws.dashboard.flow.DashboardFlowWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utility.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DashFlowMiddleware {


    @Autowired
    DashInquiryFramework dashInquiryFramework;


    public DashboardFlowWSModel getDashboardFlows(long userId, int reqPage, int reqSize) {

        DashboardFlowWSModel response = new DashboardFlowWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getDashboardFlows");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
