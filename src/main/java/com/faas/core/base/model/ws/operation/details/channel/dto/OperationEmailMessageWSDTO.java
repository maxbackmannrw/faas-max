package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationEmailMessageDBModel;

public class OperationEmailMessageWSDTO {

    private OperationEmailMessageDBModel emailMessage;

    public OperationEmailMessageWSDTO() {
    }

    public OperationEmailMessageWSDTO(OperationEmailMessageDBModel emailMessage) {
        this.emailMessage = emailMessage;
    }

    public OperationEmailMessageDBModel getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(OperationEmailMessageDBModel emailMessage) {
        this.emailMessage = emailMessage;
    }
}
