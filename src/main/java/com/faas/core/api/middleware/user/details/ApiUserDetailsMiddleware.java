package com.faas.core.api.middleware.user.details;

import com.faas.core.api.framework.user.details.ApiUserDetailsFramework;
import com.faas.core.data.ws.api.agent.details.ApiAgentDetailsWSModel;
import com.faas.core.data.ws.api.agent.details.ApiAgentInfoWSModel;
import com.faas.core.data.ws.api.agent.details.ApiAgentSipAccountWSModel;
import com.faas.core.data.ws.api.agent.details.dto.ApiAgentDetailsWSDTO;
import com.faas.core.data.ws.api.agent.details.dto.ApiAgentInfoWSDTO;
import com.faas.core.data.ws.api.agent.details.dto.ApiAgentSipAccountWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.misc.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiUserDetailsMiddleware {


    @Autowired
    ApiUserDetailsFramework apiUserDetailsFramework;


    public ApiAgentDetailsWSModel apiGetAgentDetails(long agentId) {

        ApiAgentDetailsWSModel response = new ApiAgentDetailsWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ApiAgentDetailsWSDTO agentDetailsWSDTO = apiUserDetailsFramework.apiGetAgentDetailsService(agentId);
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

        ApiAgentSipAccountWSDTO agentSipAccountWSDTO = apiUserDetailsFramework.apiGetAgentSipAccountService(agentId, processId);
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

        ApiAgentInfoWSDTO agentInfoWSDTO = apiUserDetailsFramework.apiGetAgentInfoService(agentId);
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
