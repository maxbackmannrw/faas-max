package com.faas.core.base.model.ws.process.details.trigger.wapp.dto;

import com.faas.core.base.model.db.process.details.trigger.WappCallTriggerDBModel;

public class ProcessWappCallTriggerWSDTO {

    private WappCallTriggerDBModel processWappCallTrigger;

    public ProcessWappCallTriggerWSDTO() {
    }

    public ProcessWappCallTriggerWSDTO(WappCallTriggerDBModel processWappCallTrigger) {
        this.processWappCallTrigger = processWappCallTrigger;
    }

    public WappCallTriggerDBModel getProcessWappCallTrigger() {
        return processWappCallTrigger;
    }

    public void setProcessWappCallTrigger(WappCallTriggerDBModel processWappCallTrigger) {
        this.processWappCallTrigger = processWappCallTrigger;
    }
}
