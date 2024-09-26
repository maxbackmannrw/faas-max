package com.faas.core.api.model.ws.operation.manager.channel.message;

import com.faas.core.api.model.ws.operation.manager.channel.message.dto.ApiOperationSmsChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationSmsChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationSmsChannelWSDTO operationSmsChannel;

    public ApiOperationSmsChannelWSModel() {
    }

    public ApiOperationSmsChannelWSModel(GeneralWSModel general, ApiOperationSmsChannelWSDTO operationSmsChannel) {
        this.general = general;
        this.operationSmsChannel = operationSmsChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationSmsChannelWSDTO getOperationSmsChannel() {
        return operationSmsChannel;
    }

    public void setOperationSmsChannel(ApiOperationSmsChannelWSDTO operationSmsChannel) {
        this.operationSmsChannel = operationSmsChannel;
    }
}
