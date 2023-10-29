package com.faas.core.base.model.ws.operation.details.channel.dto;

import com.faas.core.base.model.db.operation.details.channel.OperationSmsMessageDBModel;

public class OperationSmsMessageWSDTO {

    private OperationSmsMessageDBModel smsMessage;

    public OperationSmsMessageWSDTO() {
    }

    public OperationSmsMessageWSDTO(OperationSmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }

    public OperationSmsMessageDBModel getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(OperationSmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }
}
