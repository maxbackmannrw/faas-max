package com.faas.core.api.model.ws.operation.channel.message.push.dto;

import com.faas.core.base.model.db.process.details.channel.temp.PushTempDBModel;

public class ApiPushMessageTempWSDTO {

    private PushTempDBModel pushTemp;

    public ApiPushMessageTempWSDTO() {
    }

    public ApiPushMessageTempWSDTO(PushTempDBModel pushTemp) {
        this.pushTemp = pushTemp;
    }

    public PushTempDBModel getPushTemp() {
        return pushTemp;
    }

    public void setPushTemp(PushTempDBModel pushTemp) {
        this.pushTemp = pushTemp;
    }
}
