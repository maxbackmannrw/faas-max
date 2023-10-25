package com.faas.core.base.model.ws.operation.channel.dto;

import com.faas.core.base.model.db.operation.channel.OperationEmailMessageDBModel;

public class EmailMessageWSDTO {

    private OperationEmailMessageDBModel emailMessage;

    public EmailMessageWSDTO() {
    }

    public EmailMessageWSDTO(OperationEmailMessageDBModel emailMessage) {
        this.emailMessage = emailMessage;
    }

    public OperationEmailMessageDBModel getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(OperationEmailMessageDBModel emailMessage) {
        this.emailMessage = emailMessage;
    }
}
