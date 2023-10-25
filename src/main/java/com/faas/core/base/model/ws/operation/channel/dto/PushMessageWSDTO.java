package com.faas.core.base.model.ws.operation.channel.dto;

import com.faas.core.base.model.db.operation.channel.OperationPushMessageDBModel;

public class PushMessageWSDTO {

    private OperationPushMessageDBModel pushMessage;

    public PushMessageWSDTO() {
    }

    public PushMessageWSDTO(OperationPushMessageDBModel pushMessage) {
        this.pushMessage = pushMessage;
    }

    public OperationPushMessageDBModel getPushMessage() {
        return pushMessage;
    }

    public void setPushMessage(OperationPushMessageDBModel pushMessage) {
        this.pushMessage = pushMessage;
    }
}
