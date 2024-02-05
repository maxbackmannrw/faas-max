package com.faas.core.api.model.ws.operation.details.channel.message.push;

import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushChannelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationPushChannelWSModel {

    private GeneralWSModel general;
    private ApiOperationPushChannelWSDTO operationPushMessage;

    public ApiOperationPushChannelWSModel() {
    }

    public ApiOperationPushChannelWSModel(GeneralWSModel general, ApiOperationPushChannelWSDTO operationPushMessage) {
        this.general = general;
        this.operationPushMessage = operationPushMessage;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationPushChannelWSDTO getOperationPushMessage() {
        return operationPushMessage;
    }

    public void setOperationPushMessage(ApiOperationPushChannelWSDTO operationPushMessage) {
        this.operationPushMessage = operationPushMessage;
    }
}
