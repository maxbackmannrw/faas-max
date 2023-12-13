package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.ProcessSmsMessageTriggerDBModel;

public class SmsMessageTriggerWSDTO {

    private ProcessSmsMessageTriggerDBModel smsMessageTrigger;

    public SmsMessageTriggerWSDTO() {
    }

    public SmsMessageTriggerWSDTO(ProcessSmsMessageTriggerDBModel smsMessageTrigger) {
        this.smsMessageTrigger = smsMessageTrigger;
    }

    public ProcessSmsMessageTriggerDBModel getSmsMessageTrigger() {
        return smsMessageTrigger;
    }

    public void setSmsMessageTrigger(ProcessSmsMessageTriggerDBModel smsMessageTrigger) {
        this.smsMessageTrigger = smsMessageTrigger;
    }
}
