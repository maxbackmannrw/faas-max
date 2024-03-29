package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.ProcessSipCallTriggerDBModel;

public class ProcessSipCallTriggerWSDTO {

    private ProcessSipCallTriggerDBModel processSipCallTrigger;

    public ProcessSipCallTriggerWSDTO() {
    }

    public ProcessSipCallTriggerWSDTO(ProcessSipCallTriggerDBModel processSipCallTrigger) {
        this.processSipCallTrigger = processSipCallTrigger;
    }

    public ProcessSipCallTriggerDBModel getProcessSipCallTrigger() {
        return processSipCallTrigger;
    }

    public void setProcessSipCallTrigger(ProcessSipCallTriggerDBModel processSipCallTrigger) {
        this.processSipCallTrigger = processSipCallTrigger;
    }
}
