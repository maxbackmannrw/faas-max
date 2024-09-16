package com.faas.core.data.ws.api.operation.details.channel.message.wapp;

import com.faas.core.data.ws.api.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

public class ApiOperationWappMessageChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationWappMessageChannelWSDTO operationWappMessageChannel;

    public ApiOperationWappMessageChannelWSModel() {
    }

    public ApiOperationWappMessageChannelWSModel(GeneralWSModel general, ApiOperationWappMessageChannelWSDTO operationWappMessageChannel) {
        this.general = general;
        this.operationWappMessageChannel = operationWappMessageChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationWappMessageChannelWSDTO getOperationWappMessageChannel() {
        return operationWappMessageChannel;
    }

    public void setOperationWappMessageChannel(ApiOperationWappMessageChannelWSDTO operationWappMessageChannel) {
        this.operationWappMessageChannel = operationWappMessageChannel;
    }
}
