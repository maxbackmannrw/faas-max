package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationPushMessageDBModel;

public class OperationPushMessageWSDTO {

    private OperationPushMessageDBModel pushMessage;

    public OperationPushMessageWSDTO() {
    }

    public OperationPushMessageWSDTO(OperationPushMessageDBModel pushMessage) {
        this.pushMessage = pushMessage;
    }

    public OperationPushMessageDBModel getPushMessage() {
        return pushMessage;
    }

    public void setPushMessage(OperationPushMessageDBModel pushMessage) {
        this.pushMessage = pushMessage;
    }
}
