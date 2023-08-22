package com.faas.core.base.model.ws.operation.channel.dto;

import com.faas.core.base.model.db.operation.channel.PushMessageDBModel;

public class PushMessageWSDTO {

    private PushMessageDBModel pushMessage;

    public PushMessageWSDTO() {
    }

    public PushMessageWSDTO(PushMessageDBModel pushMessage) {
        this.pushMessage = pushMessage;
    }

    public PushMessageDBModel getPushMessage() {
        return pushMessage;
    }

    public void setPushMessage(PushMessageDBModel pushMessage) {
        this.pushMessage = pushMessage;
    }
}
