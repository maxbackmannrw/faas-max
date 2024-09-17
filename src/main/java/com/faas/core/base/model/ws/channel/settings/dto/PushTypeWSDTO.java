package com.faas.core.base.model.ws.channel.settings.dto;

import com.faas.core.data.db.channel.settings.PushTypeDBModel;

public class PushTypeWSDTO {

    private PushTypeDBModel pushType;

    public PushTypeWSDTO() {
    }

    public PushTypeWSDTO(PushTypeDBModel pushType) {
        this.pushType = pushType;
    }

    public PushTypeDBModel getPushType() {
        return pushType;
    }

    public void setPushType(PushTypeDBModel pushType) {
        this.pushType = pushType;
    }
}
