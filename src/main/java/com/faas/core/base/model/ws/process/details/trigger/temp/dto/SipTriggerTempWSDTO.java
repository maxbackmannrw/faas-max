package com.faas.core.base.model.ws.process.details.trigger.temp.dto;

import com.faas.core.base.model.db.process.details.trigger.SipTriggerTempDBModel;

public class SipTriggerTempWSDTO {

    private SipTriggerTempDBModel sipTriggerTemp;

    public SipTriggerTempWSDTO() {
    }

    public SipTriggerTempWSDTO(SipTriggerTempDBModel sipTriggerTemp) {
        this.sipTriggerTemp = sipTriggerTemp;
    }

    public SipTriggerTempDBModel getSipTriggerTemp() {
        return sipTriggerTemp;
    }

    public void setSipTriggerTemp(SipTriggerTempDBModel sipTriggerTemp) {
        this.sipTriggerTemp = sipTriggerTemp;
    }
}
