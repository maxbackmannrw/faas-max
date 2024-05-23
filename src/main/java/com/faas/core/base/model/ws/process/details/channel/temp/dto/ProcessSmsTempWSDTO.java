package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.SmsTempDBModel;

public class ProcessSmsTempWSDTO {

    private SmsTempDBModel processSmsTemp;

    public ProcessSmsTempWSDTO() {
    }

    public ProcessSmsTempWSDTO(SmsTempDBModel processSmsTemp) {
        this.processSmsTemp = processSmsTemp;
    }

    public SmsTempDBModel getProcessSmsTemp() {
        return processSmsTemp;
    }

    public void setProcessSmsTemp(SmsTempDBModel processSmsTemp) {
        this.processSmsTemp = processSmsTemp;
    }
}
