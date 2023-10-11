package com.faas.core.api.framework.client.details;

import com.faas.core.api.model.ws.session.dto.ApiAgentSessionWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiClientDeviceFramework {

    @Autowired
    AppUtils appUtils;


    public ApiAgentSessionWSDTO apiGetAgentSessionService(long agentId, int reqPage, int reqSize) {

        ApiAgentSessionWSDTO agentSessionWSDTO = new ApiAgentSessionWSDTO();

        return agentSessionWSDTO;
    }

    
}
