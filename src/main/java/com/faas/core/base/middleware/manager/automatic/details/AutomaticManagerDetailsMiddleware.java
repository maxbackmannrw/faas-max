package com.faas.core.base.middleware.manager.automatic.details;

import com.faas.core.base.framework.manager.automatic.details.AutomaticManagerDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.automatic.AutomaticOperationListWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AutomaticManagerDetailsMiddleware {


    @Autowired
    AutomaticManagerDetailsFramework automaticManagerDetailsFramework;


    public AutomaticOperationListWSModel getAutomaticOperations(long userId, String sessionState, int reqPage, int reqSize) {

        AutomaticOperationListWSModel response = new AutomaticOperationListWSModel();
        GeneralWSModel general = new GeneralWSModel();



        general.setOperation("getAutomaticOperations");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
