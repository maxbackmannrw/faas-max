package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.SipCallTriggerDBModel;

public class SipCallTriggerWSDTO {

    private SipCallTriggerDBModel sipCallTrigger;

    public SipCallTriggerWSDTO() {
    }

    public SipCallTriggerWSDTO(SipCallTriggerDBModel sipCallTrigger) {
        this.sipCallTrigger = sipCallTrigger;
    }

    public SipCallTriggerDBModel getSipCallTrigger() {
        return sipCallTrigger;
    }

    public void setSipCallTrigger(SipCallTriggerDBModel sipCallTrigger) {
        this.sipCallTrigger = sipCallTrigger;
    }
}
