package com.faas.core.base.model.ws.process.details.channel.trigger.dto;

import com.faas.core.base.model.db.process.details.channel.trigger.ProcessWappMessageTriggerDBModel;

public class ProcessWappMessageTriggerWSDTO {

    private ProcessWappMessageTriggerDBModel wappMessageTrigger;

    public ProcessWappMessageTriggerWSDTO() {
    }

    public ProcessWappMessageTriggerWSDTO(ProcessWappMessageTriggerDBModel wappMessageTrigger) {
        this.wappMessageTrigger = wappMessageTrigger;
    }

    public ProcessWappMessageTriggerDBModel getWappMessageTrigger() {
        return wappMessageTrigger;
    }

    public void setWappMessageTrigger(ProcessWappMessageTriggerDBModel wappMessageTrigger) {
        this.wappMessageTrigger = wappMessageTrigger;
    }
}
