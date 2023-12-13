package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.ProcessWappCallTriggerDBModel;

public class WappCallTriggerWSDTO {

    private ProcessWappCallTriggerDBModel wappCallTrigger;

    public WappCallTriggerWSDTO() {
    }

    public WappCallTriggerWSDTO(ProcessWappCallTriggerDBModel wappCallTrigger) {
        this.wappCallTrigger = wappCallTrigger;
    }

    public ProcessWappCallTriggerDBModel getWappCallTrigger() {
        return wappCallTrigger;
    }

    public void setWappCallTrigger(ProcessWappCallTriggerDBModel wappCallTrigger) {
        this.wappCallTrigger = wappCallTrigger;
    }
}
