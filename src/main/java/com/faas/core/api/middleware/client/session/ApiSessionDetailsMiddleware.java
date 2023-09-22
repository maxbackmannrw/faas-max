package com.faas.core.api.middleware.client.session;

import com.faas.core.api.framework.client.session.ApiSessionDetailsFramework;
import com.faas.core.api.model.ws.client.session.ApiSessionDetailsWSModel;
import com.faas.core.api.model.ws.client.session.dto.ApiSessionDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiSessionDetailsMiddleware {


    @Autowired
    ApiSessionDetailsFramework apiSessionDetailsFramework;


    public ApiSessionDetailsWSModel apiGetSessionDetails(long agentId, long sessionId) {

        ApiSessionDetailsWSModel response = new ApiSessionDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiSessionDetailsWSDTO sessionDetailsWSDTO = apiSessionDetailsFramework.apiGetSessionDetailsService(agentId,sessionId);
        if (sessionDetailsWSDTO != null) {
            response.setSessionDetails(sessionDetailsWSDTO);
        }

        general.setOperation("apiGetSessionDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }







}
