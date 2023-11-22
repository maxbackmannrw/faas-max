package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.SmsMessageTriggerDBModel;

public class SmsMessageTriggerWSDTO {

    private SmsMessageTriggerDBModel smsMessageTrigger;

    public SmsMessageTriggerWSDTO() {
    }

    public SmsMessageTriggerWSDTO(SmsMessageTriggerDBModel smsMessageTrigger) {
        this.smsMessageTrigger = smsMessageTrigger;
    }

    public SmsMessageTriggerDBModel getSmsMessageTrigger() {
        return smsMessageTrigger;
    }

    public void setSmsMessageTrigger(SmsMessageTriggerDBModel smsMessageTrigger) {
        this.smsMessageTrigger = smsMessageTrigger;
    }
}
