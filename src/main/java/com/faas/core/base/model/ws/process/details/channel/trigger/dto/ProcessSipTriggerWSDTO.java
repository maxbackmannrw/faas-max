package com.faas.core.base.model.ws.process.details.channel.trigger.dto;

import com.faas.core.base.model.db.process.details.channel.trigger.ProcessSipTriggerDBModel;

public class ProcessSipTriggerWSDTO {

    private ProcessSipTriggerDBModel sipCallTrigger;

    public ProcessSipTriggerWSDTO() {
    }

    public ProcessSipTriggerWSDTO(ProcessSipTriggerDBModel sipCallTrigger) {
        this.sipCallTrigger = sipCallTrigger;
    }

    public ProcessSipTriggerDBModel getSipCallTrigger() {
        return sipCallTrigger;
    }

    public void setSipCallTrigger(ProcessSipTriggerDBModel sipCallTrigger) {
        this.sipCallTrigger = sipCallTrigger;
    }
}
