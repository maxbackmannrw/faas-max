package com.faas.core.api.model.ws.operation.channel.push.dto;

import com.faas.core.base.model.db.operation.channel.PushMessageDBModel;

public class ApiPushMessageWSDTO {

    private PushMessageDBModel pushMessage;

    public ApiPushMessageWSDTO() {
    }

    public ApiPushMessageWSDTO(PushMessageDBModel pushMessage) {
        this.pushMessage = pushMessage;
    }

    public PushMessageDBModel getPushMessage() {
        return pushMessage;
    }

    public void setPushMessage(PushMessageDBModel pushMessage) {
        this.pushMessage = pushMessage;
    }
}
