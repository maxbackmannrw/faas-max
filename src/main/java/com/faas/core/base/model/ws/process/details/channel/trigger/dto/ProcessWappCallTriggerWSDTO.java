package com.faas.core.base.model.ws.process.details.channel.trigger.dto;

import com.faas.core.base.model.db.process.details.channel.trigger.ProcessWappCallTriggerDBModel;

public class ProcessWappCallTriggerWSDTO {

    private ProcessWappCallTriggerDBModel wappCallTrigger;

    public ProcessWappCallTriggerWSDTO() {
    }

    public ProcessWappCallTriggerWSDTO(ProcessWappCallTriggerDBModel wappCallTrigger) {
        this.wappCallTrigger = wappCallTrigger;
    }

    public ProcessWappCallTriggerDBModel getWappCallTrigger() {
        return wappCallTrigger;
    }

    public void setWappCallTrigger(ProcessWappCallTriggerDBModel wappCallTrigger) {
        this.wappCallTrigger = wappCallTrigger;
    }
}
