package com.faas.core.base.middleware.dashboard.session;

import com.faas.core.base.framework.dashboard.session.DashSessionFramework;
import com.faas.core.base.model.ws.client.content.dto.AllClientsWSDTO;
import com.faas.core.base.model.ws.dashboard.session.DashboardSessionWSModel;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DashSessionMiddleware {


    @Autowired
    DashSessionFramework dashSessionFramework;


    public DashboardSessionWSModel getDashboardSessions(long userId, int reqPage, int reqSize) {

        DashboardSessionWSModel response = new DashboardSessionWSModel();
        GeneralWSModel general = new GeneralWSModel();
        AllClientsWSDTO allClientsWSDTO = new AllClientsWSDTO();


        general.setOperation("getDashboardSessions");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
