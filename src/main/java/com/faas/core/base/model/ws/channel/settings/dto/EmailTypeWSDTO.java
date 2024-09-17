package com.faas.core.base.model.ws.channel.settings.dto;

import com.faas.core.data.db.channel.settings.EmailTypeDBModel;

public class EmailTypeWSDTO {

    private EmailTypeDBModel emailType;

    public EmailTypeWSDTO() {
    }

    public EmailTypeWSDTO(EmailTypeDBModel emailType) {
        this.emailType = emailType;
    }

    public EmailTypeDBModel getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailTypeDBModel emailType) {
        this.emailType = emailType;
    }
}
