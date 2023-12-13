package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;

public class ProcessPushTempWSDTO {

    private ProcessPushTempDBModel pushTemp;

    public ProcessPushTempWSDTO() {
    }

    public ProcessPushTempWSDTO(ProcessPushTempDBModel pushTemp) {
        this.pushTemp = pushTemp;
    }

    public ProcessPushTempDBModel getPushTemp() {
        return pushTemp;
    }

    public void setPushTemp(ProcessPushTempDBModel pushTemp) {
        this.pushTemp = pushTemp;
    }
}
