package com.faas.core.api.model.ws.operation.details.channel.message.push;

import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationPushChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationPushChannelWSDTO pushChannel;

    public ApiOperationPushChannelWSModel() {
    }

    public ApiOperationPushChannelWSModel(GeneralWSModel general, ApiOperationPushChannelWSDTO pushChannel) {
        this.general = general;
        this.pushChannel = pushChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationPushChannelWSDTO getPushChannel() {
        return pushChannel;
    }

    public void setPushChannel(ApiOperationPushChannelWSDTO pushChannel) {
        this.pushChannel = pushChannel;
    }
}
