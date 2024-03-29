package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.ProcessAITriggerDBModel;

public class ProcessAITriggerWSDTO {

    private ProcessAITriggerDBModel processAITrigger;

    public ProcessAITriggerWSDTO() {
    }

    public ProcessAITriggerWSDTO(ProcessAITriggerDBModel processAITrigger) {
        this.processAITrigger = processAITrigger;
    }

    public ProcessAITriggerDBModel getProcessAITrigger() {
        return processAITrigger;
    }

    public void setProcessAITrigger(ProcessAITriggerDBModel processAITrigger) {
        this.processAITrigger = processAITrigger;
    }
}
