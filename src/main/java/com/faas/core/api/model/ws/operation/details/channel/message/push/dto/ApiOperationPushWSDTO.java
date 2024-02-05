package com.faas.core.api.model.ws.operation.details.channel.message.push.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationPushMessageDBModel;

public class ApiOperationPushWSDTO {

    private OperationPushMessageDBModel pushMessage;

    public ApiOperationPushWSDTO() {
    }

    public ApiOperationPushWSDTO(OperationPushMessageDBModel pushMessage) {
        this.pushMessage = pushMessage;
    }

    public OperationPushMessageDBModel getPushMessage() {
        return pushMessage;
    }

    public void setPushMessage(OperationPushMessageDBModel pushMessage) {
        this.pushMessage = pushMessage;
    }
}
