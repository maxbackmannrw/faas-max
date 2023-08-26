package com.faas.core.remote.channel.message.sms.service;

import com.faas.core.api.model.ws.operation.channel.message.sms.ApiOperationSmsMessageWSModel;
import com.faas.core.api.model.ws.operation.channel.message.sms.dto.ApiOperationSmsMessageWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RemoteWappMessageService {



    @Autowired
    AppUtils appUtils;


    public ApiOperationSmsMessageWSModel apiGetOperationSmsMessageService(long agentId, long sessionId) {

        return null;
    }




}
