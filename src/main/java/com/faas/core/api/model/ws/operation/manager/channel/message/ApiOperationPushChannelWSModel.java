package com.faas.core.api.model.ws.operation.manager.channel.message;

import com.faas.core.api.model.ws.operation.manager.channel.message.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


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
