package com.faas.core.api.model.ws.operation.channel.message.push.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;

public class ApiPushMessageTempWSDTO {

    private ProcessPushTempDBModel pushTemp;

    public ApiPushMessageTempWSDTO() {
    }

    public ApiPushMessageTempWSDTO(ProcessPushTempDBModel pushTemp) {
        this.pushTemp = pushTemp;
    }

    public ProcessPushTempDBModel getPushTemp() {
        return pushTemp;
    }

    public void setPushTemp(ProcessPushTempDBModel pushTemp) {
        this.pushTemp = pushTemp;
    }
}
