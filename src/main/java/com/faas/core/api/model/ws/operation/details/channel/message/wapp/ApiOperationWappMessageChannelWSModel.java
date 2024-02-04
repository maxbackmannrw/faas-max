package com.faas.core.api.model.ws.operation.details.channel.message.wapp;

import com.faas.core.api.model.ws.operation.details.channel.message.wapp.dto.ApiOperationWappMessageWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

public class ApiOperationWappMessageChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationWappMessageWSDTO operationWappMessage;

    public ApiOperationWappMessageChannelWSModel() {
    }

    public ApiOperationWappMessageChannelWSModel(GeneralWSModel general, ApiOperationWappMessageWSDTO operationWappMessage) {
        this.general = general;
        this.operationWappMessage = operationWappMessage;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationWappMessageWSDTO getOperationWappMessage() {
        return operationWappMessage;
    }

    public void setOperationWappMessage(ApiOperationWappMessageWSDTO operationWappMessage) {
        this.operationWappMessage = operationWappMessage;
    }
}
