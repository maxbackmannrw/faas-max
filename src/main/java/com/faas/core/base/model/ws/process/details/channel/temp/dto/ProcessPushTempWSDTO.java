package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessPushTempDBModel;

public class ProcessPushTempWSDTO {

    private ProcessPushTempDBModel processPushTemp;

    public ProcessPushTempWSDTO() {
    }

    public ProcessPushTempWSDTO(ProcessPushTempDBModel processPushTemp) {
        this.processPushTemp = processPushTemp;
    }

    public ProcessPushTempDBModel getProcessPushTemp() {
        return processPushTemp;
    }

    public void setProcessPushTemp(ProcessPushTempDBModel processPushTemp) {
        this.processPushTemp = processPushTemp;
    }
}
