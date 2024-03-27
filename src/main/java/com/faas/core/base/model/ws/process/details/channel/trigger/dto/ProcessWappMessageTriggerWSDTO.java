package com.faas.core.base.model.ws.process.details.channel.trigger.dto;

import com.faas.core.base.model.db.process.details.channel.trigger.ProcessWappMessageTriggerDBModel;

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
