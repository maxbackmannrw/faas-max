package com.faas.core.api.framework.operation.channel.messenger;

import com.faas.core.api.model.ws.operation.channel.messenger.dto.ApiMessengerWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiMessengerFramework {


    @Autowired
    AppUtils appUtils;



    public ApiMessengerWSDTO apiGetOperationMessengersService(long agentId, long sessionId) {

        return null;
    }


}
