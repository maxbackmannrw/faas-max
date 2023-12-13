package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.ProcessSipCallTriggerDBModel;

public class SipCallTriggerWSDTO {

    private ProcessSipCallTriggerDBModel sipCallTrigger;

    public SipCallTriggerWSDTO() {
    }

    public SipCallTriggerWSDTO(ProcessSipCallTriggerDBModel sipCallTrigger) {
        this.sipCallTrigger = sipCallTrigger;
    }

    public ProcessSipCallTriggerDBModel getSipCallTrigger() {
        return sipCallTrigger;
    }

    public void setSipCallTrigger(ProcessSipCallTriggerDBModel sipCallTrigger) {
        this.sipCallTrigger = sipCallTrigger;
    }
}
