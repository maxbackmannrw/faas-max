package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.ProcessEmailTriggerDBModel;

public class EmailTriggerWSDTO {

    private ProcessEmailTriggerDBModel emailTrigger;

    public EmailTriggerWSDTO() {
    }

    public EmailTriggerWSDTO(ProcessEmailTriggerDBModel emailTrigger) {
        this.emailTrigger = emailTrigger;
    }

    public ProcessEmailTriggerDBModel getEmailTrigger() {
        return emailTrigger;
    }

    public void setEmailTrigger(ProcessEmailTriggerDBModel emailTrigger) {
        this.emailTrigger = emailTrigger;
    }
}
