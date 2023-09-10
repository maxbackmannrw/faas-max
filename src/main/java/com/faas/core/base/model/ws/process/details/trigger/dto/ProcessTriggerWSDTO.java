package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.ProcessTriggerDBModel;

public class ProcessTriggerWSDTO {

    private ProcessTriggerDBModel processTrigger;

    public ProcessTriggerWSDTO() {
    }

    public ProcessTriggerWSDTO(ProcessTriggerDBModel processTrigger) {
        this.processTrigger = processTrigger;
    }

    public ProcessTriggerDBModel getProcessTrigger() {
        return processTrigger;
    }

    public void setProcessTrigger(ProcessTriggerDBModel processTrigger) {
        this.processTrigger = processTrigger;
    }
}
