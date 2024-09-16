package com.faas.core.data.ws.api.operation.details.channel.message.push;

import com.faas.core.data.ws.api.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;


public class ApiOperationPushChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationPushChannelWSDTO operationPushChannel;

    public ApiOperationPushChannelWSModel() {
    }

    public ApiOperationPushChannelWSModel(GeneralWSModel general, ApiOperationPushChannelWSDTO operationPushChannel) {
        this.general = general;
        this.operationPushChannel = operationPushChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationPushChannelWSDTO getOperationPushChannel() {
        return operationPushChannel;
    }

    public void setOperationPushChannel(ApiOperationPushChannelWSDTO operationPushChannel) {
        this.operationPushChannel = operationPushChannel;
    }
}
