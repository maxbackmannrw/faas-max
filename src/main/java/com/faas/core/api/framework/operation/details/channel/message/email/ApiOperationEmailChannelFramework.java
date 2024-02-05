package com.faas.core.api.framework.operation.details.channel.message.email;

import com.faas.core.api.model.ws.operation.details.channel.message.email.dto.ApiOperationEmailWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApiOperationEmailChannelFramework {

    @Autowired
    AppUtils appUtils;


    public ApiOperationEmailWSDTO apiGetOperationEmailMessagesService(long agentId, long sessionId) {

        return null;
    }



    public ApiOperationEmailWSDTO apiGetEmailMessagesService() {

        return null;
    }


    public ApiOperationEmailWSDTO apiGetEmailMessageService() {

        return null;
    }


    public ApiOperationEmailWSDTO apiSendEmailMessageService() {

        return null;
    }


    public ApiOperationEmailWSDTO apiUpdateEmailMessageService() {

        return null;
    }


    public ApiOperationEmailWSDTO apiRemoveEmailMessageService() {

        return null;
    }


    public ApiOperationEmailWSDTO apiGetEmailMessageTempsService() {

        return null;
    }


    public ApiOperationEmailWSDTO apiGetEmailMessageTempService() {

        return null;
    }



}
