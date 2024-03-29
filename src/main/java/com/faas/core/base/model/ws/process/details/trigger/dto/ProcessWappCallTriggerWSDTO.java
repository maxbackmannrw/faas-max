package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.ProcessWappCallTriggerDBModel;

public class ProcessWappCallTriggerWSDTO {

    private ProcessWappCallTriggerDBModel processWappCallTrigger;

    public ProcessWappCallTriggerWSDTO() {
    }

    public ProcessWappCallTriggerWSDTO(ProcessWappCallTriggerDBModel processWappCallTrigger) {
        this.processWappCallTrigger = processWappCallTrigger;
    }

    public ProcessWappCallTriggerDBModel getProcessWappCallTrigger() {
        return processWappCallTrigger;
    }

    public void setProcessWappCallTrigger(ProcessWappCallTriggerDBModel processWappCallTrigger) {
        this.processWappCallTrigger = processWappCallTrigger;
    }
}
