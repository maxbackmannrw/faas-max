package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.ProcessWappMessageTriggerDBModel;

public class WappMessageTriggerWSDTO {

    private ProcessWappMessageTriggerDBModel wappMessageTrigger;

    public WappMessageTriggerWSDTO() {
    }

    public WappMessageTriggerWSDTO(ProcessWappMessageTriggerDBModel wappMessageTrigger) {
        this.wappMessageTrigger = wappMessageTrigger;
    }

    public ProcessWappMessageTriggerDBModel getWappMessageTrigger() {
        return wappMessageTrigger;
    }

    public void setWappMessageTrigger(ProcessWappMessageTriggerDBModel wappMessageTrigger) {
        this.wappMessageTrigger = wappMessageTrigger;
    }
}
