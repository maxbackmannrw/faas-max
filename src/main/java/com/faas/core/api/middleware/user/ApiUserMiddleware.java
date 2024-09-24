package com.faas.core.api.middleware.user;

import com.faas.core.api.framework.user.ApiUserFramework;
import com.faas.core.api.model.ws.user.content.ApiAgentWSModel;
import com.faas.core.api.model.ws.user.content.dto.ApiAgentWSDTO;
import com.faas.core.api.model.ws.user.details.ApiAgentDetailsWSModel;
import com.faas.core.api.model.ws.user.details.ApiAgentInfoWSModel;
import com.faas.core.api.model.ws.user.details.ApiAgentSipAccountWSModel;
import com.faas.core.api.model.ws.user.details.dto.ApiAgentDetailsWSDTO;
import com.faas.core.api.model.ws.user.details.dto.ApiAgentInfoWSDTO;
import com.faas.core.api.model.ws.user.details.dto.ApiAgentSipAccountWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ApiUserMiddleware {


    @Autowired
    ApiUserFramework apiUserFramework;


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

    public ApiAgentDetailsWSModel apiGetAgentDetails(long agentId) {

        ApiAgentDetailsWSModel response = new ApiAgentDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentDetailsWSDTO agentDetailsWSDTO = apiUserFramework.apiGetAgentDetailsService(agentId);
        if (agentDetailsWSDTO != null) {
            response.setApiAgentDetails(agentDetailsWSDTO);
        }

        general.setOperation("apiGetAgentDetails");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiAgentSipAccountWSModel apiGetAgentSipAccount(long agentId, String processId) {

        ApiAgentSipAccountWSModel response = new ApiAgentSipAccountWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentSipAccountWSDTO agentSipAccountWSDTO = apiUserFramework.apiGetAgentSipAccountService(agentId, processId);
        if (agentSipAccountWSDTO != null) {
            response.setAgentSipAccount(agentSipAccountWSDTO);
        }

        general.setOperation("apiGetAgentSipAccount");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ApiAgentInfoWSModel apiGetAgentInfo(long agentId) {

        ApiAgentInfoWSModel response = new ApiAgentInfoWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<ApiAgentInfoWSDTO> apiAgentInfoWSDTOS = new ArrayList<>();

        ApiAgentInfoWSDTO agentInfoWSDTO = apiUserFramework.apiGetAgentInfoService(agentId);
        if (agentInfoWSDTO != null) {
            apiAgentInfoWSDTOS.add(agentInfoWSDTO);
        }

        response.setAgentInfos(apiAgentInfoWSDTOS);
        general.setOperation("apiGetAgentInfo");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

}
