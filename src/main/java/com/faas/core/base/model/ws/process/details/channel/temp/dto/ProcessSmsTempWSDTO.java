package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.ProcessSmsTempDBModel;

public class ProcessSmsTempWSDTO {

    private ProcessSmsTempDBModel processSmsTemp;

    public ProcessSmsTempWSDTO() {
    }

    public ProcessSmsTempWSDTO(ProcessSmsTempDBModel processSmsTemp) {
        this.processSmsTemp = processSmsTemp;
    }

    public ProcessSmsTempDBModel getProcessSmsTemp() {
        return processSmsTemp;
    }

    public void setProcessSmsTemp(ProcessSmsTempDBModel processSmsTemp) {
        this.processSmsTemp = processSmsTemp;
    }
}
