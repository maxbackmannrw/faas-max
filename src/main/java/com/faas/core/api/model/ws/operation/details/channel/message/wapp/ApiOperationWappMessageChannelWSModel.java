package com.faas.core.api.model.ws.operation.details.channel.message.wapp;

import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationWappMessageChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationWappMessageChannelWSDTO operationWappMessage;

    public ApiOperationWappMessageChannelWSModel() {
    }

    public ApiOperationWappMessageChannelWSModel(GeneralWSModel general, ApiOperationWappMessageChannelWSDTO operationWappMessage) {
        this.general = general;
        this.operationWappMessage = operationWappMessage;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationWappMessageChannelWSDTO getOperationWappMessage() {
        return operationWappMessage;
    }

    public void setOperationWappMessage(ApiOperationWappMessageChannelWSDTO operationWappMessage) {
        this.operationWappMessage = operationWappMessage;
    }
}
