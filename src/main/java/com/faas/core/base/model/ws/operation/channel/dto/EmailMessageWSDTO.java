package com.faas.core.base.model.ws.operation.channel.dto;

import com.faas.core.base.model.db.operation.channel.EmailMessageDBModel;

public class EmailMessageWSDTO {

    private EmailMessageDBModel emailMessage;

    public EmailMessageWSDTO() {
    }

    public EmailMessageWSDTO(EmailMessageDBModel emailMessage) {
        this.emailMessage = emailMessage;
    }

    public EmailMessageDBModel getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(EmailMessageDBModel emailMessage) {
        this.emailMessage = emailMessage;
    }
}
