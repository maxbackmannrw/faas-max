package com.faas.core.api.framework.operation.details.channel.message.push;

import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushTempWSDTO;
import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiOperationPushChannelFramework {


    @Autowired
    AppUtils appUtils;


    public ApiOperationPushChannelWSDTO apiGetOperationPushMessagesService() {

        return null;
    }


    public ApiOperationPushWSDTO apiGetPushMessagesService() {

        return null;
    }


    public ApiOperationPushWSDTO apiGetPushMessageService() {

        return null;
    }


    public ApiOperationPushWSDTO apiSendPushMessageService() {

        return null;
    }


    public ApiOperationPushWSDTO apiUpdatePushMessageService() {

        return null;
    }


    public ApiOperationPushWSDTO apiRemovePushMessageService() {

        return null;
    }



    public ApiOperationPushTempWSDTO apiGetPushMessageTempsService() {

        return null;
    }

    public ApiOperationPushTempWSDTO apiGetPushMessageTempService() {

        return null;
    }

}
