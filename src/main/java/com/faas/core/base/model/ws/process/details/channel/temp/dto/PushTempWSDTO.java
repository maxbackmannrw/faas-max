package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;

public class PushTempWSDTO {

    private ProcessPushTempDBModel pushTemp;

    public PushTempWSDTO() {
    }

    public PushTempWSDTO(ProcessPushTempDBModel pushTemp) {
        this.pushTemp = pushTemp;
    }

    public ProcessPushTempDBModel getPushTemp() {
        return pushTemp;
    }

    public void setPushTemp(ProcessPushTempDBModel pushTemp) {
        this.pushTemp = pushTemp;
    }
}
