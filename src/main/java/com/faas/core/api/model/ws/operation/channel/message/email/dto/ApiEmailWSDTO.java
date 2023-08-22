package com.faas.core.api.model.ws.operation.channel.message.email.dto;

import com.faas.core.base.model.db.operation.channel.EmailMessageDBModel;

public class ApiEmailWSDTO {

    private EmailMessageDBModel emailMessage;

    public ApiEmailWSDTO() {
    }

    public ApiEmailWSDTO(EmailMessageDBModel emailMessage) {
        this.emailMessage = emailMessage;
    }

    public EmailMessageDBModel getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(EmailMessageDBModel emailMessage) {
        this.emailMessage = emailMessage;
    }
}
