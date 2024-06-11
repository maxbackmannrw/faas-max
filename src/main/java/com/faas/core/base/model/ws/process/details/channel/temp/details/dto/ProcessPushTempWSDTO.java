package com.faas.core.base.model.ws.process.details.channel.temp.details.dto;

import com.faas.core.base.model.db.process.details.channel.temp.PushTempDBModel;

public class ProcessPushTempWSDTO {

    private PushTempDBModel processPushTemp;

    public ProcessPushTempWSDTO() {
    }

    public ProcessPushTempWSDTO(PushTempDBModel processPushTemp) {
        this.processPushTemp = processPushTemp;
    }

    public PushTempDBModel getProcessPushTemp() {
        return processPushTemp;
    }

    public void setProcessPushTemp(PushTempDBModel processPushTemp) {
        this.processPushTemp = processPushTemp;
    }
}
