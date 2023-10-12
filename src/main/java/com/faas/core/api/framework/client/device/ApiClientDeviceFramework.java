package com.faas.core.api.framework.client.device;

import com.faas.core.api.model.ws.client.session.dto.ApiAgentSessionWSDTO;
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
