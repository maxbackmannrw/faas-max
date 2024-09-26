package com.faas.core.api.model.ws.operation.channel.message;

import com.faas.core.api.model.ws.operation.channel.message.dto.ApiOperationWappMessageChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

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
