package com.faas.core.base.model.ws.operation.channel.dto;

import com.faas.core.base.model.db.operation.channel.OperationSmsMessageDBModel;

public class SmsMessageWSDTO {

    private OperationSmsMessageDBModel smsMessage;

    public SmsMessageWSDTO() {
    }

    public SmsMessageWSDTO(OperationSmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }

    public OperationSmsMessageDBModel getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(OperationSmsMessageDBModel smsMessage) {
        this.smsMessage = smsMessage;
    }
}
