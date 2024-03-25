package com.faas.core.base.model.ws.process.details.channel.trigger.dto;

import com.faas.core.base.model.db.process.details.channel.trigger.ProcessSmsTriggerDBModel;

public class ProcessSmsTriggerWSDTO {

    private ProcessSmsTriggerDBModel smsMessageTrigger;

    public ProcessSmsTriggerWSDTO() {
    }

    public ProcessSmsTriggerWSDTO(ProcessSmsTriggerDBModel smsMessageTrigger) {
        this.smsMessageTrigger = smsMessageTrigger;
    }

    public ProcessSmsTriggerDBModel getSmsMessageTrigger() {
        return smsMessageTrigger;
    }

    public void setSmsMessageTrigger(ProcessSmsTriggerDBModel smsMessageTrigger) {
        this.smsMessageTrigger = smsMessageTrigger;
    }
}
