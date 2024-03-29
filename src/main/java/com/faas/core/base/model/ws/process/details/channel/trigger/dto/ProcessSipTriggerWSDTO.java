package com.faas.core.base.model.ws.process.details.channel.trigger.dto;

import com.faas.core.base.model.db.process.details.channel.trigger.ProcessSipTriggerDBModel;

public class ProcessSipTriggerWSDTO {

    private ProcessSipTriggerDBModel processSipTrigger;

    public ProcessSipTriggerWSDTO() {
    }

    public ProcessSipTriggerWSDTO(ProcessSipTriggerDBModel processSipTrigger) {
        this.processSipTrigger = processSipTrigger;
    }

    public ProcessSipTriggerDBModel getProcessSipTrigger() {
        return processSipTrigger;
    }

    public void setProcessSipTrigger(ProcessSipTriggerDBModel processSipTrigger) {
        this.processSipTrigger = processSipTrigger;
    }
}
