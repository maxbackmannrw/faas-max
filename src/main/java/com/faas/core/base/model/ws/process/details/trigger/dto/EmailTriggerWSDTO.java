package com.faas.core.base.model.ws.process.details.trigger.dto;

import com.faas.core.base.model.db.process.details.trigger.EmailTriggerDBModel;

public class EmailTriggerWSDTO {

    private EmailTriggerDBModel emailTrigger;

    public EmailTriggerWSDTO() {
    }

    public EmailTriggerWSDTO(EmailTriggerDBModel emailTrigger) {
        this.emailTrigger = emailTrigger;
    }

    public EmailTriggerDBModel getEmailTrigger() {
        return emailTrigger;
    }

    public void setEmailTrigger(EmailTriggerDBModel emailTrigger) {
        this.emailTrigger = emailTrigger;
    }
}
