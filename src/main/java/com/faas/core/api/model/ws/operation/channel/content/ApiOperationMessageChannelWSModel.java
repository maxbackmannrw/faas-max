package com.faas.core.api.model.ws.operation.channel.content;

import com.faas.core.api.model.ws.operation.channel.content.dto.ApiOperationMessageChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationMessageChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationMessageChannelWSDTO operationMessageChannel;

    public ApiOperationMessageChannelWSModel() {
    }

    public ApiOperationMessageChannelWSModel(GeneralWSModel general, ApiOperationMessageChannelWSDTO operationMessageChannel) {
        this.general = general;
        this.operationMessageChannel = operationMessageChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationMessageChannelWSDTO getOperationMessageChannel() {
        return operationMessageChannel;
    }

    public void setOperationMessageChannel(ApiOperationMessageChannelWSDTO operationMessageChannel) {
        this.operationMessageChannel = operationMessageChannel;
    }
}
