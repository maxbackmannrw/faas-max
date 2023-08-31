package com.faas.core.api.framework.operation.channel.message.push;

import com.faas.core.api.model.ws.operation.channel.message.push.dto.ApiOperationPushMessageWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.push.dto.ApiPushMessageTempWSDTO;
import com.faas.core.api.model.ws.operation.channel.message.push.dto.ApiPushMessageWSDTO;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiPushMessageFramework {


    @Autowired
    AppUtils appUtils;


    public ApiOperationPushMessageWSDTO apiGetOperationPushMessagesService() {

        return null;
    }


    public ApiPushMessageWSDTO apiGetPushMessagesService() {

        return null;
    }


    public ApiPushMessageWSDTO apiGetPushMessageService() {

        return null;
    }


    public ApiPushMessageWSDTO apiSendPushMessageService() {

        return null;
    }


    public ApiPushMessageWSDTO apiUpdatePushMessageService() {

        return null;
    }


    public ApiPushMessageWSDTO apiRemovePushMessageService() {

        return null;
    }



    public ApiPushMessageTempWSDTO apiGetPushMessageTempsService() {

        return null;
    }

    public ApiPushMessageTempWSDTO apiGetPushMessageTempService() {

        return null;
    }

}
