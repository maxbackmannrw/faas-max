package com.faas.core.base.model.ws.process.details.channel.trigger.dto;

import com.faas.core.base.model.db.process.details.channel.trigger.ProcessEmailTriggerDBModel;

public class ProcessEmailTriggerWSDTO {

    private ProcessEmailTriggerDBModel emailTrigger;

    public ProcessEmailTriggerWSDTO() {
    }

    public ProcessEmailTriggerWSDTO(ProcessEmailTriggerDBModel emailTrigger) {
        this.emailTrigger = emailTrigger;
    }

    public ProcessEmailTriggerDBModel getEmailTrigger() {
        return emailTrigger;
    }

    public void setEmailTrigger(ProcessEmailTriggerDBModel emailTrigger) {
        this.emailTrigger = emailTrigger;
    }
}
