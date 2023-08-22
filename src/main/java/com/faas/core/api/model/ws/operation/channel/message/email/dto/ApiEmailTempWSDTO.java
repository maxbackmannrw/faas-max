package com.faas.core.api.model.ws.operation.channel.message.email.dto;

import com.faas.core.base.model.db.process.details.channel.temp.EmailTempDBModel;

public class ApiEmailTempWSDTO {

    private EmailTempDBModel emailTemp;

    public ApiEmailTempWSDTO() {
    }

    public ApiEmailTempWSDTO(EmailTempDBModel emailTemp) {
        this.emailTemp = emailTemp;
    }

    public EmailTempDBModel getEmailTemp() {
        return emailTemp;
    }

    public void setEmailTemp(EmailTempDBModel emailTemp) {
        this.emailTemp = emailTemp;
    }
}
