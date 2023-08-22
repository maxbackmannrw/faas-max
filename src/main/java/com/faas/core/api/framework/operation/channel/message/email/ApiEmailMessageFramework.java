package com.faas.core.api.framework.operation.channel.message.email;

import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiEmailWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiEmailMessageFramework {

    @Autowired
    AppUtils appUtils;


    public ApiOperationEmailWSDTO apiGetOperationEmailMessagesService(long agentId, long sessionId) {

        return null;
    }



    public ApiEmailWSDTO apiGetEmailMessagesService() {

        return null;
    }


    public ApiEmailWSDTO apiGetEmailMessageService() {

        return null;
    }


    public ApiEmailWSDTO apiSendEmailMessageService() {

        return null;
    }


    public ApiEmailWSDTO apiUpdateEmailMessageService() {

        return null;
    }


    public ApiEmailWSDTO apiRemoveEmailMessageService() {

        return null;
    }


    public ApiEmailWSDTO apiGetEmailMessageTempsService() {

        return null;
    }


    public ApiEmailWSDTO apiGetEmailMessageTempService() {

        return null;
    }



}
