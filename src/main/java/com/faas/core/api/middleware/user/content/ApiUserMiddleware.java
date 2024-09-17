package com.faas.core.api.middleware.user.content;

import com.faas.core.api.framework.user.content.ApiUserFramework;
import com.faas.core.api.model.ws.agent.content.ApiAgentWSModel;
import com.faas.core.api.model.ws.agent.content.dto.ApiAgentWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiUserMiddleware {


    @Autowired
    ApiUserFramework apiUserFramework;

    @Autowired
    AppUtils appUtils;


    public ApiAgentWSModel apiAgentLogin(String userEmail, String password) {

        ApiAgentWSModel response = new ApiAgentWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiAgentWSDTO> apiAgentWSDTOS = new ArrayList<>();

        ApiAgentWSDTO apiAgentWSDTO = apiUserFramework.apiAgentLoginService(userEmail, password);
        if (apiAgentWSDTO != null) {
            apiAgentWSDTOS.add(apiAgentWSDTO);
        }

        response.setAgents(apiAgentWSDTOS);
        general.setOperation("apiAgentLogin");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


}
