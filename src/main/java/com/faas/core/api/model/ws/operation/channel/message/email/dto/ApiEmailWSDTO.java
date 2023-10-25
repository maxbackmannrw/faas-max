package com.faas.core.api.model.ws.operation.channel.message.email.dto;

import com.faas.core.base.model.db.operation.channel.OperationEmailMessageDBModel;

public class ApiEmailWSDTO {

    private OperationEmailMessageDBModel emailMessage;

    public ApiEmailWSDTO() {
    }

    public ApiEmailWSDTO(OperationEmailMessageDBModel emailMessage) {
        this.emailMessage = emailMessage;
    }

    public OperationEmailMessageDBModel getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(OperationEmailMessageDBModel emailMessage) {
        this.emailMessage = emailMessage;
    }
}
