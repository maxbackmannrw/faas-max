package com.faas.core.base.model.ws.process.details.channel.temp.dto;

import com.faas.core.base.model.db.process.details.channel.temp.EmailTempDBModel;

public class EmailTempWSDTO {

    private EmailTempDBModel emailTemp;

    public EmailTempWSDTO() {
    }

    public EmailTempWSDTO(EmailTempDBModel emailTemp) {
        this.emailTemp = emailTemp;
    }

    public EmailTempDBModel getEmailTemp() {
        return emailTemp;
    }

    public void setEmailTemp(EmailTempDBModel emailTemp) {
        this.emailTemp = emailTemp;
    }
}
