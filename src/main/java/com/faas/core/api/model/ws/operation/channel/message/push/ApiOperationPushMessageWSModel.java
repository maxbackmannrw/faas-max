package com.faas.core.api.model.ws.operation.channel.message.push;

import com.faas.core.api.model.ws.operation.channel.message.push.dto.ApiOperationPushMessageWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationPushMessageWSModel {

    private GeneralWSModel general;
    private ApiOperationPushMessageWSDTO operationPushMessage;

    public ApiOperationPushMessageWSModel() {
    }

    public ApiOperationPushMessageWSModel(GeneralWSModel general, ApiOperationPushMessageWSDTO operationPushMessage) {
        this.general = general;
        this.operationPushMessage = operationPushMessage;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationPushMessageWSDTO getOperationPushMessage() {
        return operationPushMessage;
    }

    public void setOperationPushMessage(ApiOperationPushMessageWSDTO operationPushMessage) {
        this.operationPushMessage = operationPushMessage;
    }
}
