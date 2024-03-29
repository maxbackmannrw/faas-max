package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.ProcessWappMessageTriggerDBModel;

public class ProcessWappMessageTriggerWSDTO {

    private ProcessWappMessageTriggerDBModel processWappMessageTrigger;

    public ProcessWappMessageTriggerWSDTO() {
    }

    public ProcessWappMessageTriggerWSDTO(ProcessWappMessageTriggerDBModel processWappMessageTrigger) {
        this.processWappMessageTrigger = processWappMessageTrigger;
    }

    public ProcessWappMessageTriggerDBModel getProcessWappMessageTrigger() {
        return processWappMessageTrigger;
    }

    public void setProcessWappMessageTrigger(ProcessWappMessageTriggerDBModel processWappMessageTrigger) {
        this.processWappMessageTrigger = processWappMessageTrigger;
    }
}
