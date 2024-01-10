package com.faas.core.api.framework.client.details;

import com.faas.core.api.model.ws.client.details.dto.ApiClientDetailsWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiClientDetailsFramework {

    @Autowired
    AppUtils appUtils;


    public ApiClientDetailsWSDTO apiGetAgentSessionService(long agentId, int reqPage, int reqSize) {

        ApiClientDetailsWSDTO clientDetailsWSDTO = new ApiClientDetailsWSDTO();

        return clientDetailsWSDTO;
    }

    
}
