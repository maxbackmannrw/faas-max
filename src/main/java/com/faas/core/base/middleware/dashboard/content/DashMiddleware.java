package com.faas.core.base.middleware.dashboard.content;

import com.faas.core.base.framework.dashboard.content.DashFramework;
import com.faas.core.base.model.ws.dashboard.content.DashboardWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DashMiddleware {


    @Autowired
    DashFramework dashFramework;


    public DashboardWSModel getDashboard(long userId, int reqPage, int reqSize) {

        DashboardWSModel response = new DashboardWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getDashboard");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
