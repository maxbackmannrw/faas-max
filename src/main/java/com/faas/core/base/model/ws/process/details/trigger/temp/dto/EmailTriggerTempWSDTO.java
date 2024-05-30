package com.faas.core.base.model.ws.process.details.trigger.temp.dto;

import com.faas.core.base.model.db.process.details.trigger.EmailTriggerTempDBModel;

public class EmailTriggerTempWSDTO {

    private EmailTriggerTempDBModel emailTriggerTemp;

    public EmailTriggerTempWSDTO() {
    }

    public EmailTriggerTempWSDTO(EmailTriggerTempDBModel emailTriggerTemp) {
        this.emailTriggerTemp = emailTriggerTemp;
    }

    public EmailTriggerTempDBModel getEmailTriggerTemp() {
        return emailTriggerTemp;
    }

    public void setEmailTriggerTemp(EmailTriggerTempDBModel emailTriggerTemp) {
        this.emailTriggerTemp = emailTriggerTemp;
    }
}
