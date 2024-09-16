package com.faas.core.api.middleware.agent.content;

import com.faas.core.api.framework.agent.content.ApiAgentFramework;
import com.faas.core.data.ws.api.agent.content.ApiAgentWSModel;
import com.faas.core.data.ws.api.agent.content.dto.ApiAgentWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import com.faas.core.misc.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiAgentMiddleware {


    @Autowired
    ApiAgentFramework apiAgentFramework;

    @Autowired
    AppUtils appUtils;


    public ApiAgentWSModel apiAgentLogin(String userEmail, String password) {

        ApiAgentWSModel response = new ApiAgentWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiAgentWSDTO> apiAgentWSDTOS = new ArrayList<>();

        ApiAgentWSDTO apiAgentWSDTO = apiAgentFramework.apiAgentLoginService(userEmail, password);
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
