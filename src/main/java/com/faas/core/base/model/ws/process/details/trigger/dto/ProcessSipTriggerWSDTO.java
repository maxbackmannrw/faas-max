package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.SipTriggerDBModel;

public class ProcessSipTriggerWSDTO {

    private SipTriggerDBModel processSipTrigger;

    public ProcessSipTriggerWSDTO() {
    }

    public ProcessSipTriggerWSDTO(SipTriggerDBModel processSipTrigger) {
        this.processSipTrigger = processSipTrigger;
    }

    public SipTriggerDBModel getProcessSipTrigger() {
        return processSipTrigger;
    }

    public void setProcessSipTrigger(SipTriggerDBModel processSipTrigger) {
        this.processSipTrigger = processSipTrigger;
    }
}
