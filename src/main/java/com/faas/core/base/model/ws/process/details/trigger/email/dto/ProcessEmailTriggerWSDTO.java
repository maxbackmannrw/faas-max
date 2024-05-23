package com.faas.core.base.model.ws.process.details.trigger.email.dto;

import com.faas.core.base.model.db.process.details.trigger.EmailTriggerDBModel;

public class ProcessEmailTriggerWSDTO {

    private EmailTriggerDBModel processEmailTrigger;

    public ProcessEmailTriggerWSDTO() {
    }

    public ProcessEmailTriggerWSDTO(EmailTriggerDBModel processEmailTrigger) {
        this.processEmailTrigger = processEmailTrigger;
    }

    public EmailTriggerDBModel getProcessEmailTrigger() {
        return processEmailTrigger;
    }

    public void setProcessEmailTrigger(EmailTriggerDBModel processEmailTrigger) {
        this.processEmailTrigger = processEmailTrigger;
    }
}
