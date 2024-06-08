package com.faas.core.base.model.ws.process.details.trigger.details.dto;

import com.faas.core.base.model.db.process.details.trigger.WappMessageTriggerDBModel;

public class ProcessWappMessageTriggerWSDTO {

    private WappMessageTriggerDBModel processWappMessageTrigger;

    public ProcessWappMessageTriggerWSDTO() {
    }

    public ProcessWappMessageTriggerWSDTO(WappMessageTriggerDBModel processWappMessageTrigger) {
        this.processWappMessageTrigger = processWappMessageTrigger;
    }

    public WappMessageTriggerDBModel getProcessWappMessageTrigger() {
        return processWappMessageTrigger;
    }

    public void setProcessWappMessageTrigger(WappMessageTriggerDBModel processWappMessageTrigger) {
        this.processWappMessageTrigger = processWappMessageTrigger;
    }
}
