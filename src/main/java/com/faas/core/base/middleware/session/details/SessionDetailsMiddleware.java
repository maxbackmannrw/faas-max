package com.faas.core.base.middleware.session.details;

import com.faas.core.base.framework.session.details.SessionDetailsFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.session.details.SessionDetailsWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionDetailsMiddleware {


    @Autowired
    SessionDetailsFramework sessionDetailsFramework;


    public SessionDetailsWSModel getSessionDetails(long userId, String sessionId) {

        SessionDetailsWSModel response = new SessionDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();


        general.setOperation("getSessionDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
